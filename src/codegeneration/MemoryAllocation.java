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

		// definitioni.address = 
		// ∑ definitioni.type.size * definition.name.size | 0 <= j < i
		if (classNode.getDefinition() != null)
			for (Definition child : classNode.getDefinition()) {
				if (child instanceof VarDefinition) {
					VarDefinition def = (VarDefinition) child;				
					child.setAddress(acumAddress);		
					acumAddress += child.getType().getSize() * def.getName().size();
				}
				if(child instanceof TupleDefinition){
					child.accept(this, param);
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
		int parameterAddress = 4;
		// parameteri.addres = 4 + ∑ parameteri.type.size | 0 <= j < i
		if (method.getParameter() != null)
			for(int i = method.getParameter().size() - 1; i >= 0 ; i--){
				method.getParameter().get(i).getDefinition().setAddress(parameterAddress);
				parameterAddress += method.getParameter().get(i).getDefinition().getType().getSize();
			}

		if (method.getRetorno() != null)
			method.getRetorno().accept(this, param);

		// definitioni.address = ∑ -definitioni.type.size * definition.name.size | 0 <= j < i
		int localAddress = 0;
		if (method.getDefinition() != null)
			for (Definition child : method.getDefinition()){
				if(child instanceof VarDefinition){
					VarDefinition def = (VarDefinition) child;
					localAddress -= child.getType().getSize() * def.getName().size();
				}
				child.setAddress(localAddress);

			}

		if (method.getSentence() != null)
			for (Sentence child : method.getSentence())
				child.accept(this, param);

		return null;
	}

	// class TupleDefinition { String name; List<VarDefinition> vardefinition; }
	public Object visit(TupleDefinition tupleDefinition, Object param) {

		// super.visit(node, param);

		// vardefinitioni.address = ∑ vardefinitioni.type.size | 0 <= j < i
		int offset = 0;
		if (tupleDefinition.getVardefinition() != null)
			for (VarDefinition child : tupleDefinition.getVardefinition()) {
				child.setAddress(offset);
				offset += child.getType().getSize();
			}

		return null;
	}

}
