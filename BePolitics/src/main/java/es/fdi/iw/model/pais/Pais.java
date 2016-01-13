package es.fdi.iw.model.pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Representa un pa�s
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

*/


	




}
