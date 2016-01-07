package es.fdi.iw.model.pais.eventos;

public class EventosRegular  implements Eventos{
	@Override
	public TipoEvento getTipoEvento() {
		return TipoEvento.EVENTO_REGULAR;
	}
}
