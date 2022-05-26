/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	forSentence:sentence -> init:sentence  condition:expr  increment:sentence  sentence:sentence*

public class ForSentence extends AbstractSentence {

	public ForSentence(Sentence init, Expr condition, Sentence increment, List<Sentence> sentence) {
		this.init = init;
		this.condition = condition;
		this.increment = increment;
		this.sentence = sentence;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(init, condition, increment, sentence);
	}

	public ForSentence(Object init, Object condition, Object increment, Object sentence) {
		this.init = (Sentence) getAST(init);
		this.condition = (Expr) getAST(condition);
		this.increment = (Sentence) getAST(increment);
		this.sentence = this.<Sentence>getNodesFromContexts(sentence);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(init, condition, increment, sentence);
	}

	public Sentence getInit() {
		return init;
	}
	public void setInit(Sentence init) {
		this.init = init;
	}

	public Expr getCondition() {
		return condition;
	}
	public void setCondition(Expr condition) {
		this.condition = condition;
	}

	public Sentence getIncrement() {
		return increment;
	}
	public void setIncrement(Sentence increment) {
		this.increment = increment;
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

	private Sentence init;
	private Expr condition;
	private Sentence increment;
	private List<Sentence> sentence;

	public String toString() {
       return "{init:" + getInit() + ", condition:" + getCondition() + ", increment:" + getIncrement() + ", sentence:" + getSentence() + "}";
   }
}
