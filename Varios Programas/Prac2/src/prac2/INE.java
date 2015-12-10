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
public class INE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner dato = new Scanner(System.in);
       int e,c,m=0,h=0;
       String o;
       do {
           System.out.print("Indica tu sexo. Si eres mujer  escribe M si eres hombre escribe H\n");
           o=dato.next();
          if (o=="M")
              m++;
                      else
              if (o=="H")
                  h++;
              else 
                  System.out.print("\nPor favor solo ingresa la letra que corresponde a tu sexo en maysucula\n");
       System.out.print("\n Escribe tu edad:\n");
       e=dato.nextInt();
       if (e<18)
           System.out.print("Eres menor de edad, no puedes participar :/:\n");
       else 
           if (e>=18 && e<=21)
               System.out.print("Eres un Joven\n");
           else 
               if (e>=22 && e<=40)
                   System.out.print("Eres un adulto joven \n");
               else 
                   if (e>=41 && e<=60)
                       System.out.print("Eres un adulto \n");
                   else 
                       if (e>=61 && e<=80)
                           System.out.print("Eres una adulto mayor\n");
       else
                     System.out.print("Eres una persona de la tercera edad\n");
         System.out.print("\n Hay otra persona formada detras de ti ?\n Si es asi pon 1, de lo contrario 0");
         c=dato.nextInt();
       }  
       while(c==1);
       System.out.print("El numero de mujeres que participaron fue: "+ m+"El numero de hombres que participaron fue:"+h);
    }
    
}