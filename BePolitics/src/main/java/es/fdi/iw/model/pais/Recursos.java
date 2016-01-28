package es.fdi.iw.model.pais;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 * La clase simboliza los recursos que hay. Se puede a�adir algo de un tipo de recurso y restar.
 * Para restar hay que sumar una cantidad negativa.
 * Los recursos van en el mismo orden que TipoRecurso:
 * 
 * PIB,
 * APOYO_POPULAR,
 * ENERGIA,
 * POBLACION
 * 
 * @author Ismael
 * @see TipoRecurso
 *
 */
@Entity
@NamedQueries({
    @NamedQuery(name="allRecursos",
            query="select r from Recursos r"),
    @NamedQuery(name="RecursosById",
    query="select r from Recursos r where r.id = :id")
})
public class Recursos {
	private long id;
	private int resources[];
	private static final int minimo = 10;
	
	
	
	/**
	 * Inicializa los recursos al m�nimo
	 */
	
	public  Recursos(){
		this.resources = new int[TipoRecurso.getNumTipoRecursos()];
		
		for(int i=0; i<TipoRecurso.getNumTipoRecursos();i++){
			this.resources[i] = minimo;
		}
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
	 * Obtiene la cantidad de un recurso que tiene la clase
	 * @param r el recurso a obtener
	 * @return la cantidad de recurso que hay, -1 en caso de fallo
	 */
	public int getRecurso(TipoRecurso r){
		return getRecurso(TipoRecurso.getIndice(r));
	}
    /**
     * Devuelve el recurso por su índice
     * @param idx el índice del recurso, debe estar entre 0 y Tipo
     * @return -1 si el índice no es correcto, la cantidad del recurso en otro caso
     */
    public int getRecurso(int idx){
        if(idx < 0 || idx >= TipoRecurso.getNumTipoRecursos()) return -1;
        return this.resources[idx];
    }
	
    public int getPIB(){
        return this.resources[TipoRecurso.getIndice(TipoRecurso.PIB)];
	}
 	public void setPIB(int p){
     this.resources[TipoRecurso.getIndice(TipoRecurso.PIB)] = p;
	}
 	public int getAPOYO_POPULAR(){
        return this.resources[TipoRecurso.getIndice(TipoRecurso.APOYO_POPULAR)];
	}
 	public void setAPOYO_POPULAR(int p){
     this.resources[TipoRecurso.getIndice(TipoRecurso.APOYO_POPULAR)] = p;
	}

 	public int getENERGIA(){
        return this.resources[TipoRecurso.getIndice(TipoRecurso.ENERGIA)];
	}
 	public void setENERGIA(int p){
     this.resources[TipoRecurso.getIndice(TipoRecurso.ENERGIA)] = p;
	}
 	public int getPOBLACION(){
        return this.resources[TipoRecurso.getIndice(TipoRecurso.POBLACION)];
	}
 	public void setPOBLACION(int p){
     this.resources[TipoRecurso.getIndice(TipoRecurso.POBLACION)] = p;
	}
 	/*
 	 	
	public int getApoyo_Popular(){
		return getRecurso(TipoRecurso.APOYO_POPULAR);
	}
	public int getEnergia(){
		return getRecurso(TipoRecurso.ENERGIA);
	}
	public int getPoblacion(){
		return getRecurso(TipoRecurso.POBLACION);
	}*/
	
	/**
	 * Recibe un array de recursos que se suma a los recursos actuales
	 * @param recursos un array de enteros
	 */
	public void produce(int[] recursos){
		for(int i=0; i<TipoRecurso.getNumTipoRecursos();i++){
			this.resources[i]+=recursos[i];
		}
	}


    /**
	 * Suma a un determinado recurso a una cantidad
	 * @param r
	 * @param cantidad
	 */
	public void sumaRecurso(TipoRecurso r, int cantidad){
			this.resources[TipoRecurso.getIndice(r)] +=cantidad;
	}
	
	
	
}
