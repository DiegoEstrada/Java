package protocolocomedodisp;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;


public class DibujarAutomata extends JFrame {

    public DibujarAutomata()  {
        this.setTitle("Protocolo ");
        this.setLocation(510,160);
        this.setSize(650,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        //flechas de data in y act, sentidos de las flechas
        g.drawOval(180, 205, 300, 150);
        g.fillOval(446, 230, 7, 7);
        g.fillOval(206, 322,7, 7);
        
        g.setColor(Color.red);
        //estados ready sending
        g.fillOval(126, 230, 128, 95);
        g.fillOval(418, 230, 128, 95);
        g.fillRect(300, 300, 60, 60);
        
        g.setColor(Color.black);
        //flecha start y sentido de la flecha
        g.drawLine(50, 272, 123, 272);
        g.fillOval(122, 270, 7, 7);
        
        //flecha tiem out y sentido de la flecha
        g.drawArc(500, 225, 100, 100, 135, -263);
        g.fillOval(518, 313, 7, 7);
        
        g.setColor(Color.blue);
        
        //etiquetas a las flechas
        
        g.drawString("time out", 550, 215);
        g.drawString("act", 320, 375);
        g.drawString("Paridad", 310, 333);
        g.drawString("data in", 315, 190);
        g.drawString("Start", 76,260);
        
        g.setColor(Color.black);
        //nombres de los estados
        g.drawString("Ready", 170, 282);
        g.drawString("Sending", 460, 282);
        
    }
}
