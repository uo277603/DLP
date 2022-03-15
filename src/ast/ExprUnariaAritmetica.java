/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	exprUnariaAritmetica:expr -> op:String  expr:expr

public class ExprUnariaAritmetica extends AbstractExpr {

	public ExprUnariaAritmetica(String op, Expr expr) {
		this.op = op;
		this.expr = expr;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr);
	}

	public ExprUnariaAritmetica(Object op, Object expr) {
		this.op = (op instanceof Token) ? ((Token)op).getText() : (String) op;
		this.expr = (Expr) getAST(expr);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(op, expr);
	}

	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}

	public Expr getExpr() {
		return expr;
	}
	public void setExpr(Expr expr) {
		this.expr = expr;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String op;
	private Expr expr;

	public String toString() {
       return "{op:" + getOp() + ", expr:" + getExpr() + "}";
   }
}
