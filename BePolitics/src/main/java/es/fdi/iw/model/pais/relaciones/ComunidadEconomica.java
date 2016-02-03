package es.fdi.iw.model.pais.relaciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import es.fdi.iw.model.Author;
import es.fdi.iw.model.pais.Pais;


/**
 * Una comunidad económica es una lista de países miembros y otra de administradores
 * un pais administrador podra echar a miembros o salir, un miembro solo puede salir
 * 
 * 
 * @author Ismael
 *
 */
@Entity
@NamedQueries({

    @NamedQuery(name="comunidadEconomicaByAdmin",
        query="select ce from ComunidadEconomica ce where ce.admin = :param"),
    @NamedQuery(name="delComunidadEconomica",
    	query="delete from ComunidadEconomica ce where ce.id= :idParam")
})
public class ComunidadEconomica {
	private long id;
	private String nombre;
	
	private Pais admin;
	
	//Una comunidad economica se compone por varios paises
	private List<Pais> paises;
	
	public ComunidadEconomica(){
		this.paises = new ArrayList<Pais>();
	}
	/**
	 * Crea una comunidad economica que debe recibir el primer pais implicado
	 * como miembro. Ese pais sera automaticamente el lider. 
	 * 
	 * @param lider el pais que lo crea, no puede ser null
	 * @throws IOException si el lider es null o no se puede agregar el lider a la lista de paises o de lideres
	 */
	public ComunidadEconomica(Pais lider){
		
		//TODO revisar array list al arracar la BD
		this.admin = lider;
		this.paises = new ArrayList<Pais>();
	}
	/**
	 * Dice si p es miembro de la comunidad
	 * @param p el pais
	 * @return true si es miembro, false en cualquier otro caso
	 */
	public boolean esMiembro(Pais p){
		return this.paises.contains(p);
	}
	/**
	 * Dice si p es lider de la comunidad
	 * @param p el pais
	 * @return true si es lider, false en cualquier otro caso
	 */
	public boolean esLider(Pais p){
		return (this.admin.getId() == p.getId());
	}
	
	/**
	 * Un lider invitara a un miembro. Si quien a�ade a un miembro no es l�der, no se a�ade 
	 *  
	 * @param lider un pais que debe ser admin de la comunidad
	 * @param invitado un miembro que no debe ser ya socio
	 * @return
	 */
	public boolean hacerMiembro(Pais lider, Pais invitado){
		//if(!esLider(lider)) return false;
		
		//if(this.paises.contains(invitado)) return false;
		System.out.println(invitado.getNombre());
		return this.paises.add(invitado);
	}
	
	@Id
    @GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@OneToOne(targetEntity=Pais.class)
	@JoinColumn(name="id")
	public Pais getAdmin() {
		return admin;
	}
	public void setAdmin(Pais admin) {
		this.admin = admin;
	}
	@ManyToMany(targetEntity=Pais.class, mappedBy="miComunidad")
	public List<Pais> getPaises() {
		return paises;
	}
	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	

}
