/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import org.antlr.v4.runtime.*;

import visitor.*;

//	program -> classnode:classNode  methodcallsentence:methodCallSentence

public class Program extends AbstractAST  {

	public Program(ClassNode classnode, MethodCallSentence methodcallsentence) {
		this.classnode = classnode;
		this.methodcallsentence = methodcallsentence;

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(classnode, methodcallsentence);
	}

	public Program(Object classnode, Object methodcallsentence) {
		this.classnode = (ClassNode) getAST(classnode);
		this.methodcallsentence = (MethodCallSentence) getAST(methodcallsentence);

       // Lo siguiente se puede borrar si no se quiere la posicion en el fichero.
       // Obtiene la linea/columna a partir de las de los hijos.
       setPositions(classnode, methodcallsentence);
	}

	public ClassNode getClassnode() {
		return classnode;
	}
	public void setClassnode(ClassNode classnode) {
		this.classnode = classnode;
	}

	public MethodCallSentence getMethodcallsentence() {
		return methodcallsentence;
	}
	public void setMethodcallsentence(MethodCallSentence methodcallsentence) {
		this.methodcallsentence = methodcallsentence;
	}

	@Override
	public Object accept(Visitor v, Object param) { 
		return v.visit(this, param);
	}

	private ClassNode classnode;
	private MethodCallSentence methodcallsentence;

	public String toString() {
       return "{classnode:" + getClassnode() + ", methodcallsentence:" + getMethodcallsentence() + "}";
   }
}
