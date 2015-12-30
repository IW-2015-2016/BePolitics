package es.fdi.iw.model.pais;

import java.io.IOException;
import java.util.ArrayList;

import es.fdi.iw.model.pais.construcciones.Construcciones;
import es.fdi.iw.model.pais.relaciones.ComunidadEconomica;
import es.fdi.iw.model.pais.relaciones.Guerras;
import es.fdi.iw.model.politicos.Politico;


/**
 * Representa un país
 * 
 * @author Ismael 
 */
public class Pais {
	private ArrayList<Politico> politicos;
	private Recursos recursos;
	private int id;
	private String nombre;
	private Guerras guerra;
	private Construcciones construcciones;
	private ComunidadEconomica comunidad;
	
	
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
	
	
	/**
	 * Recibe un objeto y determina si es un país.
	 * 
	 * @param o Un objeto que compara si el recibido es el mismo país
	 * @return true si tienen el mismo ID
	 */
	public boolean equals(Object o){
		
		if(o.getClass()!=Pais.class) return false;
		
		if(this.id == ((Pais) o).id) return true;
		return false;
		
	}



	public String getNombre() {
		return nombre;
	}

}
