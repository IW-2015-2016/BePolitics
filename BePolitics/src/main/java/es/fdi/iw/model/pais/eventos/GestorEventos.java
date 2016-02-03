package es.fdi.iw.model.pais.eventos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import es.fdi.iw.model.modificadores.ModificadorProduccion;
import es.fdi.iw.model.pais.Pais;

/**
 * Contiene una lista de eventos pasados y un evento actual para la guerra con un país. 
 * Deberá poder resolver eventos
 * 
 * @author Ismael
 *
 */
@Entity
public class GestorEventos{
	private long id;
	private List<Evento> eventos;
	private Evento eventoActual;
	private  TipoEvento tipoEvento;
	
	public GestorEventos(){
		
	}
	/**
	 * Constructor por defecto, inicializa las listas
	 * 
	 */
	public GestorEventos(TipoEvento tipo){
		this.eventos = new ArrayList<Evento>();
		this.eventoActual = null;
		this.tipoEvento = tipo;
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
				|| e.getTipoEvento() != this.tipoEvento)
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
		
		if (this.tipoEvento == TipoEvento.EVENTO_REGULAR)
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
		return this.tipoEvento;
	}
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}



	
	
	@Id
    @GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@OneToMany(targetEntity=Evento.class)
	@JoinColumn(name="gestor_evento") 
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	@OneToOne(targetEntity=Evento.class, fetch=FetchType.EAGER)
	public Evento getEventoActual() {
		return eventoActual;
	}
	public void setEventoActual(Evento eventoActual) {
		this.eventoActual = eventoActual;
	}

}
