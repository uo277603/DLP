/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import visitor.*;

//	realType:type -> 

public class RealType extends AbstractType {

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}


	public String toString() {
       return "{RealType}";
   }

   //Modificacioens

	@Override
	public String getName() {
		return "float";
	}

	// realType.size = 4
	@Override
	public int getSize() {
		return 4;
	}


	@Override
	public String getSuffix() {
		return "f";
	}
}
