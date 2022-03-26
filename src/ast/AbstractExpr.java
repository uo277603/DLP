/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

public abstract class AbstractExpr extends AbstractAST implements Expr {

    private Type type;
    private boolean modifiable;
    
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public boolean isModifiable() {
        return modifiable;
    }
    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }

    

}
