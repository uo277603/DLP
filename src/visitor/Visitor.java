/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package visitor;

import ast.*;

public interface Visitor {
	public Object visit(Program program, Object param);
	public Object visit(ClassNode classNode, Object param);
	public Object visit(Method method, Object param);
	public Object visit(Parameter parameter, Object param);
	public Object visit(Print print, Object param);
	public Object visit(Read read, Object param);
	public Object visit(Assignment assignment, Object param);
	public Object visit(Conditional conditional, Object param);
	public Object visit(Loop loop, Object param);
	public Object visit(ForSentence forSentence, Object param);
	public Object visit(ReturnNode returnNode, Object param);
	public Object visit(MethodCallSentence methodCallSentence, Object param);
	public Object visit(ExprBinariaAritmetica exprBinariaAritmetica, Object param);
	public Object visit(ExprUnariaAritmetica exprUnariaAritmetica, Object param);
	public Object visit(ExprBinariaLogica exprBinariaLogica, Object param);
	public Object visit(ExprUnariaLogica exprUnariaLogica, Object param);
	public Object visit(Acces acces, Object param);
	public Object visit(ArrayAcces arrayAcces, Object param);
	public Object visit(Cast cast, Object param);
	public Object visit(LitEnt litEnt, Object param);
	public Object visit(LitReal litReal, Object param);
	public Object visit(LitChar litChar, Object param);
	public Object visit(Variable variable, Object param);
	public Object visit(MethodCallExpr methodCallExpr, Object param);
	public Object visit(IntType intType, Object param);
	public Object visit(RealType realType, Object param);
	public Object visit(CharType charType, Object param);
	public Object visit(ArrayType arrayType, Object param);
	public Object visit(VoidType voidType, Object param);
	public Object visit(StructType structType, Object param);
	public Object visit(TupleDefinition tupleDefinition, Object param);
	public Object visit(VarDefinition varDefinition, Object param);
}
