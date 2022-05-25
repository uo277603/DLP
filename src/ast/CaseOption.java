/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	caseOption -> valor:expr  sentence:sentence*

public class CaseOption extends AbstractAST  {

	public CaseOption(Expr valor, List<Sentence> sentence) {
		this.valor = valor;
		this.sentence = sentence;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(valor, sentence);
	}

	public CaseOption(Object valor, Object sentence) {
		this.valor = (Expr) getAST(valor);
		this.sentence = this.<Sentence>getNodesFromContexts(sentence);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(valor, sentence);
	}

	public Expr getValor() {
		return valor;
	}
	public void setValor(Expr valor) {
		this.valor = valor;
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

	private Expr valor;
	private List<Sentence> sentence;

	public String toString() {
       return "{valor:" + getValor() + ", sentence:" + getSentence() + "}";
   }

   private SwitchSentence switchSentence;

	public SwitchSentence getSwitchSentence() {
		return switchSentence;
	}

	public void setSwitchSentence(SwitchSentence switchSentence) {
		this.switchSentence = switchSentence;
	}
}
