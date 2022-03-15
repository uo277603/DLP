/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import visitor.*;

//	intType:type -> 

public class IntType extends AbstractType {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{IntType}";
   }
}
