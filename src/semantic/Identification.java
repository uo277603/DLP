/**
 * Tutorial de Diseño de Lenguajes de Programación
 * @author Raúl Izquierdo
 */

package semantic;

import ast.*;
import main.*;
import visitor.*;

public class Identification extends DefaultVisitor {

    public Identification(ErrorManager errorManager) {
        this.errorManager = errorManager;
    }

    // # ----------------------------------------------------------
    /*
    * Poner aquí los visit.
    *
    * Si se ha usado VGen, solo hay que copiarlos de la clase 'visitor/_PlantillaParaVisitors.txt'.
    */

    // public Object visit(Program prog, Object param) {
    //      ...
    // }

    // ...
    // ...
    // ...

    // # --------------------------------------------------------
    // Métodos auxiliares recomendados (opcionales) -------------

    private void error(String msg) {
        error(msg, null);
    }

    private void error(String msg, Position position) {
        errorManager.notify("Identification", msg, position);
    }


    private ErrorManager errorManager;
}
