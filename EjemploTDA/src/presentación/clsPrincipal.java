/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentación;

import Cola.Cola;
import Lista.clsListaSimple;
import Lista.clsListaDoble;
import Lista.clsListaCircular;
import pArbol.clsArbol;

/**
 *
 * @author pc
 */
public class clsPrincipal {
    public static void main(String[] args) {
        clsArbol obj = new clsArbol();
        obj.insertar(50);
        obj.insertar(25);
        obj.insertar(100);
        obj.insertar(10);
        obj.insertar(125);
        obj.insertar(18);
        obj.insertar(80);
        obj.insertar(150);
        obj.inorden();
        //obj.insertar(410);
    }
}
