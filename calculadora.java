/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author Mirka
 */
import java.util.*;
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double n1,n2,resop;
        int op, resp;
        
        Scanner dato = new Scanner(System.in);
        Operaciones res = new Operaciones();
        
        do{
            System.out.print("\n\n");
            System.out.println("Indica los valores: ");
            n1=dato.nextDouble();
            n2=dato.nextDouble();
        
            System.out.print("\n\n");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.print("\n");
            System.out.print("Indica la opcion: \t");
            op=dato.nextInt();
        
            System.out.print("\n\n");
            
            switch(op)
            {
              case 1:
                res.Suma(n1,n2);
              break;
                
              case 2:
                res.Resta(n1,n2);
              break;
            
              case 3:
                res.Mult(n1,n2);
              break;
                    
              case 4:
                res.Divi(n1,n2);
              break;
                
            }
           
            System.out.print("\n\n");
            System.out.println("Deseas realizar otra operacion:   1.SI  o  2.NO");
            resp=dato.nextInt();
        
        }while(resp==1);
        
        
        
        
        
        
        
        
        
       


    }
    
}
