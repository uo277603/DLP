/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package visitor;

import java.io.*;

import ast.*;
import java.util.*;

/**
 * ASTPrinter. Utilidad que ayuda a validar un arbol AST:
 * - Muestra la estructura del árbol en HTML.
 * - Destaca los hijos/propiedades a null.
 * - Muestra a qué texto apuntan las posiciones de cada nodo (linea/columna)
 *      ayudando a decidir cual de ellas usar en los errores y generación de código.
 *
 * Esta clase se genera con VGen. El uso de esta clase es opcional (puede eliminarse del proyecto).
 *
 */
public class ASTPrinter extends DefaultVisitor {

    /**
     * toHtml. Muestra la estructura del AST indicando qué hay en las posiciones
     * (línea y columna) de cada nodo.
     *
     * @param sourceFile El fichero del cual se ha obtenido el AST
     * @param raiz       El AST creado a partir de sourceFile
     * @param filename   Nombre del fichero HMTL a crear con la traza del AST
     */

    public static void toHtml(String sourceFile, AST raiz, String filename) {
        toHtml(sourceFile, raiz, filename, 4);
    }

    public static void toHtml(AST raiz, String filename) {
        toHtml(null, raiz, filename);
    }

    // tabWidth deberían ser los espacios correspondientes a un tabulador en eclipse.
    // Normalmente no sería necesario especificarlo. Usar mejor los dos métodos anteriores.

    public static void toHtml(String sourceFile, AST raiz, String filename, int tabWidth) {
        try {
            PrintWriter writer = new PrintWriter(
                    new FileWriter(filename.endsWith(".html") ? filename : filename + ".html"));
            generateHeader(writer);
            writer.println("[ASTPrinter] -------------------------------- line:col  line:col");
            if (raiz != null) {
                ASTPrinter tracer = new ASTPrinter(writer, loadLines(sourceFile, tabWidth));
                raiz.accept(tracer, Integer.valueOf(0));
            } else
                writer.println("raiz == null");
            writer.println(ls + ls + "[ASTPrinter] --------------------------------");
            generateFooter(writer);
            writer.close();
            System.out.println(ls + "ASTPrinter: Fichero '" + filename
                    + ".html' generado. Abra dicho fichero para validar el AST generado.");
        } catch (IOException e) {
            System.out.println(ls + "ASTPrinter: No se ha podido crear el fichero " + filename);
            e.printStackTrace();
        }
    }

    private static void generateHeader(PrintWriter writer) {
        writer.println("<html>\r\n"
            + "<head>\r\n"
            + "<meta charset=\"utf-8\" />\r\n"
            + "<style type=\"text/css\">\r\n"
            + ".value { font-weight: bold; }\r\n"
            + ".dots { color: #bebdbd; }\r\n"
            + ".type { color: #BBBBBB; }\r\n"
            + ".pos { color: #CCCCCC; }\r\n"
            + ".sourceText { color: #BBBBBB; }\r\n"
            + ".posText {\r\n" + "	color: #BBBBBB;\r\n"
            + "	text-decoration: underline; font-weight: bold;\r\n"
            + "}\r\n"
            + ".null {\r\n"
            + "	color: #FF0000;\r\n"
            + "	font-weight: bold;\r\n"
            + "	font-style: italic;\r\n" + "}\r\n"
            + "</style>\r\n" + "</head>\r\n" + "\r\n"
            + "<body><pre>");
    }

    private static void generateFooter(PrintWriter writer) {
        writer.println("</pre>\r\n" + "</body>\r\n" + "</html>");
    }

    private ASTPrinter(PrintWriter writer, List<String> sourceLines) {
        this.writer = writer;
        this.sourceLines = sourceLines;
    }

    // ----------------------------------------------
	//	class Program { ClassNode classnode;  MethodCallSentence methodcallsentence; }
	public Object visit(Program program, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Program", program, false);

		visit(indent + 1, "classnode", "ClassNode", program.getClassnode());
		visit(indent + 1, "methodcallsentence", "MethodCallSentence", program.getMethodcallsentence());
		return null;
	}

	//	class ClassNode { String name;  List<Definition> definition;  List<String> createMethod;  List<Method> method; }
	public Object visit(ClassNode classNode, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ClassNode", classNode, false);

		print(indent + 1, "name", "String", classNode.getName());
		visit(indent + 1, "definition", "List<Definition>", classNode.getDefinition());
		print(indent + 1, "createMethod", "List<String>", classNode.getCreateMethod());
		visit(indent + 1, "method", "List<Method>", classNode.getMethod());
		return null;
	}

	//	class Method { String name;  List<Parameter> parameter;  Type retorno;  List<Definition> definition;  List<Sentence> sentence; }
	public Object visit(Method method, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Method", method, false);

		print(indent + 1, "name", "String", method.getName());
		visit(indent + 1, "parameter", "List<Parameter>", method.getParameter());
		visit(indent + 1, "retorno", "Type", method.getRetorno());
		visit(indent + 1, "definition", "List<Definition>", method.getDefinition());
		visit(indent + 1, "sentence", "List<Sentence>", method.getSentence());
		return null;
	}

	//	class Parameter { String name;  Type type; }
	public Object visit(Parameter parameter, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Parameter", parameter, false);

		print(indent + 1, "name", "String", parameter.getName());
		visit(indent + 1, "type", "Type", parameter.getType());
		return null;
	}

	//	class Print { String string;  List<Expr> expr; }
	public Object visit(Print print, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Print", print, false);

		print(indent + 1, "string", "String", print.getString());
		visit(indent + 1, "expr", "List<Expr>", print.getExpr());
		return null;
	}

	//	class Read { List<Expr> expr; }
	public Object visit(Read read, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Read", read, false);

		visit(indent + 1, "expr", "List<Expr>", read.getExpr());
		return null;
	}

	//	class Assignment { Expr left;  Expr right; }
	public Object visit(Assignment assignment, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Assignment", assignment, false);

		visit(indent + 1, "left", "Expr", assignment.getLeft());
		visit(indent + 1, "right", "Expr", assignment.getRight());
		return null;
	}

	//	class MultipleAssignment { List<Expr> expr;  Expr valor; }
	public Object visit(MultipleAssignment multipleAssignment, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "MultipleAssignment", multipleAssignment, false);

		visit(indent + 1, "expr", "List<Expr>", multipleAssignment.getExpr());
		visit(indent + 1, "valor", "Expr", multipleAssignment.getValor());
		return null;
	}

	//	class Conditional { Expr condition;  List<Sentence> iftrue;  List<Sentence> iffalse; }
	public Object visit(Conditional conditional, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Conditional", conditional, false);

		visit(indent + 1, "condition", "Expr", conditional.getCondition());
		visit(indent + 1, "iftrue", "List<Sentence>", conditional.getIftrue());
		visit(indent + 1, "iffalse", "List<Sentence>", conditional.getIffalse());
		return null;
	}

	//	class Loop { List<Sentence> init;  Expr condition;  List<Sentence> sentence; }
	public Object visit(Loop loop, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Loop", loop, false);

		visit(indent + 1, "init", "List<Sentence>", loop.getInit());
		visit(indent + 1, "condition", "Expr", loop.getCondition());
		visit(indent + 1, "sentence", "List<Sentence>", loop.getSentence());
		return null;
	}

	//	class ReturnNode { Expr expr; }
	public Object visit(ReturnNode returnNode, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ReturnNode", returnNode, false);

		visit(indent + 1, "expr", "Expr", returnNode.getExpr());
		return null;
	}

	//	class MethodCallSentence { String name;  List<Expr> args; }
	public Object visit(MethodCallSentence methodCallSentence, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "MethodCallSentence", methodCallSentence, false);

		print(indent + 1, "name", "String", methodCallSentence.getName());
		visit(indent + 1, "args", "List<Expr>", methodCallSentence.getArgs());
		return null;
	}

	//	class ExprBinariaAritmetica { Expr left;  String op;  Expr right; }
	public Object visit(ExprBinariaAritmetica exprBinariaAritmetica, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExprBinariaAritmetica", exprBinariaAritmetica, false);

		visit(indent + 1, "left", "Expr", exprBinariaAritmetica.getLeft());
		print(indent + 1, "op", "String", exprBinariaAritmetica.getOp());
		visit(indent + 1, "right", "Expr", exprBinariaAritmetica.getRight());
		return null;
	}

	//	class ExprUnariaAritmetica { String op;  Expr expr; }
	public Object visit(ExprUnariaAritmetica exprUnariaAritmetica, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExprUnariaAritmetica", exprUnariaAritmetica, false);

		print(indent + 1, "op", "String", exprUnariaAritmetica.getOp());
		visit(indent + 1, "expr", "Expr", exprUnariaAritmetica.getExpr());
		return null;
	}

	//	class ExprBinariaLogica { Expr left;  String op;  Expr right; }
	public Object visit(ExprBinariaLogica exprBinariaLogica, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExprBinariaLogica", exprBinariaLogica, false);

		visit(indent + 1, "left", "Expr", exprBinariaLogica.getLeft());
		print(indent + 1, "op", "String", exprBinariaLogica.getOp());
		visit(indent + 1, "right", "Expr", exprBinariaLogica.getRight());
		return null;
	}

	//	class ExprUnariaLogica { String op;  Expr expr; }
	public Object visit(ExprUnariaLogica exprUnariaLogica, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ExprUnariaLogica", exprUnariaLogica, false);

		print(indent + 1, "op", "String", exprUnariaLogica.getOp());
		visit(indent + 1, "expr", "Expr", exprUnariaLogica.getExpr());
		return null;
	}

	//	class Acces { Expr left;  String op;  String right; }
	public Object visit(Acces acces, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Acces", acces, false);

		visit(indent + 1, "left", "Expr", acces.getLeft());
		print(indent + 1, "op", "String", acces.getOp());
		print(indent + 1, "right", "String", acces.getRight());
		return null;
	}

	//	class ArrayAcces { Expr left;  Expr right; }
	public Object visit(ArrayAcces arrayAcces, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ArrayAcces", arrayAcces, false);

		visit(indent + 1, "left", "Expr", arrayAcces.getLeft());
		visit(indent + 1, "right", "Expr", arrayAcces.getRight());
		return null;
	}

	//	class Cast { Type typeToConvert;  Expr expr; }
	public Object visit(Cast cast, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "Cast", cast, false);

		visit(indent + 1, "typeToConvert", "Type", cast.getTypeToConvert());
		visit(indent + 1, "expr", "Expr", cast.getExpr());
		return null;
	}

	//	class LitEnt { String string; }
	public Object visit(LitEnt litEnt, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "LitEnt", litEnt, "string", litEnt.getString());
		return null;
	}

	//	class LitReal { String string; }
	public Object visit(LitReal litReal, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "LitReal", litReal, "string", litReal.getString());
		return null;
	}

	//	class LitChar { String string; }
	public Object visit(LitChar litChar, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "LitChar", litChar, "string", litChar.getString());
		return null;
	}

	//	class Variable { String string; }
	public Object visit(Variable variable, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "Variable", variable, "string", variable.getString());
		return null;
	}

	//	class MethodCallExpr { String name;  List<Expr> args; }
	public Object visit(MethodCallExpr methodCallExpr, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "MethodCallExpr", methodCallExpr, false);

		print(indent + 1, "name", "String", methodCallExpr.getName());
		visit(indent + 1, "args", "List<Expr>", methodCallExpr.getArgs());
		return null;
	}

	//	class IntType {  }
	public Object visit(IntType intType, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "IntType", intType, true);

		return null;
	}

	//	class RealType {  }
	public Object visit(RealType realType, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "RealType", realType, true);

		return null;
	}

	//	class CharType {  }
	public Object visit(CharType charType, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "CharType", charType, true);

		return null;
	}

	//	class ArrayType { int index;  Type type; }
	public Object visit(ArrayType arrayType, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "ArrayType", arrayType, false);

		print(indent + 1, "index", "int", arrayType.getIndex());
		visit(indent + 1, "type", "Type", arrayType.getType());
		return null;
	}

	//	class VoidType {  }
	public Object visit(VoidType voidType, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "VoidType", voidType, true);

		return null;
	}

	//	class StructType { String name; }
	public Object visit(StructType structType, Object param) {
		int indent = ((Integer)param).intValue();

		printCompact(indent, "StructType", structType, "name", structType.getName());
		return null;
	}

	//	class TupleDefinition { String name;  List<VarDefinition> vardefinition; }
	public Object visit(TupleDefinition tupleDefinition, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "TupleDefinition", tupleDefinition, false);

		print(indent + 1, "name", "String", tupleDefinition.getName());
		visit(indent + 1, "vardefinition", "List<VarDefinition>", tupleDefinition.getVardefinition());
		return null;
	}

	//	class VarDefinition { List<String> name;  Type type; }
	public Object visit(VarDefinition varDefinition, Object param) {
		int indent = ((Integer)param).intValue();

		printName(indent, "VarDefinition", varDefinition, false);

		print(indent + 1, "name", "List<String>", varDefinition.getName());
		visit(indent + 1, "type", "Type", varDefinition.getType());
		return null;
	}


	// -----------------------------------------------------------------
	// Métodos invocados desde los métodos visit -----------------------

	private void printName(int indent, String name, AST node, boolean empty) {
		String text = ls + tabula(indent) + name + " &rarr;  ";
		text = String.format("%1$-" + 93 + "s", text);
		if (empty)
			text = text.replace(name, valueTag(name));
		writer.print(text + getPosition(node));
	}

	private void print(int indent, String name, String type, Object value) {
		write(indent, formatValue(value) + "  " + typeTag(type));
	}

	private void print(int indent, String attName, String type, List<? extends Object> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (Object child : children)
				write(indent + 1, formatValue(child));
		else
			writer.print(" " + valueTag(null));
	}

	// Versión compacta de una linea para nodos que solo tienen un atributo String
	private void printCompact(int indent, String nodeName, AST node, String attName, Object value) {
		String fullName = nodeName + '.' + attName;
		String text = ls + tabula(indent) + '\"' + value + "\"  " + fullName;
		text = String.format("%1$-" + 88 + "s", text);
		// text = text.replace(value.toString(), valueTag(value));
		text = text.replace(fullName, typeTag(fullName));
		writer.print(text + getPosition(node));
	}

	private void visit(int indent, String attName, String type, List<? extends AST> children) {
		write(indent, attName + "  " + typeTag(type) + " = ");
		if (children != null)
			for (AST child : children)
				child.accept(this, indent + 1);
		else
			writer.print(" " + valueTag(null));
	}

	private void visit(int indent, String attName, String type, AST child) {
		if (child != null)
			child.accept(this, Integer.valueOf(indent));
		else
			write(indent, valueTag(null) + "  " + attName + ':' + typeTag(type));
	}

	// -----------------------------------------------------------------
	// Métodos auxiliares privados -------------------------------------

	private void write(int indent, String text) {
		writer.print(ls + tabula(indent) + text);
	}

	private static String tabula(int count) {
		StringBuffer cadena = new StringBuffer("<span class=\"dots\">");
		for (int i = 0; i < count; i++)
			cadena.append(i % 2 == 0 && i > 0 ? "|  " : ".  ");
		return cadena.toString() + "</span>";
	}

	private String typeTag(String type) {
		if (type.equals("String"))
			return "";
		return "<span class=\"type\">" + type.replace("<", "&lt;").replace(">", "&gt;") + "</span>";
	}

	private String valueTag(Object value) {
		if (value == null)
			return "<span class=\"null\">null</span>";
		return "<span class=\"value\">" + value + "</span>";
	}

	private String formatValue(Object value) {
		String text = valueTag(value);
		if (value instanceof String)
			text = "\"" + text + '"';
		return text;
	}


	// -----------------------------------------------------------------
	// Métodos para mostrar las Posiciones -----------------------------

	private String getPosition(AST node) {
		String text = node.getStart() + "  " + node.getEnd();
		text = "<span class=\"pos\">" + String.format("%1$-" + 13 + "s", text) + "</span>";
		text = text.replace("null", "<span class=\"null\">null</span>");
		String sourceText = findSourceText(node);
		if (sourceText != null)
			text += sourceText;
		return text;
	}

	private String findSourceText(AST node) {
		if (sourceLines == null)
			return null;

		Position start = node.getStart();
		Position end = node.getEnd();
		if (start == null || end == null)
			return null;

		String afterText, text, beforeText;
		if (start.getLine() == end.getLine()) {
			String line = sourceLines.get(start.getLine() - 1);
			afterText = line.substring(0, start.getColumn() - 1);
			text = line.substring(start.getColumn() - 1, end.getColumn());
			beforeText = line.substring(end.getColumn());
		} else {
			String firstLine = sourceLines.get(start.getLine() - 1);
			String lastLine = sourceLines.get(end.getLine() - 1);

			afterText = firstLine.substring(0, start.getColumn() - 1);

			text = firstLine.substring(start.getColumn() - 1);
			text += "</span><span class=\"sourceText\">" + " ... " + "</span><span class=\"posText\">";
			text += lastLine.substring(0, end.getColumn()).replaceAll("^\\s+", "");

			beforeText = lastLine.substring(end.getColumn());
		}
		return "<span class=\"sourceText\">" + afterText.replaceAll("^\\s+", "")
				+ "</span><span class=\"posText\">" + text
				+ "</span><span class=\"sourceText\">" + beforeText + "</span>";
	}

	private static List<String> loadLines(String sourceFile, int tabWidth) {
		if (sourceFile == null)
			return null;
		try {
			String spaces = new String(new char[tabWidth]).replace("\0", " ");

			List<String> lines = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			String line;
			while ((line = br.readLine()) != null) {
			//	lines.add(line.replace("\t", spaces)); // Si tab = 4 espaces (Eclipse)
				lines.add(line);
            }
			br.close();
			return lines;
		} catch (FileNotFoundException e) {
			System.out.println("Warning. No se pudo encontrar el fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		} catch (IOException e) {
			System.out.println("Warning. Error al leer del fichero fuente '" + sourceFile + "'. No se mostrará informaicón de posición.");
			return null;
		}
	}


	private List<String> sourceLines;
	private static String ls = System.getProperty("line.separator");
	private PrintWriter writer;
}
