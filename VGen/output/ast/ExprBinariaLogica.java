/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	exprBinariaLogica:expr -> left:expr  op:String  right:expr

public class ExprBinariaLogica extends AbstractExpr {

	public ExprBinariaLogica(Expr left, String op, Expr right) {
		this.left = left;
		this.op = op;
		this.right = right;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, right);
	}

	public ExprBinariaLogica(Object left, Object op, Object right) {
		this.left = (Expr) getAST(left);
		this.op = (op instanceof Token) ? ((Token)op).getText() : (String) op;
		this.right = (Expr) getAST(right);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(left, op, right);
	}

	public Expr getLeft() {
		return left;
	}
	public void setLeft(Expr left) {
		this.left = left;
	}

	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
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
	private String op;
	private Expr right;

	public String toString() {
       return "{left:" + getLeft() + ", op:" + getOp() + ", right:" + getRight() + "}";
   }
}
