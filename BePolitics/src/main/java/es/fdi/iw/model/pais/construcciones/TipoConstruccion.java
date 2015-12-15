package pais.construcciones;

public enum TipoConstruccion {
	MINISTERIO_DE_INDUSTRIA,
	MINISTERIO_DE_EDUCACION,
	BOLSA_DE_VALORES,
	MINISTERIO_DE_ECONOMIA,
	MINISTERIO_DE_JUSTICIA,
	MINISTERIO_DE_SANIDAD,
	PROMOTORAS_INMOBILIARIAS,
	CONFERENCIA_EPISCOPAL;
	/**
         * Devuelve el número de construcciones que hay
         * @return el número máximo de construcciones
         */
        public static int getNumConstrucciones(){
            return 8;
        }
	/**
	 * Devuelve el orden de 0 a 7 de los distintos tipos de construccion
	 * 0 = MINISTERIO_DE_INDUSTRIA,
	 * 1 = MINISTERIO_DE_EDUCACION,
	 * 2 = BOLSA_DE_VALORES,
	 * 3 = MINISTERIO_DE_ECONOMIA,
	 * 4 = MINISTERIO_DE_JUSTICIA,
	 * 5 = MINISTERIO_DE_SANIDAD,
	 * 6 = PROMOTORAS_INMOBILIARIAS,
	 * 7 = CONFERENCIA_EPISCOPAL
	 */
	public static int getIndex(TipoConstruccion t){
		int ret=-1;
		switch(t){
		case MINISTERIO_DE_INDUSTRIA:
			ret=0;
			break;
		case MINISTERIO_DE_EDUCACION:
			ret=1;
			break;
		case BOLSA_DE_VALORES:
			ret=2;
			break;
		case MINISTERIO_DE_ECONOMIA:
			ret=3;
			break;
		case MINISTERIO_DE_JUSTICIA:
			ret=4;
			break;
		case MINISTERIO_DE_SANIDAD:
			ret=5;
			break;
		case PROMOTORAS_INMOBILIARIAS:
			ret=6;
			break;
		case CONFERENCIA_EPISCOPAL:
			ret=6;
			break;
		}
		return ret;
	}
	
	/**
	 * Devuelve el nombre de los tipos de construccion recibiendo un enumerado
	 * 
	 * @param t el tipo de construccion
	 * @return un string con el nombre del tipo de construccion
	 */
	public static String getNombre(TipoConstruccion t){
		String ret="";
		switch(t){
		case MINISTERIO_DE_INDUSTRIA:
			ret="Ministerio de industria";
			break;
		case MINISTERIO_DE_EDUCACION:
			ret="Ministerio de educaci�n";
			break;
		case BOLSA_DE_VALORES:
			ret="Bolsa de valores";
			break;
		case MINISTERIO_DE_ECONOMIA:
			ret="Ministerio de econom�a";
			break;
		case MINISTERIO_DE_JUSTICIA:
			ret="Ministerio de Justicia";
			break;
		case MINISTERIO_DE_SANIDAD:
			ret="Ministerio de Sanidad";
			break;
		case PROMOTORAS_INMOBILIARIAS:
			ret="Promotoras inmobiliarias";
			break;
		case CONFERENCIA_EPISCOPAL:
			ret="Conferencia Episcopal";
			break;
		}
		return ret;
	}
        
        public static TipoConstruccion getConstruccion(int idx){
            TipoConstruccion ret = null;
            if(idx >= 0 && idx < TipoConstruccion.getNumConstrucciones())
		switch(idx){
		case 0:
			ret = MINISTERIO_DE_INDUSTRIA;
			break;
		case 1:
			ret=MINISTERIO_DE_EDUCACION;
			break;
		case 2:
			ret=BOLSA_DE_VALORES;
			break;
		case 3:
			ret=MINISTERIO_DE_ECONOMIA;
			break;
		case 4:
			ret=MINISTERIO_DE_JUSTICIA;
			break;
		case 5:
			ret=MINISTERIO_DE_SANIDAD;
			break;
		case 6:
			ret=PROMOTORAS_INMOBILIARIAS;
			break;
		case 7:
			ret=CONFERENCIA_EPISCOPAL;
			break;
		}
		return ret;
        }
	
}
