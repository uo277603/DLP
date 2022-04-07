/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import ast.*;
import visitor.*;

/**
 * Clase encargada de asignar direcciones a las variables.
 */
public class MemoryAllocation extends DefaultVisitor {

	// class ClassNode { String name; List<Definition> definition; List<String>
	// createMethod; List<Method> method; }
	public Object visit(ClassNode classNode, Object param) {
		int acumAddress = 0;
		// super.visit(node, param);

		if (classNode.getDefinition() != null)
			for (Definition child : classNode.getDefinition()) {
				if (child instanceof VarDefinition) {
					child.setAddress(acumAddress);
					acumAddress += child.getType().getSize();
				}
			}

		if (classNode.getMethod() != null)
			for (Method child : classNode.getMethod())
				child.accept(this, param);

		return null;
	}

	// class Method { String name; List<Parameter> parameter; Type retorno;
	// List<Definition> definition; List<Sentence> sentence; }
	public Object visit(Method method, Object param) {

		// super.visit(node, param);

		if (method.getParameter() != null)
			for (Parameter child : method.getParameter())
				child.accept(this, param);

		if (method.getRetorno() != null)
			method.getRetorno().accept(this, param);

		if (method.getDefinition() != null)
			for (Definition child : method.getDefinition())
				child.accept(this, param);

		if (method.getSentence() != null)
			for (Sentence child : method.getSentence())
				child.accept(this, param);

		return null;
	}

	// class TupleDefinition { String name; List<VarDefinition> vardefinition; }
	public Object visit(TupleDefinition tupleDefinition, Object param) {

		// super.visit(node, param);
		int offset = 0;
		if (tupleDefinition.getVardefinition() != null)
			for (VarDefinition child : tupleDefinition.getVardefinition()) {
				child.setAddress(offset);
				offset += child.getType().getSize();
			}

		return null;
	}

	// class VarDefinition { List<String> name; Type type; }
	public Object visit(VarDefinition varDefinition, Object param) {

		// super.visit(node, param);

		if (varDefinition.getType() != null)
			varDefinition.getType().accept(this, param);

		return null;
	}

}
