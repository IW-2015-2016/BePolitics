package pais.relaciones;

import java.io.IOException;
import java.util.ArrayList;

import pais.Pais;
import pais.eventos.EventosGuerra;
/**
 * Representa todas las guerras que tiene un pa�s. Permite la creaci�n de nuevas guerras y la finalizaci�n.
 * cada guerra tiene asociada una clase EventosGuerra que contendr� todos los eventos de esa guerra pasados
 * y el evento activo
 * 
 * @author Ismael
 * @see Pair<L,R>
 * @see Pais
 * @see EventosGuerra
 *
 */
public class Guerras {
	/* Tuplas de (Pais, eventos)*/
	private ArrayList<Pair<Pais, EventosGuerra>> guerrasYEventos;
	private Pais propietario;
	/**
	 * Se debe entregar el país al que pertenece la alianza
	 * 
	 * @param pais el pais que posee la lista de alianzas
	 * @throws IOException si el país está vacío
	 */
	public Guerras(Pais pais) throws IOException{
		this.guerrasYEventos = new ArrayList<Pair<Pais,EventosGuerra>>();
		if (pais == null) throw new IOException();
		this.propietario = pais;
		
	}
	/**
	 * Devuelve el nombre del pais que tiene guardada esta lista de aliados
	 * @return el nombre de quien tiene la lista de aliado
	 */
	public String propietario(){
		return this.propietario.getNombre();
	}
	/**
	 * Entra en guerra con un pais. Si el pais ya estaba en guerra devolverá falso, si p es null, lanzará una excepción
	 * 
	 * @param p
	 * @return
	 * @throws IOException 
	 */
	public boolean entrarEnGuerra(Pais p) throws IOException{
		if(p==null) throw new IOException();
		
		//Crea un par para buscar el pa�s
		Pair<Pais, EventosGuerra> par = new Pair<Pais, EventosGuerra>(p,null);
		
		if (this.guerrasYEventos.contains(par)) return false;
		par.setRight(new EventosGuerra());
		return this.guerrasYEventos.add(par);
	}
	/**
	 * Acaba una guerra
	 * @param p el país con el que se quiere terminar la guerra
	 * @return true si se acaba la guerra, false si no existe o no se puede borrar
	 */
	public boolean acabaGuerra(Pais p){
		Pair<Pais, EventosGuerra> par = new Pair<Pais, EventosGuerra>(p,null);
		if(!this.guerrasYEventos.contains(par)){
			return false;
		}
		if(this.guerrasYEventos.remove(par)){
			//TODO añadir a los paises eventos de eliminación de la alianza en tiempo x
			
			return true;
		}
		return false;
	}
	
	/**
	 * Comprueba si un país está en guerra con este
	 * @param p el país
	 * @return true si es enemigo, false en caso contrario
	 */
	public boolean esEnemigo(Pais p){
		Pair<Pais, EventosGuerra> par = new Pair<Pais, EventosGuerra>(p,null);
		return this.guerrasYEventos.contains(par);
	}
}
