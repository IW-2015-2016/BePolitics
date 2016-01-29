package es.fdi.iw.model.politicos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import es.fdi.iw.model.modificadores.ModificadorProduccion;
import es.fdi.iw.model.pais.Pais;

/**
 * Esta clase representa un pol�tico. Sus stats deben estar siempre entre 0 y 100 y para ello
 * hay un nuevo tipo de excepci�n que lo representa. tambi�n est� �ntimamente relacionado con 
 * el enumerado StatsPol�tico 
 * 
 * 
 * @author Ismael
 * @see ExcepcionPolitico
 * @see StatsPol�tico
 */

@Entity
@NamedQueries({
    @NamedQuery(name="allPoliticos",
            query="select p from Politico p"),
    @NamedQuery(name="politicoById",
            query="select p from Politico p where p.id=:idParam"),

    @NamedQuery(name="deletePolitico",
            query="delete from Politico p where p.id=:idParam")
})
public class Politico {
	//Orden: {HONESTIDAD,CARISMA,ELOCUENCIA,POPULARIDAD}
	private long id;
	/***********************/
	/**Stats**/
	private int honestidad;
	private int carisma;
	private int elocuencia;
	private int popularidad;
	/***********************/
	private int sumaStats;
	private String nombre;
	private String cita;
	private Double precio;
	private Pais propietario; 

	
	public Politico(){}
	/*********************/
	/****CONSTRUCTORES****/
	/*********************/
	
	/**
	 * Constructor con todos los par�metros
	 * @param nombre el nombre
	 * @param honestidad honestidad del 0 al 100
	 * @param carisma carisma del 0 al 100
	 * @param elocuencia elocuencia del 0 al 100
	 * @param popularidad apoyo popular del 0 al 100
	 * @param quote algo c�lebre dicho por el pol�tico
	 * @param mod un modificador que ser� clonado para evitar errores de modificacion indeseables.
	 * @throws ExceptionPolitico Lanza exception cuando los valores no est�n en el intervalo cerrado [0,100]
	 */
	public Politico(int carisma,int elocuencia, int honestidad, ModificadorProduccion mod,String nombre,int popularidad, String quote) throws ExceptionPolitico{
		
		this.nombre = nombre;
		this.carisma = carisma;
		this.elocuencia=elocuencia;
		this.honestidad=honestidad;
		this.popularidad=popularidad;
		this.propietario=null;
		this.cita=quote;
			

	}
		/**
		 * Constructor con todos los par�metros menos el modificador de produccion
		 * @param nombre el nombre
		 * @param honestidad honestidad del 0 al 100
		 * @param carisma carisma del 0 al 100
		 * @param elocuencia elocuencia del 0 al 100
		 * @param popularidad apoyo popular del 0 al 100
		 * @param quote algo c�lebre dicho por el pol�tico
		 * @throws ExceptionPolitico Lanza exception cuando los valores no est�n en el intervalo cerrado [0,100]
		 */
	public Politico(int carisma,int elocuencia, int honestidad,String nombre,int popularidad, String quote, Pais propietario, Double precio) throws ExceptionPolitico{
		this.nombre = nombre;
		this.carisma = carisma;
		this.elocuencia=elocuencia;
		this.honestidad=honestidad;
		this.popularidad=popularidad;
		this.propietario=propietario;
		this.cita=quote;
		this.sumaStats = this.carisma + this.elocuencia + this.honestidad + this.popularidad;
			
			
			
		}

		/**
		 * Constructor con todos los par�metros menos la cita y el modificador de producci�n
		 * @param nombre el nombre
		 * @param honestidad honestidad del 0 al 100
		 * @param carisma carisma del 0 al 100
		 * @param elocuencia elocuencia del 0 al 100
		 * @param popularidad apoyo popular del 0 al 100
		 * @throws ExceptionPolitico Lanza exception cuando los valores no est�n en el intervalo cerrado [0,100]
		 */
		public Politico(String nombre, int honestidad, int carisma, int elocuencia, int popularidad) throws ExceptionPolitico{
			this.setNombre(nombre);
		
			
		}

		/*******************************************/
		/*********Fin de los constructores**********/
		/*******************************************/
		
		
		
	
		/**********************************/
		/********Getters y setters*********/
		/**********************************/
		
		
		/**
		 * Establece un stat s�lamente, indicado por "tipo", el valor debe estar entre 0 y 100 o el cambio no se efectuar� y
		 * ser� lanzada una excepci�n
		 * @param tipo el tipo de stat
		 * @param valor el valor, debe estar entre 0 y 100
		 * @return true si se ha realizado, false en caso contrario
		 * @throws ExceptionPolitico lanza una excepci�n si el valor es menos que 0 o mayor que 100 
		 */
	
		
	
		
	
		public void setCita(String cita){
			this.cita=cita;
		}
		
		public String getCita(){
			return this.cita;
		}

		
		
		

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		@Id
	    @GeneratedValue
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public int getHonestidad() {
			return honestidad;
		}

		public void setHonestidad(int honestidad) {
			this.honestidad = honestidad;
		}

		public int getCarisma() {
			return carisma;
		}

		public void setCarisma(int carisma) {
			this.carisma = carisma;
		}

		public int getElocuencia() {
			return elocuencia;
		}

		public void setElocuencia(int elocuencia) {
			this.elocuencia = elocuencia;
		}

		public int getPopularidad() {
			return popularidad;
		}

		public void setPopularidad(int popularidad) {
			this.popularidad = popularidad;
		}
		
		@ManyToOne(targetEntity=Pais.class)
		public Pais getPropietario() {
			return propietario;
		}
		public void setPropietario(Pais propietario) {
			this.propietario = propietario;
		}

		public int getSumaStats() {
			return sumaStats;
		}

		public void setSumaStats(int sumaStats) {
			this.sumaStats = sumaStats;
		}

		public Double getPrecio() {
			return precio;
		}

		public void setPrecio(Double precio) {
			this.precio = precio;
		}


}

		