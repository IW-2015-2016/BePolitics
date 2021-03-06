package es.fdi.iw.model.pais;



import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import es.fdi.iw.model.Author;
import es.fdi.iw.model.modificadores.ModificadorProduccion;
import es.fdi.iw.model.pais.construcciones.Construcciones;
import es.fdi.iw.model.pais.construcciones.TipoConstruccion;
import es.fdi.iw.model.pais.eventos.Evento;
import es.fdi.iw.model.pais.relaciones.ComunidadEconomica;
import es.fdi.iw.model.pais.relaciones.Guerras;
import es.fdi.iw.model.politicos.Politico;
import es.fdi.iw.model.usuario.Usuario;


/**
 * Representa un pa�s
 * 
 * @author futurDrama
 */

@Entity
@NamedQueries({
    @NamedQuery(name="allPaises",
            query="select p from Pais p"),
    @NamedQuery(name="paisById",
    query="select p from Pais p where p.id = :id"),
    @NamedQuery(name="delPais",
    	query="delete from Pais p where p.id= :idParam")
})
public class Pais {
	private long id;
	@Column(unique=true)
	private String nombre;
	
	private List<Politico> politicos;
	private Recursos recursos;
	private Guerras guerra;
	
	private Construcciones construcciones;
	private List<ModificadorProduccion> modificadores;
	private Date lastProduction;
	private Usuario usuario;
	
	private List<Evento> eventos;
	
	
	//Un pais puede pertenecer a varias comunidades economicas
	private List<ComunidadEconomica> miComunidad;
	
	public Pais(){
		
	}
	
	
	
	public Pais(Construcciones construcciones, String nombre,  Recursos recursos) {
	
		this.nombre = nombre;
		this.construcciones = construcciones;
		this.recursos = recursos;
		this.guerra = new Guerras();
		this.guerra.setPropietario(this);
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		this.lastProduction = new Date(yesterday.getTimeInMillis());
		this.usuario = null;
		this.miComunidad = new ArrayList<ComunidadEconomica>();
		this.eventos = new ArrayList<Evento>();
	}
	@OneToOne(targetEntity=Usuario.class, fetch=FetchType.EAGER)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Id
    @GeneratedValue
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el nombre del pa�s
	 * @return
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(targetEntity=Politico.class)
	@JoinColumn(name="propietario") 
	public List<Politico> getPoliticos() {
		return politicos;
	}
	public void setPoliticos(List<Politico> politicos) {
		this.politicos = (List<Politico>) politicos;
	}
	
	
	@OneToOne(targetEntity=Recursos.class,cascade=CascadeType.ALL)  
	public Recursos getRecursos() {
		return recursos;
	}
	public void setRecursos(Recursos recursos) {
		this.recursos = recursos;
	}
	
	@OneToOne(targetEntity=Guerras.class,cascade=CascadeType.ALL)
	public Guerras getGuerra() {
		return guerra;
	}
	public void setGuerra(Guerras guerra) {
		this.guerra = guerra;
	}
	@OneToOne(targetEntity=Construcciones.class,cascade=CascadeType.ALL)
	public Construcciones getConstrucciones() {
		return construcciones;
	}
	public void setConstrucciones(Construcciones construcciones) {
		this.construcciones = construcciones;
	}
	@OneToMany(targetEntity=ModificadorProduccion.class)
	@JoinColumn(name="propietario") 
	public List<ModificadorProduccion> getModificadores() {
		return modificadores;
	}
	public void setModificadores(List<ModificadorProduccion> modificadores) {
		this.modificadores =  modificadores;
	}
	
	
	/**
	 * Recibe un objeto y determina si es un pa�s.
	 * 
	 * @param o Un objeto que compara si el recibido es el mismo pa�s
	 * @return true si tienen el mismo ID
	 */
	public boolean equals(Object o){
		//No es de la clase
		if(o.getClass()!=Pais.class) return false;
		//El id del pa�s es igual
		if(this.id == ((Pais) o).id) return true;
		
		return false;
	
	}

	/**
	 * Produce los recursos del pa�s, s�lo una vez al d�a
	 * 
	 * @return true si ha producido, false si hoy ya se hab�a producido
	 */
	public boolean produce() {

		// Si hoy se ha producido, no se produce m�s
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		if (this.lastProduction.compareTo(today) == 0)
			return false;

		// Si no se ha producido, se actualiza la fecha
		this.lastProduction = today;

		int cantidades[] = new int[TipoRecurso.getNumTipoRecursos()];
		for (int i = 0; i < TipoRecurso.getNumTipoRecursos(); i++) {
			cantidades[i] = 0;
		}
		System.out.println("LLega2");

		int percentModify[] = this.calculaModificadores();

		for (int i = 0; i < TipoConstruccion.getNumConstrucciones(); i++) {
			for (int j = 0; j < TipoRecurso.getNumTipoRecursos(); j++) {
				// La producci�n de cada edificio se suma ponderada con su
				// modificador
				cantidades[j] += this.construcciones.getProduccionRecurso(i, j) * (100 - percentModify[j]);
			}
		}

		this.recursos.produce(cantidades);

		return true;
	}

	/**
	 * Calcula los modificadores de producci�n
	 * 
	 * @return
	 */
	private int[] calculaModificadores() {

		int porcentajes[] = new int[TipoRecurso.getNumTipoRecursos()];
		for (int i = 0; i < TipoRecurso.getNumTipoRecursos(); i++) {
			porcentajes[i] = 0;
		}
		System.out.println("llega");
		
		Iterator<ModificadorProduccion> iterador = null;
		if (this.modificadores == null || this.modificadores.size()<1 || (iterador = this.modificadores.iterator())==null){
			return new int[] { 0, 0, 0, 0 };
		}

		
		while (iterador.hasNext()) {
			ModificadorProduccion p = ((ModificadorProduccion) iterador);
			int tipo = TipoRecurso.getIndice(p.getTipo());
			porcentajes[tipo] += p.getPorcentaje();
		}

		return porcentajes;
	}
	public void addModificador(ModificadorProduccion m){
		this.modificadores.add(m);
	}
	

	public Date getLastProduction() {
		return lastProduction;
	}

	public void setLastProduction(Date lastProduction) {
		this.lastProduction = lastProduction;
	}


	@ManyToMany(targetEntity=ComunidadEconomica.class,fetch=FetchType.EAGER)
	public List<ComunidadEconomica> getMiComunidad() {
		return miComunidad;
	}



	public void setMiComunidad(List<ComunidadEconomica> miComunidad) {
		this.miComunidad = miComunidad;
	}

	@OneToMany(targetEntity=Evento.class)
	@JoinColumn(name="propietario_evento") 
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = (List<Evento>) eventos;
	}

	

	
	
}
