/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import visitor.*;

//	read:sentence -> expr:expr*

public class Read extends AbstractSentence {

	public Read(List<Expr> expr) {
		this.expr = expr;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr);
	}

	public Read(Object expr) {
		this.expr = this.<Expr>getNodesFromContexts(expr);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr);
	}

	public List<Expr> getExpr() {
		return expr;
	}
	public void setExpr(List<Expr> expr) {
		this.expr = expr;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<Expr> expr;

	public String toString() {
       return "{expr:" + getExpr() + "}";
   }
}
