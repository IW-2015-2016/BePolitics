package es.fdi.iw.model.politicos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Politico {
	//Orden: {HONESTIDAD,CARISMA,ELOCUENCIA,POPULARIDAD}
	private long id;
	private int stats[];
	private String nombre;
	private String cita;
	
	private Pais propietario; 
	/*TODO no funciona Explicacion
	 * private ModificadorProduccion modificador;
	*/
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
	public Politico(String nombre, int honestidad, int carisma, int elocuencia, int popularidad, String quote, ModificadorProduccion mod) throws ExceptionPolitico{
		this.setNombre(nombre);

		this.stats[StatsPolitico.getIndex(StatsPolitico.HONESTIDAD)] = honestidad;
		this.stats[StatsPolitico.getIndex(StatsPolitico.CARISMA)] = carisma;
		this.stats[StatsPolitico.getIndex(StatsPolitico.ELOCUENCIA)] = elocuencia;
		this.stats[StatsPolitico.getIndex(StatsPolitico.POPULARIDAD)] = popularidad;
		
		//this.modificador =  mod.clone();
		this.setCita(quote);
		
		for(int i=0; i < StatsPolitico.getNumStats(); i++)
			if(this.stats[i]< 0 || this.stats[i]>100)
				throw new ExceptionPolitico();
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
		public Politico(String nombre, int honestidad, int carisma, int elocuencia, int popularidad, String quote) throws ExceptionPolitico{
			this.setNombre(nombre);


			this.stats[StatsPolitico.getIndex(StatsPolitico.HONESTIDAD)] = honestidad;
			this.stats[StatsPolitico.getIndex(StatsPolitico.CARISMA)] = carisma;
			this.stats[StatsPolitico.getIndex(StatsPolitico.ELOCUENCIA)] = elocuencia;
			this.stats[StatsPolitico.getIndex(StatsPolitico.POPULARIDAD)] = popularidad;
			
			this.setCita(quote);
			
			for(int i=0; i < StatsPolitico.getNumStats(); i++)
				if(this.stats[i]< 0 || this.stats[i]>100)
					throw new ExceptionPolitico();
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
		
			this.stats[StatsPolitico.getIndex(StatsPolitico.HONESTIDAD)] = honestidad;
			this.stats[StatsPolitico.getIndex(StatsPolitico.CARISMA)] = carisma;
			this.stats[StatsPolitico.getIndex(StatsPolitico.ELOCUENCIA)] = elocuencia;
			this.stats[StatsPolitico.getIndex(StatsPolitico.POPULARIDAD)] = popularidad;

			
			for(int i=0; i < StatsPolitico.getNumStats(); i++)
				if(this.stats[i]< 0 || this.stats[i]>100)
					throw new ExceptionPolitico();
		}
		/**
		 * Constructor con todos los par�metros menos la cita
		 * @param nombre el nombre
		 * @param honestidad honestidad del 0 al 100
		 * @param carisma carisma del 0 al 100
		 * @p	public ModificadorProduccion getModificador(){
			return this.modificador;
		}
		
		public void setModificadorProduccion(ModificadorProduccion mod){
			this.modificador = mod;
		}
		aram elocuencia elocuencia del 0 al 100
		 * @param popularidad apoyo popular del 0 al 100
		 * @throws ExceptionPolitico Lanza exception cuando los valores no est�n en el intervalo cerrado [0,100]
		 */
		/*public Politico(String nombre, int honestidad, int carisma, int elocuencia, int popularidad, ModificadorProduccion mod) throws ExceptionPolitico{
			this.setNombre(nombre);

			this.stats[StatsPolitico.getIndex(StatsPolitico.HONESTIDAD)] = honestidad;
			this.stats[StatsPolitico.getIndex(StatsPolitico.CARISMA)] = carisma;
			this.stats[StatsPolitico.getIndex(StatsPolitico.ELOCUENCIA)] = elocuencia;
			this.stats[StatsPolitico.getIndex(StatsPolitico.POPULARIDAD)] = popularidad;
			
			this.modificador =  mod.clone();
			
			for(int i=0; i < StatsPolitico.getNumStats(); i++)
				if(this.stats[i]< 0 || this.stats[i]>100)
					throw new ExceptionPolitico();
		}
		*/
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
		public void setSingleStat(StatsPolitico tipo, int valor) throws ExceptionPolitico{
			if(valor< 0 || valor>100)
				throw new ExceptionPolitico();
			/*El orden siempre es {HONESTIDAD,CARISMA,ELOCUENCIA,POPULARIDAD}*/
			
			this.stats[StatsPolitico.getIndex(tipo)] = valor;
			
		}
		
		public int getSingleStat(StatsPolitico tipo){
			int ret=-1;
			/*El orden siempre es {HONESTIDAD,CARISMA,ELOCUENCIA,POPULARIDAD}*/
			switch(tipo){
				case HONESTIDAD:
					ret = this.stats[0];
					break;
				case CARISMA:
					ret = this.stats[1];
					break;
				case ELOCUENCIA:
					ret = this.stats[2];
					break;
				case POPULARIDAD:
					ret = this.stats[3];
					break;
			}
			
			return ret;
		}
		
	
		public void setCita(String cita){
			this.cita=cita;
		}
		
		public String getCita(){
			return this.cita;
		}

		
		
		private int[] getStats() {
			return stats;
		}

		private void setStats(int stats[]) {
			try {
				
			for(int i=0; i < StatsPolitico.getNumStats(); i++)
				if(stats[i]< 0 || stats[i]>100)
						throw new ExceptionPolitico();
						
				this.stats = stats;
				
			} catch (ExceptionPolitico e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			
		}

		private String getNombre() {
			return nombre;
		}

		private void setNombre(String nombre) {
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
		
		
		@ManyToOne(targetEntity=Pais.class)
		public Pais getPropietario() {
			return propietario;
		}
		public void setPropietario(Pais propietario) {
			this.propietario = propietario;
		}
		
}
