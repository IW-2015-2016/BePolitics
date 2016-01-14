package es.fdi.iw.model.pais.eventos;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import es.fdi.iw.model.modificadores.ModificadorProduccion;
import es.fdi.iw.model.pais.Pais;
import es.fdi.iw.model.pais.TipoRecurso;
/**
 * Esto representa un evento, cada evento tendrá un título y una descripción, y 
 * generará unos modificadores cuando se responda a una de las dos opciones
 * @author Ismael
 *
 */
 @Entity
public class Evento {
	private static final int DIAS_CADUCIDAD_EVENTO_GUERRA = 7;
	private static final int DIAS_CADUCIDAD_EVENTO_NO_GUERRA = 7;
	
	private String titulo_evento;
	private String descripcion_evento;
	private String opcion1_evento;
	private String opcion2_evento;
	private int rec1_evento;
	private int rec2_evento;
	private boolean respondido_evento;
	private int porcentaje1_evento;
	private int porcentaje2_evento;
	private int porcentaje3_evento;
	private int porcentaje4_evento;
	private int tipoEvento_evento;
	
	private boolean eligioLaPrimeraRespuesta_evento;
	private boolean resuelto_evento;
	
	/**
	 * Crea un evento, no puede ser tipo guerra
	 * 
	 * @param tit el título
	 * @param desc la descripción
	 * @param opt1 el texto de opción de respuesta 1
	 * @param opt2 el texto de opción de respueta 2
	 * @param tipRec1 el tipo de recurso modificado con la respuesta 1
	 * @param tipRec2 el tipo de recurso modificado con la respuesta 2
	 * @param porcent1 el porcentaje del recurso modificado con la respuesta 1
	 * @param porcent2 el porcentaje del recurso modificado con la respuesta 2
	 * @param tipo el tipo de evento
	 * @throws IOException si el tipo de evento es de guerra, el constructor de guerras es distinto
	 */
	public Evento(String tit, String desc, String opt1, String opt2, 
			TipoRecurso tipRec1, TipoRecurso tipRec2, int porcent1, 
			int porcent2, TipoEvento tipo) throws IOException{
		
		if (tipo == TipoEvento.GUERRA) throw new IOException("Error, el constructor por defecto para guerra no tiene estos atributos");
		this.eligioLaPrimeraRespuesta_evento =false;
		this.titulo_evento = tit;
		this.descripcion_evento = desc;
		this.opcion1_evento = opt1;
		this.opcion2_evento = opt2;
		this.rec1_evento = tipRec1;
		this.rec2_evento = tipRec2;
		this.porcentaje1_evento = porcent1;
		this.porcentaje2_evento = porcent2;
		this.porcentaje3_evento = Integer.MIN_VALUE;
		this.porcentaje4_evento = Integer.MIN_VALUE;
		this.tipoEvento_evento = tipo;
		this.respondido_evento = false;
		this.resuelto_evento = false;
		this.eligioLaPrimeraRespuesta_evento = true;
		
	}
	/**
	 * Crea un evento de guerra
	 * 
	 * @param tit el título
	 * @param desc la descripción
	 * @param opt1 el texto de opción de respuesta 1
	 * @param opt2 el texto de opción de respueta 2
	 * @param tipRec1 el tipo de recurso modificado con resolución de la guerra
	 * @param porc1 el porcentaje del recurso modificado con la respuesta 1
	 * @param porc2 el porcentaje del recurso modificado con la respuesta 2
	 * @param porc3 el porcentaje del recurso modificado con la respuesta 3
	 * @param porc4 el porcentaje del recurso modificado con la respuesta 4
	 * @param tipo el tipo de evento
	 * @throws IOException si el evento no es de guerra
	 */
	public Evento(String tit, String desc, String opt1, String opt2, 
			TipoRecurso tipRec1, int porc1, int porc2, int porc3, int porc4, TipoEvento tipo) throws IOException{
		
		if (tipo != TipoEvento.GUERRA) throw new IOException("Error, no se puede crear un evento que no sea de guerra con este constructor");
		
		this.eligioLaPrimeraRespuesta_evento =true;
		this.titulo_evento = tit;
		this.descripcion_evento= desc;
		this.opcion1_evento = opt1;
		this.opcion2_evento = opt2;
		this.rec1_evento = tipRec1;
		this.rec2_evento = null;
		this.porcentaje1_evento = porc1;
		this.porcentaje2_evento = porc2;
		this.porcentaje3_evento = porc3;
		this.porcentaje4_evento = porc4;
		this.tipoEvento_evento = tipo;
		this.respondido_evento = false;
		this.resuelto_evento = false;
	}
	
	/**
	 * respuesta del evento, si no es de tipo guerra, además se añade el modificador de producción
	 * 
	 * @param respuestaElegida el número de respuesta, tiene que ser 1 o 2, si no es ninguno, se elige 1 por defecto
	 */
	public void respondeEvento(int respuestaElegida){
		
		if(respuestaElegida == 1)
			this.eligioLaPrimeraRespuesta_evento =true;
		else if( respuestaElegida == 2)
			this.eligioLaPrimeraRespuesta_evento =false;
		else this.eligioLaPrimeraRespuesta_evento =true;
		
		
		// Se añade el modificador del evento
		if (this.tipoEvento_evento != TipoEvento.GUERRA){
			
			Date today = new Date(Calendar.getInstance().getTimeInMillis());
			Calendar aux = Calendar.getInstance();
			aux.add(Calendar.DATE, +DIAS_CADUCIDAD_EVENTO_NO_GUERRA);
			Date finEvento = new Date(aux.getTimeInMillis());
			String s=this.opcion1_evento;
			TipoRecurso rec = this.rec1_evento;
			int porcent = this.porcentaje1_evento;
			if(!this.eligioLaPrimeraRespuesta_evento){
				s= this.opcion2_evento;
				rec = this.rec2_evento;
				porcent = this.porcentaje2_evento;
				
				
			}	
			String tituloModif = "Modificacion";
			String descrModif = "Durante el evento "+ this.titulo_evento +", la elección de la opción \"" + s +"\" causa esta modificación.";
		
			ModificadorProduccion m1 = new ModificadorProduccion(rec, porcent, tituloModif, descrModif, today, finEvento);	
		}
		
	}
	/**
	 * Resuelve un evento de tipo guerra entre dos países cuando ambos han respondido y no se ha resuelto aún. 
	 * Si ya se ha resuelto no se puede resolver de nuevo
	 * 
	 * @param yo este país
	 * @param otro el otro país
	 * @return true si se resolvió, false en caso contrario o si el evento no es de tipo guerra
	 */
	public boolean resuelveEventoGuerra(Pais yo, Pais otro){

		if (this.tipoEvento_evento != TipoEvento.GUERRA) return false;
		Evento e = otro.getGuerras().getEventoActual(yo);
		
		if(this.respondido_evento && e.respondido && !this.resuelto_evento && !e.resuelto) {
			
			ModificadorProduccion m1 = null;
			ModificadorProduccion m2 = null;
			Date today = new Date(Calendar.getInstance().getTimeInMillis());
			Calendar aux = Calendar.getInstance();
			aux.add(Calendar.DATE, +DIAS_CADUCIDAD_EVENTO_GUERRA);
			Date finEvento = new Date(aux.getTimeInMillis());
			
			
			String tituloModif = "Modificacion";
			String descrModif = "En la cruenta batalla de "+today.toString()+", durante el evento "+ this.titulo_evento+ " por tu gestión"
					+ " el país nota la diferencia";
			
			// RESOLUCION DE LA BATALLA
			if(this.eligioLaPrimeraRespuesta_evento && e.eligioLaPrimeraRespuesta){
				m1= new ModificadorProduccion(rec1, porcentaje1, tituloModif, descrModif, today, finEvento);
				m2 = new ModificadorProduccion(rec1, porcentaje1, tituloModif, descrModif, today, finEvento);
			}else if(!this.eligioLaPrimeraRespuesta_evento && !e.eligioLaPrimeraRespuesta ){
				m1= new ModificadorProduccion(rec1, porcentaje2, tituloModif, descrModif, today, finEvento);
				m2 = new ModificadorProduccion(rec2, porcentaje3, tituloModif, descrModif, today, finEvento);
			}else if(!this.eligioLaPrimeraRespuesta_evento && e.eligioLaPrimeraRespuesta){
				m1= new ModificadorProduccion(rec1, porcentaje3, tituloModif, descrModif, today, finEvento);
				m2 = new ModificadorProduccion(rec2, porcentaje2, tituloModif, descrModif, today, finEvento);
			}else if(this.eligioLaPrimeraRespuesta_evento && !e.eligioLaPrimeraRespuesta){
				m1= new ModificadorProduccion(rec1, porcentaje4, tituloModif, descrModif, today, finEvento);
				m2 = new ModificadorProduccion(rec1, porcentaje4, tituloModif, descrModif, today, finEvento);
			}
			// Se añaden los modificadores
			yo.addModificador(m1);
			otro.addModificador(m2);
			//se marca como resuelto
			e.resuelto = true;
			this.resuelto_evento = true;	
			
			return true;
		}
		return false;
		
	}
	/**
	 * Se obtiene el estado de la pregunta, respondida o no
	 * @return true si se respondió al evento
	 */
	public boolean getRespondido(){
		return this.respondido_evento;
	}
	public TipoEvento getTipo(){
		return this.tipoEvento_evento;
	}
	
	public String getTitulo(){
		return this.titulo_evento;
	}
	
	public String getDescripcion(){
		return this.descripcion_evento;
	}
	
	public String getOpcion1(){
		return this.opcion1_evento;
	}
	public String getOpcion2(){
		return this.opcion2_evento;
	}
}
