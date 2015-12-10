/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prac2;

/**
 *
 * @author cecyt-8
 */
import java.util.*;
public class java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado =new Scanner(System.in);
        int a,b,c ;
        System.out.print("Este programa calculara el numero mayor de tres numeros\n Introduce el primer valor \n");
        a=teclado.nextInt();
        System.out.print("Ingresa el segundo valor\n");
        b=teclado.nextInt();
        System.out.print("Ingresa el tercer valor\n");
        c=teclado.nextInt();
        if (a>b && a>c )
            System.out.print("El numero mayor es " +a);
        else 
            if (b>a && b>c)
                System.out.print("El numero mayor es " +b);
        else
                if (c>a && c>b)
                    System.out.print("El numero mayor es " +c);
                
         
    }
    
}
