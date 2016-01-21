package es.fdi.iw.model.pais.relaciones;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 3c4ebb4... cambios para mergear
import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
=======
>>>>>>> 3c4ebb4... cambios para mergear

import es.fdi.iw.model.pais.Pais;
import es.fdi.iw.model.pais.eventos.Evento;
import es.fdi.iw.model.pais.eventos.GestorEventos;
import es.fdi.iw.model.pais.eventos.TipoEvento;



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
<<<<<<< HEAD
public class Guerras {
	/* Tuplas de (Pais, eventos)*/
	private long id;
	private ArrayList<Pair<Pais, GestorEventos>> guerrasYEventos;
	private Pais propietario;
	
	public Guerras(){}
	
	/**
	 * Se debe entregar el paÃ­s al que pertenece la alianza
	 * 
	 * @param pais el pais que posee la lista de alianzas
	 * @throws IOException si el paÃ­s estÃ¡ vacÃ­o
	 */
	public Guerras(Pais pais) throws IOException{
		this.guerrasYEventos = new ArrayList<Pair<Pais,GestorEventos>>();
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
		Pair<Pais, GestorEventos> par = new Pair<Pais, GestorEventos>(p,null);
		
		if (this.guerrasYEventos.contains(par)) return false;
		par.setRight(new GestorEventos(TipoEvento.GUERRA));
		return this.guerrasYEventos.add(par);
	}
	/**
	 * Acaba una guerra
	 * @param p el paÃ­s con el que se quiere terminar la guerra
	 * @return true si se acaba la guerra, false si no existe o no se puede borrar
	 */
	public boolean acabaGuerra(Pais p){
		Pair<Pais, GestorEventos> par = new Pair<Pais, GestorEventos>(p,null);
		if(!this.guerrasYEventos.contains(par)){
			return false;
		}
		if(this.guerrasYEventos.remove(par)){
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
		Pair<Pais, GestorEventos> par = new Pair<Pais, GestorEventos>(p,null);
		return this.guerrasYEventos.contains(par);
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
		
		int idx = this.guerrasYEventos.lastIndexOf(new Pair<Pais, GestorEventos>(p,null));
		
		if (idx>0) return null;
		//Obtiene el par país/EventosGuerra, saca EventosGuerra y de este el evento actual. 
		return ((GestorEventos)
					((Pair<Pais,GestorEventos>)
							this.guerrasYEventos.get(idx)
					).getRight()
				).getEventoActual();	
	}
	/**
	 * Obtiene una list de los eventos pasados con todos los países
	 * @param p un país
	 * @return la lista de eventos si el país está en guerra, null en caso contrario
	 */
	public ArrayList<Evento> getEventosPasados(Pais p){
		
		int idx = this.guerrasYEventos.lastIndexOf(new Pair<Pais, GestorEventos>(p,null));
		
		if (idx>0) return null;
		//Obtiene el par país/EventosGuerra, saca EventosGuerra y de este los eventos pasados. 
<<<<<<< HEAD
		return ((GestorEventos)
=======
		return (ArrayList<Evento>) ((GestorEventos)
>>>>>>> 0c59353... Crea Tablas
					((Pair<Pais,GestorEventos>)
							this.guerrasYEventos.get(idx)
					).getRight()
				).getEventos();	
	}

	
	
=======
=======
>>>>>>> 3c4ebb4... cambios para mergear
public class Guerras {
	/* Tuplas de (Pais, eventos)*/
	private long id;
	private ArrayList<Pair<Pais, GestorEventos>> guerrasYEventos;
	private Pais propietario;
	
	public Guerras(){}
	
	/**
	 * Se debe entregar el paÃ­s al que pertenece la alianza
	 * 
	 * @param pais el pais que posee la lista de alianzas
	 * @throws IOException si el paÃ­s estÃ¡ vacÃ­o
	 */
	public Guerras(Pais pais) throws IOException{
		this.guerrasYEventos = new ArrayList<Pair<Pais,GestorEventos>>();
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

<<<<<<< HEAD
>>>>>>> 43e87a0... Pruebas para hacer merge
=======
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
		Pair<Pais, GestorEventos> par = new Pair<Pais, GestorEventos>(p,null);
		
		if (this.guerrasYEventos.contains(par)) return false;
		par.setRight(new GestorEventos(TipoEvento.GUERRA));
		return this.guerrasYEventos.add(par);
	}
	/**
	 * Acaba una guerra
	 * @param p el paÃ­s con el que se quiere terminar la guerra
	 * @return true si se acaba la guerra, false si no existe o no se puede borrar
	 */
	public boolean acabaGuerra(Pais p){
		Pair<Pais, GestorEventos> par = new Pair<Pais, GestorEventos>(p,null);
		if(!this.guerrasYEventos.contains(par)){
			return false;
		}
		if(this.guerrasYEventos.remove(par)){
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
		Pair<Pais, GestorEventos> par = new Pair<Pais, GestorEventos>(p,null);
		return this.guerrasYEventos.contains(par);
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
		
		int idx = this.guerrasYEventos.lastIndexOf(new Pair<Pais, GestorEventos>(p,null));
		
		if (idx>0) return null;
		//Obtiene el par país/EventosGuerra, saca EventosGuerra y de este el evento actual. 
		return ((GestorEventos)
					((Pair<Pais,GestorEventos>)
							this.guerrasYEventos.get(idx)
					).getRight()
				).getEventoActual();	
	}
	/**
	 * Obtiene una list de los eventos pasados con todos los países
	 * @param p un país
	 * @return la lista de eventos si el país está en guerra, null en caso contrario
	 */
	public ArrayList<Evento> getEventosPasados(Pais p){
		
		int idx = this.guerrasYEventos.lastIndexOf(new Pair<Pais, GestorEventos>(p,null));
		
		if (idx>0) return null;
		//Obtiene el par país/EventosGuerra, saca EventosGuerra y de este los eventos pasados. 
		return (ArrayList<Evento>) ((GestorEventos)
					((Pair<Pais,GestorEventos>)
							this.guerrasYEventos.get(idx)
					).getRight()
				).getEventos();	
	}
>>>>>>> 3c4ebb4... cambios para mergear
}
