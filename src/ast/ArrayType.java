/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	arrayType:type -> index:int  type:type

public class ArrayType extends AbstractType {

	public ArrayType(int index, Type type) {
		this.index = index;
		this.type = type;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(type);
	}

	public ArrayType(Object index, Object type) {
		this.index = (index instanceof Token) ? Integer.parseInt(((Token)index).getText()) : (Integer) index;
		this.type = (Type) getAST(type);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(index, type);
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private int index;
	private Type type;

	public String toString() {
       return "{index:" + getIndex() + ", type:" + getType() + "}";
   }

   //Modificaciones

	@Override
	public String getName() {
		return "[" + getIndex() + "]" + getType().getName();
	}
}
