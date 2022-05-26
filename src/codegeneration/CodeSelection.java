/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package codegeneration;

import java.io.*;
import java.util.*;
import java.util.logging.MemoryHandler;
import java.util.spi.ToolProvider;

import org.antlr.v4.parse.ANTLRParser.ruleEntry_return;

import ast.*;
import semantic.Ambito;
import visitor.*;

public class CodeSelection extends DefaultVisitor {

    public enum Funcion {
        VALOR, DIRECCION
    }

    private int count = 0;

    private Map<String, String> instrucciones = new HashMap<String, String>();

    public CodeSelection(Writer writer, String sourceFile) {
        this.writer = new PrintWriter(writer);
        this.sourceFile = sourceFile;
        instrucciones.put("+", "add");
		instrucciones.put("-", "sub");
		instrucciones.put("*", "mul");
		instrucciones.put("/", "div");
		instrucciones.put("and", "and");
		instrucciones.put("or", "or");
		instrucciones.put("<", "lt");
		instrucciones.put(">", "gt");
		instrucciones.put("=", "eq");
		instrucciones.put("<>", "ne");
		instrucciones.put(">=", "ge");
		instrucciones.put("<=", "le");
    }

    // class Program { ClassNode classnode; MethodCallSentence methodcallsentence; }
    /*
    * run [[ Program → classnode:classNode methodcallsentence:methodCallSentence]] =
    *   #SOURCE {sourceFile}
    *   crea[[classnode]]
    *   ejecuta[[methodcallsentence]]
    */
    public Object visit(Program program, Object param) {
        out("#source \"" + sourceFile + "\"");
        if (program.getMethodcallsentence() != null)
            program.getMethodcallsentence().accept(this, param);
        out("halt");
        if (program.getClassnode() != null)
            program.getClassnode().accept(this, param);

        return null;
    }

    // class ClassNode { String name; List<Definition> definition; List<String>
    // createMethod; List<Method> method; }
    /*
    * run [[ ClassNode → name:String definition:definition* createMethod:String* method:method* ]] =
    *   define[[definitioni]]
    *   declara[[method]]
    */
    public Object visit(ClassNode classNode, Object param) {

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
    /*
    * Run [[ Method → name:String parameter:parameter* retorno:type definition:definition* sentence:sentence* ]] =
    *   #LINE {start.line}
    *   {name}:
    *   #FUNC {name}
    *   #RET {retorno.name}
    *   #PARAM parameteri
    *   #LOCAL definitioni
    *   ENTER { Σ definitioni.type.size }
    *   ejecuta[[sentencei]]
    *   si retorno == VoidType
    *   RET 0, {Σ definitioni.type.size}, {Σ parameteri.definition.type.size}
    */
    public Object visit(Method method, Object param) {
        line(method.getStart());
        out(method.getName() + ":");
        out("#func " + method.getName());
        out("#ret " + method.getRetorno().getName());
        for(Parameter p: method.getParameter()){
            out("#param " + p.getName() + ":" + p.getType().getName());
        }
        int localsSize = 0;
        for (Definition v : method.getDefinition()) {
            //localsSize += v.getType().getSize();
            VarDefinition vars = (VarDefinition) v;
            localsSize += vars.getType().getSize() * vars.getName().size();
            for (String s : vars.getName()) {
                out("#local " + s + ":" + vars.getType().getName());
            }
        }
        out("enter " + localsSize);

        if (method.getSentence() != null)
            for (Sentence child : method.getSentence())
                child.accept(this, param);

        if (method.getRetorno().getClass() == VoidType.class) {
            int parameterSize = method.getParameter().stream().map(a -> a.getType().getSize())
                    .reduce(0, (x, y) -> x + y);
            out("ret 0, " + localsSize + ", " + parameterSize);
        }

        return null;
    }

    // class Print { String string; List<Expr> expr; }
    /*
    * ejecuta [[ Print → string:String expr:expr*]] = 
    *   #LINE {end.line}
    *   para cada exp en expr
    *   valor[[exp]]
    *   OUT<exp.tipo>
    *   Si string == println
    *   PUSHB 10
    *   OUTB
    */
    public Object visit(Print print, Object param) {

        line(print);
        if (print.getExpr() != null)
            for (Expr child : print.getExpr()) {
                child.accept(this, Funcion.VALOR);
                out("out" + child.getType().getSuffix());
            }
        if (print.getString().equalsIgnoreCase("println")) {
            out("pushb 10");
            out("outb");
        }

        return null;
    }

    // class Read { List<Expr> expr; }
    /*
    * ejecuta [[ Read → expr:expr* ]] = 
    *   #LINE {end.line}
    *   para cada exp en expr
    *   dirección[[exp]]
    *   IN<exp.type>
    *   STORE<exp.type>
    */
    public Object visit(Read read, Object param) {

        line(read);

        if (read.getExpr() != null)
            for (Expr child : read.getExpr()) {
                child.accept(this, Funcion.DIRECCION);
                out("in" + child.getType().getSuffix());
                out("store" + child.getType().getSuffix());
            }

        return null;
    }

    // class Assignment { Expr left; Expr right; }
    /*
    * ejecuta[[Assignment → left:expr right:expr]] = 
    *   #LINE {end.line}
    *   direccion[[left]]
    *   valor[[right]]
    *   STORE<left.type>
    */
    public Object visit(Assignment assignment, Object param) {

        line(assignment.getStart());

        if (assignment.getLeft() != null)
            assignment.getLeft().accept(this, Funcion.DIRECCION);

        if (assignment.getRight() != null)
            assignment.getRight().accept(this, Funcion.VALOR);
        out("store" + assignment.getLeft().getType().getSuffix());

        return null;
    }

    // class Conditional { Expr condition; List<Sentence> iftrue; List<Sentence>
    // iffalse; }
    /*
    * ejecuta[[Conditional → condition:expr iftrue:sentence* iffalse:sentence*]] =
    *   #LINE {end.line}
    *   valor[[condition]]
    *   jz else{n}
    *   ejecuta[[iftruei]]
    *   jmp finIf{n}
    *   else{n}:
    *   ejecuta[[iffalsei]]
    *   finif{n}:
    */
    public Object visit(Conditional conditional, Object param) {

        line(conditional);

        int n = count++;

        if (conditional.getCondition() != null)
            conditional.getCondition().accept(this, Funcion.VALOR);
        out("jz else" + n);

        if (conditional.getIftrue() != null)
            for (Sentence child : conditional.getIftrue())
                child.accept(this, param);
        out("jmp finIf" + n);
        out("else" + n + ":");
        if (conditional.getIffalse() != null)
            for (Sentence child : conditional.getIffalse())
                child.accept(this, param);
        out("finIf" + n + ":");

        return null;
    }

    // class Loop { List<Sentence> init; Expr condition; List<Sentence> sentence; }
    /*
    * Ejecuta[[Loop → init:sentence* condition:expr sentence:sentence*]] = 
    *   #LINE {end.line}
    *    Ejecuta[[initi]]
    *   inicioLoop{n}:
    *   valor[[condition]]
    *   jnz finLoop{n}
    *   ejecuta[[sentencei]]
    *   jmp inicioLoop{n}
    *   finLoop{n}:
    */
    public Object visit(Loop loop, Object param) {

        line(loop);
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
    /*
    * Ejecuta[[ReturnNode → expr:expr ]] =
    *   #LINE {end.line}
    *   Si expr != null
    *       Valor[[expr]]
    *       RET {expr.type.size}, { Σ expr.method.definition.type.size},
    *       { Σ expr.method.parameter.definition.type.size}
    */
    public Object visit(ReturnNode returnNode, Object param) {

        line(returnNode);

        if (returnNode.getExpr() != null) {
            returnNode.getExpr().accept(this, Funcion.VALOR);
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
    /*
    * Ejecuta[[MethodCallSentence → name:String args:expr*]] = 
    *   Valor[[argsi]]
    *   CALL {name}
    *   Si methodCallSentence.definition.type != VoidType
    *       POP<methodCallSentence.method.retorno>
    */
    public Object visit(MethodCallSentence methodCallSentence, Object param) {
        if (methodCallSentence.getArgs() != null)
            for (Expr child : methodCallSentence.getArgs())
                child.accept(this, Funcion.VALOR);
        out("call " + methodCallSentence.getName());
        if (methodCallSentence.getDefinition().getRetorno().getClass() != VoidType.class) {
            out("pop" + methodCallSentence.getDefinition().getRetorno().getSuffix());
        }

        return null;
    }

    // class ExprBinariaAritmetica { Expr left; String op; Expr right; }
    /*
    * Valor[[ExprBinariaAritmetica → left:expr op:String right:expr]] =
    *   #LINE {exprBinariaAritmetica}
    *   Valor[[left]]
    *   Valor[[right]]
    *   Si op ==’+’ 
    *       ADD<left.type>
    *   Sino si op ==’-’
    *       SUB<left.type>
    *   Sino si op ==’*’ 
    *       MUL<left.type>
    *   Sino si op ==’/’ 
    *       DIV<left.type>
    */
    public Object visit(ExprBinariaAritmetica exprBinariaAritmetica, Object param) {
        line(exprBinariaAritmetica);
        if (exprBinariaAritmetica.getLeft() != null)
            exprBinariaAritmetica.getLeft().accept(this, Funcion.VALOR);

        if (exprBinariaAritmetica.getRight() != null)
            exprBinariaAritmetica.getRight().accept(this, Funcion.VALOR);

        out(instrucciones.get(exprBinariaAritmetica.getOp()) + exprBinariaAritmetica.getLeft().getType().getSuffix());
        return null;
    }

    // class ExprUnariaAritmetica { String op; Expr expr; }
    /*
    * Valor[[ExprUnariaAritmetica → op:String expr:expr]]=
    *   #LINE {exprUnariaAritmetica}
    *   Si op == ‘-‘
    *       Valor[[expr]]
    *       PUSH<expr.type> -1
    *       MUL<expr.type>
    */
    public Object visit(ExprUnariaAritmetica exprUnariaAritmetica, Object param) {
        line(exprUnariaAritmetica);
        if (exprUnariaAritmetica.getOp().equals("-")) {
            exprUnariaAritmetica.getExpr().accept(this, Funcion.VALOR);
            out("push" + exprUnariaAritmetica.getExpr().getType().getSuffix() + " -1");
            out("mul" + exprUnariaAritmetica.getExpr().getType().getSuffix());
        }

        return null;
    }

    // class ExprBinariaLogica { Expr left; String op; Expr right; }
    /*
    * Valor[[ExprBinariaLogica → left:expr op:String right:expr ]=
    *   #LINE {exprBinariaLogica}
    *   Si left.type == CharType
	*	    B2I
	*   Valor[[right]]
	*   Si right.type == CharType
	*	    B2I
    *   Si op == ’>’ 
    *       GT<left.type>
    *   Sino si op == ’<’
    *       LT<left.type>
    *   Sino si op == ’>=’ 
    *       GE<left.type>
    *   Sino si op == ’<=’ 
    *       LE<left.type>
    *   Sino si op == ’and’ 
    *       AND
    *   Sino si op == ’or’ 
    *       OR
    */
    public Object visit(ExprBinariaLogica exprBinariaLogica, Object param) {
        line(exprBinariaLogica);
        String suffix = exprBinariaLogica.getLeft().getType().getSuffix();
        if (exprBinariaLogica.getLeft() != null){
            exprBinariaLogica.getLeft().accept(this, Funcion.VALOR);
            if(exprBinariaLogica.getLeft().getType().getClass() == CharType.class){
                out("b2i");
                suffix = "i";
            }
        }

        if (exprBinariaLogica.getRight() != null){
            exprBinariaLogica.getRight().accept(this, Funcion.VALOR);
            if(exprBinariaLogica.getRight().getType().getClass() == CharType.class)
                out("b2i");
        }
        
        if(exprBinariaLogica.getOp().equals("and") || exprBinariaLogica.getOp().equals("or"))
            out(instrucciones.get(exprBinariaLogica.getOp()));
        else if(exprBinariaLogica.getType().getClass() != CharType.class){
            out(instrucciones.get(exprBinariaLogica.getOp()) + suffix);
        }

        return null;
    }

    // class ExprUnariaLogica { String op; Expr expr; }
    /*
    * Valor[[ExprUnariaLogica → op:String expr:expr]]=
    *   #LINE {exprUnariaLogica}
    *   Si op == ‘not’
    *       Valor[[expr]]
    *       NOT
    */
    public Object visit(ExprUnariaLogica exprUnariaLogica, Object param) {
        line(exprUnariaLogica);
        
        if (exprUnariaLogica.getOp().equals("not")) {
            exprUnariaLogica.getExpr().accept(this, Funcion.VALOR);
            out("not");
        }

        return null;
    }

    // class Acces { Expr left; String op; String right; }
    /*
    * valor[[Access → left:expr op:String right:String]]=
    *   #LINE {access}
    *   direccion[[left]]
    *   PUSH {left.type.definition.vardefinition[string].address}
    *   ADD
    *   LOAD<left.type.definition.vardefinition[string].type}
    *
    * direccion[[Access → left:expr op:String right:String]]=
    *   dirección[[left]]
    *   PUSHA {left.type.definition.vardefinition[string].address}
    *   ADD
    */
    public Object visit(Acces acces, Object param) {
        line(acces);
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
        } else if (param.equals(Funcion.DIRECCION)) {
            out("add");
        }

        return null;
    }

    // class ArrayAcces { Expr left; Expr right; }
    /*
    * valor[[ArrayAccess → left:expr right:expr ]]=
    *   #LINE {arrayAccess}
    *   direccion[[left]]
    *   valor[[right]]
    *   PUSH {left.type.type.size}
    *
    * direccion[[ArrayAccess → left:expr right:expr]]=
    *   dirección[[left]]
    *   PUSH {left.type.type.size}
    *   Valor[[right]]
    *   MUL
    *   ADD
    */
    public Object visit(ArrayAcces arrayAcces, Object param) {
        line(arrayAcces);
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
            out("push " + tipo.getType().getSize());
            arrayAcces.getRight().accept(this, Funcion.VALOR);
            out("mul");
            out("add");
        }

        return null;
    }

    // class Cast { Type typeToConvert; Expr expr; }
    /*
    * Valor[[Cast → typeToConvert:tipo expr:expr]] = 
    *   #LINE {cast}
    *   Valor[[expr]]
    *   {expr.type.suffix}2{typeToConver.suffix}
    */
    public Object visit(Cast cast, Object param) {
        line(cast);
        if (cast.getExpr() != null)
            cast.getExpr().accept(this, Funcion.VALOR);

        out(cast.getExpr().getType().getSuffix() + "2" + cast.getTypeToConvert().getSuffix());
        

        return null;
    }

    // class LitEnt { String string; }
    /*
    * Valor[[LitEnt → string:String ]] =
    *   PUSH {string}
    */
    public Object visit(LitEnt litEnt, Object param) {
        line(litEnt);
        out("push " + litEnt.getString());
        return null;
    }

    // class LitReal { String string; }
    /*
    * Valor[[LitReal → string:String ]] =
    *   PUSHF {string}
    */
    public Object visit(LitReal litReal, Object param) {
        line(litReal);
        out("pushf " + litReal.getString());
        return null;
    }

    // class LitChar { String string; }
    /*
    * Valor[[LLitCharitReal → string:String ]] =
    *   PUSHB {string}
    */
    public Object visit(LitChar litChar, Object param) {
        line(litChar);
        if("'\\n'".equals(litChar.getString()))
            out("pushb 10");
        else
            out("pushb " + (int) litChar.getString().charAt(1));
        return null;
    }

    // class Variable { String string; }
    /*
    * Valor[[Variable → string:String ]] =
    *   Dirección[[var]]
    *   LOAD<variable.type>
    *
    * dirección[[Variable → string:String ]] = 
    *   Si def.ambito != GLOBAL
    *       PUSHA BP
    *       PUSHA {def.address }
    *       ADD
    *   Sino
    *       PUSHA {def.address}
    */
    public Object visit(Variable variable, Object param) {
        line(variable);
        if (param.equals(Funcion.VALOR)) {
            variable.accept(this, Funcion.DIRECCION);
            out("load" + variable.getType().getSuffix());
        } else if (param.equals(Funcion.DIRECCION)) {
            if (variable.getDefinition().getAmbito() == Ambito.LOCAL) {
                out("pusha bp");
                out("push " + variable.getDefinition().getVarAddress(variable.getString()));
                out("add");
            } else if(variable.getDefinition().getAmbito() == Ambito.GLOBAL){
                out("pusha " + variable.getDefinition().getVarAddress(variable.getString()));
            }else{
                out("pusha bp");
                out("push " + variable.getDefinition().getAddress());
                out("add");
            }
        }

        return null;
    }

    // class MethodCallExpr { String name; List<Expr> args; }
    /*
    * Valor[[MethodCallExpr → name:String args:expr*]] =
    *   #LINE {methodCallExpr}
    *   Valor[argsi]]
    *   CALL {name}
    */
    public Object visit(MethodCallExpr methodCallExpr, Object param) {
        line(methodCallExpr);
        if (methodCallExpr.getArgs() != null)
            for (Expr child : methodCallExpr.getArgs())
                child.accept(this, Funcion.VALOR);
        out("call " + methodCallExpr.getName());

        return null;
    }

    // class TupleDefinition { String name; List<VarDefinition> vardefinition; }
    /*
    * define[[ TupleDefinition  → name:String vardefinition:varDefinition*]] = 
	*   #TYPE {name} : {
	*   Para cada var en vardefinition
	*   	Para cada s en var.name
	*   		{s} : {MAPLType(type)}
	*   }
    */
    public Object visit(TupleDefinition tupleDefinition, Object param) {
        line(tupleDefinition);
        out("#type " + tupleDefinition.getName() + ": {");
        for (VarDefinition v: tupleDefinition.getVardefinition())
            for (String s : v.getName()) 
                out(s + ":" + v.getType().getName());
        out("}");
        return null;
    }

    // class VarDefinition { List<String> name; Type type; }
    /*
    * define [[VarDefinition:definition → name:String* type:type ]] =
	*   #GLOBAL {namei}: {MAPLType(type)}
    */
    public Object visit(VarDefinition varDefinition, Object param) {
        line(varDefinition);
        for (String s : varDefinition.getName()) {
            out("#global " + s + ":" + varDefinition.getType().getName());
        }

        return null;
    }

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
