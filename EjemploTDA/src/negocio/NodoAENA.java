/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class NodoAENA {
    private int cod;
    private ArrayList<NodoAENA> listRef;
    
    public NodoAENA(int cod){
        this.cod = cod; // Matriz o Vector de 3 x 3
        this.listRef = new ArrayList<NodoAENA>();
    }
}
