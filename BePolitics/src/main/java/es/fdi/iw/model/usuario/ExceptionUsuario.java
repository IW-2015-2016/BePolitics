package es.fdi.iw.model.usuario;
/**
 *Excepciones que se pueden generar a la hora de crear un usuario nuevo en el sistema
 * 
 * @author Julia
 *
 */
public class ExceptionUsuario extends Exception {

	public ExceptionUsuario(){
		super("Error al crear el usuario. Debe ser mayor de 18 años.");
	}
	/**
	 * Constructor de excepci�n, llama al constructor de IOException
	 * @param message
	 * @see IOException(String message)
	 */
	public ExceptionUsuario(String message){
		super(message);
	}
	/**
	 * Constructor de excepci�n, llama al constructor de IOException
	 * @param message
	 * @param cause
	 * @see IOException(String message, Throwable cause)
	 */
	public ExceptionUsuario(String message, Throwable cause){
		super(message, cause);
	}
	
	public String getMessage()
    {
        return super.getMessage();
    }


}
