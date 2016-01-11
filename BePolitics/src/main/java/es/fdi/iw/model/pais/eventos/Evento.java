package es.fdi.iw.model.pais.eventos;

import java.io.IOException;

import es.fdi.iw.model.pais.TipoRecurso;
/**
 * Esto representa un evento, cada evento tendrá un título y una descripción, y 
 * generará unos modificadores cuando se responda a una de las dos opciones
 * @author Ismael
 *
 */
public class Evento {
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
		
	}

}
