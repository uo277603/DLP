/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import visitor.*;

//	breakSentence:sentence -> 

public class BreakSentence extends AbstractSentence {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{BreakSentence}";
   }
}
