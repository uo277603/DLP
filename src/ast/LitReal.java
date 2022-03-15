/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	litReal:expr -> string:String

public class LitReal extends AbstractExpr {

	public LitReal(String string) {
		this.string = string;
	}

	public LitReal(Object string) {
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
}
