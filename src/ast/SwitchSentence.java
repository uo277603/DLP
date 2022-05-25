/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	switchSentence:sentence -> valor:expr  caseoption:caseOption*  defaultcase:defaultCase

public class SwitchSentence extends AbstractSentence {

	public SwitchSentence(Expr valor, List<CaseOption> caseoption, DefaultCase defaultcase) {
		this.valor = valor;
		this.caseoption = caseoption;
		this.defaultcase = defaultcase;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(valor, caseoption, defaultcase);
	}

	public SwitchSentence(Object valor, Object caseoption, Object defaultcase) {
		this.valor = (Expr) getAST(valor);
		this.caseoption = this.<CaseOption>getNodesFromContexts(caseoption);
		this.defaultcase = (DefaultCase) getAST(defaultcase);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(valor, caseoption, defaultcase);
	}

	public Expr getValor() {
		return valor;
	}
	public void setValor(Expr valor) {
		this.valor = valor;
	}

	public List<CaseOption> getCaseoption() {
		return caseoption;
	}
	public void setCaseoption(List<CaseOption> caseoption) {
		this.caseoption = caseoption;
	}

	public DefaultCase getDefaultcase() {
		return defaultcase;
	}
	public void setDefaultcase(DefaultCase defaultcase) {
		this.defaultcase = defaultcase;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expr valor;
	private List<CaseOption> caseoption;
	private DefaultCase defaultcase;

	public String toString() {
       return "{valor:" + getValor() + ", caseoption:" + getCaseoption() + ", defaultcase:" + getDefaultcase() + "}";
   }
}
