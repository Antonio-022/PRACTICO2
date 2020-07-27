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
public class clsListaDoble {
    private nodoLD pListaD;
    public clsListaDoble(){
        this.pListaD = null;
    }
    
    public void setpListaD(nodoLD pListaD){
        this.pListaD = pListaD;
    }
    
    public nodoLD getpListaD(){
        return this.pListaD;
    }
       public void InsertDer(int dato){
        nodoLD N= new nodoLD(dato);
        if(this.pListaD==null){
            this.pListaD =N;
        }else if(this.pListaD.getRefDer()== null){
            N.setRefIzq(this.pListaD);
            this.pListaD.setRefDer(N);
        }else {
            N.setRefDer(this.pListaD.getRefDer());
            this.pListaD.getRefDer().setRefIzq(N);
            this.pListaD.setRefDer(N);
            N.setRefIzq(this.pListaD);
        }
    }
    public void insertarIzq(int dato){
        nodoLD nn = new nodoLD(dato);
        if(this.pListaD == null){
            this.pListaD = nn;
        }else{
            if(this.pListaD.getRefIzq() == null){
                nn.setRefDer(this.pListaD);
                this.pListaD.setRefIzq(nn);
            }else{
                (this.pListaD.getRefIzq()).setRefDer(nn);
                nn.setRefIzq(this.pListaD.getRefIzq());
                nn.setRefDer(this.pListaD);
                this.pListaD.setRefIzq(nn);
            }
        }
    }
    
    public boolean moverDer(){
        if(this.pListaD.getRefDer() != null){
            this.pListaD = this.pListaD.getRefDer();
            return true;
        }else{
            return false;
        }
    }
    
    public boolean moverIzq(){
        if(this.pListaD.getRefIzq() != null){
            this.pListaD = this.pListaD.getRefIzq();
            return true;
        }else{
            return false;
        }
    }
    
    public void irPrimero(){
        while(moverIzq()){
            ;
        }
    }
    
    public void irUltimo(){
        while(moverDer()){
            ;
        }
    }
  public boolean estaVacia(){
        return this.pListaD == null ? true : false;
    }
    public void Eliminar(){
        if(!estaVacia()){
            if(!moverIzq()){
                if(moverDer()){
                    this.pListaD.setRefIzq(null);
                }else this.pListaD = null;
            }else{
                this.pListaD.setRefDer(this.pListaD.getRefDer().getRefDer());
            }
        }
    }
    public int cantNodos(){
        int x=0;
        if(!estaVacia()){
            x=1;
            nodoLD b = this.pListaD;
            while(b.getRefIzq()!=null){
                b=b.getRefIzq();
            }
            while(b.getRefDer()!=null){
                x++;
                b=b.getRefDer();
            }
        }
        return x;
    }
}
