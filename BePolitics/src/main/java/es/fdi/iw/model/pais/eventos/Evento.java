package es.fdi.iw.model.pais.eventos;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import es.fdi.iw.model.modificadores.ModificadorProduccion;
import es.fdi.iw.model.pais.Pais;
import es.fdi.iw.model.pais.TipoRecurso;
/**
 * Esto representa un evento, cada evento tendr� un t�tulo y una descripci�n, y 
 * generar� unos modificadores cuando se responda a una de las dos opciones
 * @author Ismael
 *
 */
public class Evento {
	private static final int DIAS_CADUCIDAD_EVENTO_GUERRA = 7;
	private static final int DIAS_CADUCIDAD_EVENTO_NO_GUERRA = 7;
	
	private String titulo;
	private String descripcion;
	private String opcion1;
	private String opcion2;
	private TipoRecurso rec1;
	private TipoRecurso rec2;
	private boolean respondido;
	private int porcentaje1;
	private int porcentaje2;
	private int porcentaje3;
	private int porcentaje4;
	private TipoEvento tipoEvento;
	
	private boolean eligioLaPrimeraRespuesta;
	private boolean resuelto;
	
	/**
	 * Crea un evento, no puede ser tipo guerra
	 * 
	 * @param tit el t�tulo
	 * @param desc la descripci�n
	 * @param opt1 el texto de opci�n de respuesta 1
	 * @param opt2 el texto de opci�n de respueta 2
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
		this.eligioLaPrimeraRespuesta =false;
		this.titulo = tit;
		this.descripcion = desc;
		this.opcion1 = opt1;
		this.opcion2 = opt2;
		this.rec1 = tipRec1;
		this.rec2 = tipRec2;
		this.porcentaje1 = porcent1;
		this.porcentaje2 = porcent2;
		this.porcentaje3 = Integer.MIN_VALUE;
		this.porcentaje4 = Integer.MIN_VALUE;
		this.tipoEvento = tipo;
		this.respondido = false;
		this.resuelto = false;
		this.eligioLaPrimeraRespuesta = true;
		
	}
	/**
	 * Crea un evento de guerra
	 * 
	 * @param tit el t�tulo
	 * @param desc la descripci�n
	 * @param opt1 el texto de opci�n de respuesta 1
	 * @param opt2 el texto de opci�n de respueta 2
	 * @param tipRec1 el tipo de recurso modificado con resoluci�n de la guerra
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
		
		this.eligioLaPrimeraRespuesta =true;
		this.titulo = tit;
		this.descripcion = desc;
		this.opcion1 = opt1;
		this.opcion2 = opt2;
		this.rec1 = tipRec1;
		this.rec2 = null;
		this.porcentaje1 = porc1;
		this.porcentaje2 = porc2;
		this.porcentaje3 = porc3;
		this.porcentaje4 = porc4;
		this.tipoEvento = tipo;
		this.respondido = false;
		this.resuelto = false;
	}
	
	/**
	 * respuesta del evento, si no es de tipo guerra, adem�s se a�ade el modificador de producci�n
	 * 
	 * @param respuestaElegida el n�mero de respuesta, tiene que ser 1 o 2, si no es ninguno, se elige 1 por defecto
	 */
	public void respondeEvento(int respuestaElegida){
		
		if(respuestaElegida == 1)
			this.eligioLaPrimeraRespuesta =true;
		else if( respuestaElegida > 2)
			this.eligioLaPrimeraRespuesta =false;
		else this.eligioLaPrimeraRespuesta =true;
		
		
		// Se a�ade el modificador del evento
		if (this.tipoEvento != TipoEvento.GUERRA){
			
			Date today = new Date(Calendar.getInstance().getTimeInMillis());
			Calendar aux = Calendar.getInstance();
			aux.add(Calendar.DATE, +DIAS_CADUCIDAD_EVENTO_NO_GUERRA);
			Date finEvento = new Date(aux.getTimeInMillis());
			String s=this.opcion1;
			TipoRecurso rec = this.rec1;
			int porcent = this.porcentaje1;
			if(!this.eligioLaPrimeraRespuesta){
				s= this.opcion2;
				rec = this.rec2;
				porcent = this.porcentaje2;
			}
			
			String tituloModif = "Modificacion";
			String descrModif = "Durante el evento "+ this.titulo +", la elecci�n de la opci�n \"" + s +"\" causa esta modificaci�n.";
			
			
			
			ModificadorProduccion m1 = new ModificadorProduccion(rec, porcent, tituloModif, descrModif, today, finEvento);
			
		}
	}
	/**
	 * Resuelve un evento de tipo guerra entre dos pa�ses cuando ambos han respondido y no se ha resuelto a�n. 
	 * Si ya se ha resuelto no se puede resolver de nuevo
	 * 
	 * @param yo este pa�s
	 * @param otro el otro pa�s
	 * @return true si se resolvi�, false en caso contrario o si el evento no es de tipo guerra
	 */
	public boolean resuelveEventoGuerra(Pais yo, Pais otro){

		if (this.tipoEvento != TipoEvento.GUERRA) return false;
		Evento e = otro.getGuerras().getEventoActual(yo).getEventoActual();
		
		if(this.respondido && e.respondido && !this.resuelto && !e.resuelto) {
			
			ModificadorProduccion m1 = null;
			ModificadorProduccion m2 = null;
			Date today = new Date(Calendar.getInstance().getTimeInMillis());
			Calendar aux = Calendar.getInstance();
			aux.add(Calendar.DATE, +DIAS_CADUCIDAD_EVENTO_GUERRA);
			Date finEvento = new Date(aux.getTimeInMillis());
			
			
			String tituloModif = "Modificacion";
			String descrModif = "En la cruenta batalla de "+today.toString()+", durante el evento "+ this.titulo+ " por tu gesti�n"
					+ " el pa�s nota la diferencia";
			
			// RESOLUCION DE LA BATALLA
			if(this.eligioLaPrimeraRespuesta && e.eligioLaPrimeraRespuesta){
				m1= new ModificadorProduccion(rec1, porcentaje1, tituloModif, descrModif, today, finEvento);
				m2 = new ModificadorProduccion(rec1, porcentaje1, tituloModif, descrModif, today, finEvento);
			}else if(!this.eligioLaPrimeraRespuesta && !e.eligioLaPrimeraRespuesta ){
				m1= new ModificadorProduccion(rec1, porcentaje2, tituloModif, descrModif, today, finEvento);
				m2 = new ModificadorProduccion(rec2, porcentaje3, tituloModif, descrModif, today, finEvento);
			}else if(!this.eligioLaPrimeraRespuesta && e.eligioLaPrimeraRespuesta){
				m1= new ModificadorProduccion(rec1, porcentaje3, tituloModif, descrModif, today, finEvento);
				m2 = new ModificadorProduccion(rec2, porcentaje2, tituloModif, descrModif, today, finEvento);
			}else if(this.eligioLaPrimeraRespuesta && !e.eligioLaPrimeraRespuesta){
				m1= new ModificadorProduccion(rec1, porcentaje4, tituloModif, descrModif, today, finEvento);
				m2 = new ModificadorProduccion(rec1, porcentaje4, tituloModif, descrModif, today, finEvento);
			}
			// Se a�aden los modificadores
			yo.addModificador(m1);
			otro.addModificador(m2);
			//se marca como resuelto
			e.resuelto = true;
			this.resuelto = true;	
			
			return true;
		}
		return false;
		
	}
	/**
	 * Se obtiene el estado de la pregunta, respondida o no
	 * @return true si se respondi� al evento
	 */
	public boolean getRespondido(){
		return this.respondido;
	}

}
