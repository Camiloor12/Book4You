
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class IniciarSesion implements ActionListener{
	  private Base b = new Base();
	  private ImageIcon volver = new ImageIcon("cap.jpg");
	  private JButton botonVolver = new JButton(volver);
	  private ImageIcon ImgSesion = new ImageIcon("signup.png");
	  private JButton IniciarS = new JButton(ImgSesion);
	  private Font fuente = new Font("Hammersmith One", Font.ITALIC, 15);
	  private JLabel Email = new JLabel("Email:");
	  private JTextField EmailT = new JTextField("");
	  private JLabel password = new JLabel("Contraseña:");
	  private JPasswordField passwordT = new JPasswordField("");
	  public IniciarSesion() {
		  	password.setFont(fuente);
		  	passwordT.setFont(fuente);
		    botonVolver.setBorderPainted(false);
		    JPanel p = b.getBase1();
		    botonVolver.setOpaque(false);
		    botonVolver.setContentAreaFilled(false);
		    botonVolver.addActionListener(this);
		    botonVolver.setBounds(10, 35, 100, 77);
		    IniciarS.setOpaque(false);
		    IniciarS.setContentAreaFilled(false);
		    IniciarS.addActionListener(this);
		    IniciarS.setBounds((p.getWidth() / 2) - 95, 125, 145, 46);
		    Email.setBounds((p.getWidth() / 2) - 115, 0, 200, 35);
		    Email.setFont(fuente);
		    EmailT.setBounds((p.getWidth() / 2) - 115, 25, 200, 35);
		    EmailT.setFont(fuente);
		    password.setBounds((p.getWidth() / 2) - 115, 60, 200, 35);
		    passwordT.setBounds((p.getWidth() / 2) - 115, 85, 200, 35);
		    p.add(Email);
		    p.add(EmailT);
		    p.add(password);
		    p.add(passwordT);
		    p.add(IniciarS);
		    b.add(botonVolver);
		    botonVolver.setVisible(true);
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(botonVolver == e.getSource()) {
			new Inicio();
			b.dispose();
		}else if(IniciarS == e.getSource()) {
			
		}
		
	}
}
