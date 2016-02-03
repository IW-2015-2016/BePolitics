package es.fdi.iw.model.pais.eventos;
/**
 * 
 * Indica los tipos de evento que puede haber
 * 
 * @author futurDrama
 *
 */
public enum TipoEvento {
	GUERRA, 
	COMUNIDAD_ECONOMICA,
	EVENTO_REGULAR;

 public static TipoEvento stringtoEvento(String s){
		 TipoEvento e = null;
     	 if(s.equalsIgnoreCase("GUERRA")) e = TipoEvento.GUERRA;
     	 if(s.equalsIgnoreCase("COMUNIDAD_ECONOMICA")) e = TipoEvento.COMUNIDAD_ECONOMICA;
     	 if(s.equalsIgnoreCase("EVENTO_REGULAR")) e = TipoEvento.EVENTO_REGULAR;
  
     	return e;
     	
 }   
 }