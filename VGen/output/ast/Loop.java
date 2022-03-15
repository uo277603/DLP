/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	loop:sentence -> init:sentence*  condition:expr  sentence:sentence*

public class Loop extends AbstractSentence {

	public Loop(List<Sentence> init, Expr condition, List<Sentence> sentence) {
		this.init = init;
		this.condition = condition;
		this.sentence = sentence;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(init, condition, sentence);
	}

	public Loop(Object init, Object condition, Object sentence) {
		this.init = this.<Sentence>getNodesFromContexts(init);
		this.condition = (Expr) getAST(condition);
		this.sentence = this.<Sentence>getNodesFromContexts(sentence);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(init, condition, sentence);
	}

	public List<Sentence> getInit() {
		return init;
	}
	public void setInit(List<Sentence> init) {
		this.init = init;
	}

	public Expr getCondition() {
		return condition;
	}
	public void setCondition(Expr condition) {
		this.condition = condition;
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

	private List<Sentence> init;
	private Expr condition;
	private List<Sentence> sentence;

	public String toString() {
       return "{init:" + getInit() + ", condition:" + getCondition() + ", sentence:" + getSentence() + "}";
   }
}
