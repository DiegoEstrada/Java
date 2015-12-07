/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac;

/**
 *
 * @author Diego EG
 */
import java.util.*;
public class Prac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner data = new Scanner (System.in);
        int arreglo[];
        int cont,c,a,b,res,p,op;
        System.out.println("Este programahace el promedio de un arreglo con metodos ");
        System.out.println("Ingresa la cantidad de numeros que ingresaras ");
        p = data.nextInt();
        arreglo= new int [p];
        for (cont=0;cont<p;cont++)
        {
            arreglo[cont]=data.nextInt();
        }
        promedio resultado =new promedio ();
      
        
        resultado.prom(arreglo);
    }
    
}
