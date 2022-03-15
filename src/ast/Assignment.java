/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	assignment:sentence -> left:expr  right:expr

public class Assignment extends AbstractSentence {

	public Assignment(Expr left, Expr right) {
		this.left = left;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public Assignment(Object left, Object right) {
		this.left = (Expr) getAST(left);
		this.right = (Expr) getAST(right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public Expr getLeft() {
		return left;
	}
	public void setLeft(Expr left) {
		this.left = left;
	}

	public Expr getRight() {
		return right;
	}
	public void setRight(Expr right) {
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expr left;
	private Expr right;

	public String toString() {
       return "{left:" + getLeft() + ", right:" + getRight() + "}";
   }
}
