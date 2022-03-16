/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	methodCalExpr:expr -> name:String  args:expr*

public class MethodCalExpr extends AbstractExpr {

	public MethodCalExpr(String name, List<Expr> args) {
		this.name = name;
		this.args = args;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(args);
	}

	public MethodCalExpr(Object name, Object args) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.args = this.<Expr>getNodesFromContexts(args);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, args);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Expr> getArgs() {
		return args;
	}
	public void setArgs(List<Expr> args) {
		this.args = args;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Expr> args;

	public String toString() {
       return "{name:" + getName() + ", args:" + getArgs() + "}";
   }
}
