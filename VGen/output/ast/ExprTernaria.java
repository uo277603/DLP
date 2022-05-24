/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	exprTernaria:expr -> condicion:expr  expr1:expr  expr2:expr

public class ExprTernaria extends AbstractExpr {

	public ExprTernaria(Expr condicion, Expr expr1, Expr expr2) {
		this.condicion = condicion;
		this.expr1 = expr1;
		this.expr2 = expr2;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, expr1, expr2);
	}

	public ExprTernaria(Object condicion, Object expr1, Object expr2) {
		this.condicion = (Expr) getAST(condicion);
		this.expr1 = (Expr) getAST(expr1);
		this.expr2 = (Expr) getAST(expr2);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condicion, expr1, expr2);
	}

	public Expr getCondicion() {
		return condicion;
	}
	public void setCondicion(Expr condicion) {
		this.condicion = condicion;
	}

	public Expr getExpr1() {
		return expr1;
	}
	public void setExpr1(Expr expr1) {
		this.expr1 = expr1;
	}

	public Expr getExpr2() {
		return expr2;
	}
	public void setExpr2(Expr expr2) {
		this.expr2 = expr2;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expr condicion;
	private Expr expr1;
	private Expr expr2;

	public String toString() {
       return "{condicion:" + getCondicion() + ", expr1:" + getExpr1() + ", expr2:" + getExpr2() + "}";
   }
}
