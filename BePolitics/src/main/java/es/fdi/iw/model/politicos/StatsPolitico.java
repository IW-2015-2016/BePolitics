package es.fdi.iw.model.politicos;
/**
 * Guarda los stats que puede existir. Adem�s los ordena.
 * 
 * 1 = HONESTIDAD
 * 2 = CARISMA
 * 3 = ELOCUENCIA
 * 4 = POPULARIDAD
 * 
 * Existen m�todos que obtienen el indice o el stat por el �ndice
 * 
 * @author futurDrama
 *
 */
public enum StatsPolitico {
	HONESTIDAD,CARISMA,ELOCUENCIA,POPULARIDAD;
	
	static int getNumStats(){ 
		return 4;
	}
	/**
	 * Devuelve el �ndice del par�metro, de 0 a 4, siendo
	 * 1 = HONESTIDAD
	 * 2 = CARISMA
	 * 3 = ELOCUENCIA
	 * 4 = POPULARIDAD
	 * 
	 * @param s el stat a comprobar
	 * @return un n�mero de 0 a 4
	 */
	static int getIndex(StatsPolitico s){
		int ret =-1;
		switch(s){
		case HONESTIDAD:
			ret = 0;
			break;
		case CARISMA:
			ret = 1;
			break;
		case ELOCUENCIA:
			ret = 2;
			break;
		case POPULARIDAD:
			ret = 3;
			break;
		}
		return ret;
	}
	
	/**
	 * Devuelve el stat determinado por el �ndice del par�metro, de 0 a 4, siendo
	 * 1 = HONESTIDAD
	 * 2 = CARISMA
	 * 3 = ELOCUENCIA
	 * 4 = POPULARIDAD
	 * 
	 * @param s el �ndice stat a comprobar
	 * @return un stat del enumerado, null si el �ndice no era correcto
	 */
	static StatsPolitico getIndex(int s){
		StatsPolitico ret = null;
		if(s >= 0 || s< StatsPolitico.getNumStats()){
			switch(s){
				case 0:
					ret = HONESTIDAD;
					break;
				case 1:
					ret = CARISMA;
					break;
				case 2:
					ret = ELOCUENCIA;
					break;
				case 3:
					ret = POPULARIDAD;
					break;
			}
		}
		return ret;
	}
}
