package es.fdi.iw.model.pruebas;

import es.fdi.iw.model.politicos.ExceptionPolitico;
import es.fdi.iw.model.politicos.Politico;


public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//nombre, HONESTIDAD,CARISMA,ELOCUENCIA,APOYO_POPULAR
		try {
			Politico p1 = new Politico("José María Aznar", 10, 80,70,40,"Estamos trabajando en ello");
			Politico p2 = new Politico("Pablo Iglesias", 99, 40, 80, 60,"Sonreíd, que sí se puede");
		} catch (ExceptionPolitico e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
