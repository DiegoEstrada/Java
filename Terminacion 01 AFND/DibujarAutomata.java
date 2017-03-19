
package terminaciondecadena01afnd;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class DibujarAutomata extends JFrame{
    
    public DibujarAutomata()
    {
        this.setTitle("Cadena con terminacion 01");
        this.setSize(650, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void paint(Graphics g){
            
    super.paint(g);
    g.setColor(Color.red);
    //liea que une todos los estados
    g.drawLine(40, 275, 450, 275);
    //liena que regresa a q0
    g.drawArc(105, 210, 80, 100, 0,180);
    //sentidos de las flechas
    g.fillOval(103, 245, 7, 7);
    g.fillOval(89, 272, 7, 7);
    g.fillOval(249, 272, 7, 7);
    g.fillOval(409, 272, 7, 7);
    
    g.setColor(Color.black);
    g.fillOval(95, 238, 100, 75);
    g.fillOval(255, 238, 100, 75);
    g.fillOval(415, 238, 100, 75);
    
    g.setColor(Color.green); 
    g.drawString("0,1", 138, 200);
    g.drawString("Start", 55, 265);
    g.drawString("0", 219, 260);
    g.drawString("1", 380, 260);
    
    g.setColor(Color.white);
    g.drawOval(420, 243, 90, 65);
    g.drawString("Q0", 133, 280);
    g.drawString("Q1", 295, 280);
    g.drawString("Q2", 455, 280);
   
    }  
}
