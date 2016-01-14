package es.fdi.iw.model.pais.eventos;

import java.util.ArrayList;
/**
 * Esta clase guarda un montÃ³n de eventos regulares 
 * 
 * @author Ismael
 *
 */
 @Entity
public class EventosRegular  implements Eventos{
	private ArrayList<Evento> eventos_regular;
	private Evento eventoActual_regular;
	
	
	
	/**
	 * Constructor por defecto, inicializa las listas
	 * 
	 */
	public EventosRegular(){
		this.eventos_regular = new ArrayList<Evento>();
		this.eventoActual_regular = null;
	}
	
	/**
	 * Devuelve true si existe evento actual, false en caso contrario
	 * @return
	 */
	public boolean tieneEventoActual(){
		if (this.eventoActual_regular==null) return false;
		return true;
	}
	/**
	 * aÃ±ade un evento actual si no habÃ­a uno. El evento debe 
	 * ser de tipo regular
	 * 
	 * @param e el evento a aÃ±adir 
	 * @return true si lo añadio, false en caso de que ya existiera, se recibiese un evento nulo o el evento recibido no sea regular
	 */
	public boolean addEventoActual(Evento e){
		
		if (!this.tieneEventoActual() 
				|| e!= null 
				|| e.getTipo() != TipoEvento.EVENTO_REGULAR)
			return false;	
		
		this.eventoActual_regular=e;
		return true;
	}
	
	/**
	 * Con esto se responde un evento, como el evento sÃ³lo tiene dos
	 * opciones, la respuesta debe estar entre 1 y 2
	 * 
	 * @param opcion un entero que debe ser 1 o 2
	 * @return true si se respondiÃ³, false si no
	 */
	public boolean respondeEvento(int opcion){
		
		if (this.eventoActual_regular==null
				||	this.eventoActual_regular.getRespondido()) 
			return false;
		
		if(opcion>2) return false;
		
		else if(opcion>0) {
			this.eventoActual_regular.respondeEvento(opcion);
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
		return this.eventoActual_regular;
	}
	
	@Override
	public ArrayList<Evento> getEventosPasados() {
		return this.eventos_regular;
	}
}
