/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	classNode -> name:String  definition:definition*  createMethod:String*  method:method*

public class ClassNode extends AbstractAST  {

	public ClassNode(String name, List<Definition> definition, List<String> createMethod, List<Method> method) {
		this.name = name;
		this.definition = definition;
		this.createMethod = createMethod;
		this.method = method;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(definition, method);
	}

	public ClassNode(Object name, Object definition, Object createMethod, Object method) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.definition = this.<Definition>getNodesFromContexts(definition);
		this.createMethod = getStringsFromTokens(createMethod);
		this.method = this.<Method>getNodesFromContexts(method);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, definition, createMethod, method);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Definition> getDefinition() {
		return definition;
	}
	public void setDefinition(List<Definition> definition) {
		this.definition = definition;
	}

	public List<String> getCreateMethod() {
		return createMethod;
	}
	public void setCreateMethod(List<String> createMethod) {
		this.createMethod = createMethod;
	}

	public List<Method> getMethod() {
		return method;
	}
	public void setMethod(List<Method> method) {
		this.method = method;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Definition> definition;
	private List<String> createMethod;
	private List<Method> method;

	public String toString() {
       return "{name:" + getName() + ", definition:" + getDefinition() + ", createMethod:" + getCreateMethod() + ", method:" + getMethod() + "}";
   }
}
