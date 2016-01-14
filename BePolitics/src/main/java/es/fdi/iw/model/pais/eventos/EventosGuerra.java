package es.fdi.iw.model.pais.eventos;
/**
 * Contiene una lista de eventos pasados y un evento actual. Deberá poder resolver eventos
 * 
 * @author Ismael
 *
 */
 @Entity 
public class EventosGuerra implements Eventos{
	private int id_evento_guerra;
	@Override
	public TipoEvento getTipoEvento() {
		return TipoEvento.GUERRA;
	}
}
