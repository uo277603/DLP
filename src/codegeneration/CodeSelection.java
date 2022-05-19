/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;
import java.util.logging.MemoryHandler;

import org.antlr.v4.parse.ANTLRParser.ruleEntry_return;

import ast.*;
import semantic.Ambito;
import visitor.*;

public class CodeSelection extends DefaultVisitor {

    public enum Funcion {
        VALOR, DIRECCION
    }

    private int count = 0;

    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;
    }

    // class Program { ClassNode classnode; MethodCallSentence methodcallsentence; }
    public Object visit(Program program, Object param) {

        if (program.getMethodcallsentence() != null)
            program.getMethodcallsentence().accept(this, param);
        out("halt");
        if (program.getClassnode() != null)
            program.getClassnode().accept(this, param);

        return null;
    }

    // class ClassNode { String name; List<Definition> definition; List<String>
    // createMethod; List<Method> method; }
    public Object visit(ClassNode classNode, Object param) {

        // super.visit(node, param);

        if (classNode.getDefinition() != null)
            for (Definition child : classNode.getDefinition())
                child.accept(this, param);

        if (classNode.getMethod() != null)
            for (Method child : classNode.getMethod())
                child.accept(this, param);

        return null;
    }

    // class Method { String name; List<Parameter> parameter; Type retorno;
    // List<Definition> definition; List<Sentence> sentence; }
    public Object visit(Method method, Object param) {

        out(method.getName() + ":");
        int localsSize = 0;
        for (Definition v : method.getDefinition()) {
            localsSize += v.getType().getSize();
        }
        out("enter " + localsSize);

        if (method.getSentence() != null)
            for (Sentence child : method.getSentence())
                child.accept(this, param);

        if (method.getRetorno().getClass() == VoidType.class) {
            int parameterSize = method.getDefinition().stream().map(a -> a.getType().getSize())
                    .reduce(0, (x, y) -> x + y);
            out("ret 0, " + localsSize + ", " + parameterSize);
        }

        return null;
    }

    // class Print { String string; List<Expr> expr; }
    public Object visit(Print print, Object param) {

        // super.visit(node, param);

        if (print.getExpr() != null)
            for (Expr child : print.getExpr()) {
                child.accept(this, Funcion.VALOR);
                out("out" + child.getType().getSuffix());
            }

        return null;
    }

    // class Read { List<Expr> expr; }
    public Object visit(Read read, Object param) {

        // super.visit(node, param);

        if (read.getExpr() != null)
            for (Expr child : read.getExpr()) {
                child.accept(this, Funcion.DIRECCION);
                out("in" + child.getType().getSuffix());
                out("store" + child.getType().getSuffix());
            }

        return null;
    }

    // class Assignment { Expr left; Expr right; }
    public Object visit(Assignment assignment, Object param) {

        // super.visit(node, param);

        if (assignment.getLeft() != null)
            assignment.getLeft().accept(this, Funcion.DIRECCION);

        if (assignment.getRight() != null)
            assignment.getRight().accept(this, Funcion.VALOR);
        out("store" + assignment.getLeft().getType().getSuffix());

        return null;
    }

    // class Conditional { Expr condition; List<Sentence> iftrue; List<Sentence>
    // iffalse; }
    public Object visit(Conditional conditional, Object param) {

        int n = count++;

        if (conditional.getCondition() != null)
            conditional.getCondition().accept(this, Funcion.VALOR);
        out("jz else" + n);

        if (conditional.getIftrue() != null)
            for (Sentence child : conditional.getIftrue())
                child.accept(this, param);
        out("jmp finalIf" + n);
        out("else" + n + ":");
        if (conditional.getIffalse() != null)
            for (Sentence child : conditional.getIffalse())
                child.accept(this, param);
        out("finIf" + n + ":");

        return null;
    }

    // class Loop { List<Sentence> init; Expr condition; List<Sentence> sentence; }
    public Object visit(Loop loop, Object param) {

        int n = count++;

        if (loop.getInit() != null)
            for (Sentence child : loop.getInit())
                child.accept(this, param);
        out("inicioLoop" + n + ":");
        if (loop.getCondition() != null)
            loop.getCondition().accept(this, Funcion.VALOR);
        out("jnz finLoop" + n);
        if (loop.getSentence() != null)
            for (Sentence child : loop.getSentence())
                child.accept(this, param);
        out("jmp inicioLoop" + n);
        out("finLoop" + n + ":");

        return null;
    }

    // class ReturnNode { Expr expr; }
    public Object visit(ReturnNode returnNode, Object param) {

        // super.visit(node, param);

        if (returnNode.getExpr() != null) {
            int localSize = returnNode.getMethod().getDefinition().stream().map(a -> a.getType().getSize())
                    .reduce(0, (x, y) -> x + y);
            int paramSize = returnNode.getMethod().getParameter().stream()
                    .map(a -> a.getDefinition().getType().getSize())
                    .reduce(0, (x, y) -> x + y);
            out("ret " + returnNode.getExpr().getType().getSize() + ", " + localSize + ", " + paramSize);
        }

        return null;
    }

    // class MethodCallSentence { String name; List<Expr> args; }
    public Object visit(MethodCallSentence methodCallSentence, Object param) {

        out("call " + methodCallSentence.getName());
        if (methodCallSentence.getDefinition().getRetorno().getClass() != VoidType.class) {
            out("pop" + methodCallSentence.getDefinition().getRetorno().getSuffix());
        }
       
        return null;
    }

    // class ExprBinariaAritmetica { Expr left; String op; Expr right; }
    public Object visit(ExprBinariaAritmetica exprBinariaAritmetica, Object param) {

        if (exprBinariaAritmetica.getLeft() != null)
            exprBinariaAritmetica.getLeft().accept(this, Funcion.VALOR);

        if (exprBinariaAritmetica.getRight() != null)
            exprBinariaAritmetica.getRight().accept(this, Funcion.VALOR);

        switch (exprBinariaAritmetica.getOp()) {
            case "+":
                out("add" + exprBinariaAritmetica.getLeft().getType().getSuffix());
                break;
            case "-":
                out("sub" + exprBinariaAritmetica.getLeft().getType().getSuffix());
                break;
            case "*":
                out("mul" + exprBinariaAritmetica.getLeft().getType().getSuffix());
                break;
            case "/":
                out("div" + exprBinariaAritmetica.getLeft().getType().getSuffix());
                break;
            default:
                break;
        }

        return null;
    }

    // class ExprUnariaAritmetica { String op; Expr expr; }
    public Object visit(ExprUnariaAritmetica exprUnariaAritmetica, Object param) {

        if (exprUnariaAritmetica.getOp().equals("-")) {
            exprUnariaAritmetica.getExpr().accept(this, Funcion.VALOR);
            out("push" + exprUnariaAritmetica.getExpr().getType().getSuffix() + " -1");
            out("mul" + exprUnariaAritmetica.getExpr().getType().getSuffix());
        }

        return null;
    }

    // class ExprBinariaLogica { Expr left; String op; Expr right; }
    public Object visit(ExprBinariaLogica exprBinariaLogica, Object param) {

        if (exprBinariaLogica.getLeft() != null)
            exprBinariaLogica.getLeft().accept(this, Funcion.VALOR);

        if (exprBinariaLogica.getRight() != null)
            exprBinariaLogica.getRight().accept(this, Funcion.VALOR);

        switch (exprBinariaLogica.getOp()) {
            case ">":
                out("gt" + exprBinariaLogica.getLeft().getType().getSuffix());
                break;
            case "<":
                out("lt" + exprBinariaLogica.getLeft().getType().getSuffix());
                break;
            case ">=":
                out("ge" + exprBinariaLogica.getLeft().getType().getSuffix());
                break;
            case "<=":
                out("le" + exprBinariaLogica.getLeft().getType().getSuffix());
                break;
            case "and":
                out("and");
                break;
            case "or":
                out("or");
                break;
            default:
                break;
        }

        return null;
    }

    // class ExprUnariaLogica { String op; Expr expr; }
    public Object visit(ExprUnariaLogica exprUnariaLogica, Object param) {

        if (exprUnariaLogica.getOp().equals("not")) {
            exprUnariaLogica.getExpr().accept(this, Funcion.VALOR);
            out("not");
        }

        return null;
    }

    // class Acces { Expr left; String op; String right; }
    public Object visit(Acces acces, Object param) {
        acces.getLeft().accept(this, Funcion.DIRECCION);
        StructType tipo = (StructType) acces.getLeft().getType();
        VarDefinition definition = null;
        for (VarDefinition d : tipo.getDefinition().getVardefinition()) 
            for (String n : d.getName()) 
                if (n.equals(acces.getRight())) 
                    definition = d;    
        out("push" + acces.getLeft().getType().getSuffix() + " " + definition.getAddress());
        if (param.equals(Funcion.VALOR)) {     
            out("add");
            out("load" + definition.getType().getSuffix());
        }else if(param.equals(Funcion.DIRECCION)){
            out("add");
        }

        return null;
    }

    // class ArrayAcces { Expr left; Expr right; }
    public Object visit(ArrayAcces arrayAcces, Object param) {
        ArrayType tipo = (ArrayType) arrayAcces.getLeft().getType();

        if (param.equals(Funcion.VALOR)) {
            arrayAcces.getLeft().accept(this, Funcion.DIRECCION);
            arrayAcces.getRight().accept(this, Funcion.VALOR);

            out("push " + tipo.getType().getSize());
            out("mul");
            out("add");
            out("load" + tipo.getType().getSuffix());
        } else if (param.equals(Funcion.DIRECCION)) {
            arrayAcces.getLeft().accept(this, Funcion.DIRECCION);
            out("push " + tipo.getSize());
            arrayAcces.getRight().accept(this, Funcion.VALOR);
            out("mul");
            out("add");
        }

        return null;
    }

    // class Cast { Type typeToConvert; Expr expr; }
    public Object visit(Cast cast, Object param) {

        if (cast.getExpr() != null)
            cast.getExpr().accept(this, Funcion.VALOR);

        if (cast.getTypeToConvert().equals(IntType.class) && cast.getExpr().getType().equals(CharType.class))
            out("b2i");
        else if (cast.getTypeToConvert().equals(IntType.class) && cast.getExpr().getType().equals(RealType.class))
            out("f2i");
        else if (cast.getTypeToConvert().equals(CharType.class) && cast.getExpr().getType().equals(IntType.class))
            out("i2b");
        else if (cast.getTypeToConvert().equals(RealType.class) && cast.getExpr().getType().equals(IntType.class))
            out("i2f");

        return null;
    }

    // class LitEnt { String string; }
    public Object visit(LitEnt litEnt, Object param) {
        out("push " + litEnt.getString());
        return null;
    }

    // class LitReal { String string; }
    public Object visit(LitReal litReal, Object param) {
        out("pushf " + litReal.getString());
        return null;
    }

    // class LitChar { String string; }
    public Object visit(LitChar litChar, Object param) {
        out("pushb " + (int) litChar.getString().charAt(1));
        return null;
    }

    // class Variable { String string; }
    public Object visit(Variable variable, Object param) {
        if (param.equals(Funcion.VALOR)) {
            variable.accept(this, Funcion.DIRECCION);
            out("load" + variable.getType().getSuffix());
        } else if (param.equals(Funcion.DIRECCION)) {
            if (variable.getDefinition().getAmbito() != Ambito.GLOBAL) {
                out("pusha bp");
                out("push " + variable.getDefinition().getAddress());
                out("add");
            } else {
                out("pusha " + variable.getDefinition().getAddress());
            }
        }

        return null;
    }

    // class MethodCallExpr { String name; List<Expr> args; }
    public Object visit(MethodCallExpr methodCallExpr, Object param) {

        if (methodCallExpr.getArgs() != null)
            for (Expr child : methodCallExpr.getArgs())
                child.accept(this, Funcion.VALOR);
        out("call " + methodCallExpr.getName());

        return null;
    }

    /*
     * // class TupleDefinition { String name; List<VarDefinition> vardefinition; }
     * public Object visit(TupleDefinition tupleDefinition, Object param) {
     * 
     * // super.visit(node, param);
     * 
     * if (tupleDefinition.getVardefinition() != null)
     * for (VarDefinition child : tupleDefinition.getVardefinition())
     * child.accept(this, param);
     * 
     * return null;
     * }
     * 
     * // class VarDefinition { List<String> name; Type type; }
     * public Object visit(VarDefinition varDefinition, Object param) {
     * 
     * // super.visit(node, param);
     * 
     * if (varDefinition.getType() != null)
     * varDefinition.getType().accept(this, param);
     * 
     * return null;
     * }
     */

    // Métodos auxiliares recomendados (opcionales) -------------

    // Imprime una línea en el fichero de salida
    private void out(String instruction) {
        writer.println(instruction);
    }

    private void line(AST node) {
        line(node.getEnd());
    }

    private void line(Position pos) {
        if (pos != null)
            out("\n#line " + pos.getLine());
        else
            System.out.println("#line no generado. Se ha pasado una Position null. Falta información en el AST");
    }

    private PrintWriter writer;
    private String sourceFile;
}
