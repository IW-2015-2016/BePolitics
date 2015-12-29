package usuario;

import java.util.Date;

import es.fdi.iw.model.pais.Pais;
import es.fdi.iw.model.politicos.ExceptionPolitico;


/**
 * Esta Clase representa a los distintos tipos de usuarios que pueden usar nuestra aplicación y los identifica con un ROL. 
 * Comprueba que la edad del jugador sea mayor de 18. He añadido procedimientos para crear distintos tipos de usuarios.
 * 
 * @author Julia
 */
public class Usuario {

	private int id; //clave unica para la bd
	private String nombre;
	private String apellidos;
	private String email;
	private Genero genero;
	private int edad;
	private String nick; //Esto no esta eb el esquema pero lo veo necesario
	private String pasword;
	private Pais pais; //El pais del jugador
	private TipoLider tipoLider;
	private Rol rol;
	private Date fechaRegistro; //Me parece interesante almacenar esto porque podemos activar los eventos según el tiempo jugado por ejemplo
	
	public Usuario(int id, String nombre, String apellidos, String email, Genero genero, int edad, String nick,
			String pasword, Pais pais, TipoLider tipoLider, Rol rol, Date fechaRegistro) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.genero = genero;
		if(edad<18) throw new ExceptionUsuario();
		else this.edad = edad;
		this.nick = nick;
		this.pasword = pasword;
		this.pais = pais;
		this.tipoLider = tipoLider;
		this.rol = rol;
		this.fechaRegistro = fechaRegistro;
	}
	public Usuario CrearJugador(int id, String nombre, String apellidos, String email, Genero genero, int edad, String nick,
			String pasword, Pais pais, TipoLider tipoLider, Rol rol, Date fechaRegistro) {
		return new Usuario(id,nombre,apellidos,email,genero,edad,nick,pasword,pais,tipoLider,Rol.UsuarioRegistrado,fechaRegistro);
	}
	public Usuario CrearEditor(int id, String nombre, String apellidos, String email, Genero genero, int edad, String nick,
			String pasword, Date fechaRegistro){
		return new Usuario(id,nombre,apellidos,email,genero,edad,nick,pasword,null,TipoLider.NINGUNO,Rol.Editor,fechaRegistro);
	}
	public Usuario CrearAdministrador(int id, String nombre, String apellidos, String email, Genero genero, int edad, String nick,
			String pasword, Date fechaRegistro) {
		return new Usuario(id,nombre,apellidos,email,genero,edad,nick,pasword,null,TipoLider.NINGUNO,Rol.Administrador,fechaRegistro);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Date getfechaRegistro() {
		return fechaRegistro;
	}

	public void setfechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public TipoLider gettipoLider() {
		return tipoLider;
	}

	public void settipoLider(TipoLider tipoLider) {
		this.tipoLider = tipoLider;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	
}