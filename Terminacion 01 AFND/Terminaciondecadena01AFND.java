
package terminaciondecadena01afnd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Terminaciondecadena01AFND {
    public static ArrayList<String> caracter = new ArrayList();
    static String cadenadecyu="";
     
    

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op;
        System.out.println("Este programa determina si una cadena termina con los caracteres 01 (forma x01)");
        System.out.println("Ingresa el numero que corresponda a la opcion que deseas ejecutar ");
        System.out.println("1. Modo manual");
        System.out.println("2. Modo automatico");
        System.out.println("3. Visualizar autómata");
        op=teclado.nextInt();
        
        Modo(op);
        
    }
    
    public static void Modo (int op)
    {
       PrintWriter wr=AbrirArchivo();
       ArrayList estados = new ArrayList();
        switch (op)
        {
            case 1: 
              
                BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
                Scanner entrada = new Scanner (System.in);
                int rep;
                do {
                    
                System.out.println("Ingresa la cadena de ceros y unos exclusivamente");
                
                try {
                cadenadecyu=br.readLine();
                } catch (IOException ex) {
                    System.out.println("Error al leer la cadena "+ex.getMessage());
                }
                    
                estados=GenerarTabla(cadenadecyu);
                
                if (TienelaForma(estados))
                        System.out.println("La cadena termina en 01");
                else
                        System.out.println("La cadena no termina en 01");
               
                    System.out.println("Deseas volver a ejecutar el programa?");
                    System.out.println("Ingresa 1 para volver a ejecutarlo");
                    System.out.println("Ingresa 0 para sailr");
                    rep=entrada.nextInt();
                    ImprimirEstados(estados,wr);
                } while (rep==1);
                 CerrarArchivo(wr);
                
                System.out.println("El recorrido de los estados se encuentra en el archivo Estados.txt");
            break;
            
            case 2: 
                do {
                    cadenadecyu=GeneraCadenaAleatoria();
                    estados=GenerarTabla(cadenadecyu);
                    
                    if (TienelaForma(estados))
                        System.out.println("La cadena "+ cadenadecyu+ " termina en 01");
                    else
                        System.out.println("La cadena " +cadenadecyu+ " no termina en 01");
                    ImprimirEstados(estados,wr);
                } while (repetir()==1);
                
                CerrarArchivo(wr);
                System.out.println("El recorrido de los estados se encuentra en el archivo Estados.txt");
                break;
            case 3:
                DibujarAutomata A4 = new DibujarAutomata();
                break;
            default:
                System.out.println("Ingresa solo nuemros del uno al tres");
                break;
        }
    }
    
    
    public static ArrayList GenerarTabla (String cerosunos)
    {
        ArrayList<String> procesos = new ArrayList();
        String caux;
        String pasoaneterior;
        String pasoactual;
        int tam;
        int tpasoanterior;
        int i=0,j;
        tam=cerosunos.length(); 
        caux=Automata(48, cerosunos.charAt(i)); 
        procesos.add(AgrgaQs(caux)); //agrego el primer paso
        pasoaneterior=caux;
        for (i=1;i<tam;i++)
        {
            pasoactual="";
            tpasoanterior=pasoaneterior.length();
            for (j=0;j<tpasoanterior;j++)
            {
                pasoactual+=Automata((pasoaneterior.charAt(j)), cerosunos.charAt(i));
            }
            procesos.add(AgrgaQs(pasoactual));
            pasoaneterior=pasoactual;

        }
        return procesos;
    }
    
   
    
    public static int repetir ()
    {
        Random r = new Random();
        int desicion;
        desicion=r.nextInt();
        desicion=Math.abs(desicion%2);
        return desicion;
    }
    
    public static void ImprimirEstados (ArrayList tablaestados,PrintWriter wr)
    {
        int i,t = tablaestados.size();
        
        String caracterleido;
        
       
      
       
            wr.println("La cadena "+ cadenadecyu +" presenta las siguientes transiciones:");
                for(i=0;i<t;i++){
                 
                 caracterleido=(String) tablaestados.get(i);
                 wr.println("caracter "+cadenadecyu.charAt(i)+"-> "+ caracterleido);
                 
                }
                
                if (TienelaForma(tablaestados))
               wr.println("Cadena Valida");
                else
                    wr.println("Cadena Invalida");
        
        
        
        
        
        
    }
    
    public static String GeneraCadenaAleatoria()
    {
       Random r = new Random();
       int CoU, cantidad,i;
       String CerosyUnos="";
      
       cantidad=r.nextInt();
       cantidad=cantidad%1000;
       
       while (cantidad==0){  // condicion para que no genere la cadena "" y se genere un problema al procesar esta cadena
            cantidad=r.nextInt();
            cantidad=cantidad%1000;
       }
       cantidad=Math.abs(cantidad);
        
       
        for(i=0;i<cantidad;i++)
        {
            CoU=r.nextInt();
            CoU=CoU%2;
            CerosyUnos=CerosyUnos+(Integer.toString(Math.abs(CoU)));
        }
        
       return CerosyUnos;
    }
    
    
    public static boolean TienelaForma (ArrayList procesos)
    {
        boolean es = false;
        String ultimocracter;
        int tprocesos, tcadena,i,j;
        
        tprocesos=procesos.size();
        
        ultimocracter=(String) procesos.get(tprocesos-1);
        
        tcadena=ultimocracter.length();
        
        for (i=0;i<tcadena;i++)
        {
            if (ultimocracter.charAt(i)==50){
                es=true;
                break;
            }
        }
        return es;
    }
    
    public static String Automata (int estado, char caracter)
    {
        String retorno= "No entro " ;
        switch (estado)
        {
            case 48:
                    switch (caracter)
                    {
                        case '0':
                            retorno="01";
                        break;
                        case '1':
                            retorno="0";
                        break;
                        default:
                            retorno="X";
                        break;    
                    }
            break;
            
            case 49: 
                    if (caracter=='1')
                            retorno= "2";
                    else 
                            retorno="X";
            break;
            
            case 50:
                    if (caracter>0)
                        retorno = "X";
            break;
            
            case 88:
                       retorno= "X";
            break;
                
            default:
                        retorno = "N";
            break;         
        }
        return retorno;
    }
    
    public static String AgrgaQs (String edos)
    {
        int i,tam=edos.length();
        String ret="";
        
        for (i=0;i<tam;i++)
        {
            if (edos.charAt(i)== '0' || edos.charAt(i)=='1'  || edos.charAt(i)=='2')
                ret+="Q"+edos.charAt(i)+",";
            else
                ret+=edos.charAt(i)+",";
        }
        ret=ret.substring(0, ret.length()-1);
        return ret;
               
    }
    
    public static PrintWriter AbrirArchivo()
    {
        String nombre="Estados.txt";
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr=null;
 try {
            f=new File(nombre);
            w=new FileWriter (f);
            bw=new BufferedWriter(w);
            wr=new PrintWriter(bw);
    } catch (IOException io){io.getMessage();}
            return wr;
    }
    
    public static void CerrarArchivo(PrintWriter wr)
    {
        wr.close();
    }
   
    
} 