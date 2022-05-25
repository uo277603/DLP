/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	multipleAssignment:sentence -> expr:expr*  valor:expr

public class MultipleAssignment extends AbstractSentence {

	public MultipleAssignment(List<Expr> expr, Expr valor) {
		this.expr = expr;
		this.valor = valor;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr, valor);
	}

	public MultipleAssignment(Object expr, Object valor) {
		this.expr = this.<Expr>getNodesFromContexts(expr);
		this.valor = (Expr) getAST(valor);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr, valor);
	}

	public List<Expr> getExpr() {
		return expr;
	}
	public void setExpr(List<Expr> expr) {
		this.expr = expr;
	}

	public Expr getValor() {
		return valor;
	}
	public void setValor(Expr valor) {
		this.valor = valor;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private List<Expr> expr;
	private Expr valor;

	public String toString() {
       return "{expr:" + getExpr() + ", valor:" + getValor() + "}";
   }
}
