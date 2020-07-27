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
public class nodoAB {
    private nodoAB hijoDer, hijoIzq;
    private int cod;
    public nodoAB(int cod){
        this.hijoDer = null;
        this.hijoIzq = null;
        this.cod = cod;
    }

    public nodoAB getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(nodoAB hijoDer) {
        this.hijoDer = hijoDer;
    }

    public nodoAB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(nodoAB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    
}
