package es.fdi.iw.model.pais.eventos;

import java.util.ArrayList;
/**
 * Esta interfaz indica lo que tiene que hacer un evento
 * 
 * @author Ismael
 *
 */
public interface Eventos {
	/**
	 * Devuelve el evento actual
	 * 
	 * @return El evento actual
	 */
	public abstract Eventos getEventoActual();
	/**
	 * Devuelve todos los eventos que ya no est�n activos
	 * 
	 * @return un ArrayList de eventos
	 */
	public abstract ArrayList<Eventos> getEventosPasados();

}