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
public class parimpar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO 
        int var=0; 
        int par=0, impar=0;
        while (var<=100)
        {
          if (var%2==0)
           par+=var;           
            else 
            impar+=var;
            var++;
        }
        System.out.print("La suma de los numeros pares son: "+par);
        System.out.print("\n La suma de los numeros impares son: " +impar+ "\n");
    }
    
}
