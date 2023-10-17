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

public class Base extends JFrame implements ActionListener{
	  private ImageIcon logo;
	  private JPanel base1 = new JPanel();

	  public Base() {
		ImageIcon image = new ImageIcon("logot.jpg");
		
		ImageIcon imagenFondo = new ImageIcon("fondoo.jpg");
        Image fondo = imagenFondo.getImage();
        logo = new ImageIcon("logo.png");
        JLabel logo2 = new JLabel();
        logo2.setIcon(logo);
        logo2.setBounds(300, -15, 300, 200);
        
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                this.setBackground(Color.white);
                g.drawImage(fondo, 0, 135, getWidth(), 500, this);
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 600);
             
        this.setLayout(null);
        this.setTitle("BOOK4YOU");
        this.setIconImage(image.getImage());
        base1.setBackground(Color.white);
        base1.setBounds(10, 138, getWidth() - 35 , 500);
        
        base1.setLayout(null);
        this.add(base1);
        this.add(logo2);
        this.setVisible(true);
        this.setResizable(false);
	}
	  
	  
	public void actionPerformed(ActionEvent e) {
		
        
    }
}


