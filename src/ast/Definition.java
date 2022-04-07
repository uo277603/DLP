/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import semantic.Ambito;

public interface Definition extends AST {
    
    public void setAmbito(Ambito ambito);
    public Ambito getAmbito();

    public void setAddress(int address);
    public int getAddress();

    public Type getType();
    public void setType(Type type);
}
