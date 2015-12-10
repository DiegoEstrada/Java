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
public class OpBasic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner N= new Scanner(System.in);
        System.out.print("Este programa realiza las operaciones aritmeticas simples (suma, resta, multiplicacion y division\n");
        int n1,n2,r1,r2,r3,r4, u;
        do 
        {
        System.out.print("Introduce el primer valor\n" );
        n1= N.nextInt();
        System.out.print("Introduce el segundo valor\n" );
        n2= N.nextInt();
        r1=n1+n2;
        r2=n1-n2;
        r3=n1*n2;
        r4=n1/n2;
        System.out.print("\nLos resultados para la suma son: " +r1+ "\n Para la resta son: " +r2+ "\nPara la multiplicacion son: " +r3+ "\n Para la division son: " +r4 );
        System.out.print("\n ¿Deseas volver a correr el programa?\n Introduce 1 si es asi , sino introduce un 2\n"  );
        u=N.nextInt();
        }
        while (u==1);
    }
    
}
