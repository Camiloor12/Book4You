import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Registro extends JFrame{

	public Registro() {
		 ImageIcon image = new ImageIcon("logot.jpg");
	        String imagenFondo = "fondoo.jpg";
	        Image fondo = new ImageIcon(imagenFondo).getImage();
	        setContentPane(new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                this.setBackground(Color.white);
	                g.drawImage(fondo, 0, 130, getWidth(), 400, this);
	            }
	        });
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setSize(1000, 600);
	        this.setLayout(null);
	        this.setTitle("BOOK4YOU");
	        this.setIconImage(image.getImage());
	        this.setVisible(true);
	        this.setResizable(false);
	}
}
