/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;

import ast.*;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

    // private Map<String, VarDefinition> tabSimbVar = new HashMap<String,
    // VarDefinition>();
    private ContextMap<String, VarDefinition> tabSimbVar = new ContextMap<>();
    private Map<String, TupleDefinition> tabSimbTuple = new HashMap<>();
    private Map<String, Method> tabSimbFeature = new HashMap<>();
    private List<String> constructorNames = new ArrayList<>();

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    //	class Program { ClassNode classnode;  MethodCallSentence methodcallsentence; }
	public Object visit(Program program, Object param) {

		// super.visit(node, param);

		if (program.getClassnode() != null)
			program.getClassnode().accept(this, param);

		if (program.getMethodcallsentence() != null)
			program.getMethodcallsentence().accept(this, param);

        Method main = tabSimbFeature.get(program.getMethodcallsentence().getName());
        if(main != null){
            // tabSimbFeature[methodcallsentence.name].isConstructor()
            predicado(main.isConstructor(), "El método " + main.getName() + " definido en el main no es un constructor", program);
        }

		return null;
	}

    // class ClassNode { String name; List<Definition> definition; List<String>
    // createMethod; List<Method> method; }
    public Object visit(ClassNode classNode, Object param) {

        super.visit(classNode, param);

        // Asignar ámbito a las definiciones
        for (Definition child : classNode.getDefinition()) {
			child.setAmbito(Ambito.GLOBAL);
		}

        // Antes de nada visitar todos los hijos para añadir a la tabla los métodos
        // que pueden ir en el constructor
        List<String> names = classNode.getCreateMethod();
        for (String name : names) {
            // tabSimbFeature[namei] ≠ ∅
            Method definition = tabSimbFeature.get(name);
            predicado(definition != null, "Método no definido: " + name, classNode);
            // constructorNames[createMethodi] == ∅
            predicado(!constructorNames.contains(name), "El método " + name + " ya ha sido definido como constructor", classNode);
            constructorNames.add(name);
            // ClassNode.createDefinitions += createMethodi
            if(definition != null)
                definition.setConstructor();
            classNode.setCreateDefinitions(name);
        }

        return null;
    }

    // class Method { String name; List<Parameter> parameter; Type retorno;
    // List<Definition> definition; List<Sentence> sentence; }
    public Object visit(Method method, Object param) {

        // tabSimbFeature[name] == ∅
        Method definition = tabSimbFeature.get(method.getName());
        predicado(definition == null, "Método ya definido: " + method.getName(), method);
        // tabSimbFeature[name] = method
        tabSimbFeature.put(method.getName(), method);

        // tabSimbVar.set
        tabSimbVar.set();
        // super.visit
        super.visit(method, method);
        // tabSimVar.reset
        tabSimbVar.reset();

        // sentenciai.method = method
        for (Sentence child : method.getSentence()){
		    child.setMethod(method);
            if(child instanceof Conditional){
                Conditional cond = (Conditional) child;
                for(Sentence s: cond.getIftrue())
                    s.setMethod(method);
                for(Sentence s: cond.getIffalse())
                    s.setMethod(method);
            }else if(child instanceof Loop){
                Loop loop = (Loop) child;
                for(Sentence s: loop.getSentence())
                    s.setMethod(method);
            }
        }

        // Establecer el ámbito de los parámetros
        for (Parameter child : method.getParameter())
            child.getDefinition().setAmbito(Ambito.PARAMETRO);

        // Establecer el ámbito de las definiciones
        for (Definition child : method.getDefinition()) 
            child.setAmbito(Ambito.LOCAL);

        return null;
    }

    // class MethodCallSentence { String name; List<Expr> args; }
    public Object visit(MethodCallSentence methodCallSentence, Object param) {

        // super.visit(node, param);

        if (methodCallSentence.getArgs() != null)
            for (Expr child : methodCallSentence.getArgs())
                child.accept(this, param);

        // tabSimbFeature[name] ≠ ∅
        Method definition = tabSimbFeature.get(methodCallSentence.getName());
        predicado(definition != null, "Método no definido: " + methodCallSentence.getName(), methodCallSentence);
        // methodCallSentence.definition = tabSimbFeature[name]
        methodCallSentence.setDefinition(definition);

        return null;
    }

    // class MethodCallExpr { String name; List<Expr> args; }
    public Object visit(MethodCallExpr methodCallExpr, Object param) {

        // super.visit(node, param);

        if (methodCallExpr.getArgs() != null)
            for (Expr child : methodCallExpr.getArgs())
                child.accept(this, param);

        // tabSimbFeature[name] ≠ ∅
        Method definition = tabSimbFeature.get(methodCallExpr.getName());
        predicado(definition != null, "Método no definido: " + methodCallExpr.getName(), methodCallExpr);
        // MethodCallExpr.definition = tabSimbFeature[name]
        methodCallExpr.setDefinition(definition);

        return null;
    }

    // class Variable { String string; }
    public Object visit(Variable variable, Object param) {

        // tabSimbVar[name] ≠ ∅
        VarDefinition definition = tabSimbVar.getFromAny(variable.getString());
        predicado(definition != null, "Variable no definida: " + variable.getString(), variable);
        // Variable.definition = tabSimbVar[name]
        variable.setDefinition(definition);
        return null;
    }

    // class StructType { String name; }
    public Object visit(StructType structType, Object param) {
        // tabSimbTuple[name] ≠ ∅
        TupleDefinition definition = tabSimbTuple.get(structType.getName());
        predicado(definition != null, "Estructura no definida: " + structType.getName(), structType);
        // StructType.definition = tabSimbTuple[name]
        structType.setDefinition(definition);
        return null;
    }

    // class TupleDefinition { String name; List<VarDefinition> vardefinition; }
    public Object visit(TupleDefinition tupleDefinition, Object param) {

        // tabSimbTuple[name] == ∅
        TupleDefinition definition = tabSimbTuple.get(tupleDefinition.getName());
        predicado(definition == null, "Estructura ya definida: " + tupleDefinition.getName(), tupleDefinition);
        // tabSimbTuple[name] = tupleDefinition
        tabSimbTuple.put(tupleDefinition.getName(), tupleDefinition);

        tabSimbVar.set();
        super.visit(tupleDefinition, param);
        tabSimbVar.reset();

        return null;
    }

    // class Parameter { String name; Type type; }
    public Object visit(Parameter parameter, Object param) {

        // super.visit(node, param);

        if (parameter.getType() != null)
            parameter.getType().accept(this, param);

        // Convertimos el parátero a una VarDefinition
        List<String> names = new ArrayList<>();
        names.add(parameter.getName());
        VarDefinition varDefinition = new VarDefinition(names, parameter.getType());

        // tabSimbVar[name] == ∅
        VarDefinition definition = tabSimbVar.getFromTop(parameter.getName());
        predicado(definition == null, "Parámetro ya definido: " + parameter.getName(), parameter);
        // tabSimbVar[name] = parameter
        tabSimbVar.put(parameter.getName(), varDefinition);
        // parameter.definition = tabSimbVar[name]
        parameter.setDefinition(varDefinition);

        return null;
    }

    // class VarDefinition { List<String> name; Type type; }
    public Object visit(VarDefinition varDefinition, Object param) {
        // super.visit(node, param);

        if (varDefinition.getType() != null)
            varDefinition.getType().accept(this, param);

        // Hay que tener en cuenta que puede haber declaración múltiple de variables
        List<String> vars = varDefinition.getName();

        for (String name : vars) {
            // tabSimbVar[name] == ∅
            VarDefinition definition = tabSimbVar.getFromTop(name);
            predicado(definition == null, "Variable ya definida: " + name, varDefinition);
            // tabSimbVar[name] = varDefinition
            tabSimbVar.put(name, varDefinition);
        }

        return null;
    }

    private void predicado(boolean condition, String errorMessage, AST node) {
        if (!condition)
            error(errorMessage, node.getStart());
    }

    /*
     * private void error(String msg) {
     * error(msg, null);
     * }
     */

    private void error(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }

    private ErrorManager errorManager;
}
