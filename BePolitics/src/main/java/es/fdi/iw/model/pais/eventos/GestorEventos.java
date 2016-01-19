package es.fdi.iw.model.pais.eventos;

import java.util.ArrayList;

import es.fdi.iw.model.pais.Pais;

/**
 * Contiene una lista de eventos pasados y un evento actual para la guerra con un país. 
 * Deberá poder resolver eventos
 * 
 * @author Ismael
 *
 */
public class GestorEventos{

	private ArrayList<Evento> eventos;
	private Evento eventoActual;
	private final TipoEvento tipo;
	/**
	 * Constructor por defecto, inicializa las listas
	 * 
	 */
	public GestorEventos(TipoEvento tipo){
		this.eventos = new ArrayList<Evento>();
		this.eventoActual = null;
		this.tipo = tipo;
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
				|| e.getTipo() != this.tipo)
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
	public boolean respondeEvento(int opcion, Pais yo, Pais otro){
		
		if (this.eventoActual==null
				||	this.eventoActual.getRespondido()) 
			return false;
		
		if(opcion>2) return false;
		
		else if(opcion>0) {
			this.eventoActual.respondeEvento(opcion);
			return true;
		}
		
		if (this.tipo == TipoEvento.EVENTO_REGULAR)
			this.resuelve(yo, otro);
		
		return false;
	}
	/**
	 * Resuelve el evento de guerra actual si ambos países han respondido
	 * @param yo
	 * @param otro
	 * @return
	 */
	private boolean resuelve(Pais yo, Pais otro){
		boolean ret = false;
		ret= this.eventoActual.resuelveEventoGuerra(yo, otro);
		
		if(ret){
			this.eventos.add(this.eventoActual);
			this.eventoActual = null;
		}
		return ret;
	}
	

	public TipoEvento getTipoEvento() {
		return this.tipo;
	}
	

	public Evento getEventoActual() {
		return this.eventoActual;
	}
	

	public ArrayList<Evento> getEventosPasados() {
		return this.eventos;
	}
}
