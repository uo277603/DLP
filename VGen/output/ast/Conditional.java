/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import java.util.*;
import org.antlr.v4.runtime.*;

import visitor.*;

//	conditional:sentence -> condition:expr  iftrue:sentence*  iffalse:sentence*

public class Conditional extends AbstractSentence {

	public Conditional(Expr condition, List<Sentence> iftrue, List<Sentence> iffalse) {
		this.condition = condition;
		this.iftrue = iftrue;
		this.iffalse = iffalse;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, iftrue, iffalse);
	}

	public Conditional(Object condition, Object iftrue, Object iffalse) {
		this.condition = (Expr) getAST(condition);
		this.iftrue = this.<Sentence>getNodesFromContexts(iftrue);
		this.iffalse = this.<Sentence>getNodesFromContexts(iffalse);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(condition, iftrue, iffalse);
	}

	public Expr getCondition() {
		return condition;
	}
	public void setCondition(Expr condition) {
		this.condition = condition;
	}

	public List<Sentence> getIftrue() {
		return iftrue;
	}
	public void setIftrue(List<Sentence> iftrue) {
		this.iftrue = iftrue;
	}

	public List<Sentence> getIffalse() {
		return iffalse;
	}
	public void setIffalse(List<Sentence> iffalse) {
		this.iffalse = iffalse;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private Expr condition;
	private List<Sentence> iftrue;
	private List<Sentence> iffalse;

	public String toString() {
       return "{condition:" + getCondition() + ", iftrue:" + getIftrue() + ", iffalse:" + getIffalse() + "}";
   }
}
