package es.fdi.iw.model.pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Representa un paï¿½s
 * 
 * @author Ismael 
 */
@Entity
public class Pais {
	/*
	private ArrayList<Politico> politicos;
	private Recursos recursos;
	*/
	private int id_pais;
	private String nombre_pais;
	/*
	private Guerras guerra;
	private Construcciones construcciones;
	private ComunidadEconomica comunidad;
	private ArrayList<ModificadorProduccion> modificadores;
	private Date lastProduction;
	*/
	public Pais(int id_pais, String nombre) {
		
		this.id_pais = id_pais;
		this.nombre_pais = nombre;
	
		/*
		try {
			this.guerra = new Guerras(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.construcciones = new Construcciones();
		
		this.comunidad=null;
		this.recursos = new Recursos();
		
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		this.lastProduction = new Date(yesterday.getTimeInMillis());
	    */
		
	}
	
	
	@Id
    @GeneratedValue
	public int getId_pais() {
		return id_pais;
	}

	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	public String getNombre_pais() {
		return nombre_pais;
	}

	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}
	
	


	
	
/*	
    public boolean equals(Object o){
		
		if(o.getClass()!=Pais.class) return false;
		
		if(this.id_pais == ((Pais) o).id_pais) return true;
		return false;
		
	}
	
	/**
	 * Obtiene el nombre del país
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Produce los recursos del país, sólo una vez al día
	 * @return true si ha producido, false si hoy ya se había producido
	 */
	public boolean produce(){
	
		/*Si hoy se ha producido, no se produce más*/
		Date today = new Date(Calendar.getInstance().getTimeInMillis());
		if(this.lastProduction.compareTo(today) == 0) return false;
		/*Si no se ha producido, se actualiza la fecha */
		this.lastProduction = today;
		
		
		int cantidades[] = new int[TipoRecurso.getNumTipoRecursos()];
		for(int i=0;i<TipoRecurso.getNumTipoRecursos();i++){
			cantidades[i]=0;
		}
		
		int percentModify[] = this.calculaModificadores();
		
		for(int i =0;i<TipoConstruccion.getNumConstrucciones();i++){
			for(int j=0; j<TipoRecurso.getNumTipoRecursos();j++){
				/*La producción de cada edificio se suma ponderada con su modificador */
				cantidades[j]+= this.construcciones.getProduccionRecurso(i, j) *(100-percentModify[j]);
			}
		}
		this.recursos.produce(cantidades);
		return true;
	}
	/**
	 * Calcula los modificadores de producción
	 * @return
	 */
	private int[] calculaModificadores(){
		int porcentajes[] = new int[TipoRecurso.getNumTipoRecursos()];
		for(int i=0;i<TipoRecurso.getNumTipoRecursos();i++){
			porcentajes[i]=0;
		}
		
		Iterator<ModificadorProduccion> iterador = this.modificadores.iterator();
		while (iterador.hasNext()) {
			ModificadorProduccion p = ((ModificadorProduccion) iterador);
			int tipo = TipoRecurso.getIndice(p.getTipo());
			porcentajes[tipo] += p.getPorcentaje(); 
		}
		
		return porcentajes;
		
	}
	
	public Guerras getGuerras(){
		return this.guerra;
	}
	
	public void addModificador(ModificadorProduccion m){
		this.modificadores.add(m);
	}
*/


	




}
