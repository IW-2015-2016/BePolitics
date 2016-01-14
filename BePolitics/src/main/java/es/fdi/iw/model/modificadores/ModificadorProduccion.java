package es.fdi.iw.model.modificadores;

import java.sql.Date;

import es.fdi.iw.model.pais.TipoRecurso;


/**
 * Modificadores a la producción. contienen un tipo de recurso, un porcentaje, un título,
 * una descripción, y una fecha de inicio y otra de fin. tienen como objetivo almacenar
 * las modificaciones de producción que sufre un país por cualquier motivo.
 * 
 * @author Ismael
 * @see Date
 */
 @Entity
public class ModificadorProduccion {
	private TipoRecurso tipo_recurso;
	private int porcentaje_recurso;
	private String titulo_recurso;
	private String descripcion_recurso;
	private Date fechainicio_recurso;
	private Date fechafin_recurso;
	/**
	 * Crea un Modificador. si el porcentaje no está entre -100 y 100, se pondrá automáticamente a 0
	 *  
	 * @param t el tipo de recurso
	 * @param porcent el porcentaje que modifica
	 * @param titulo el título del modificador
	 * @param descripcion la descripción del modificador
	 * @param inicio aquí va la fecha de inicio (java.sql.Date)
	 * @param fin aquí va la fecha de fin (java.sql.Date)
	 * 
	 * @see java.sql.Date
	 */
	public ModificadorProduccion(TipoRecurso t, int porcent, String titulo, String descripcion, Date inicio, Date fin){
		this.setPorcentaje(porcent);
		if(porcent<-100 || porcent>100) 
			this.setPorcentaje(0);
		this.setTitulo(titulo);
		this.setDescripcion(descripcion);
		this.setFechainicio(inicio);
		this.setFechafin(fin);
	}
	
	/**
	 * Clona el modificador de producción actual.
	 */
	public ModificadorProduccion clone(){
		return new ModificadorProduccion(this.tipo_recurso,this.porcentaje_recurso, this.titulo_recurso,this.descripcion_recurso,this.fechainicio_recurso,this.fechafin_recurso);
	}
	
	/*********************/
	/**Getters y setters**/
	/*********************/
	
	public TipoRecurso getTipo() {
		return tipo_recurso;
	}
	public void setTipo(TipoRecurso tipo) {
		this.tipo_recurso = tipo;
	}
	public int getPorcentaje() {
		return porcentaje_recurso;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje_recurso = porcentaje;
	}
	public Date getFechainicio() {
		return fechainicio_recurso;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio_recurso = fechainicio;
	}
	public Date getFechafin() {
		return fechafin_recurso;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin_recurso = fechafin;
	}
	public String getTitulo() {
		return titulo_recurso;
	}
	public void setTitulo(String titulo) {
		this.titulo_recurso = titulo;
	}
	public String getDescripcion() {
		return descripcion_recurso;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion_recurso = descripcion;
	}

	
}
