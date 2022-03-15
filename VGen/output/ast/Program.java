/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	program -> classnode:classNode  methodcall:methodCall

public class Program extends AbstractAST  {

	public Program(ClassNode classnode, MethodCall methodcall) {
		this.classnode = classnode;
		this.methodcall = methodcall;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(classnode, methodcall);
	}

	public Program(Object classnode, Object methodcall) {
		this.classnode = (ClassNode) getAST(classnode);
		this.methodcall = (MethodCall) getAST(methodcall);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(classnode, methodcall);
	}

	public ClassNode getClassnode() {
		return classnode;
	}
	public void setClassnode(ClassNode classnode) {
		this.classnode = classnode;
	}

	public MethodCall getMethodcall() {
		return methodcall;
	}
	public void setMethodcall(MethodCall methodcall) {
		this.methodcall = methodcall;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private ClassNode classnode;
	private MethodCall methodcall;

	public String toString() {
       return "{classnode:" + getClassnode() + ", methodcall:" + getMethodcall() + "}";
   }
}
