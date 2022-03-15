package visitor;

import ast.*;

public class SourceVisitor extends DefaultVisitor {
	// class Program { ClassNode classnode; MethodCall methodcall; }
	public Object visit(Program program, Object param) {

		// super.visit(node, param);

		if (program.getClassnode() != null)
			program.getClassnode().accept(this, param);

		System.out.println("main");

		if (program.getMethodcall() != null)
			program.getMethodcall().accept(this, param);
		System.out.print("end");
		return null;
	}

	// class ClassNode { String name; List<Definition> definition; List<String>
	// createMethod; List<Method> method; }
	public Object visit(ClassNode classNode, Object param) {

		// super.visit(node, param);
		System.out.println("class " + classNode.getName() + ";");
		System.out.println();
		if (classNode.getDefinition() != null)
			System.out.println("global");
		System.out.println("types");
		Definition lastChild = null;
		for (Definition child : classNode.getDefinition()){
			if(lastChild != null && lastChild instanceof TupleDefinition && child instanceof VarDefinition)
				System.out.println("vars");
			child.accept(this, param);
			lastChild = child;
		}

		System.out.println("create");
		for (String s : classNode.getCreateMethod()) {
			System.out.println(s + ';');
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
		System.out.print("feature " + method.getName());
		if (method.getParameter() != null) {
			System.out.print("(");
			for (Parameter child : method.getParameter())
				child.accept(this, param);
			System.out.print(")");

		}

		if (method.getRetorno() != null) {
			System.out.print(" : " + method.getRetorno().getName());
			method.getRetorno().accept(this, param);
		}
		System.out.println(" is");
		if (method.getDefinition() != null) {
			System.out.println("local");
			for (Definition child : method.getDefinition()) {
				child.accept(this, param);
				System.out.println();
			}
		}
		System.out.println("do");
		if (method.getSentence() != null)
			for (Sentence child : method.getSentence())
				child.accept(this, param);

		return null;
	}

	// class Parameter { String name; Type type; }
	public Object visit(Parameter parameter, Object param) {

		// super.visit(node, param);
		System.out.print(parameter.getName() + " : " + parameter.getType().getName());
		if (parameter.getType() != null)
			parameter.getType().accept(this, param);

		return null;
	}

	// class Print { String string; List<Expr> expr; }
	public Object visit(Print print, Object param) {

		// super.visit(node, param);
		System.out.print(print.getString() + " ");
		if (print.getExpr() != null)
			for (Expr child : print.getExpr()) {
				child.accept(this, param);
			}
		System.out.println(";");
		return null;
	}

	// class Read { List<Expr> expr; }
	public Object visit(Read read, Object param) {

		// super.visit(node, param);
		System.out.print("read ");
		if (read.getExpr() != null)
			for (Expr child : read.getExpr())
				child.accept(this, param);
		System.out.println(";");
		return null;
	}

	// class Assignment { Expr left; Expr right; }
	public Object visit(Assignment assignment, Object param) {

		// super.visit(node, param);

		if (assignment.getLeft() != null)
			assignment.getLeft().accept(this, param);
		System.out.print(" := ");
		if (assignment.getRight() != null)
			assignment.getRight().accept(this, param);

		System.out.println(";");
		return null;
	}

	// class Conditional { Expr condition; List<Sentence> iftrue; List<Sentence>
	// iffalse; }
	public Object visit(Conditional conditional, Object param) {

		// super.visit(node, param);
		System.out.print("if ");
		if (conditional.getCondition() != null)
			conditional.getCondition().accept(this, param);
		System.out.println(" then");
		if (conditional.getIftrue() != null)
			for (Sentence child : conditional.getIftrue())
				child.accept(this, param);

		if (conditional.getIffalse() != null) {
			System.out.println("else");
			for (Sentence child : conditional.getIffalse())
				child.accept(this, param);
		}
		System.out.println("end");

		return null;
	}

	// class Loop { List<Sentence> init; Expr condition; List<Sentence> sentence; }
	public Object visit(Loop loop, Object param) {

		// super.visit(node, param);

		if (loop.getInit() != null) {
			System.out.println("from");
			for (Sentence child : loop.getInit())
				child.accept(this, param);
		}
		System.out.print("until ");
		if (loop.getCondition() != null)
			loop.getCondition().accept(this, param);
		System.out.println(" loop");
		if (loop.getSentence() != null)
			for (Sentence child : loop.getSentence())
				child.accept(this, param);
		System.out.println("end");
		return null;
	}

	// class ReturnNode { Expr expr; }
	public Object visit(ReturnNode returnNode, Object param) {

		// super.visit(node, param);
		System.out.print("return ");
		if (returnNode.getExpr() != null)
			returnNode.getExpr().accept(this, param);

		System.out.println(";");
		return null;
	}

	//	class ExprBinariaAritmetica { Expr left;  String op;  Expr right; }
	public Object visit(ExprBinariaAritmetica exprBinariaAritmetica, Object param) {

		// super.visit(node, param);

		if (exprBinariaAritmetica.getLeft() != null)
			exprBinariaAritmetica.getLeft().accept(this, param);
		System.out.print(" " + exprBinariaAritmetica.getOp() + " ");
		if (exprBinariaAritmetica.getRight() != null)
			exprBinariaAritmetica.getRight().accept(this, param);

		return null;
	}

	//	class ExprUnariaAritmetica { String op;  Expr expr; }
	public Object visit(ExprUnariaAritmetica exprUnariaAritmetica, Object param) {

		// super.visit(node, param);
		System.out.print(exprUnariaAritmetica.getOp() + " ");
		if (exprUnariaAritmetica.getExpr() != null)
			exprUnariaAritmetica.getExpr().accept(this, param);

		return null;
	}

	//	class ExprBinariaLogica { Expr left;  String op;  Expr right; }
	public Object visit(ExprBinariaLogica exprBinariaLogica, Object param) {

		// super.visit(node, param);

		if (exprBinariaLogica.getLeft() != null)
			exprBinariaLogica.getLeft().accept(this, param);

		System.out.print(" " + exprBinariaLogica.getOp() + " ");
		if (exprBinariaLogica.getRight() != null)
			exprBinariaLogica.getRight().accept(this, param);

		return null;
	}

	//	class ExprUnariaLogica { String op;  Expr expr; }
	public Object visit(ExprUnariaLogica exprUnariaLogica, Object param) {

		// super.visit(node, param);
		System.out.print(exprUnariaLogica.getOp() + " ");
		if (exprUnariaLogica.getExpr() != null)
			exprUnariaLogica.getExpr().accept(this, param);

		return null;
	}

	//	class Acces { Expr left;  String op;  Expr right; }
	public Object visit(Acces acces, Object param) {

		// super.visit(node, param);

		if (acces.getLeft() != null)
			acces.getLeft().accept(this, param);

		System.out.print(acces.getOp());	
		if (acces.getRight() != null)
			acces.getRight().accept(this, param);

		return null;
	}
	// class ArrayAcces { Expr left; Expr right; }
	public Object visit(ArrayAcces arrayAcces, Object param) {

		// super.visit(node, param);

		if (arrayAcces.getLeft() != null)
			arrayAcces.getLeft().accept(this, param);

		if (arrayAcces.getRight() != null)
			arrayAcces.getRight().accept(this, param);

		return null;
	}

	// class Cast { Type typeToConvert; Expr expr; }
	public Object visit(Cast cast, Object param) {

		// super.visit(node, param);
		System.out.println("to<" + cast.getTypeToConvert().getName() + ">(" + cast.getExpr() + ");");
		if (cast.getTypeToConvert() != null)
			cast.getTypeToConvert().accept(this, param);

		if (cast.getExpr() != null)
			cast.getExpr().accept(this, param);

		return null;
	}

	// class LitEnt { String string; }
	public Object visit(LitEnt litEnt, Object param) {
		System.out.print(litEnt.getString());
		return null;
	}

	// class LitReal { String string; }
	public Object visit(LitReal litReal, Object param) {
		System.out.print(litReal.getString());
		return null;
	}

	// class LitChar { String string; }
	public Object visit(LitChar litChar, Object param) {
		System.out.print(litChar.getString());
		return null;
	}

	// class Variable { String string; }
	public Object visit(Variable variable, Object param) {
		System.out.print(variable.getString());
		return null;
	}

	// class IntType { }
	public Object visit(IntType intType, Object param) {
		return null;
	}

	// class RealType { }
	public Object visit(RealType realType, Object param) {
		return null;
	}

	// class CharType { }
	public Object visit(CharType charType, Object param) {
		return null;
	}

	// class ArrayType { }
	public Object visit(ArrayType arrayType, Object param) {
		return null;
	}

	// class VoidType { }
	public Object visit(VoidType voidType, Object param) {
		return null;
	}

	// class StructType { }
	public Object visit(StructType structType, Object param) {
		return null;
	}

	// class TupleDefinition { String name; List<VarDefinition> vardefinition; }
	public Object visit(TupleDefinition tupleDefinition, Object param) {

		// super.visit(node, param);
		System.out.println("deftuple " + tupleDefinition.getName() + " as");
		if (tupleDefinition.getVardefinition() != null)
			for (VarDefinition child : tupleDefinition.getVardefinition())
				child.accept(this, param);
		System.out.println("end");
		return null;
	}

	// class VarDefinition { List<String> name; Type type; }
	public Object visit(VarDefinition varDefinition, Object param) {

		// super.visit(node, param);
		System.out.println(varDefinition.getNames() + " : " + varDefinition.getType().getName());
		if (varDefinition.getType() != null)
			varDefinition.getType().accept(this, param);

		return null;
	}

	// class MethodCall { String name; List<Expr> args; }
	public Object visit(MethodCall methodCall, Object param) {

		// super.visit(node, param);
		System.out.print(methodCall.getName() + "(");
		
		if (methodCall.getArgs() != null){
		int count = 0;
			for (Expr child : methodCall.getArgs()){
				child.accept(this, param);
				if(count != methodCall.getArgs().size() - 1)
					System.out.print(", ");
				count++;
			}
		}
		System.out.println(");");

		return null;
	}
}
