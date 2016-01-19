package es.fdi.iw.model.pais.eventos;

import java.util.ArrayList;
/**
 * Esta clase guarda un montón de eventos regulares 
 * 
 * @author Ismael
 *
 */
public class EventosRegular  implements Eventos{
	private ArrayList<Evento> eventos;
	private Evento eventoActual;
	
	
	
	/**
	 * Constructor por defecto, inicializa las listas
	 * 
	 */
	public EventosRegular(){
		this.eventos = new ArrayList<Evento>();
		this.eventoActual = null;
	}
	
	/**
	 * Devuelve true si existe evento actual, false en caso contrario
	 * @return
	 */
	public boolean tieneEventoActual(){
		if (this.eventoActual==null) return false;
		return true;
	}
	/**
	 * añade un evento actual si no había uno. El evento debe 
	 * ser de tipo regular
	 * 
	 * @param e el evento a añadir 
	 * @return true si lo a�adio, false en caso de que ya existiera, se recibiese un evento nulo o el evento recibido no sea regular
	 */
	public boolean addEventoActual(Evento e){
		
		if (!this.tieneEventoActual() 
				|| e!= null 
				|| e.getTipo() != TipoEvento.EVENTO_REGULAR)
			return false;	
		
		this.eventoActual=e;
		return true;
	}
	
	/**
	 * Con esto se responde un evento, como el evento sólo tiene dos
	 * opciones, la respuesta debe estar entre 1 y 2
	 * 
	 * @param opcion un entero que debe ser 1 o 2
	 * @return true si se respondió, false si no
	 */
	public boolean respondeEvento(int opcion){
		
		if (this.eventoActual==null
				||	this.eventoActual.getRespondido()) 
			return false;
		
		if(opcion>2) return false;
		
		else if(opcion>0) {
			this.eventoActual.respondeEvento(opcion);
			return true;
		}
		
		return false;
	}
	
	@Override
	public TipoEvento getTipoEvento() {
		return TipoEvento.EVENTO_REGULAR;
	}
	
	@Override
	public Evento getEventoActual() {
		return this.eventoActual;
	}
	
	@Override
	public ArrayList<Evento> getEventosPasados() {
		return this.eventos;
	}
}
