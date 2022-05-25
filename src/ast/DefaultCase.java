/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import visitor.*;

//	defaultCase -> sentence:sentence*

public class DefaultCase extends AbstractAST  {

	public DefaultCase(List<Sentence> sentence) {
		this.sentence = sentence;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(sentence);
	}

	public DefaultCase(Object sentence) {
		this.sentence = this.<Sentence>getNodesFromContexts(sentence);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(sentence);
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

	private List<Sentence> sentence;

	public String toString() {
       return "{sentence:" + getSentence() + "}";
   }

   private SwitchSentence switchSentence;

	public SwitchSentence getSwitchSentence() {
		return switchSentence;
	}

	public void setSwitchSentence(SwitchSentence switchSentence) {
		this.switchSentence = switchSentence;
	}
}
