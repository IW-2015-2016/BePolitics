package es.fdi.iw.model.pais.relaciones;
/**
 * Relaciona dos objetos. El de la izquierda será inmutable pero el de la derecha se puede
 * cambiar a discrección. La clase pair sólo compara en su método equals al objeto de la 
 * izquierda, el de la derecha no será comparado.
 * 
 * @author <a href="https://www.linkedin.com/in/glen-edmonds-77b6208"> Glen Edmonds </a> on the source <a href="https://stackoverflow.com/questions/521171/a-java-collection-of-value-pairs-tuples">https://stackoverflow.com/questions/521171/a-java-collection-of-value-pairs-tuples</a> 
 * @author Ismael (Modificaciones menores)
 *
 * @param <L> Una clase cualquiera. Tras la creación el objeto será inmutable
 * @param <R> Una clase cualquiera
 * 
 */
public class Pair<L,R> {

	  private final L left;
	  private R right;
	  /**
	   * Constructor único, debe recibir los dos parámetros. se ha de tener cuidado de no introducir un
	   * null en left, porque no se podrá modificar más adelante, right sin embargo es mutable
	   * @param left un parámetro que será inmutable
	   * @param right un parámetro modificable
	   */
	  public Pair(L left, R right) {
	    this.left = left;
	    this.right = right;
	  }
	  /**
	   * Obtiene el parámetro de la izquierda, es inmutable
	   * @return un parámetro constante
	   */
	  public L getLeft() { 
		  return left; 
	  }
	  /**
	   * Obtiene el parámetro de la derecha
	   * @return un objeto del tipo parametrizado
	   */
	  public R getRight() { 
		  return right; 
	  }
	  /**
	   * Permite modificar el parámetro right, es posible introducir null
	   * @param right un parámetro del tipo <R>
	   */
	  public void setRight(R right){
		  this.right = right;
	  }
	  /**
	   * El código hash será un and explícito de left. no teniendo en cuenta right
	   * @return un código hash
	   */
	  @Override
	  public int hashCode() { 
		  return left.hashCode();// ^ right.hashCode(); 
	  }

	  /**
	   * Devuelve true si el objeto de la izquierda es igual
	   * @param o el Par a comparar
	   * @return true si el objeto de la izquierda es el mismo, false en caso contrario	  
	   */
	  @SuppressWarnings("unchecked")
      @Override
	  public boolean equals(Object o) {
	    if (!(o instanceof Pair)) return false;
	    Pair<L,R> par = (Pair<L,R>) o;
	    return this.left.equals(par.getLeft());// &&  this.right.equals(pairo.getRight());
	  }
}