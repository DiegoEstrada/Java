package ticker;

import java.awt.FlowLayout;
import java.util.*;
import javax.swing.*;


public class Tick extends JFrame implements Runnable  {
	
	String papirrin="ABCDEFGHIJKLM";
	Thread cambiar;
	JFrame JF1 ;
	JPanel JP1;
	JLabel texto;
	
	
	
	public Tick()
	{
		JF1= new JFrame ();
		this.setTitle("Papirrin1");
		this.setSize(400, 400);
		this.setExtendedState(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		texto= new JLabel("Hola a todos");
		this.add(texto);
				
		
		cambiar= new Thread(this);
		cambiar.start();
		
		this.setVisible(true);
	}
	
	public void run() {
		int tam= texto.getText().length();
		int cont;
		String t = texto.getText();
		
		while(true)
		{
			try	{
				
				for(cont=0;cont<tam;cont++)
				{
					if (cont+1==tam)
					{
						texto.setText("");
					}
					cambiar.sleep(500);
					texto.setText(""+t.charAt(cont));
				}
			}catch(Exception e) {e.getMessage();}
		}
		
		
		
	}

}
