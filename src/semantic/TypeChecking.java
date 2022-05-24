/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

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
            s.setMethod(method);
            if (s instanceof ReturnNode) {
                existsReturn = true;
                break;
            }
        }
        if (method.getRetorno().getClass() != VoidType.class) {     
            predicado(existsReturn, "Este método debe retornar un resultado de tipo: " + method.getRetorno(),
                    method.getStart());
            if(existsReturn)
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

        predicado(esPrimitivo(parameter.getType()), "El parámetro debe de ser de tipo primitivo", parameter.getStart());
        return null;
    }

    // class Print { String string; List<Expr> expr; }
    public Object visit(Print print, Object param) {

        // super.visit(node, param);

        if (print.getExpr() != null)
            for (Expr child : print.getExpr())
                child.accept(this, param);

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
        predicado(mismoTipo(assignment.getLeft().getType(), assignment.getRight().getType()),
                "Los operandos deben ser del mismo tipo", assignment);
        predicado(esPrimitivo(assignment.getLeft().getType()), "La parte de la izquierda tiene que ser simple", assignment.getStart());
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
        if (returnNode.getMethod().getRetorno().getClass() == VoidType.class) {
            predicado(returnNode.getExpr() == null, "El retorno tiene que ser de tipo Void", returnNode.getEnd());
        } else {   
            predicado(returnNode.getExpr() != null, "El retorno no puede ser de tipo Void", returnNode.getEnd());
            if(returnNode.getExpr() != null)
                predicado(returnNode.getExpr().getType().getClass() == returnNode.getMethod().getRetorno().getClass(),
                    "El tipo de la expresión no coincide con el tipo de retorno", returnNode.getExpr());
        }

        return null;
    }

    // class MethodCallSentence { String name; List<Expr> args; }
    public Object visit(MethodCallSentence methodCallSentence, Object param) {

        // super.visit(node, param);

        if (methodCallSentence.getArgs() != null)
            for (Expr child : methodCallSentence.getArgs())
                child.accept(this, param);

        boolean sameArgs = methodCallSentence.getArgs().size() == methodCallSentence.getDefinition().getParameter().size();
        predicado(sameArgs,
                "El número de parámetos no coincide", methodCallSentence.getStart());
        if(sameArgs){
            boolean sameType = true;
            for(int i = 0; i < methodCallSentence.getArgs().size(); i++){
                if(!mismoTipo(methodCallSentence.getArgs().get(i).getType(), methodCallSentence.getDefinition().getParameter().get(i).getType()))
                    sameType = false;
            }
            predicado(sameType, "El tipo de los parámetros no coincide", methodCallSentence.getStart());
        }
        return null;
    }

    //	class ExprTernaria { Expr condicion;  Expr expr1;  Expr expr2; }
	public Object visit(ExprTernaria exprTernaria, Object param) {

		super.visit(exprTernaria, param);

        predicado(mismoTipo(exprTernaria.getExpr1().getType(), exprTernaria.getExpr2().getType()), "Los tipos de ambas expresiones debe coincidir");
        predicado(exprTernaria.getCondicion().getType().getClass() == IntType.class, "La condición debe de ser de tipo entero",
        exprTernaria);
        exprTernaria.setType(exprTernaria.getExpr1().getType());

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
        predicado(mismoTipo(exprBinariaAritmetica.getLeft().getType(), exprBinariaAritmetica.getRight().getType()),
                "Los tipos de los operandos deben coincidir", exprBinariaAritmetica.getStart());
        predicado(
                exprBinariaAritmetica.getLeft().getType().getClass() == IntType.class
                        || exprBinariaAritmetica.getLeft().getType().getClass() == RealType.class,
                "Las operaciones aritméticas solo son aplicables a int o real", exprBinariaAritmetica.getStart());

        exprBinariaAritmetica.setType(exprBinariaAritmetica.getLeft().getType());
        exprBinariaAritmetica.setModifiable(false);
        return null;
    }

    // class ExprUnariaAritmetica { String op; Expr expr; }
    public Object visit(ExprUnariaAritmetica exprUnariaAritmetica, Object param) {

        // super.visit(node, param);

        if (exprUnariaAritmetica.getExpr() != null)
            exprUnariaAritmetica.getExpr().accept(this, param);

        exprUnariaAritmetica.setType(exprUnariaAritmetica.getExpr().getType());

        predicado(
                exprUnariaAritmetica.getType().getClass() == IntType.class
                        || exprUnariaAritmetica.getType().getClass() == RealType.class,
                "Las operaciones aritméticas solo son aplicables a int o real", exprUnariaAritmetica.getStart());

        
        exprUnariaAritmetica.setModifiable(false);

        return null;
    }

    // class ExprBinariaLogica { Expr left; String op; Expr right; }
    public Object visit(ExprBinariaLogica exprBinariaLogica, Object param) {

        super.visit(exprBinariaLogica, param);

        /*if (exprBinariaLogica.getLeft() != null)
            exprBinariaLogica.getLeft().accept(this, param);

        if (exprBinariaLogica.getRight() != null)
            exprBinariaLogica.getRight().accept(this, param);*/

        predicado(mismoTipo(exprBinariaLogica.getLeft().getType(), exprBinariaLogica.getRight().getType()),
            "Los tipos de los operandos deben coincidir", exprBinariaLogica.getStart());
        if(exprBinariaLogica.getOp().equals("<>") || exprBinariaLogica.getOp().equals("=")){
            predicado(esPrimitivo(exprBinariaLogica.getLeft().getType()), "El tipo de los operandos debe de ser primitivo", exprBinariaLogica.getStart());
        }else if (exprBinariaLogica.getOp().equals("and") || exprBinariaLogica.getOp().equals("or")){
            predicado(exprBinariaLogica.getLeft().getType().getClass() == IntType.class, "Los operandos deben de ser enteros", exprBinariaLogica.getStart());
        }else{
            predicado(esNumero(exprBinariaLogica.getLeft().getType()), "Los operandos deben de ser enteros o reales", exprBinariaLogica.getStart());
        }
        exprBinariaLogica.setType(new IntType());
        exprBinariaLogica.setModifiable(false);
        return null;
    }

    // class ExprUnariaLogica { String op; Expr expr; }
    public Object visit(ExprUnariaLogica exprUnariaLogica, Object param) {

        // super.visit(node, param);

        if (exprUnariaLogica.getExpr() != null)
            exprUnariaLogica.getExpr().accept(this, param);

        predicado(exprUnariaLogica.getExpr().getType().getClass() == IntType.class, "El tipo de la expresión tiene que ser entero", exprUnariaLogica.getStart());

        exprUnariaLogica.setType(new IntType());
        exprUnariaLogica.setModifiable(false);
        return null;
    }

    // class Acces { Expr left; String op; String right; }
    public Object visit(Acces acces, Object param) {

        // super.visit(node, param);

        if (acces.getLeft() != null)
            acces.getLeft().accept(this, param);

        predicado(acces.getLeft().getType() instanceof StructType, "La expresión de la izquierda tiene que ser una estructura", acces.getStart());
        acces.setModifiable(true);
        if(acces.getLeft().getType() instanceof StructType){
            StructType tipo = (StructType) acces.getLeft().getType();
            for(VarDefinition d : tipo.getDefinition().getVardefinition()){
                if(d.getName().get(0).equals(acces.getRight())){
                    acces.setType(d.getType());
                }
            }
            predicado(acces.getType() != null, "El campo " + acces.getRight() + " no está definido", acces.getStart());
        }
        if(acces.getType() == null)
            acces.setType(acces.getLeft().getType()); // para evitar nullPointer
        return null;
    }

    // class ArrayAcces { Expr left; Expr right; }
    public Object visit(ArrayAcces arrayAcces, Object param) {

        super.visit(arrayAcces, param);

        /*if (arrayAcces.getLeft() != null)
            arrayAcces.getLeft().accept(this, param);

        if (arrayAcces.getRight() != null)
            arrayAcces.getRight().accept(this, param);*/
        
        predicado(arrayAcces.getLeft().getType().getClass() == ArrayType.class, "La expresión de la izquierda tiene que ser un array", arrayAcces.getStart());
        predicado(arrayAcces.getRight().getType().getClass() == IntType.class, "El índice tiene que ser un entero", arrayAcces.getStart());
        if(arrayAcces.getLeft().getType() instanceof ArrayType){
            ArrayType tipo = (ArrayType) arrayAcces.getLeft().getType();
            arrayAcces.setType(tipo.getType());
        }else{
            arrayAcces.setType(arrayAcces.getLeft().getType());
        }
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

        predicado(esPrimitivo(cast.getTypeToConvert()), "El tipo a convertir tiene que ser primitivo", cast.getStart());    
        predicado(esPrimitivo(cast.getExpr().getType()), "Solo se pueden convertir tipos simples", cast.getStart());
        predicado(cast.getTypeToConvert().getClass() != cast.getExpr().getType().getClass(), "Los tipos del cast tienen que ser diferentes", cast.getStart());
        predicado(isCompaitbleCast(cast.getTypeToConvert(), cast.getExpr().getType()), "Los tipos del cast no son compatibles", cast.getStart());
        cast.setType(cast.getTypeToConvert());
        cast.setModifiable(false);
        return null;
    }

    // class LitEnt { String string; }
    public Object visit(LitEnt litEnt, Object param) {
        litEnt.setType(new IntType());
        litEnt.setModifiable(false);
        return null;
    }

    // class LitReal { String string; }
    public Object visit(LitReal litReal, Object param) {
        litReal.setType(new RealType());
        litReal.setModifiable(false);
        return null;
    }

    // class LitChar { String string; }
    public Object visit(LitChar litChar, Object param) {
        litChar.setType(new CharType());
        litChar.setModifiable(false);
        return null;
    }

    // class Variable { String string; }
    public Object visit(Variable variable, Object param) {
        variable.setType(variable.getDefinition().getType());
        variable.setModifiable(true);
        return null;
    }

    // class MethodCallExpr { String name; List<Expr> args; }
    public Object visit(MethodCallExpr methodCallExpr, Object param) {

        // super.visit(node, param);

        if (methodCallExpr.getArgs() != null)
            for (Expr child : methodCallExpr.getArgs())
                child.accept(this, param);
        boolean sameArgs = methodCallExpr.getArgs().size() == methodCallExpr.getDefinition().getParameter().size();
        predicado(sameArgs,
                "El número de parámetos no coincide", methodCallExpr.getStart());
        predicado(methodCallExpr.getDefinition().isRetornable(), "La función " + methodCallExpr.getName() + " no tiene tipo de retorno",
        methodCallExpr.getStart());

        if(sameArgs){
            boolean sameType = true;
            for(int i = 0; i < methodCallExpr.getArgs().size(); i++){
                if(!mismoTipo(methodCallExpr.getArgs().get(i).getType(), methodCallExpr.getDefinition().getParameter().get(i).getType()))
                    sameType = false;
            }
            predicado(sameType, "El tipo de los parámetros no coincide", methodCallExpr.getStart());
        }

        methodCallExpr.setType(methodCallExpr.getDefinition().getRetorno());
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

    private boolean esNumero(Type tipo){
        return tipo.getClass() == IntType.class || tipo.getClass() == RealType.class;
    }

    boolean isCompaitbleCast(Type typeToConvert, Type type) {
        if(typeToConvert == type)
            return false;
        else if(typeToConvert.getClass() == RealType.class && type.getClass() == CharType.class)
            return false;
        else if(typeToConvert.getClass() == CharType.class& type.getClass() == RealType.class)
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
