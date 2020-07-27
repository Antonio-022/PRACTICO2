/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pArbol;
import negocio.nodoAB;
/**
 *
 * @author pc
 */
public class clsArbol {
    private nodoAB raiz;
    public clsArbol(){
        this.raiz = null;
    }
    
    public nodoAB getRaiz(){
        return this.raiz;
    }
    
    public void insertar(int cod){
        nodoAB nn = new nodoAB(cod);
        if(this.raiz == null){
            this.raiz = nn;
        }else{
            insertar(this.raiz, nn);
        }
    }
    
    private void insertar(nodoAB Raux, nodoAB nn){
        if(nn.getCod() > Raux.getCod()){
            if(Raux.getHijoDer() == null){
                Raux.setHijoDer(nn);
            }else{
                insertar(Raux.getHijoDer(), nn);
            }
        }else{
            if(Raux.getHijoIzq() == null){
                Raux.setHijoIzq(nn);
            }else{
                insertar(Raux.getHijoIzq(), nn);
            }
        }
    }
    
    public void inorden(){
        inorden(this.raiz);
    }
    
    private void inorden(nodoAB nn){
        if(nn.getHijoIzq() != null){
            inorden(nn.getHijoIzq());
        }
        System.out.println(nn.getCod());
        if(nn.getHijoDer() != null){
            inorden(nn.getHijoDer());
        }
    }
    public boolean Eliminar(int n){
        if(this.raiz.getCod()== n){
            if(raiz.getHijoDer()!=null && raiz.getHijoIzq()!=null){
                nodoAB aux = raiz.getHijoDer(), v = raiz.getHijoIzq();
                while(v.getHijoDer()!=null){ v=v.getHijoDer(); }
                v.setHijoDer(aux);
                raiz=raiz.getHijoIzq();
            }else if(raiz.getHijoDer()== null){  raiz=raiz.getHijoIzq();
            }else if(raiz.getHijoIzq()==null){    raiz=raiz.getHijoDer();
            }else raiz=null;
            return true;
        }
        if (n>raiz.getCod() && raiz.getHijoDer()!= null){
            return Encontrar(raiz, raiz.getHijoDer(), n);
        }else if(raiz.getHijoIzq()!= null){
            return Encontrar(raiz, raiz.getHijoIzq(), n);
        }else return false;
    }
    public boolean Encontrar(nodoAB padre,nodoAB X,int n){
        if(X.getCod()== n){
            boolean d = padre.getHijoDer()==X?true:false;
            Eliminar(padre, X, n, d);
            return true;
        }
        padre=X;
        if (n>X.getCod() && X.getHijoDer()!= null){
            return Encontrar(padre, X.getHijoDer(), n);
        }else if(X.getHijoIzq()!= null){
            return Encontrar(padre, X.getHijoIzq(), n);
        }else return false;
    }
    public void Eliminar(nodoAB padre, nodoAB X, int n,boolean bandera){
        if(X.getHijoDer()!=null && X.getHijoIzq()!=null){
            nodoAB aux = X.getHijoDer();
            nodoAB v=X.getHijoIzq();
            while(v.getHijoDer()!=null){ v=v.getHijoDer(); }
            v.setHijoDer(aux);
            
            if(bandera){
                padre.setHijoDer(X.getHijoIzq());
            }else padre.setHijoIzq(X.getHijoIzq()); 
            
        }else if(X.getHijoDer()!=null){ 
            if(bandera){
                padre.setHijoDer(X.getHijoDer());
            }else padre.setHijoIzq(X.getHijoDer()); 
            
        }else if(X.getHijoIzq()!=null){
            if(bandera){
                padre.setHijoDer(X.getHijoIzq());
            }else padre.setHijoIzq(X.getHijoIzq()); 
            
        }else{
            if(bandera){
                padre.setHijoDer(null); 
            }else padre.setHijoIzq(null); 
        }
    }
    
}
