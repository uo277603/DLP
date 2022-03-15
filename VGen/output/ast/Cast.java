/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	cast:expr -> typeToConvert:type  expr:expr

public class Cast extends AbstractExpr {

	public Cast(Type typeToConvert, Expr expr) {
		this.typeToConvert = typeToConvert;
		this.expr = expr;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(typeToConvert, expr);
	}

	public Cast(Object typeToConvert, Object expr) {
		this.typeToConvert = (Type) getAST(typeToConvert);
		this.expr = (Expr) getAST(expr);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(typeToConvert, expr);
	}

	public Type getTypeToConvert() {
		return typeToConvert;
	}
	public void setTypeToConvert(Type typeToConvert) {
		this.typeToConvert = typeToConvert;
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

	private Type typeToConvert;
	private Expr expr;

	public String toString() {
       return "{typeToConvert:" + getTypeToConvert() + ", expr:" + getExpr() + "}";
   }
}
