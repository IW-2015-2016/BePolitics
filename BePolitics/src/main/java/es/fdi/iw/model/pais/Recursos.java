package es.fdi.iw.model.pais;

import java.util.Random;

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
public class Recursos {
	private int resources[];
	private static final int minimo = 10;
	/**
	 * Inicializa los recursos al m�nimo
	 */
	public Recursos(){
		this.resources = new int[TipoRecurso.getNumTipoRecursos()];
		
		for(int i=0; i<TipoRecurso.getNumTipoRecursos();i++){
			this.resources[i] = minimo;
		}
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
		return getRecurso(TipoRecurso.PIB);
	}
	public int getApoyo_Popular(){
		return getRecurso(TipoRecurso.APOYO_POPULAR);
	}
	public int getEnergia(){
		return getRecurso(TipoRecurso.ENERGIA);
	}
	public int getPoblacion(){
		return getRecurso(TipoRecurso.POBLACION);
	}
	
	/**
	 * Suma a un determinado recurso a una cantidad
	 * @param r
	 * @param cantidad
	 */
	public void sumaRecurso(TipoRecurso r, int cantidad){
			this.resources[TipoRecurso.getIndice(r)] +=cantidad;
	}
	/**
	 * Recibe un array de recursos que se suma a los recursos actuales
	 * @param recursos un array de enteros
	 */
	public void produce(int[] recursos){
		for(int i=0; i<TipoRecurso.getNumTipoRecursos();i++){
			this.resources[i]+=recursos[i];
		}
	}
	
}
