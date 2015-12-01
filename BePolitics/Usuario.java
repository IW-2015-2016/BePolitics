package es.fdi.iw.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@NamedQueries({
    @NamedQuery(name="allUsers",
            query="select u from usuario u"),
    @NamedQuery(name="userByLogin",
        query="select u from User u where u.login = :loginParam"),
    @NamedQuery(name="delUser",
    	query="delete from usuario u where u.id= :idParam")
})
public class Usuario {
	
    private static BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
    
	private String nombre;
	private String apellidos;
	private String correo;
	private Genero genero;
	private int edad;
	private String nick;
	private String pass;
	private Lider lider;
	private Role role;
	
	private String hashedAndSalted;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Lider getLider() {
		return lider;
	}
	public void setLider(Lider lider) {
		this.lider = lider;
	}
	public Usuario(String nick, String pass) {
		super();
		this.nick = nick;
		this.pass = pass;
	}
	public Usuario(String nombre, String apellidos, String correo, Genero genero, int edad, String nick, String pass,
			Lider lider) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.genero = genero;
		this.edad = edad;
		this.nick = nick;
		this.pass = pass;
		this.lider = lider;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static Usuario createUser(String nick, String pass, Role role) {
		Usuario u = new Usuario();
		u.nick = nick;
		u.hashedAndSalted = generateHashedAndSalted(pass);
		u.role = role;
		return u;
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
	
	
}
