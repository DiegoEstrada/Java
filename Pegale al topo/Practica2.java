package juego;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
	
	

public class Practica2 extends JFrame implements ActionListener,Runnable{
	
	private JPanel panel;
	private JButton botones[], iniciar;
	private JLabel marcador ;
	private ImageIcon imagenes [];
	private int golpescorrectos;
	private Thread cambio;
	
	
	
	public Practica2(){
		
	golpescorrectos=0;
	
	cambio = new Thread(this);
	
	cambio.start();
	
	this.setTitle("Pegale al Topo");
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(new FlowLayout());
	
	panel = new JPanel();
	panel.setLayout(new GridLayout(4, 5));
	
	botones=new JButton[20];
	
	imagenes = new ImageIcon[3];
	imagenes[0]= new ImageIcon("topo.png");
	imagenes[1]= new ImageIcon("topomareado.png");
	imagenes[2]= new ImageIcon("pasto.png");
	
	iniciar = new JButton ("Comenzar Juego");
	marcador= new JLabel ("Aciertos: 0 ");
	
	GenerarTablero();
	
	this.add(panel);
	this.add(iniciar);
	this.add(marcador);
	this.setVisible(true);
	
	
	int c;
	
	iniciar.addActionListener(this);
	
	for(c=0;c<20;c++)
		botones[c].addActionListener(this);
	
	}
	
	

	
	public  void GenerarTablero()
	{
		Random r = new Random();
		int c,imagenporelegir;
		
		
		
		for(c=0;c<20;c++)
		{
			imagenporelegir=Math.abs(r.nextInt()%5);
			
				if (imagenporelegir==0)
					botones[c]= new JButton ((imagenes[0]));
				else
					botones[c]= new JButton ((imagenes[2]));
			panel.add(botones[c]);
		}
		
		
	}
	
	
	public void ReiniciarTablero()
	{
		Random r = new Random();
		int cont,imagenporelegir;
		golpescorrectos=0;
		
		
		
		for(cont=0;cont<20;cont++)
		{
			botones[cont].setEnabled(true);
			imagenporelegir=Math.abs(r.nextInt()%5);
			
				if (imagenporelegir==0)
					botones[cont].setIcon(imagenes[0]);
				else
					botones[cont].setIcon(imagenes[2]);
		}
	}
	

	
	public void actionPerformed(ActionEvent e) {
		
		JButton op =(JButton)e.getSource();
		
		if (op.getIcon()==imagenes[0])
		{
			op.setIcon(imagenes[1]);
			op.setEnabled(false);
			golpescorrectos++;
		}
		else 
			if (op==iniciar)
				ReiniciarTablero();	
			
		
		
		marcador.setText("Has golpeado: " +golpescorrectos+" topos");
	}
	
	public void run ()
	{
		int t;
		Random r = new Random();
		
		t=Math.abs(r.nextInt()%5)+1;
		while (true){
		try 
		{
			cambio.sleep(t*1000);
			ReiniciarTablero();
			cambio.start();
		}catch (Exception e){e.getMessage();}
		
		
		}
	}
}
