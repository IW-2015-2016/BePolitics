package es.fdi.iw.model.usuario;



import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import es.fdi.iw.model.Genero;

import es.fdi.iw.model.pais.Pais;
import es.fdi.iw.model.politicos.ExceptionPolitico;


/**
 * Esta Clase representa a los distintos tipos de usuarios que pueden usar nuestra aplicación y los identifica con un ROL. 
 * Comprueba que la edad del jugador sea mayor de 18. He añadido procedimientos para crear distintos tipos de usuarios.
 */
@Entity
@NamedQueries({
    @NamedQuery(name="allUsuarios",
            query="select u from Usuario u"),
    @NamedQuery(name="allUsuarioRol",
    	query="select u from Usuario u where u.rol = :rolParam"),
    @NamedQuery(name="usuarioByLogin",
    query="select u from Usuario u where u.nick = :loginParam"),
    @NamedQuery(name="delUsuario",
    	query="delete from Usuario u where u.id= :idParam")
})
public class Usuario {

	private long id; //clave unica para la bd
	private String nombre;
	private String apellidos;
	private String email;
	private Genero genero;
	private int edad;
	private String nick; //Esto no esta eb el esquema pero lo veo necesario
	//private String pasword;	(07-seguridad-en-web)
	private Pais pais; //El pais del jugador
	private TipoLider tipoLider;
	private Rol rol;
	private Date fechaRegistro; //Me parece interesante almacenar esto porque podemos activar los eventos según el tiempo jugado por ejemplo
	
	private static BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder(); //(07-seguridad-en-web)
	private String hashedAndSalted; //(07-seguridad-en-web)
	
	
	//Se debe crear un constructor vacío para evitar este error: No default constructor for entity:
	public Usuario(){}
	
	
	public Usuario(String nombre, String apellidos, String email, Genero genero, int edad, String nick,
			Pais pais, TipoLider tipoLider,String password,Rol rol)throws ExceptionUsuario {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.genero = genero;
		if(edad<18) throw new ExceptionUsuario();
		else this.edad = edad;
		this.nick = nick;
		this.hashedAndSalted = bcryptEncoder.encode(password); 
		//this.pasword = pasword;
		this.pais = pais;
		this.rol = rol;
		this.tipoLider = tipoLider;
	
		this.fechaRegistro = new Date(Calendar.getInstance().getTimeInMillis());	
	}



	@Id
    @GeneratedValue
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Genero getGenero() {
		return this.genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public boolean isPassValid(String pass) {
		return bcryptEncoder.matches(pass, hashedAndSalted);		
	}

	public String getHashedAndSalted() {
		return this.hashedAndSalted;
	}


	public void setHashedAndSalted(String hashedAndSalted) {
		this.hashedAndSalted = hashedAndSalted;
	}
	@OneToOne(targetEntity=Pais.class, fetch=FetchType.EAGER)
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
	public Date getfechaRegistro() {
		return fechaRegistro;
	}

	public void setfechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public static String generateHashedAndSalted(String pass) {
		/*
		Código viejo: sólo 1 iteración de SHA-1. bCrypt es mucho más seguro (itera 1024 veces...)
		
		Además, bcryptEncoder guarda la sal junto a la contraseña
		byte[] saltBytes = hexStringToByteArray(user.salt);
		byte[] passBytes = pass.getBytes();
		byte[] toHash = new byte[saltBytes.length + passBytes.length];
		System.arraycopy(passBytes, 0, toHash, 0, passBytes.length);
		System.arraycopy(saltBytes, 0, toHash, passBytes.length, saltBytes.length);
		return byteArrayToHexString(sha1hash(toHash));
		*/
		return bcryptEncoder.encode(pass);
	}
	public static Usuario crearUsuario(String login, String pass) {
		Usuario u = new Usuario();
		u.nick = login;
		u.hashedAndSalted = generateHashedAndSalted(pass);

		return u;
	}
	
	public String toString(){
		
		return "login: "+ this.nick+ " Email: "+ this.email;
	}
	
}