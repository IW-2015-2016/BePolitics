package es.fdi.iw.model.pais.construcciones;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.fdi.iw.model.pais.Recursos;
import es.fdi.iw.model.pais.TipoRecurso;
import es.fdi.iw.model.politicos.Politico;


/**
 * Esta clase representa todas las construcciones que puede haber en un país. En ella
 * hay métodos para subir el nivel o la producción, está guardado un multiplicador de costes
 * y de producciones, que será el factor de aumento cuando suba de nivel
 * @author Ismael
 *
 */
public class Construcciones {
	
	//[TiposConstruccion]
	private Politico politicoAlojado[];

	private int nivel[];
	
	//[TiposConstruccion][TipoRecurso]
    //Una de las dimensiones es el tipo de la construccion y la otra el tipo de recurso
    /*
    Ejemplo:
    Ministerio de sanidad.
        -pib
        -felicidad
    Ministerio de justicia.
        -pib
        -felicidad

    */
	private int coste[][];
	private int produccion_hora[][];
	
	
	
	/**
	 *  Crea una construccion desde cero
	 * @param nombre
	 * @param rec
	 */
	public Construcciones(){
            for(int i=0; i<TipoConstruccion.getNumConstrucciones();i++){
                this.nivel[i]=1;
                this.politicoAlojado=null;
                for(int j=0;j<TipoRecurso.getNumTipoRecursos();j++){
                    this.coste[i][j]=1;
                    this.produccion_hora[i][j]=1;   
                }
            }
	}
     
    /**
     * Sustituye el politico alojado
     * @param newPolitico el nuevo politico
     * @param t el tipo de construccion en el que se le aloja
     */
	public void setPolitico(Politico newPolitico, TipoConstruccion t){
		this.politicoAlojado[TipoConstruccion.getIndex(t)] = newPolitico;
	}
	
	/**
         * Devuelve el politico alojado
         * @param t el edificio del que se quiere obtener el politico
         * @return el politico alojado
         */
	public Politico getPolitico(TipoConstruccion t){
		return this.politicoAlojado[TipoConstruccion.getIndex(t)];
	}
	
	/**
     * Toma una construccion, comprueba si hay recursos, si los hay sube el nivel,
     * multiplica los costes y la produccion
     * @param t el tipo de construccion
     * @param r los recursos del pais
     * @return true si se lleva a cabo y false en caso contrario
     */
    public boolean subeNivel(TipoConstruccion t, Recursos r){
        
        int idxConstruccion = TipoConstruccion.getIndex(t);
        // Comprueba si hay recursos
        for (int i =0;i<TipoRecurso.getNumTipoRecursos();i++)
           if(this.coste[idxConstruccion][i]>r.getRecurso(i))
               return false;
        
        // Gastar recursos
        for(int i =0; i<TipoRecurso.getNumTipoRecursos();i++){
            try {
                int idxRecurso =r.getRecurso(i);
                if (r.getRecurso(i) < coste[idxConstruccion][idxRecurso]){
                    return false;
                }
                if(TipoRecurso.seGasta(i)){
                    r.sumaRecurso(TipoRecurso.getRecurso(i), (-1*coste[idxConstruccion][idxRecurso]));
                }
                    
            } catch (IOException ex) {
                Logger.getLogger(Construcciones.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        //subir nivel
        this.nivel[idxConstruccion]++;
        //Multiplicador de coste
        for(int i =0; i<TipoRecurso.getNumTipoRecursos();i++)
            this.coste[idxConstruccion][i]*=TipoConstruccion.multiplicadorCoste[idxConstruccion];
        
            
        //Multiplicador de produccion
        for(int i =0;i<TipoRecurso.getNumTipoRecursos();i++)
            this.produccion_hora[idxConstruccion][i]*=TipoConstruccion.multiplicadorProduccion[i];
        
        return true;            
    }
    /**
     * Devuelve el nivel de la construccion
     * @param t el tipo de construccion
     * @return el nivel de la construccion
     */
    public int getNivelConstruccion(TipoConstruccion t){
    	return nivel[TipoConstruccion.getIndex(t)];
    }
    /**
     * Devuelve la produccion de un recurso concreto en un edificio concreto
     * @param c la construccion 
     * @param r el recurso
     * @return La produccion
     */
    public int getProduccionRecurso(TipoConstruccion c, TipoRecurso r){
    	return this.produccion_hora[TipoConstruccion.getIndex(c)][TipoRecurso.getIndice(r)];
    }
    /**
     * Devuelve la produccion de un recurso concreto en un edificio concreto
     * @param c la el indice de la construccion 
     * @param r el indice del recurso
     * @return La produccion
     */
    public int getProduccionRecurso(int c, int r){
    	return this.getProduccionRecurso(TipoConstruccion.getConstruccion(c),
    									 TipoRecurso.getRecurso(r));
    }
}
