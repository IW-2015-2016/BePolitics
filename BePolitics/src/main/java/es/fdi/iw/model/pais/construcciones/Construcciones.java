package pais.construcciones;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pais.TipoRecurso;
import pais.TipoRecurso;
import politicos.Politico;
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
     * Sustituye el polÃ­tico alojado
     * @param newPolitico el nuevo polÃ­tico
     * @param t el tipo de construcciÃ³n en el que se le aloja
     */
	public void setPolitico(Politico newPolitico, TipoConstruccion t){
		this.politicoAlojado[TipoConstruccion.getIndex(t)] = newPolitico;
	}
	
	/**
         * Devuelve el polÃ­tico alojado
         * @param t el edificio del que se quiere obtener el polÃ­tico
         * @return el polÃ­tico alojado
         */
	public Politico getPolitico(TipoConstruccion t){
		return this.politicoAlojado[TipoConstruccion.getIndex(t)];
	}
	
	/**
     * Toma una construcciÃ³n, comprueba si hay recursos, si los hay sube el nivel,
     * multiplica los costes y la producciÃ³n
     * @param t el tipo de construcciÃ³n
     * @param r los recursos del paÃ­s
     * @return true si se lleva a cabo y false en caso contrario
     */
    public boolean subeNivel(TipoConstruccion t, pais.Recursos r){
        
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
        
            
        //Multiplicador de producciÃ³n
        for(int i =0;i<TipoRecurso.getNumTipoRecursos();i++)
            this.produccion_hora[idxConstruccion][i]*=TipoConstruccion.multiplicadorProduccion[i];
        
        return true;            
    }
    /**
     * Devuelve el nivel de la construccion
     * @param t el tipo de construcción
     * @return el nivel de la construccion
     */
    public int getNivelConstruccion(TipoConstruccion t){
    	return nivel[TipoConstruccion.getIndex(t)];
    }
    /**
     * Devuelve la producción de un recurso concreto en un edificio concreto
     * @param c la construcción 
     * @param r el recurso
     * @return La producción
     */
    public int getProduccionRecurso(TipoConstruccion c, TipoRecurso r){
    	return this.produccion_hora[TipoConstruccion.getIndex(c)][TipoRecurso.getIndice(r)];
    }
}
