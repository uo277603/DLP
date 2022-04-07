/**
 * @generated VGen (for ANTLR) 1.7.4
 */

package ast;

import semantic.Ambito;

public abstract class AbstractDefinition extends AbstractAST implements Definition {

    private Ambito ambito;
    private int address;

    public Ambito getAmbito() {
        return ambito;
    }

    public void setAmbito(Ambito ambito) {
        this.ambito = ambito;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    

    
}
