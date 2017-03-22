
package protocolocomedodisp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class ProtocoloComEdoDisp {
    static int c=1;
    
    public static void main(String[] args) {
        ArrayList<String> leercadenasderchivoactual= new ArrayList();
        ArrayList<String> cadenasprocesadas = new ArrayList();

        //implementación del autómata para el protocolo
        PrintWriter hiscadenasleidas=AbreArchivo("Historialdecadenasgeneradas.txt");
        PrintWriter hiscadenasaceptadas=AbreArchivo("Historialdecadenasaceptadas.txt");
        do {
        System.out.println("Status: ON");
        GeneraArchivo(); //guardadas para enviarlas al historial de todas las iteraciones on us cadenas 
        leercadenasderchivoactual=LeerArchivo();
        ImprimeenArchivo(hiscadenasleidas, leercadenasderchivoactual);
        TiempodeEspera();
        cadenasprocesadas=Evaluar(leercadenasderchivoactual);
            ImprimeenArchivo(hiscadenasaceptadas, cadenasprocesadas);
            c++;
        }
        while (EstadodelDisp()==1);
        CierraArchivo(hiscadenasleidas);
        CierraArchivo(hiscadenasaceptadas);
        DibujarAutomata A3 = new DibujarAutomata();
    }
    
    public static void TiempodeEspera ()
    {
        int segundos=1;
        try {
            System.out.println("Waiting...");
            Thread.sleep(segundos*1000);
        }
        catch (Exception e)
        {
            System.out.println("Fallo " +e.getMessage());
        }
        
         System.out.println("Finished");
    }
    
    public static int EstadodelDisp (){
        Random r = new Random();
        int edo;
        edo=r.nextInt();
        edo=Math.abs(edo%2);
        return edo;
    }
    
    public static ArrayList<String> LeerArchivo()
    {
        System.out.println("Sending");
        ArrayList<String> retorno=new ArrayList();
        try
        {
            FileInputStream tex = new FileInputStream("AGenerado.txt");
            
            DataInputStream entrada = new DataInputStream(tex);
            
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            
            String linea;
            
            while ((linea = buffer.readLine())!= null)
            {
                retorno.add(linea);
            }
        }
        catch (Exception e)
        {
            System.out.println("Error al leer el archivo"+e.getMessage());
        }
        
        return retorno;
    }
    
    public static ArrayList<String> Evaluar (ArrayList<String> cads){
        int tam,i; 
       ArrayList<String> ret=new ArrayList();
       
        tam=cads.size();
        for (i=0;i<tam;i++)
        {
           
                    if (Automata(cads.get(i))==0)
                    {
                        ret.add(cads.get(i));
                    }
        }
        return ret;
       
    }
    
    public static void GeneraArchivo ( )
    {
       // ArrayList<String> cadenas= new ArrayList();
        int contador,totaldecadenas;
        String nombre="AGenerado.txt";
        String cadena;
        totaldecadenas=50;
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
      
        try {
            f=new File(nombre);
            w=new FileWriter (f);
            bw=new BufferedWriter(w);
            wr=new PrintWriter(bw);
            
                for(contador=0;contador<totaldecadenas;contador++){
                    cadena=GenerarCadenas();
                    //cadenas.add(cadena);
                    wr.println(cadena);
                }
        wr.close();
        bw.close();
            
        }catch (Exception e){
            System.out.println("Error en el archivo");
        }
        
        System.out.println("Ready");
    }
    
    public static String GenerarCadenas ()
    {
        Random r = new Random();
        int i,caracter,tam;
        String Cad="";
        
        tam=16; //Genera cadenas de 4 bytes 
        
        for(i=0;i<tam;i++)
        {
            caracter=r.nextInt();
            caracter=Math.abs(caracter%2);
            Cad+=String.valueOf(caracter);
                
        }
        
        return Cad;
        
    }
    
    
    
     public static int Automata(String CU)
    {
        int t = CU.length();
        int j=1,e=-1;

        if (CU.charAt(0)=='1'){
            e=1;
        }
       if (CU.charAt(0)=='0'){
            e=2;
       }
        
        while (j<t && (CU.charAt(j)=='1' || CU.charAt(j)=='0') )
        {
            switch (e)
            {
                case 0:
                   
                        if (CU.charAt(j)=='1'){
                            e=1;
                        }
                        else{
                            e=2;
                        }
                   
                       j++;
                       break;
                case 1:
                    if (CU.charAt(j)=='1')
                    {
                        e=0;
                    }
                    else{
                        e=3;
                    }
                    j++;
                    break;
                case 2:
                    if (CU.charAt(j)=='1')
                    {
                        e=3;
                    }
                    else
                    {
                        e=0;
                    }
                    j++;
                    break;
                case 3:
                    if (CU.charAt(j)=='1')
                    {
                        e=2;
                    }
                    else{
                        e=1;
                    }
                    j++;
                    break;
                default:
                    System.out.println("Error en la cadena");
                    break;
            }
        }
     return e;   
    }
    
     
     public static PrintWriter AbreArchivo(String nombre)
     {
         
        File f;
        FileWriter fw;
        BufferedWriter bw;
        PrintWriter wr=null;
        
        try{
            f=new File(nombre);
            fw=new FileWriter (f);
            bw=new BufferedWriter(fw);
            wr=new PrintWriter(bw);
        
        }catch (Exception e){System.out.println("Se proujo el siguiente error"+e.getMessage());}
        return wr;
     }
     
     public static void ImprimeenArchivo(PrintWriter wr,ArrayList<String> cadenas) {
         
         int i,t=cadenas.size();
         wr.println("\nIteración número "+c+"\n");
         for(i=0;i<t;i++)
         {
             wr.println(cadenas.get(i));
         }
         
    }
     
     public static void CierraArchivo(PrintWriter wr)
     {
         wr.close();
     }
}
