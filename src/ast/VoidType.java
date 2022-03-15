/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import visitor.*;

//	voidType:type -> 

public class VoidType extends AbstractType {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{VoidType}";
   }

   //Modificaciones

	@Override
	public String getName() {
		return "VOID";
	}
}
