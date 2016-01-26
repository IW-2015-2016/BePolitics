package es.fdi.iw.model.pais.relaciones;


import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;
import es.fdi.iw.model.pais.Pais;
import es.fdi.iw.model.pais.eventos.Evento;
import es.fdi.iw.model.pais.eventos.GestorEventos;
import es.fdi.iw.model.pais.eventos.TipoEvento;
import es.fdi.iw.model.politicos.Politico;



/**
 * Representa todas las guerras que tiene un país. Permite la creación de nuevas guerras y la finalización.
 * cada guerra tiene asociada una clase EventosGuerra que contendrá todos los eventos de esa guerra pasados
 * y el evento activo
 * 
 * @author Ismael
 * @see Pair<L,R>
 * @see Pais
 * @see EventosGuerra
 *
 */
@Entity
public class Guerras {
	/* Tuplas de (Pais, eventos)*/
	private long id;
	private ArrayList<Pair> guerrasYEventos;
	private Pais propietario;
	
	public Guerras(){}
	
	/**
	 * Se debe entregar el paÃ­s al que pertenece la alianza
	 * 
	 * @param pais el pais que posee la lista de alianzas
	 * @throws IOException si el paÃ­s estÃ¡ vacÃ­o
	 */
	public Guerras(Pais pais) throws IOException{
		this.setGuerrasYEventos(new ArrayList<Pair>());
		if (pais == null) throw new IOException();
		this.propietario = pais;
		
	}

    @Id
    @GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Devuelve el nombre del pais que tiene guardada esta lista de aliados
	 * @return el nombre de quien tiene la lista de aliado
	 */
	public String propietario(){
		return this.propietario.getNombre();
	}
	/**
	 * Entra en guerra con un pais. Si el pais ya estaba en guerra devolverÃ¡ falso, si p es null, lanzarÃ¡ una excepciÃ³n
	 * 
	 * @param p
	 * @return
	 * @throws IOException 
	 */
	public boolean entrarEnGuerra(Pais p) throws IOException{
		if(p==null) throw new IOException();
		
		//Crea un par para buscar el país
		Pair par = new Pair(p,null);
		
		if (this.getGuerrasYEventos().contains(par)) return false;
		par.setRight(new GestorEventos(TipoEvento.GUERRA));
		return this.getGuerrasYEventos().add(par);
	}
	/**
	 * Acaba una guerra
	 * @param p el paÃ­s con el que se quiere terminar la guerra
	 * @return true si se acaba la guerra, false si no existe o no se puede borrar
	 */
	public boolean acabaGuerra(Pais p){
		Pair par = new Pair(p,null);
		if(!this.getGuerrasYEventos().contains(par)){
			return false;
		}
		if(this.getGuerrasYEventos().remove(par)){
			//TODO aÃ±adir a los paises eventos de eliminaciÃ³n de la alianza en tiempo x
			
			return true;
		}
		return false;
	}
	
	/**
	 * Comprueba si un paÃ­s estÃ¡ en guerra con este
	 * @param p el paÃ­s
	 * @return true si es enemigo, false en caso contrario
	 */
	public boolean esEnemigo(Pais p){
		Pair par = new Pair(p,null);
		return this.getGuerrasYEventos().contains(par);
	}
	/**
	 * Dice si el país es propietario de esta lista de guerras
	 * @param p el país
	 * @return true si el país es igual al propietario
	 */
	public boolean esPropietario(Pais p){
		return this.propietario.equals(p);
		
	}
	/**
	 * Contiene el evento actual de la guerra, 
	 * @param p el pais
	 * @return un evento si lo hay, si no lo hay o no se esta en guerra, devuelve null
	 */
	public Evento getEventoActual(Pais p){
		
		int idx = this.getGuerrasYEventos().lastIndexOf(new Pair(p,null));
		
		if (idx>0) return null;
		//Obtiene el par país/EventosGuerra, saca EventosGuerra y de este el evento actual. 
		return ((GestorEventos)
					((Pair)
							this.getGuerrasYEventos().get(idx)
					).getRight()
				).getEventoActual();	
	}
	/**
	 * Obtiene una list de los eventos pasados con todos los países
	 * @param p un país
	 * @return la lista de eventos si el país está en guerra, null en caso contrario
	 */
	public ArrayList<Evento> getEventosPasados(Pais p){
		
		int idx = this.getGuerrasYEventos().lastIndexOf(new Pair(p,null));
		
		if (idx>0) return null;
		//Obtiene el par país/EventosGuerra, saca EventosGuerra y de este los eventos pasados. 

	

		return (ArrayList<Evento>) ((GestorEventos)

					((Pair)
							this.getGuerrasYEventos().get(idx)
					).getRight()
				).getEventos();	
	}
	@OneToMany(targetEntity=Pair.class)
	@JoinColumn(name="guerra") 
	private List<Pair> getGuerrasYEventos() {
		return  guerrasYEventos;
	}

	private void setGuerrasYEventos(List<Pair> guerrasYEventos) {
		this.guerrasYEventos =  (ArrayList<Pair>) guerrasYEventos;
	}

}
