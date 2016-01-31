package es.fdi.iw.model.pais.construcciones;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

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
@Entity
@NamedQueries({
    @NamedQuery(name="allConstrucciones",
            query="select c from Construcciones c"),
    @NamedQuery(name="ConstruccionesById",
    query="select c from Construcciones c where c.id = :id")
})
public class Construcciones {
	
	private long id;
	//[TiposConstruccion]
	private Politico[] politicoAlojado;
	private String[] nombres;
	private int[] nivel;
	
	//[TiposConstruccion][TipoRecurso]
	private int[][] coste;
	private int[][] produccion_hora;


	public Construcciones(){}
	/**
	 *  Crea el conjunto de construcciones para un pais
	 */
	public Construcciones(String needed){
		int max_construcciones =TipoConstruccion.getNumConstrucciones();
		int max_recursos = TipoRecurso.getNumTipoRecursos();
			this.nivel = new int [max_construcciones];
			this.nombres = new String [max_construcciones];
			this.coste = new int [max_construcciones][max_recursos];
			this.produccion_hora = new int [max_construcciones][max_recursos];
            for(int i=0; i<max_construcciones;i++){
                this.nivel[i]=1;
                this.politicoAlojado=null;
                for(int j=0;j<max_recursos;j++){
                    this.coste[i][j]=1;
                    this.produccion_hora[i][j]=1;   
                }
                this.nombres[i]=TipoConstruccion.getConstruccion(i).toString();
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
	@OneToMany(targetEntity=Politico.class)
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
    
    
	@Id
    @GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public void setNombres(String[] nombres){
		this.nombres=nombres;
	}
	public String[] getNombres(){
		return this.nombres;
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

	public Politico[] getPoliticoAlojado() {
		return politicoAlojado;
	}
	public void setPoliticoAlojado(Politico[] politicoAlojado) {
		this.politicoAlojado = politicoAlojado;
	}
	public int[] getNivel() {
		return nivel;
	}
	public void setNivel(int[] nivel) {
		this.nivel = nivel;
	}
	public int[][] getCoste() {
		return coste;
	}
	public void setCoste(int[][] coste) {
		this.coste = coste;
	}
	public int[][] getProduccion_hora() {
		return produccion_hora;
	}
	public void setProduccion_hora(int[][] produccion_hora) {
		this.produccion_hora = produccion_hora;
	}
}
