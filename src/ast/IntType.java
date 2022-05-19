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

   //Modificaciones

	@Override
	public String getName() {
		return "INTEGER";
	}

	@Override
	public int getSize() {
		return 2;
	}


	@Override
	public String getSuffix() {
		return "i";
	}
}
