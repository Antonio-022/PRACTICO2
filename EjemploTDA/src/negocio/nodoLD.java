/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author pc
 */
public class nodoLD {
    private int dato;
    private nodoLD refDer, refIzq;
    
    public nodoLD(int dato){
        this.dato = dato;
        this.refDer = null;
        this.refIzq = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodoLD getRefDer() {
        return refDer;
    }

    public void setRefDer(nodoLD refDer) {
        this.refDer = refDer;
    }

    public nodoLD getRefIzq() {
        return refIzq;
    }

    public void setRefIzq(nodoLD refIzq) {
        this.refIzq = refIzq;
    }
    
    
}
