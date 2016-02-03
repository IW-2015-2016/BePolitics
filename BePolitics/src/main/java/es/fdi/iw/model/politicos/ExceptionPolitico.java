package es.fdi.iw.model.politicos;

import java.io.IOException;
/**
 * Excepciones de pol�ticos, que se generar�n al realizar operaciones incorrectas de entrada-salida
 * con un pol�tico
 * 
 * @author futurDrama
 *
 */
public class ExceptionPolitico extends IOException{

	
	/**
	 * Valor autogenerado UID de la excepci�n
	 */
	private static final long serialVersionUID = 6243510840435623132L;

	/**
	 * Crea la excepcionPolitico con el mensaje:
	 * "Error al crear el pol�tico. Los valores asignados deben estar entre 0 y 100"
	 */
	public ExceptionPolitico(){
		super("Error al crear el pol�tico. Los valores asignados deben estar entre 0 y 100");
	}
	/**
	 * Constructor de excepci�n, llama al constructor de IOException
	 * @param message
	 * @see IOException(String message)
	 */
	public ExceptionPolitico(String message){
		super(message);
	}
	/**
	 * Constructor de excepci�n, llama al constructor de IOException
	 * @param message
	 * @param cause
	 * @see IOException(String message, Throwable cause)
	 */
	public ExceptionPolitico(String message, Throwable cause){
		super(message, cause);
	}
	
	public String getMessage()
    {
        return super.getMessage();
    }
}
