package es.fdi.iw.noticias;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



/**
 * Clase que contiene las noticias
 * 
 * @author futurDrama
 */
@Entity
@NamedQueries({
    @NamedQuery(name="allNoticias",
            query="select n from Noticia n"),
    @NamedQuery(name="deleteNoticia",
            query="delete from Noticia n where n.id=:idParam")
})
public class Noticia {
	
	private long id;
	private String titulo;
	private String cuerpo;
	/**
	 * Default constructor
	 */
	public Noticia(){}
	
	/**
	 * crea una noticia
	 * @param tit el título
	 * @param cuerp el cuerpo
	 */
	public Noticia(String tit, String cuerp){
		this.titulo = tit;
		this.cuerpo = cuerp;
	}
	@Id
    @GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	
}
