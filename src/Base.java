import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Base extends JFrame implements ActionListener{
	  private ImageIcon logo;
	  private JPanel base1 = new JPanel();

	  public Base(int width, int height) {
		ImageIcon image = new ImageIcon("logot.jpg");
		
		ImageIcon imagenFondo = new ImageIcon("fondoo.jpg");
        Image fondo = imagenFondo.getImage();
        logo = new ImageIcon("logo.png");
        JLabel logo2 = new JLabel();
        logo2.setIcon(logo);
        logo2.setBounds(185, -15, 300, 200);
        
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                this.setBackground(Color.WHITE);
                g.drawImage(fondo, 0, 135, getWidth(), 500, this);
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(width, height);             
        this.setLayout(null);
        this.setTitle("BOOK4YOU");
        this.setIconImage(image.getImage());
        base1.setBackground(Color.WHITE);
        base1.setBounds(10, 138, getWidth() - 35 , 500);
        
        base1.setLayout(null);
        this.add(base1);
        this.setLocationRelativeTo(null);
        this.add(logo2);
        this.setResizable(false);
        this.setVisible(true);
	}
	  public Base() {
			ImageIcon image = new ImageIcon("logot.jpg");			
			ImageIcon imagenFondo = new ImageIcon("fondoo.jpg");
	        Image fondo = imagenFondo.getImage();
	        logo = new ImageIcon("logo.png");
	        JLabel logo2 = new JLabel();
	        logo2.setIcon(logo);
	        logo2.setBounds(20, -15, 300, 200);
	        setContentPane(new JPanel() {
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                this.setBackground(Color.white);
	            }
	        });
	        this.setBackground(Color.white);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setSize(800, 175);             
	        this.setLayout(null);
	        this.setTitle("BOOK4YOU");
	        this.setIconImage(image.getImage());	     
	        this.setLocationRelativeTo(null);
	        this.add(logo2);
	        this.setResizable(false);
	        this.setVisible(true);
		}
	  
	public ImageIcon getLogo() {
		return logo;
	}
	public void setLogo(ImageIcon logo) {
		this.logo = logo;
	}
	public JPanel getBase1() {
		return base1;
	}

	public void setBase1(JPanel base1) {
		this.base1 = base1;
	}

	public void addComponent(JLabel l) {
		base1.add(l);
		l.setVisible(true);
	}
	public void addComponent(JTextField l) {
		base1.add(l);
		l.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
        
    }
}


