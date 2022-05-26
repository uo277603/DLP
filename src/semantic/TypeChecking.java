/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import java.util.List;

import ast.*;
import main.*;
import visitor.*;

public class TypeChecking extends DefaultVisitor {

    public TypeChecking(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // class Program { ClassNode classnode; MethodCallSentence methodcallsentence; }
    /*
     * public Object visit(Program program, Object param) {
     * 
     * // super.visit(node, param);
     * 
     * if (program.getClassnode() != null)
     * program.getClassnode().accept(this, param);
     * 
     * if (program.getMethodcallsentence() != null)
     * program.getMethodcallsentence().accept(this, param);
     * 
     * return null;
     * }
     * 
     * // class ClassNode { String name; List<Definition> definition; List<String>
     * createMethod; List<Method> method; }
     * public Object visit(ClassNode classNode, Object param) {
     * 
     * // super.visit(node, param);
     * 
     * if (classNode.getDefinition() != null)
     * for (Definition child : classNode.getDefinition())
     * child.accept(this, param);
     * 
     * if (classNode.getMethod() != null)
     * for (Method child : classNode.getMethod())
     * child.accept(this, param);
     * 
     * return null;
     * }
     */

    // class Method { String name; List<Parameter> parameter; Type retorno;
    // List<Definition> definition; List<Sentence> sentence; }
    public Object visit(Method method, Object param) {

        /*
         * if (method.getParameter() != null)
         * for (Parameter child : method.getParameter())
         * child.accept(this, param);
         * 
         * if (method.getRetorno() != null)
         * method.getRetorno().accept(this, param);
         * 
         * if (method.getDefinition() != null)
         * for (Definition child : method.getDefinition())
         * child.accept(this, param);
         * 
         * if (method.getSentence() != null)
         * for (Sentence child : method.getSentence())
         * child.accept(this, param);
         */
        boolean existsReturn = false;
        for (Sentence s : method.getSentence()) {
            if (s instanceof ReturnNode) {
                existsReturn = true;
                break;
            }
            if (s instanceof Conditional) {
                Conditional cond = (Conditional) s;
                for (Sentence sent : cond.getIftrue())
                    if (sent instanceof ReturnNode) {
                        existsReturn = true;
                        break;
                    }
                for (Sentence sent : cond.getIffalse())
                    if (sent instanceof ReturnNode) {
                        existsReturn = true;
                        break;
                    }
            } else if (s instanceof Loop) {
                Loop loop = (Loop) s;
                for (Sentence sent : loop.getSentence())
                    if (sent instanceof ReturnNode) {
                        existsReturn = true;
                        break;
                    }
            }
        }
        // si retorno ≠ voidType
        if (method.getRetorno().getClass() != VoidType.class) {
            // returnNode ⊂ method.definition
            predicado(existsReturn, "Este método debe retornar un resultado de tipo: " + method.getRetorno(),
                    method.getStart());
            // si (∃ return) =>
            // method.retornable = true
            if (existsReturn)
                method.setRetornable(true);
        }

        super.visit(method, param);

        return null;
    }

    // class Parameter { String name; Type type; }
    public Object visit(Parameter parameter, Object param) {

        // super.visit(node, param);

        if (parameter.getType() != null)
            parameter.getType().accept(this, param);

        // esPrimitivo(type)
        predicado(esPrimitivo(parameter.getType()), "El parámetro debe de ser de tipo primitivo", parameter.getStart());
        return null;
    }

    // class Print { String string; List<Expr> expr; }
    public Object visit(Print print, Object param) {

        // super.visit(node, param);

        if (print.getExpr() != null)
            for (Expr child : print.getExpr())
                child.accept(this, param);

        // esPrimitivo(expri.type)
        for (Expr e : print.getExpr()) {
            predicado(esPrimitivo(e.getType()), "La expresión debe de ser de tipo primitivo", e.getStart());
        }
        return null;
    }

    // class Read { List<Expr> expr; }
    public Object visit(Read read, Object param) {

        // super.visit(node, param);

        if (read.getExpr() != null)
            for (Expr child : read.getExpr())
                child.accept(this, param);

        // esPrimitivo(expri.type)
        // expri.modifiable
        for (Expr e : read.getExpr()) {
            predicado(esPrimitivo(e.getType()), "La expresión debe de ser de tipo primitivo", e.getStart());
            predicado(e.isModifiable(), "La expresión debe de ser modificable", e.getStart());
        }
        return null;
    }

    // class Assignment { Expr left; Expr right; }
    public Object visit(Assignment assignment, Object param) {

        super.visit(assignment, param);

        /*
         * if (assignment.getLeft() != null)
         * assignment.getLeft().accept(this, param);
         * 
         * if (assignment.getRight() != null)
         * assignment.getRight().accept(this, param);
         */

        // mismoTipo(left.type, right.type)
        predicado(mismoTipo(assignment.getLeft().getType(), assignment.getRight().getType()),
                "Los operandos deben ser del mismo tipo", assignment);
        // esPrimitivo(left.type)
        predicado(esPrimitivo(assignment.getLeft().getType()), "La parte de la izquierda tiene que ser simple",
                assignment.getStart());
        // left.modifiable
        predicado(assignment.getLeft().isModifiable(), "Se requiere expresión modificable", assignment.getLeft());
        return null;
    }

    // class Conditional { Expr condition; List<Sentence> iftrue; List<Sentence>
    // iffalse; }
    public Object visit(Conditional conditional, Object param) {

        super.visit(conditional, param);

        /*
         * if (conditional.getCondition() != null)
         * conditional.getCondition().accept(this, param);
         * /
         * if (conditional.getIftrue() != null)
         * for (Sentence child : conditional.getIftrue())
         * child.accept(this, param);
         * 
         * if (conditional.getIffalse() != null)
         * for (Sentence child : conditional.getIffalse())
         * child.accept(this, param);
         */

        // condition.type == intType
        predicado(conditional.getCondition().getType().getClass() == IntType.class,
                "La condición debe de ser de tipo entero", conditional);
        return null;
    }

    // class Loop { List<Sentence> init; Expr condition; List<Sentence> sentence; }
    public Object visit(Loop loop, Object param) {

        super.visit(loop, param);

        /*
         * if (loop.getInit() != null)
         * for (Sentence child : loop.getInit())
         * child.accept(this, param);
         * 
         * if (loop.getCondition() != null)
         * loop.getCondition().accept(this, param);
         * 
         * if (loop.getSentence() != null)
         * for (Sentence child : loop.getSentence())
         * child.accept(this, param);
         */

        // condition.type == intType
        predicado(loop.getCondition().getType().getClass() == IntType.class, "La condición debe de ser de tipo entero",
                loop);
        return null;
    }

    // class ReturnNode { Expr expr; }
    public Object visit(ReturnNode returnNode, Object param) {

        super.visit(returnNode, param);

        /*
         * if (returnNode.getExpr() != null)
         * returnNode.getExpr().accept(this, param);
         */

        // si returnNode.method.retorno == voidType
        if (returnNode.getMethod().getRetorno().getClass() == VoidType.class) {
            // expr == null
            predicado(returnNode.getExpr() == null, "El retorno tiene que ser de tipo Void", returnNode.getEnd());
        } else {
            // expr.type ≠ VoidType
            predicado(returnNode.getExpr() != null, "El retorno no puede ser de tipo Void", returnNode.getEnd());
            // expr.type == returnNode.method.retorno
            if (returnNode.getExpr() != null)
                predicado(returnNode.getExpr().getType().getClass() == returnNode.getMethod().getRetorno().getClass(),
                        "El tipo de la expresión no coincide con el tipo de retorno", returnNode.getExpr());
        }

        return null;
    }

    private boolean checkParams(List<Expr> params1, List<Parameter> params2){
        if(params1.size() != params2.size())
            return false;
        for(int i = 0; i < params1.size(); i++){
            if(params1.get(i).getType().getClass() != params2.get(i).getType().getClass())
                return false;
        }
        return true;
    }

    // class MethodCallSentence { String name; List<Expr> args; }
    public Object visit(MethodCallSentence methodCallSentence, Object param) {

        // super.visit(node, param);

        if (methodCallSentence.getArgs() != null)
            for (Expr child : methodCallSentence.getArgs())
                child.accept(this, param);

        List<Method> methods = methodCallSentence.getDefinitions();
        Method correctMethod = null;
        int count = 0;
        for (Method m : methods) {
            if (checkParams(methodCallSentence.getArgs(), m.getParameter())) {
                correctMethod = m;
                methodCallSentence.index = count;
            }
            count++;
        }
        predicado(correctMethod != null,
                "No existe la función " + methodCallSentence.getName() + " con esos parámetros", methodCallSentence);
        // methodCallSentence.definition.parameter.length == args.length
        // boolean sameArgs = methodCallSentence.getArgs().size() ==
        // methodCallSentence.getDefinition().getParameter()
        // .size();
        /*
         * if (sameArgs) {
         * // methodCallSentence.definition.parameteri.type == argsi.type
         * boolean sameType = true;
         * for (int i = 0; i < methodCallSentence.getArgs().size(); i++) {
         * if (!mismoTipo(methodCallSentence.getArgs().get(i).getType(),
         * methodCallSentence.getDefinition().getParameter().get(i).getType()))
         * sameType = false;
         * }
         * predicado(sameType, "El tipo de los parámetros no coincide",
         * methodCallSentence.getStart());
         * }
         */
        return null;
    }

    // class ExprBinariaAritmetica { Expr left; String op; Expr right; }
    public Object visit(ExprBinariaAritmetica exprBinariaAritmetica, Object param) {

        super.visit(exprBinariaAritmetica, param);

        /*
         * if (exprBinariaAritmetica.getLeft() != null)
         * exprBinariaAritmetica.getLeft().accept(this, param);
         * 
         * if (exprBinariaAritmetica.getRight() != null)
         * exprBinariaAritmetica.getRight().accept(this, param);
         */

        // mismoTipo(left.type, right.type)
        predicado(mismoTipo(exprBinariaAritmetica.getLeft().getType(), exprBinariaAritmetica.getRight().getType()),
                "Los tipos de los operandos deben coincidir", exprBinariaAritmetica.getStart());
        // left.type == intType || left.type == realType
        predicado(
                exprBinariaAritmetica.getLeft().getType().getClass() == IntType.class
                        || exprBinariaAritmetica.getLeft().getType().getClass() == RealType.class,
                "Las operaciones aritméticas solo son aplicables a int o real", exprBinariaAritmetica.getStart());

        // exprBianariaAritmetica.type = left.type
        exprBinariaAritmetica.setType(exprBinariaAritmetica.getLeft().getType());
        // exprBinariaAritmetica.modifiable = false
        exprBinariaAritmetica.setModifiable(false);
        return null;
    }

    // class ExprUnariaAritmetica { String op; Expr expr; }
    public Object visit(ExprUnariaAritmetica exprUnariaAritmetica, Object param) {

        // super.visit(node, param);

        if (exprUnariaAritmetica.getExpr() != null)
            exprUnariaAritmetica.getExpr().accept(this, param);

        // expr.type == intType || expr.type == realType
        predicado(
                exprUnariaAritmetica.getExpr().getType().getClass() == IntType.class
                        || exprUnariaAritmetica.getExpr().getType().getClass() == RealType.class,
                "Las operaciones aritméticas solo son aplicables a int o real", exprUnariaAritmetica.getStart());

        // exprBianariaAritmetica.type = left.type
        exprUnariaAritmetica.setType(exprUnariaAritmetica.getExpr().getType());
        // exprBinariaAritmetica.modifiable = false
        exprUnariaAritmetica.setModifiable(false);

        return null;
    }

    // class ExprBinariaLogica { Expr left; String op; Expr right; }
    public Object visit(ExprBinariaLogica exprBinariaLogica, Object param) {

        super.visit(exprBinariaLogica, param);

        /*
         * if (exprBinariaLogica.getLeft() != null)
         * exprBinariaLogica.getLeft().accept(this, param);
         * 
         * if (exprBinariaLogica.getRight() != null)
         * exprBinariaLogica.getRight().accept(this, param);
         */

        // mismoTipo(left.type, right.type)
        predicado(mismoTipo(exprBinariaLogica.getLeft().getType(), exprBinariaLogica.getRight().getType()),
                "Los tipos de los operandos deben coincidir", exprBinariaLogica.getStart());

        // si(“<>” || “=”)
        if (exprBinariaLogica.getOp().equals("<>") || exprBinariaLogica.getOp().equals("=")) {
            // esPrimitivo(left.type)
            predicado(esPrimitivo(exprBinariaLogica.getLeft().getType()),
                    "El tipo de los operandos debe de ser primitivo", exprBinariaLogica.getStart());
            // si(“and” || “or”)
        } else if (exprBinariaLogica.getOp().equals("and") || exprBinariaLogica.getOp().equals("or")) {
            // left.type == IntType
            predicado(exprBinariaLogica.getLeft().getType().getClass() == IntType.class,
                    "Los operandos deben de ser enteros", exprBinariaLogica.getStart());
        } else {
            // esNumero(left.type)
            predicado(esNumero(exprBinariaLogica.getLeft().getType()), "Los operandos deben de ser enteros o reales",
                    exprBinariaLogica.getStart());
        }

        // exprBinariaLogica.type = intType
        exprBinariaLogica.setType(new IntType());
        // exprBinariaLogica.modifiable = false
        exprBinariaLogica.setModifiable(false);
        return null;
    }

    // class ExprUnariaLogica { String op; Expr expr; }
    public Object visit(ExprUnariaLogica exprUnariaLogica, Object param) {

        // super.visit(node, param);

        if (exprUnariaLogica.getExpr() != null)
            exprUnariaLogica.getExpr().accept(this, param);

        // expr.type == intType
        predicado(exprUnariaLogica.getExpr().getType().getClass() == IntType.class,
                "El tipo de la expresión tiene que ser entero", exprUnariaLogica.getStart());

        // exprUnariaLogica.type = intType
        exprUnariaLogica.setType(new IntType());
        // exprUnariaLogica.modifiable = false
        exprUnariaLogica.setModifiable(false);
        return null;
    }

    // class Acces { Expr left; String op; String right; }
    public Object visit(Acces acces, Object param) {

        // super.visit(node, param);

        if (acces.getLeft() != null)
            acces.getLeft().accept(this, param);

        // left.type == structType
        predicado(acces.getLeft().getType() instanceof StructType,
                "La expresión de la izquierda tiene que ser una estructura", acces.getStart());

        VarDefinition campo = null;

        // left.definition.varDefinition.contains(right)
        if (acces.getLeft().getType() instanceof StructType) {
            StructType tipo = (StructType) acces.getLeft().getType();
            for (VarDefinition d : tipo.getDefinition().getVardefinition()) {
                if (d.getName().get(0).equals(acces.getRight())) {
                    campo = d;
                }
            }
            predicado(campo != null, "El campo " + acces.getRight() + " no está definido", acces.getStart());
        }
        // access.type = left.definition.varDefinition.get(right).type
        if (campo != null)
            acces.setType(campo.getType());
        else
            acces.setType(acces.getLeft().getType()); // para evitar NullPointer

        // arrayAcces.modifiable = true
        acces.setModifiable(true);

        return null;
    }

    // class ArrayAcces { Expr left; Expr right; }
    public Object visit(ArrayAcces arrayAcces, Object param) {

        super.visit(arrayAcces, param);

        /*
         * if (arrayAcces.getLeft() != null)
         * arrayAcces.getLeft().accept(this, param);
         * 
         * if (arrayAcces.getRight() != null)
         * arrayAcces.getRight().accept(this, param);
         */

        // left.type == arrayType
        predicado(arrayAcces.getLeft().getType().getClass() == ArrayType.class,
                "La expresión de la izquierda tiene que ser un array", arrayAcces.getStart());
        // right.type == intType
        predicado(arrayAcces.getRight().getType().getClass() == IntType.class, "El índice tiene que ser un entero",
                arrayAcces.getStart());
        if (arrayAcces.getLeft().getType() instanceof ArrayType) {
            // arrayAcces.type = left.type.type
            ArrayType tipo = (ArrayType) arrayAcces.getLeft().getType();
            arrayAcces.setType(tipo.getType());
        } else {
            arrayAcces.setType(arrayAcces.getLeft().getType()); // Para evitar NullPointer
        }
        // arrayAcces.modifiable = true
        arrayAcces.setModifiable(true);

        return null;
    }

    // class Cast { Type typeToConvert; Expr expr; }
    public Object visit(Cast cast, Object param) {

        // super.visit(node, param);

        if (cast.getTypeToConvert() != null)
            cast.getTypeToConvert().accept(this, param);

        if (cast.getExpr() != null)
            cast.getExpr().accept(this, param);

        // esPrimitivo(typeToConvert)
        predicado(esPrimitivo(cast.getTypeToConvert()), "El tipo a convertir tiene que ser primitivo", cast.getStart());
        // esPrimitivo(expr)
        predicado(esPrimitivo(cast.getExpr().getType()), "Solo se pueden convertir tipos simples", cast.getStart());
        // typeToConvert ≠ expr.type
        predicado(cast.getTypeToConvert().getClass() != cast.getExpr().getType().getClass(),
                "Los tipos del cast tienen que ser diferentes", cast.getStart());
        // isCompatibleCast(typeToConvert, expr)
        predicado(isCompaitbleCast(cast.getTypeToConvert(), cast.getExpr().getType()),
                "Los tipos del cast no son compatibles", cast.getStart());

        // cast.type = typeToConvert
        cast.setType(cast.getTypeToConvert());
        // cast.modifiable = false
        cast.setModifiable(false);
        return null;
    }

    // class LitEnt { String string; }
    public Object visit(LitEnt litEnt, Object param) {
        // litEnt.type = intType
        litEnt.setType(new IntType());
        // litEnt.modifiable = false
        litEnt.setModifiable(false);
        return null;
    }

    // class LitReal { String string; }
    public Object visit(LitReal litReal, Object param) {
        // litReal.type = realType
        litReal.setType(new RealType());
        // litReal.modifiable = false
        litReal.setModifiable(false);
        return null;
    }

    // class LitChar { String string; }
    public Object visit(LitChar litChar, Object param) {
        // litChar.type = charType
        litChar.setType(new CharType());
        // litChar.modifiable = false
        litChar.setModifiable(false);
        return null;
    }

    // class Variable { String string; }
    public Object visit(Variable variable, Object param) {
        // variable.type = variable.definition.type
        variable.setType(variable.getDefinition().getType());
        // variable.modifiable = true
        variable.setModifiable(true);
        return null;
    }

    // class MethodCallExpr { String name; List<Expr> args; }
    public Object visit(MethodCallExpr methodCallExpr, Object param) {

        // super.visit(node, param);

        if (methodCallExpr.getArgs() != null)
            for (Expr child : methodCallExpr.getArgs())
                child.accept(this, param);

        List<Method> methods = methodCallExpr.getDefinitions();
        Method correctMethod = null;
        int count = 0;
        for (Method m : methods) {
            if (methodCallExpr.getArgs().equals(m.getParameter())) {
                correctMethod = m;
                methodCallExpr.index = count;
            }
            count++;
        }
        predicado(correctMethod != null,
                "No existe la función " + methodCallExpr.getName() + " con esos parámetros", methodCallExpr);

        if (correctMethod != null) {
            // methodCallExpr.defintion.retornable
            predicado(correctMethod.isRetornable(),
                    "La función " + correctMethod.getName() + " no tiene tipo de retorno",
                    methodCallExpr.getStart());
        }

        if (correctMethod != null) {
            // methodCallExpr.type = methodCallExpr.definition.type
            methodCallExpr.setType(correctMethod.getRetorno());
        }
        return null;
    }

    // class IntType { }
    /*
     * public Object visit(IntType intType, Object param) {
     * return null;
     * }
     * 
     * // class RealType { }
     * public Object visit(RealType realType, Object param) {
     * return null;
     * }
     * 
     * // class CharType { }
     * public Object visit(CharType charType, Object param) {
     * return null;
     * }
     * 
     * // class ArrayType { int index; Type type; }
     * public Object visit(ArrayType arrayType, Object param) {
     * 
     * // super.visit(node, param);
     * 
     * if (arrayType.getType() != null)
     * arrayType.getType().accept(this, param);
     * 
     * return null;
     * }
     * 
     * // class VoidType { }
     * public Object visit(VoidType voidType, Object param) {
     * return null;
     * }
     * 
     * // class StructType { String name; }
     * public Object visit(StructType structType, Object param) {
     * return null;
     * }
     * 
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

    // --------------------------------------------------------
    // Funciones auxiliares

    private boolean mismoTipo(Type a, Type b) {
        return (a.getClass() == b.getClass());
    }

    private boolean esPrimitivo(Type tipo) {
        return tipo.getClass() == IntType.class || tipo.getClass() == RealType.class
                || tipo.getClass() == CharType.class;
    }

    private boolean esNumero(Type tipo) {
        return tipo.getClass() == IntType.class || tipo.getClass() == RealType.class;
    }

    boolean isCompaitbleCast(Type typeToConvert, Type type) {
        if (typeToConvert == type)
            return false;
        else if (typeToConvert.getClass() == RealType.class && type.getClass() == CharType.class)
            return false;
        else if (typeToConvert.getClass() == CharType.class & type.getClass() == RealType.class)
            return false;
        else
            return true;
    }

    /**
     * predicado. Método auxiliar para implementar los predicados. Borrar si no se
     * quiere usar.
     *
     * Ejemplos de uso (suponiendo que existe un método "esPrimitivo(expr)"):
     *
     * 1. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
     * primitivo", expr.getStart());
     * 2. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
     * primitivo", expr); // Se asume getStart()
     * 3. predicado(esPrimitivo(expr.tipo), "La expresión debe ser de un tipo
     * primitivo");
     *
     * NOTA: El método getStart() (ejemplo 1) indica la linea/columna del fichero
     * fuente donde estaba el nodo
     * (y así poder dar información más detallada de la posición del error). Si se
     * usa VGen, dicho método
     * habrá sido generado en todos los nodos del AST.
     * No es obligatorio llamar a getStart() (ejemplo 2), ya que si se pasa el nodo,
     * se usará por defecto dicha
     * posición.
     * Si no se quiere imprimir la posición del fichero, se puede omitir el tercer
     * argumento (ejemplo 3).
     *
     * @param condition     Debe cumplirse para que no se produzca un error
     * @param errorMessage  Se imprime si no se cumple la condición
     * @param posicionError Fila y columna del fichero donde se ha producido el
     *                      error.
     */

    private void predicado(boolean condition, String errorMessage, AST node) {
        predicado(condition, errorMessage, node.getStart());
    }

    private void predicado(boolean condition, String errorMessage, Position position) {
        if (!condition)
            errorManager.notify("Type Checking", errorMessage, position);
    }

    private void predicado(boolean condition, String errorMessage) {
        predicado(condition, errorMessage, (Position) null);
    }

    private ErrorManager errorManager;

}
