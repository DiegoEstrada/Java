package juego;

import java.awt.BorderLayout;
import java.awt.Color;
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
	
	
	

public class Practica2 extends JFrame implements ActionListener{
	
	private JPanel panel , detalles;
	private JButton botones[], iniciar;
	private JLabel marcador ;
	private ImageIcon imagenes [];
	private int golpescorrectos,cont;
	
	
	public Practica2(){
		
	golpescorrectos=0;	
	
	this.setTitle("Pegale al Topo");
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLayout(new FlowLayout());
	
	panel = new JPanel();
	detalles = new JPanel();
	
	//Definiendo un Layout para que los botones del tablero aparescan en orden
	
	panel.setSize(100, 100);
	panel.setLayout(new GridLayout(4, 5));
	
	botones=new JButton[50];
	
	//Definiendo el arreglo de donde se obtendran las imágenes del juego
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
	
	
	
	//Registrando a los botones en el evento
	
	int c;
	iniciar.addActionListener(this);
	for(c=0;c<20;c++)
		botones[c].addActionListener(this);
	
	}
	

	
	public  void GenerarTablero()
	{
		Random r = new Random();
		int c,imagenporelegir;
		
		
		//Agregando los botones del tablero al JPanel
		for(c=0;c<20;c++)
		{
			imagenporelegir=Math.abs(r.nextInt()%5);
			
				if (imagenporelegir==0){
					botones[c]= new JButton ((imagenes[0]));
					
				}
				else
					botones[c]= new JButton ((imagenes[2]));
			panel.add(botones[c]);
		}
		
		
	}
	public void actionPerformed(ActionEvent e) {
		JButton op =(JButton)e.getSource();
		int cont,imagenporelegir;
		Random r = new Random();

		if (op.getIcon()==imagenes[0])
		{
			op.setIcon(imagenes[1]);
			op.setEnabled(false);
			golpescorrectos++;
		}
		else 
		{
			if (op==iniciar)
			{
				golpescorrectos=0;
				for(cont=0;cont<20;cont++)
				{
					botones[cont].setEnabled(true);
					imagenporelegir=Math.abs(r.nextInt()%5);
					
						if (imagenporelegir==0){
							botones[cont].setIcon(imagenes[0]);
							
						}
						else
							botones[cont].setIcon(imagenes[2]);
				
				}
			
			}
		
		}	
		marcador.setText("Has golpeado: " +golpescorrectos+" topos");
	}
}
