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
	//private ArrayList<Politico> politicos;
	//private Recursos recursos;
	private int id_pais;
	private String nombre_pais;
	//private Guerras guerra;
	//private Construcciones construcciones;
	//private ComunidadEconomica comunidad;
	public Pais(int id_pais, String nombre) {
		
		this.id_pais = id_pais;
		this.nombre_pais = nombre;
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
	public Pais(String nom) {
		this.nombre = nom;
		//TODO autogenerar el ID
		try {
			this.guerra = new Guerras(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.construcciones = new Construcciones();
		
		
		this.comunidad=null;
		
		
		
		
	}
	*/

/*	public boolean equals(Object o){
		
		if(o.getClass()!=Pais.class) return false;
		
		if(this.id_pais == ((Pais) o).id_pais) return true;
		return false;
		
	}

*/


	




}
