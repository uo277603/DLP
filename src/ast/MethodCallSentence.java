/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	methodCallSentence:sentence -> name:String  args:expr*

public class MethodCallSentence extends AbstractSentence {

	public MethodCallSentence(String name, List<Expr> args) {
		this.name = name;
		this.args = args;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(args);
	}

	public MethodCallSentence(Object name, Object args) {
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

   // Modificaciones

   private List<Method> definitions;
   public int index;

   public List<Method> getDefinitions(){
	   return definitions;
   }

   public void setDefinition(List<Method> definitions){
		this.definitions = definitions;
   }
}
