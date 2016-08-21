/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfabeto;

/**
 *
 * @author Diego EG
 */
import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class Alfabeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op;
        //GenerarUniversoConsola(n);
        //GenerarUniversoArchivo(n);
        GenerarUniversoConsola(GeneraAleatorio(3));
        
            System.out.println("\nDeseas volver a ejecutar el programa\nSi Ingresa 1\nNo Ingresa 0");
            op=teclado.nextInt();
            if (op==1)
            Modo();
            else
            System.exit(0);
    }
    
    
    public static String CDBinario (int naconvertir,int n)
    {
       int longitud,cerosporagregar;
       String binario =Integer.toBinaryString(naconvertir); //convirtiendo a binario el numero del arguemnto
       longitud=binario.length(); //calculando ela longitud del binario(texto)
       cerosporagregar=n-longitud; //determinando la cantidad de ceros que necesita ese numero
       binario=AgregaCero(cerosporagregar,binario); //Completando los numeros de la combinacion que faltaban
       return binario;
    }
    public static int Cardinalidad (int n)
    {
        return (int) Math.pow(2, n);
    }
    
    public static String AgregaCero( int cerosporagregar, String binario)
    {
        String cero="0",aux="";
        if(cerosporagregar==0)
            return binario+",";
        else 
        {
            while(cerosporagregar!=0)
            {
             aux=(aux+cero);
             cerosporagregar--;
            }
            return (aux+binario+",");
        }
    }
    public static void GenerarUniversoConsola (int n)
    {
        int k,contador;
        
        k=Cardinalidad(n);
        System.out.print("{");
        for(contador=0;contador<k;contador++)
        {
            System.out.print(CDBinario(contador,n)); 
        }
        System.out.print("e}");
     
       
    }
    public static void GenerarUniversoArchivo (int n)
    {
        int k,contador;
        String nombre="alfabeto.txt";
        k=Cardinalidad(n);
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
      
        try {
            f=new File(nombre);
            w=new FileWriter (f);
            bw=new BufferedWriter(w);
            wr=new PrintWriter(bw);
            
                for(contador=0;contador<k;contador++){
                    if (contador==0)
                    wr.write("{");
                wr.append(CDBinario(contador,n));
                    if (contador==k-1)
                        wr.append("e}");
                }
        wr.close();
        bw.close();
            
        }catch (Exception e){
            System.out.println("Error en el archivo");
        }
    }
    
    public static int GeneraAleatorio(int r)
    {
       Random rn=new Random();
       int ra;
       ra=rn.nextInt();
       ra=ra%r;
       if (r==2)
       return Math.abs(ra);
       else 
           return Math.abs(ra)+1;
    }
    public static void Modo()
    {
        Scanner leer=new Scanner(System.in);
        int md,n=5,op=1;
        /*n es el limite para las combinaciones aleatorias y tmabien las combbinacines manauales
        md es manual o aleatorio
        op es la variable que permite saber si se repite el programa o no, dado el aleatorio
        modo automatico=0   repetir=1
        modo manual=1       salir=2
        */
        System.out.println("Modo manual ingresa 1\nModo automatico ingresa 0\n");
        md=leer.nextInt();
        
        if(md==0)
        {
           do{
            GenerarUniversoArchivo(GeneraAleatorio(n));
            System.out.println("Las combinaciones se encuentran en el archivo alfabeto.txt");
           }
           while (GeneraAleatorio(2)!=0);
           //System.exit(0);
        }
        else
        {
            do {
                System.out.println("Ingresa los elemento que deseas combinar de un alfabeto de dos simbolos");
                n=leer.nextInt();
                GenerarUniversoArchivo(n);
                System.out.println("Las combinaciones se encuentran en el archivo alfabeto.txt\n\n");
                System.out.println("\nDeseas volver a ejecutar el programa\nSi Ingresa 1\nNo Ingresa 0");
                op=leer.nextInt();
                }
               while (op==1);
        }
    }
}
