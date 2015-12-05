/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo;

/**
 *
 * @author Diego EG
 */
import java.util.*;
public class Oo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num,cont,n=0,nu=1;
        int vector [];
        Scanner inf= new Scanner (System.in);
        System.out.println("Ingresa la cantidad de numeros que ingresaras:");
        num=inf.nextInt();
        vector = new int [num];
        for (cont=0; cont<num; cont++)
                {
                    System.out.println("Ingresa un digito ");
                    vector[cont]=inf.nextInt();
                }
        if (num<=5)
        {
            for (cont=0; cont<num;cont++)
            {
                System.out.println("Ingresa los digitos ");
                n+=vector[cont];
            }
             System.out.println("La suma de los primeros cinco digitos del vector es:"+n);
        }
        else 
        {
            for (cont=0; cont<num;cont++)
            {
              if(cont<=4)
              {
                  n+=vector[cont];
              }
              else 
                  nu*=vector[cont];
            }
            System.out.println("La suma de los primeros cinco digitos del vector es:"+n);
            System.out.println("El producto del resto  vector es:"+nu);
        }
       
    }
    
}
