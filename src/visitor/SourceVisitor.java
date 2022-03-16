package visitor;

import ast.*;

public class SourceVisitor extends DefaultVisitor {

	// class Program { ClassNode classnode; MethodCallSentence methodcallsentence; }
	public Object visit(Program program, Object param) {

		// super.visit(node, param);

		if (program.getClassnode() != null)
			program.getClassnode().accept(this, param);
		woutln(0, "main");
		if (program.getMethodcallsentence() != null)
			program.getMethodcallsentence().accept(this, param);
		wout(0, "end");
		return null;
	}

	// class ClassNode { String name; List<Definition> definition; List<String>
	// createMethod; List<Method> method; }
	public Object visit(ClassNode classNode, Object param) {

		// super.visit(node, param);
		woutln(0, "class " + classNode.getName() + ";");
		woutln(1, "");
		if (classNode.getDefinition() != null)
			woutln(1, "global");
		woutln(2, "types");
		Definition lastChild = null;
		for (Definition child : classNode.getDefinition()) {
			if (lastChild != null && lastChild instanceof TupleDefinition && child instanceof VarDefinition)
				woutln(2, "vars");
			child.accept(this, param);
			lastChild = child;
		}

		woutln(1, "create");
		for (String s : classNode.getCreateMethod()) {
			woutln(0, s + ';');
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
		wout(1, "feature " + method.getName());
		if (method.getParameter() != null) {
			wout(0, "(");
			for (Parameter child : method.getParameter())
				child.accept(this, param);
			wout(0, ")");

		}

		if (method.getRetorno() != null) {
			wout(0, " : " + method.getRetorno().getName());
			method.getRetorno().accept(this, param);
		}
		woutln(0, " is");
		if (method.getDefinition() != null) {
			woutln(2, "local");
			for (Definition child : method.getDefinition()) {
				child.accept(this, param);
				woutln(0, "");
			}
		}
		woutln(2, "do");
		if (method.getSentence() != null)
			for (Sentence child : method.getSentence())
				child.accept(this, param);

		return null;
	}

	// class Parameter { String name; Type type; }
	public Object visit(Parameter parameter, Object param) {

		// super.visit(node, param);
		wout(0, parameter.getName() + " : " + parameter.getType().getName());
		if (parameter.getType() != null)
			parameter.getType().accept(this, param);

		return null;
	}

	// class Print { String string; List<Expr> expr; }
	public Object visit(Print print, Object param) {

		// super.visit(node, param);
		wout(3, print.getString() + " ");
		if (print.getExpr() != null)
			for (Expr child : print.getExpr()) {
				child.accept(this, param);
			}
		woutln(0, ";");
		return null;
	}

	// class Read { List<Expr> expr; }
	public Object visit(Read read, Object param) {

		// super.visit(node, param);
		wout(3, "read ");
		if (read.getExpr() != null)
			for (Expr child : read.getExpr())
				child.accept(this, param);
		woutln(0, ";");
		return null;
	}

	// class Assignment { Expr left; Expr right; }
	public Object visit(Assignment assignment, Object param) {

		// super.visit(node, param);

		if (assignment.getLeft() != null)
			assignment.getLeft().accept(this, param);
		wout(0, " := ");
		if (assignment.getRight() != null)
			assignment.getRight().accept(this, param);

		woutln(0, ";");
		return null;
	}

	// class Conditional { Expr condition; List<Sentence> iftrue; List<Sentence>
	// iffalse; }
	public Object visit(Conditional conditional, Object param) {

		// super.visit(node, param);
		wout(3, "if ");
		if (conditional.getCondition() != null)
			conditional.getCondition().accept(this, param);
		woutln(0, " then");
		if (conditional.getIftrue() != null)
			for (Sentence child : conditional.getIftrue()) {
				wout(4, "");
				child.accept(this, param);
			}

		if (conditional.getIffalse() != null) {
			woutln(3, "else");
			for (Sentence child : conditional.getIffalse()) {
				wout(4, "");
				child.accept(this, param);
			}
		}
		woutln(3, "end");

		return null;
	}

	// class Loop { List<Sentence> init; Expr condition; List<Sentence> sentence; }
	public Object visit(Loop loop, Object param) {

		// super.visit(node, param);

		if (loop.getInit() != null) {
			woutln(3, "from");
			for (Sentence child : loop.getInit()) {
				wout(4, "");
				child.accept(this, param);
			}
		}
		wout(3, "until ");
		if (loop.getCondition() != null)
			loop.getCondition().accept(this, param);
		woutln(0, " loop");
		if (loop.getSentence() != null)
			for (Sentence child : loop.getSentence()) {
				wout(4, "");
				child.accept(this, param);
			}
		woutln(3, "end");
		return null;
	}

	// class ReturnNode { Expr expr; }
	public Object visit(ReturnNode returnNode, Object param) {

		// super.visit(node, param);
		wout(3, "return ");
		if (returnNode.getExpr() != null)
			returnNode.getExpr().accept(this, param);

		woutln(0, ";");
		return null;
	}

	// class ExprBinariaAritmetica { Expr left; String op; Expr right; }
	public Object visit(ExprBinariaAritmetica exprBinariaAritmetica, Object param) {

		// super.visit(node, param);
		wout(0, "(");
		if (exprBinariaAritmetica.getLeft() != null)
			exprBinariaAritmetica.getLeft().accept(this, param);
		wout(0, " " + exprBinariaAritmetica.getOp() + " ");
		if (exprBinariaAritmetica.getRight() != null)
			exprBinariaAritmetica.getRight().accept(this, param);
		wout(0, ")");
		return null;
	}

	// class ExprUnariaAritmetica { String op; Expr expr; }
	public Object visit(ExprUnariaAritmetica exprUnariaAritmetica, Object param) {

		// super.visit(node, param);
		wout(0, exprUnariaAritmetica.getOp() + " ");
		if (exprUnariaAritmetica.getExpr() != null)
			exprUnariaAritmetica.getExpr().accept(this, param);

		return null;
	}

	// class ExprBinariaLogica { Expr left; String op; Expr right; }
	public Object visit(ExprBinariaLogica exprBinariaLogica, Object param) {

		// super.visit(node, param);
		wout(0, "(");
		if (exprBinariaLogica.getLeft() != null)
			exprBinariaLogica.getLeft().accept(this, param);

		wout(0, " " + exprBinariaLogica.getOp() + " ");
		if (exprBinariaLogica.getRight() != null)
			exprBinariaLogica.getRight().accept(this, param);
		wout(0, ")");
		return null;
	}

	// class ExprUnariaLogica { String op; Expr expr; }
	public Object visit(ExprUnariaLogica exprUnariaLogica, Object param) {

		// super.visit(node, param);
		wout(0, exprUnariaLogica.getOp() + " ");
		if (exprUnariaLogica.getExpr() != null)
			exprUnariaLogica.getExpr().accept(this, param);

		return null;
	}

	// class Acces { Expr left; String op; String right; }
	public Object visit(Acces acces, Object param) {

		// super.visit(node, param);

		if (acces.getLeft() != null)
			acces.getLeft().accept(this, param);

		wout(0, acces.getOp());
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
		wout(0, "to<" + cast.getTypeToConvert().getName() + ">(");
		if (cast.getTypeToConvert() != null)
			cast.getTypeToConvert().accept(this, param);

		if (cast.getExpr() != null)
			cast.getExpr().accept(this, param);

		return null;
	}

	// class LitEnt { String string; }
	public Object visit(LitEnt litEnt, Object param) {
		wout(0, litEnt.getString());
		return null;
	}

	// class LitReal { String string; }
	public Object visit(LitReal litReal, Object param) {
		wout(0, litReal.getString());
		return null;
	}

	// class LitChar { String string; }
	public Object visit(LitChar litChar, Object param) {
		wout(0, litChar.getString());
		return null;
	}

	// class Variable { String string; }
	public Object visit(Variable variable, Object param) {
		wout(0, variable.getString());
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
		woutln(3, "deftuple " + tupleDefinition.getName() + " as");
		if (tupleDefinition.getVardefinition() != null)
			for (VarDefinition child : tupleDefinition.getVardefinition())
				child.accept(this, param);
		woutln(3, "end");
		return null;
	}

	// class VarDefinition { List<String> name; Type type; }
	public Object visit(VarDefinition varDefinition, Object param) {

		// super.visit(node, param);
		woutln(3, varDefinition.getNames() + " : " + varDefinition.getType().getName());
		if (varDefinition.getType() != null)
			varDefinition.getType().accept(this, param);

		return null;
	}

	// class MethodCallSentence { String name; List<Expr> args; }
	public Object visit(MethodCallSentence methodCallSentence, Object param) {

		// super.visit(node, param);
		wout(3, methodCallSentence.getName() + "(");
		if (methodCallSentence.getArgs() != null) {
			int count = 0;
			for (Expr child : methodCallSentence.getArgs()) {
				child.accept(this, param);
				if (count != methodCallSentence.getArgs().size() - 1)
					System.out.print(", ");
				count++;
			}
		}
		woutln(0, ");");
		return null;
	}

	// class MethodCallExpr { String name; List<Expr> args; }
	public Object visit(MethodCallExpr methodCallExpr, Object param) {

		// super.visit(node, param);
		wout(0, methodCallExpr.getName() + "(");
		if (methodCallExpr.getArgs() != null) {
			int count = 0;
			for (Expr child : methodCallExpr.getArgs()) {
				child.accept(this, param);
				if (count != methodCallExpr.getArgs().size() - 1)
					System.out.print(", ");
				count++;
			}
		}
		wout(0, ")");
		return null;
	}

	/*
	 * Auxiliares
	 */

	// Método auxiliar de impresión. Se puede cambiar para enviarlo a un fichero
	private void wout(int indent, String s) {
		System.out.print(getIndent(indent) + s);
	}

	private void woutln(int indent, String s) {
		System.out.println(getIndent(indent) + s);
	}

	// Método auxiliar para convertir posiciones de tabulación en cadena de
	// tabuladores
	private String getIndent(int indent) {
		String sindent = "";
		for (; indent > 0; indent--)
			sindent += "\t";
		return sindent;
	}
}
