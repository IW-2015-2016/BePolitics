package es.fdi.iw.model.pais.eventos;

import java.util.ArrayList;

public class EventosComunidadEconomica  implements Eventos{
	private ArrayList<Evento> eventos;
	
	public EventosComunidadEconomica(){
		this.eventos = new ArrayList<Evento>();
	}
	
	@Override
	public TipoEvento getTipoEvento() {
		return TipoEvento.COMUNIDAD_ECONOMICA;
	}


}
