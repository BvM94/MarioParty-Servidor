package minijuegos.encuentraLaBola;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class JencuentreLaBola extends JFrame {

	private JPanel contentPane;
private EncuentreLaBola juego;
private JLabel lblJugActual;



	/**
	 * Create the frame.
	 */
	public JencuentreLaBola(EncuentreLaBola juego) {
	
	this.juego=juego;
	
	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnA = new JRadioButton("A");
		rdbtnA.setBounds(48, 225, 39, 23);
		contentPane.add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		rdbtnB.setBounds(195, 225, 39, 23);
		contentPane.add(rdbtnB);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		rdbtnC.setBounds(334, 225, 39, 23);
		contentPane.add(rdbtnC);
		
		JRadioButton rdbtnD = new JRadioButton("D");
		rdbtnD.setBounds(472, 221, 39, 30);
		contentPane.add(rdbtnD);
		
		JRadioButton rdbtnE = new JRadioButton("E");
		rdbtnE.setBounds(616, 225, 39, 23);
		contentPane.add(rdbtnE);
		
		JButton btnElegir = new JButton("Elegir");
		
		btnElegir.setBounds(278, 321, 127, 30);
		contentPane.add(btnElegir);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnA);
		group.add(rdbtnB);
		group.add(rdbtnC);
		group.add(rdbtnD);
		group.add(rdbtnE);
		
		JLabel lblvaso = new JLabel("");
		
		
		lblvaso.setBounds(10, 38, 111, 165);
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("copa.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(lblvaso.getWidth(), lblvaso.getHeight(),
		        Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		lblvaso.setIcon(imageIcon);
		contentPane.add(lblvaso);
		
		JLabel lblVaso2 = new JLabel("");
		lblVaso2.setIcon(imageIcon);
		lblVaso2.setBounds(157, 38, 111, 165);
		contentPane.add(lblVaso2);
		
		JLabel lblVaso3 = new JLabel("");
		lblVaso3.setIcon(imageIcon);
		lblVaso3.setBounds(294, 38, 111, 165);
		contentPane.add(lblVaso3);
		
		JLabel lblVaso4 = new JLabel("");
		lblVaso4.setIcon(imageIcon);
		lblVaso4.setBounds(436, 38, 111, 165);
		contentPane.add(lblVaso4);
		
		JLabel lblVaso5 = new JLabel("");
		lblVaso5.setIcon(imageIcon);
		lblVaso5.setBounds(557, 38, 111, 165);
		contentPane.add(lblVaso5);
		
		JLabel lblJugador = new JLabel("Jugador");
		lblJugador.setBounds(21, 11, 66, 14);
		contentPane.add(lblJugador);
		
		 lblJugActual = new JLabel("");
		lblJugActual.setBounds(117, 11, 127, 14);
		contentPane.add(lblJugActual);
		
		cargarJugador();
		
		
		
		btnElegir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				Enumeration<AbstractButton> allRadioButton=group.getElements();  
		        while(allRadioButton.hasMoreElements())  
		        {  
		           JRadioButton temp=(JRadioButton)allRadioButton.nextElement();  
		           if(temp.isSelected())  
		           {  
		           
		        	   switch(temp.getText()) {
		        	   case "A":
		        	   		juego.setElecciones(0);
		        		   break;
		        	   case "B":
		        	   		juego.setElecciones(1);
		        		   break;
		        	   case "C":
		        	   		juego.setElecciones(2);
		        		   break;
		        	   case "D":
		        	   		juego.setElecciones(3);
		        		   break;
		        	   case "E":
		        	   		juego.setElecciones(4);
		        		   break;  
		        	   }
		        	   
		           }  
		        }     
				
		        
		  if(juego.haySigTurno()) {
			 cargarJugador(); 
		  }else
			  btnElegir.setEnabled(false);
		
			}
		});
		

		
	}
	
	public void cargarJugador(){
		lblJugActual.setText(juego.getNombre());
	}	
	
	
	
	
	
	
	
}
