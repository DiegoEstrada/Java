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
public class ooo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner data = new Scanner(System.in);
        int op, cont,contador=0, nume;
        int datos [];
        System.out.println("Introduce el numero de digitos que ingresaras:");
        op=data.nextInt();
        datos = new int [op];
        for (cont=0; cont<op ;cont++)
        {
            System.out.println("Por favor digita los numeros ");
            datos[cont]=data.nextInt();
        }
        System.out.println("Ingresa el numero que deseas buscar en el arreglo que llenaste anteriormente:");
        nume=data.nextInt();
        for (cont=0; cont<op;cont++)
        {
                if (datos[cont]==nume)
                    contador++;
        }
        if (contador !=0)
        {
            System.out.println("Introduciste el valor "+nume+"  " +contador+" veces");
        }
        else
            System.out.println("Jamas introduciste el valor "+nume);
    }
    
}
