import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;


import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


	
	
	public class Inicio extends JFrame implements ActionListener {
		
		private static final long serialVersionUID = 1L;
		
		protected ImageIcon logo; 
		protected JLabel logo2;
		public Inicio () {
			String imagenFondo = "fondoo.jpg";
			Image fondo = new ImageIcon(imagenFondo).getImage();

			setContentPane(new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					this.setBackground(Color.white);
					g.drawImage(fondo, 0, 220, getWidth(), getHeight(), this);
				}
			});
			
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setExtendedState(MAXIMIZED_BOTH);
			this.setLayout(null);
			
			System.out.println("Existo!!");
		
			this.setVisible(true);
			
			logo= new ImageIcon ("Logo_BOOK4U-removebg-preview.png");
			logo2= new JLabel(); 
			
			logo2.setIcon(logo);
			logo2.setBounds(695, 0, 420, 270);
			this.add(logo2);
		}
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

