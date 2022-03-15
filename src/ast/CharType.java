/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import visitor.*;

//	charType:type -> 

public class CharType extends AbstractType {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{CharType}";
   }

    //Modificaciones

	@Override
	public String getName() {
		return "CHARACTER";
	}
}
