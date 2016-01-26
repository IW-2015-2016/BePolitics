package es.fdi.iw.model.modificadores;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import es.fdi.iw.model.User;
import es.fdi.iw.model.pais.Pais;
import es.fdi.iw.model.pais.TipoRecurso;


/**
 * Modificadores a la producci�n. contienen un tipo de recurso, un porcentaje, un t�tulo,
 * una descripci�n, y una fecha de inicio y otra de fin. tienen como objetivo almacenar
 * las modificaciones de producci�n que sufre un pa�s por cualquier motivo.
 * 
 * @author Ismael
 * @see Date
 */
@Entity
public class ModificadorProduccion {
	private long id;
	private TipoRecurso tipo;
	private int porcentaje;
	private String titulo;
	private String descripcion;
	private Date fechainicio;
	private Date fechafin;
	private Pais propietario;
	public ModificadorProduccion(){}
	/**
	 * Crea un Modificador. si el porcentaje no est� entre -100 y 100, se pondr� autom�ticamente a 0
	 *  
	 * @param t el tipo de recurso
	 * @param porcent el porcentaje que modifica
	 * @param titulo el t�tulo del modificador
	 * @param descripcion la descripci�n del modificador
	 * @param inicio aqu� va la fecha de inicio (java.sql.Date)
	 * @param fin aqu� va la fecha de fin (java.sql.Date)
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
	 * Clona el modificador de producci�n actual.
	 */
	public ModificadorProduccion clone(){
		return new ModificadorProduccion(this.tipo,this.porcentaje, this.titulo,this.descripcion,this.fechainicio,this.fechafin);
	}
	
	/*********************/
	/**Getters y setters**/
	/*********************/
	
	public TipoRecurso getTipo() {
		return tipo;
	}
	public void setTipo(TipoRecurso tipo) {
		this.tipo = tipo;
	}
	public int getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	@Id
    @GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity=Pais.class)
	public Pais getPropietario() {
		return propietario;
	}
	public void setPropietario(Pais propietario) {
		this.propietario = propietario;
	}

	
}
