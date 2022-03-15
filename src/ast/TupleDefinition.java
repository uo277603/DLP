/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	tupleDefinition:definition -> name:String  vardefinition:varDefinition*

public class TupleDefinition extends AbstractDefinition {

	public TupleDefinition(String name, List<VarDefinition> vardefinition) {
		this.name = name;
		this.vardefinition = vardefinition;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(vardefinition);
	}

	public TupleDefinition(Object name, Object vardefinition) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.vardefinition = this.<VarDefinition>getNodesFromContexts(vardefinition);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, vardefinition);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<VarDefinition> getVardefinition() {
		return vardefinition;
	}
	public void setVardefinition(List<VarDefinition> vardefinition) {
		this.vardefinition = vardefinition;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<VarDefinition> vardefinition;

	public String toString() {
       return "{name:" + getName() + ", vardefinition:" + getVardefinition() + "}";
   }
}
