
package practica.pkg1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Practica1 extends JFrame implements ActionListener{

    private JPanel botones,resultado,textbox;
    private JTextField entrada1;
    private JButton Klv;
    private JButton Cel;
    private JLabel salida, instrucciones;
    
    
     public Practica1 ()
    {
        this.setLayout(new FlowLayout());
        botones=new JPanel();
        resultado=new JPanel();
        textbox=new JPanel();
        //botones.setLayout(new BorderLayout());
        //resultado.setLayout(new FlowLayout());
        //textbox.setLayout(new FlowLayout());
        entrada1=new JTextField();
        Klv=new JButton("Kelvin-Centigrados");
        Cel=new JButton("Centigrados-Kelvin");
        salida=new JLabel();
        instrucciones=new JLabel();
        salida.setText("La temperatura es:");
        instrucciones.setText("Introduce un numero en y presiona un boton para determinar la conversion de su temperatura:");
        entrada1.setBounds(100, 100, 500, 500);
        botones.add(Klv);
        botones.add(Cel);
        textbox.add(instrucciones);
        textbox.add(entrada1);
        resultado.add(salida);
        
        this.add(textbox);
        this.add(botones);
        this.add(resultado);
        
        
        Klv.addActionListener(this);
        Cel.addActionListener(this);
      
       
    }
    
    public void actionPerformed(ActionEvent e) {
       
       
        String t = entrada1.getText();
        float temp = Float.parseFloat(t);
        JButton op =(JButton)e.getSource();
        
        if(op==Klv)
        
            salida.setText(t+" grados Kelvin son " +String.valueOf(KelvinCentigrados(temp))+" grados Centigrados");
        
        else
        
            salida.setText(t+" grados Centigrados son " +String.valueOf(CentigradosKelvin(temp))+" grados Kelvin");
        
    }
    
    public float CentigradosKelvin (float g)
    {
        float centigrados;
        return centigrados=g+232;
        
    }
    public float KelvinCentigrados(float g)
    {
        float kelvin;
        return kelvin=g-232;
        
    }
     
}



