/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;
import negocio.nodoLD;
/**
 *
 * @author pc
 */
public class clsListaCircular {
    private nodoLD PLC;
     public boolean Vacia(){
        return this.PLC==null ? true : false;
    }
    
    public clsListaCircular(){
        this.PLC = null;
    }

    public nodoLD getPLC() {
        return PLC;
    }

    public void setPLC(nodoLD PLC) {
        this.PLC = PLC;
    }
      
    public void insertarDerecha(int dato){
        nodoLD nn = new nodoLD(dato);
        if(this.PLC == null){
            this.PLC = nn;
            this.PLC.setRefDer(this.PLC);
            this.PLC.setRefIzq(this.PLC);
        }else{
            (this.PLC.getRefDer()).setRefIzq(nn);
            nn.setRefDer(this.PLC.getRefDer());
            this.PLC.setRefDer(nn);
            nn.setRefIzq(this.PLC);
        }
    }
    
    public boolean estaVacia(){
        if(this.PLC == null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean esUnSoloNodo(){
        if(this.PLC == this.PLC.getRefDer() && this.PLC == this.PLC.getRefIzq()){
            return true;
        }else{
            return false;
        }
    }
    
    public void eliminarDerecha(){
        if(!estaVacia()){
            if(esUnSoloNodo()){
                this.PLC = null;
            }else{
                ((this.PLC.getRefDer()).getRefDer()).setRefIzq(this.PLC);
                this.PLC.setRefDer((this.PLC.getRefDer()).getRefDer());
            }
        }
    }
      public int cantNodos(){
         int t=0;
        if(this.PLC!=null){
            nodoLD X= this.PLC;
            do{
                t++;
                X=X.getRefDer();
            }while(X!=this.PLC);
        }
        return t;
    }
}
