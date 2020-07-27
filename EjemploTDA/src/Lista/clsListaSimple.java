/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lista;
import negocio.nodo;
/**
 *
 * @author pc
 */
public class clsListaSimple {
    private nodo refPri;
    public clsListaSimple(){
        this.refPri = null;
    }

    public nodo getRefPri() {
        return refPri;
    }

    public void setRefPri(nodo refPri) {
        this.refPri = refPri;
    }

    public boolean estaVacia(){
        return this.refPri == null ? true : false;
    }
    
    // insertar Ordenado
    
    public void insertarOrdenado(int cod, String detalle){
        nodo nn = new nodo(cod, detalle);
        if(estaVacia()){
            this.refPri = nn;
        }else{
            if(cod < this.refPri.getCod()){
                nn.setRefNodo(this.refPri);
                this.refPri = nn;
            }else{
                nodo p = refPri;
                boolean sw = false;
                while(p.getRefNodo() != null){
                    if(nn.getCod() < p.getRefNodo().getCod()){
                        sw = true;
                        nn.setRefNodo(p.getRefNodo());
                        p.setRefNodo(nn);
                        break; //corte del proceso repetitivo
                    }else{
                        p = p.getRefNodo();
                    }
                }
                if(sw == false){
                    p.setRefNodo(nn);
                }
            }
        }
    }
    
    
    
    public void eleminarNodo(){
        if(!estaVacia()){
            this.refPri = this.refPri.getRefNodo();
        }
    }
    
    public void eliminarPorCod(int cod){
        if(this.refPri.getCod() == cod){
            this.refPri = this.refPri.getRefNodo();
        }else{
            nodo p = this.refPri;
            while(p.getRefNodo() != null && cod >= p.getRefNodo().getCod()){
                if(p.getRefNodo().getCod() == cod){
                    p.setRefNodo(p.getRefNodo().getRefNodo());
                    break;// solo elimina un nodo
                }else{
                    p = p.getRefNodo();
                }
            }
        }
    }
}
