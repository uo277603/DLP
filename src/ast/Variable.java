/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	variable:expr -> string:String

public class Variable extends AbstractExpr {

	public Variable(String string) {
		this.string = string;
	}

	public Variable(Object string) {
		this.string = (string instanceof Token) ? ((Token)string).getText() : (String) string;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(string);
	}

	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String string;

	public String toString() {
       return "{string:" + getString() + "}";
   }

   // Modificaciones
   private VarDefinition definition;

   public VarDefinition getDefinition(){
	   return definition;
   }

   public void setDefinition(VarDefinition definition){
	   this.definition = definition;
   }
}
