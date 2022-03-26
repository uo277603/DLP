/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

public interface Expr extends AST {
    public void setType(Type type);

    public Type getType();

    public void setModifiable(boolean modificable);

    public boolean isModifiable();
}
