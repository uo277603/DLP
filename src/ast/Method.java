/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	method -> name:String  parameter:parameter*  retorno:type  definition:definition*  sentence:sentence*

public class Method extends AbstractAST  {

	public Method(String name, List<Parameter> parameter, Type retorno, List<Definition> definition, List<Sentence> sentence) {
		this.name = name;
		this.parameter = parameter;
		this.retorno = retorno;
		this.definition = definition;
		this.sentence = sentence;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(parameter, retorno, definition, sentence);
	}

	public Method(Object name, Object parameter, Object retorno, Object definition, Object sentence) {
		this.name = (name instanceof Token) ? ((Token)name).getText() : (String) name;
		this.parameter = this.<Parameter>getNodesFromContexts(parameter);
		this.retorno = (Type) getAST(retorno);
		this.definition = this.<Definition>getNodesFromContexts(definition);
		this.sentence = this.<Sentence>getNodesFromContexts(sentence);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(name, parameter, retorno, definition, sentence);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Parameter> getParameter() {
		return parameter;
	}
	public void setParameter(List<Parameter> parameter) {
		this.parameter = parameter;
	}

	public Type getRetorno() {
		return retorno;
	}
	public void setRetorno(Type retorno) {
		this.retorno = retorno;
	}

	public List<Definition> getDefinition() {
		return definition;
	}
	public void setDefinition(List<Definition> definition) {
		this.definition = definition;
	}

	public List<Sentence> getSentence() {
		return sentence;
	}
	public void setSentence(List<Sentence> sentence) {
		this.sentence = sentence;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private String name;
	private List<Parameter> parameter;
	private Type retorno;
	private List<Definition> definition;
	private List<Sentence> sentence;

	public String toString() {
       return "{name:" + getName() + ", parameter:" + getParameter() + ", retorno:" + getRetorno() + ", definition:" + getDefinition() + ", sentence:" + getSentence() + "}";
   }

   // Modificaciones

   private boolean isConstructor = false;

   public void setConstructor(){
	   this.isConstructor = true;
   }

   public boolean isConstructor(){
	   return isConstructor;
   }
}
