package es.fdi.iw.model.pais.relaciones;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


import es.fdi.iw.model.pais.Pais;
import es.fdi.iw.model.pais.eventos.GestorEventos;
import es.fdi.iw.model.pais.eventos.TipoEvento;

/**
 * Relaciona dos objetos. El de la izquierda ser� inmutable pero el de la derecha se puede
 * cambiar a discrecci�n. La clase pair s�lo compara en su m�todo equals al objeto de la 
 * izquierda, el de la derecha no ser� comparado.
 * 
 * @author <a href="https://www.linkedin.com/in/glen-edmonds-77b6208"> Glen Edmonds </a> on the source <a href="https://stackoverflow.com/questions/521171/a-java-collection-of-value-pairs-tuples">https://stackoverflow.com/questions/521171/a-java-collection-of-value-pairs-tuples</a> 
 * @author Ismael (Modificaciones menores)
 *
 * @param <L> Una clase cualquiera. Tras la creaci�n el objeto ser� inmutable
 * @param <R> Una clase cualquiera
 * 
 */
@Entity
public class Pair {
	  private long id;
	  private Pais izquierda;
	  private GestorEventos derecha;
	  private Guerras guerra;
	  
	  public Pair(){
		 
	  }
@Id
@GeneratedValue
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
/**
 * Obtiene el par�metro de la izquierda, es inmutable
 * @return un par�metro constante
 */
@OneToOne(targetEntity=Pais.class)
public Pais getIzquierda() { 
	  return izquierda; 
}

public void setIzquierda(Pais izquierda) {
	this.izquierda = izquierda;
}
/**
 * Obtiene el par�metro de la derecha
 * @return un objeto del tipo parametrizado
 */
@OneToOne(targetEntity=GestorEventos.class, cascade = CascadeType.ALL)
public GestorEventos getDerecha() { 
	  return derecha; 
}
/**
 * Permite modificar el par�metro right, es posible introducir null
 * @param right un par�metro del tipo <R>
 */
public void setDerecha(GestorEventos derecha){
	  this.derecha = derecha;
}
@ManyToOne(targetEntity=Guerras.class, cascade = CascadeType.ALL)
public Guerras getGuerra() {
	return guerra;
}
public void setGuerra(Guerras guerra) {
	this.guerra = guerra;
}

	  /**
	   * Constructor �nico, debe recibir los dos par�metros. se ha de tener cuidado de no introducir un
	   * null en left, porque no se podr� modificar m�s adelante, right sin embargo es mutable
	   * @param left un par�metro que ser� inmutable
	   * @param right un par�metro modificable
	   */
	  public Pair(Pais izquierda, GestorEventos derecha) {
	    this.izquierda = izquierda;
	    this.derecha = derecha;
	  }


	  /**
	   * El c�digo hash ser� un and expl�cito de left. no teniendo en cuenta right
	   * @return un c�digo hash
	   */
	 
	  public int hashCode() { 
		  return izquierda.hashCode();// ^ right.hashCode(); 
	  }

	  /**
	   * Devuelve true si el objeto de la izquierda es igual
	   * @param o el Par a comparar
	   * @return true si el objeto de la izquierda es el mismo, false en caso contrario	  
	   */
	  public boolean equals(Object o) {
	    if (!(o instanceof Pair)) return false;
	    Pair par = (Pair) o;
	    return this.izquierda.equals(par.getIzquierda());// &&  this.right.equals(pairo.getRight());
	  }

}