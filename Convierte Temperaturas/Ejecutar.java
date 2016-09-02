
package practica.pkg1;

import javax.swing.JFrame;



public class Ejecutar {
     public static void main(String[] args) {
       Practica1 ventana  = new Practica1();
       ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       ventana.setSize(650,300);
       ventana.setTitle("Convierte temperaturas");
       ventana.setVisible(true);
       
    }
}
