package es.fdi.iw.model.pais.eventos;

import java.util.ArrayList;
@Entity
public class EventosComunidadEconomica  implements Eventos{
	private ArrayList<Evento> eventos_comunidad;
	
	public EventosComunidadEconomica(){
		this.eventos_comunidad = new ArrayList<Evento>();
	}
	
	@Override
	public TipoEvento getTipoEvento() {
		return TipoEvento.COMUNIDAD_ECONOMICA;
	}


}
