package es.fdi.iw.model.pais;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import es.fdi.iw.model.modificadores.ModificadorProduccion;
import es.fdi.iw.model.pais.construcciones.Construcciones;
import es.fdi.iw.model.pais.construcciones.TipoConstruccion;
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
	private ArrayList<ModificadorProduccion> modificadores;
	private Date lastProduction;
	
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
		this.recursos = new Recursos();
		
		Calendar yesterday = Calendar.getInstance();
		yesterday.add(Calendar.DATE, -1);
		this.lastProduction = new Date(yesterday.getTimeInMillis());
		
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

}
