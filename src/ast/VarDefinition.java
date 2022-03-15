/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	varDefinition:definition -> name:String*  type:type

public class VarDefinition extends AbstractDefinition {

	public VarDefinition(List<String> name, Type type) {
		this.name = name;
		this.type = type;

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(type);
	}

	public VarDefinition(Object name, Object type) {
		this.name = getStringsFromTokens(name);
		this.type = (Type) getAST(type);

		// Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
		// Obtiene la linea/columna a partir de las de los hijos.
		setPositions(name, type);
	}

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}

	private List<String> name;
	private Type type;

	public String toString() {
		return "{name:" + getName() + ", type:" + getType() + "}";
	}

	// Modificaciones
	public String getNames() {
		StringBuilder data = new StringBuilder();

		for (int i = 0; i < name.size(); i++) {
			if (i == name.size() - 1)
				data.append(name.get(i));
			else
				data.append(name.get(i) + ", ");
		}
		return data.toString();
	}

}
