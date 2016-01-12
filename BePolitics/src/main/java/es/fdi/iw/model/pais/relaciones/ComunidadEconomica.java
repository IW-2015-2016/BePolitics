package es.fdi.iw.model.pais.relaciones;

import java.io.IOException;
import java.util.ArrayList;

import es.fdi.iw.model.pais.Pais;


/**
 * Una comunidad econÃ³mica es una lista de paÃ­ses miembros y otra de administradores
 * un pais administrador podra echar a miembros o salir, un miembro solo puede salir
 * 
 * 
 * @author Ismael
 *
 */
public class ComunidadEconomica {
	
	ArrayList<Pais> admin;
	ArrayList<Pais> paises;
	/**
	 * Crea una comunidad economica que debe recibir el primer pais implicado
	 * como miembro. Ese pais sera automaticamente el lider. 
	 * 
	 * @param lider el pais que lo crea, no puede ser null
	 * @throws IOException si el lider es null o no se puede agregar el lider a la lista de paises o de lideres
	 */
	public ComunidadEconomica(Pais lider) throws IOException{
		this.admin = new ArrayList<Pais>();
		this.paises = new ArrayList<Pais>();
		
		if (lider == null 
				|| !this.admin.add(lider)
				|| !this.paises.add(lider)) 
			throw new IOException();
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
		return this.admin.contains(p);
	}
	
	/**
	 * Un lider invitara a un miembro. Si quien añade a un miembro no es líder, no se añade 
	 *  
	 * @param lider un pais que debe ser admin de la comunidad
	 * @param invitado un miembro que no debe ser ya socio
	 * @return
	 */
	public boolean hacerMiembro(Pais lider, Pais invitado){
		if(!esLider(lider)) return false;
		
		if(this.paises.contains(invitado)) return false;
		
		return this.paises.add(invitado);
	}
	
	

}
