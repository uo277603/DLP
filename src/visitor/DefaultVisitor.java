/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package visitor;

import ast.*;
import java.util.*;

/*
DefaultVisitor. Implementación base del visitor para ser derivada por nuevos visitor.
	No modificar esta clase. Para crear nuevos visitor usar el fichero "_PlantillaParaVisitors.txt".
	DefaultVisitor ofrece una implementación por defecto de cada nodo que se limita a visitar los nodos hijos.
*/
public class DefaultVisitor implements Visitor {

	//	class Program { ClassNode classnode;  MethodCallSentence methodcallsentence; }
	public Object visit(Program program, Object param) {
		if (program.getClassnode() != null)
			program.getClassnode().accept(this, param);
		if (program.getMethodcallsentence() != null)
			program.getMethodcallsentence().accept(this, param);
		return null;
	}

	//	class ClassNode { String name;  List<Definition> definition;  List<String> createMethod;  List<Method> method; }
	public Object visit(ClassNode classNode, Object param) {
		visitChildren(classNode.getDefinition(), param);
		visitChildren(classNode.getMethod(), param);
		return null;
	}

	//	class Method { String name;  List<Parameter> parameter;  Type retorno;  List<Definition> definition;  List<Sentence> sentence; }
	public Object visit(Method method, Object param) {
		visitChildren(method.getParameter(), param);
		if (method.getRetorno() != null)
			method.getRetorno().accept(this, param);
		visitChildren(method.getDefinition(), param);
		visitChildren(method.getSentence(), param);
		return null;
	}

	//	class Parameter { String name;  Type type; }
	public Object visit(Parameter parameter, Object param) {
		if (parameter.getType() != null)
			parameter.getType().accept(this, param);
		return null;
	}

	//	class Print { String string;  List<Expr> expr; }
	public Object visit(Print print, Object param) {
		visitChildren(print.getExpr(), param);
		return null;
	}

	//	class Read { List<Expr> expr; }
	public Object visit(Read read, Object param) {
		visitChildren(read.getExpr(), param);
		return null;
	}

	//	class Assignment { Expr left;  Expr right; }
	public Object visit(Assignment assignment, Object param) {
		if (assignment.getLeft() != null)
			assignment.getLeft().accept(this, param);
		if (assignment.getRight() != null)
			assignment.getRight().accept(this, param);
		return null;
	}

	//	class Conditional { Expr condition;  List<Sentence> iftrue;  List<Sentence> iffalse; }
	public Object visit(Conditional conditional, Object param) {
		if (conditional.getCondition() != null)
			conditional.getCondition().accept(this, param);
		visitChildren(conditional.getIftrue(), param);
		visitChildren(conditional.getIffalse(), param);
		return null;
	}

	//	class Loop { List<Sentence> init;  Expr condition;  List<Sentence> sentence; }
	public Object visit(Loop loop, Object param) {
		visitChildren(loop.getInit(), param);
		if (loop.getCondition() != null)
			loop.getCondition().accept(this, param);
		visitChildren(loop.getSentence(), param);
		return null;
	}

	//	class ReturnNode { Expr expr; }
	public Object visit(ReturnNode returnNode, Object param) {
		if (returnNode.getExpr() != null)
			returnNode.getExpr().accept(this, param);
		return null;
	}

	//	class MethodCallSentence { String name;  List<Expr> args; }
	public Object visit(MethodCallSentence methodCallSentence, Object param) {
		visitChildren(methodCallSentence.getArgs(), param);
		return null;
	}

	//	class ExprBinariaAritmetica { Expr left;  String op;  Expr right; }
	public Object visit(ExprBinariaAritmetica exprBinariaAritmetica, Object param) {
		if (exprBinariaAritmetica.getLeft() != null)
			exprBinariaAritmetica.getLeft().accept(this, param);
		if (exprBinariaAritmetica.getRight() != null)
			exprBinariaAritmetica.getRight().accept(this, param);
		return null;
	}

	//	class ExprUnariaAritmetica { String op;  Expr expr; }
	public Object visit(ExprUnariaAritmetica exprUnariaAritmetica, Object param) {
		if (exprUnariaAritmetica.getExpr() != null)
			exprUnariaAritmetica.getExpr().accept(this, param);
		return null;
	}

	//	class ExprBinariaLogica { Expr left;  String op;  Expr right; }
	public Object visit(ExprBinariaLogica exprBinariaLogica, Object param) {
		if (exprBinariaLogica.getLeft() != null)
			exprBinariaLogica.getLeft().accept(this, param);
		if (exprBinariaLogica.getRight() != null)
			exprBinariaLogica.getRight().accept(this, param);
		return null;
	}

	//	class ExprUnariaLogica { String op;  Expr expr; }
	public Object visit(ExprUnariaLogica exprUnariaLogica, Object param) {
		if (exprUnariaLogica.getExpr() != null)
			exprUnariaLogica.getExpr().accept(this, param);
		return null;
	}

	//	class Acces { Expr left;  String op;  Expr right; }
	public Object visit(Acces acces, Object param) {
		if (acces.getLeft() != null)
			acces.getLeft().accept(this, param);
		if (acces.getRight() != null)
			acces.getRight().accept(this, param);
		return null;
	}

	//	class ArrayAcces { Expr left;  Expr right; }
	public Object visit(ArrayAcces arrayAcces, Object param) {
		if (arrayAcces.getLeft() != null)
			arrayAcces.getLeft().accept(this, param);
		if (arrayAcces.getRight() != null)
			arrayAcces.getRight().accept(this, param);
		return null;
	}

	//	class Cast { Type typeToConvert;  Expr expr; }
	public Object visit(Cast cast, Object param) {
		if (cast.getTypeToConvert() != null)
			cast.getTypeToConvert().accept(this, param);
		if (cast.getExpr() != null)
			cast.getExpr().accept(this, param);
		return null;
	}

	//	class LitEnt { String string; }
	public Object visit(LitEnt litEnt, Object param) {
		return null;
	}

	//	class LitReal { String string; }
	public Object visit(LitReal litReal, Object param) {
		return null;
	}

	//	class LitChar { String string; }
	public Object visit(LitChar litChar, Object param) {
		return null;
	}

	//	class Variable { String string; }
	public Object visit(Variable variable, Object param) {
		return null;
	}

	//	class MethodCallExpr { String name;  List<Expr> args; }
	public Object visit(MethodCallExpr methodCallExpr, Object param) {
		visitChildren(methodCallExpr.getArgs(), param);
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType intType, Object param) {
		return null;
	}

	//	class RealType {  }
	public Object visit(RealType realType, Object param) {
		return null;
	}

	//	class CharType {  }
	public Object visit(CharType charType, Object param) {
		return null;
	}

	//	class ArrayType { int index;  Type type; }
	public Object visit(ArrayType arrayType, Object param) {
		if (arrayType.getType() != null)
			arrayType.getType().accept(this, param);
		return null;
	}

	//	class VoidType {  }
	public Object visit(VoidType voidType, Object param) {
		return null;
	}

	//	class StructType { String name; }
	public Object visit(StructType structType, Object param) {
		return null;
	}

	//	class TupleDefinition { String name;  List<VarDefinition> vardefinition; }
	public Object visit(TupleDefinition tupleDefinition, Object param) {
		visitChildren(tupleDefinition.getVardefinition(), param);
		return null;
	}

	//	class VarDefinition { List<String> name;  Type type; }
	public Object visit(VarDefinition varDefinition, Object param) {
		if (varDefinition.getType() != null)
			varDefinition.getType().accept(this, param);
		return null;
	}

    // Método auxiliar -----------------------------
    protected void visitChildren(List<? extends AST> children, Object param) {
        if (children != null)
            for (AST child : children)
                child.accept(this, param);
    }
}
