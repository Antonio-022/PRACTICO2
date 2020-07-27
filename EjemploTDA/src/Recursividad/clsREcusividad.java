/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursividad;

/**
 *
 * @author pc
 */
public class clsREcusividad {
    public clsREcusividad(){
    
    }
    public int sumaDig(int n){
        if(n <10){
            return n;
        }else{
            return sumaDig(n/10)+n%10;
        }
    }
    
    public int sumaDigDOS(int n){
        return n < 10 ? n : sumaDigDOS(n/10)+n%10;
    }
    
    public static void main(String[] a){
        clsREcusividad obj = new clsREcusividad();
        int n = obj.sumaDigDOS(45829);
        System.out.println("Res: "+n);
    }
}
