/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	print:sentence -> string:String  expr:expr*

public class Print extends AbstractSentence {

	public Print(String string, List<Expr> expr) {
		this.string = string;
		this.expr = expr;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(expr);
	}

	public Print(Object string, Object expr) {
		this.string = (string instanceof Token) ? ((Token)string).getText() : (String) string;
		this.expr = this.<Expr>getNodesFromContexts(expr);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(string, expr);
	}

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
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

	private String string;
	private List<Expr> expr;

	public String toString() {
       return "{string:" + getString() + ", expr:" + getExpr() + "}";
   }
}
