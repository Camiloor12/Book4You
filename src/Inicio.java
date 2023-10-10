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
		protected ImageIcon logout = new ImageIcon("logout.png");
		protected JButton botonLogOut = new JButton(logout);
		protected ImageIcon user= new ImageIcon("user.png");
		protected JButton user2= new JButton(user);
		protected ImageIcon image;
		public Inicio () {
			ImageIcon image = new ImageIcon("logot.jpg");
			String imagenFondo = "fondoo.jpg";
			Image fondo = new ImageIcon(imagenFondo).getImage();

			setContentPane(new JPanel() {
				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					this.setBackground(Color.white);
					g.drawImage(fondo, 0, 150, getWidth(), 800, this);
				}
			});
			
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setExtendedState(MAXIMIZED_BOTH);
			this.setLayout(null);
			
			System.out.println("Existo!!");
		
			
			
			logo= new ImageIcon ("logo.png");
			logo2= new JLabel(); 
			logo2.setIcon(logo);
			logo2.setBounds(725, -150, 500, 500);
			botonLogOut.setBorderPainted(false);
			botonLogOut.setOpaque(false);
			botonLogOut.setContentAreaFilled(false);
			botonLogOut.setBounds(20, 40, 100, 100);
			botonLogOut.addActionListener(this);
			user2.setBorderPainted(false);
			user2.setOpaque(false);
			user2.setContentAreaFilled(false);
			user2.setBounds(1800,40,100,100);
			user2.addActionListener(this);
			
			this.add(logo2);
			this.add(botonLogOut);
			this.add(user2);
			this.setIconImage(image.getImage());
			this.setVisible(true);
		}
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()== botonLogOut) {
				this.dispose();
			}
			if (e.getSource()== user2) {
				this.dispose();
			}
			
		}
		
	}

