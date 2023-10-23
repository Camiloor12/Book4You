
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registro implements ActionListener{
	  private Base b = new Base();
	  private int start = 1900;
	  private ImageIcon volver = new ImageIcon("cap.jpg");
	  private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	  private JComboBox<String> mes = new JComboBox<>(meses);
	  private Integer[] Dias = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
	  private JComboBox<Integer> Dia = new JComboBox<>(Dias);
	  private Integer[] Años = new Integer[123];
      private JComboBox<Integer> Año;
      private ImageIcon register = new ImageIcon("registernow.png");
      private JButton registerN = new JButton(register);
	  private JButton botonVolver = new JButton(volver);
	  private Font fuente = new Font("Hammersmith One", Font.ITALIC, 15);
	  private JTextField nombreApellidos = new JTextField("");
	  private JLabel nameSurn = new JLabel("Nombre Apellidos:");
	  private JLabel Fecha = new JLabel("Fecha Nacimiento:");
	  private JLabel Email = new JLabel("Email:");
	  private JTextField EmailT = new JTextField("");
	  private JLabel Telefono = new JLabel("Telefono:");
	  private JTextField TelefonoT = new JTextField("");
	  private JLabel password = new JLabel("Contraseña:");
	  private JPasswordField passwordT = new JPasswordField("");

	  public Registro() {
		  	mes.setFont(fuente);
		  	password.setFont(fuente);
		  	passwordT.setFont(fuente);
		  	Dia.setFont(fuente);				  	
		  	for (int i = 0; i < Años.length; i++) {
		  		if(start != 2023) {
		  			Años[i]= start++;
		  		}
			}
		  	Año = new JComboBox<>(Años);
		  	Año.setFont(fuente);
		    
		    botonVolver.setBorderPainted(false);
		    JPanel p = b.getBase1();
		    nameSurn.setForeground(Color.black);
		    nameSurn.setBounds((p.getWidth() / 2) - 115, 0, 200, 35);
		    nameSurn.setFont(fuente);
		    password.setBounds((p.getWidth() / 2) - 115, 230, 200, 35);
		    passwordT.setBounds((p.getWidth() / 2) - 115, 255, 200, 35);
		    registerN.setBounds((p.getWidth() / 2) - 120, 290, 200, 100);
		    registerN.setOpaque(false);
		    registerN.setContentAreaFilled(false);
		    registerN.addActionListener(this);
		    botonVolver.setOpaque(false);
		    botonVolver.setContentAreaFilled(false);
		    botonVolver.addActionListener(this);
		    botonVolver.setBounds(10, 35, 100, 77);
		    
		    // Add the text fields to the base1 panel
		    nombreApellidos.setBounds((p.getWidth() / 2) - 115, 25, 200, 35);
		    nombreApellidos.setFont(fuente);
		    Fecha.setBounds((p.getWidth() / 2) - 115, 55, 200, 35);
		    mes.setBounds((p.getWidth() / 2) - 85, 80, 160, 30);
		    Dia.setBounds((p.getWidth() / 2) - 140, 80, 55, 30);
		    Año.setBounds((p.getWidth() / 2) + 75, 80, 65, 30);
		    Email.setBounds((p.getWidth() / 2) - 115, 105, 200, 35);
		    Email.setFont(fuente);
		    EmailT.setBounds((p.getWidth() / 2) - 115, 130, 200, 35);
		    EmailT.setFont(fuente);
		    Telefono.setBounds((p.getWidth() / 2) - 115, 165, 200, 35);
		    Telefono.setFont(fuente);
		    TelefonoT.setBounds((p.getWidth() / 2) - 115, 190, 200, 35);
		    TelefonoT.setFont(fuente);
		    p.add(nameSurn);
		    p.add(nombreApellidos);
		    p.add(Fecha);
		    p.add(mes);
		    p.add(Dia);
		    p.add(Año);
		    p.add(Email);
		    p.add(EmailT);
		    p.add(Telefono);
		    p.add(TelefonoT);
		    p.add(registerN);
		    p.add(password);
		    p.add(passwordT);
		    
		    // Call Marcadores_de_Posicion.Cambio1 after adding components to the panel
		    Marcadores_de_Posicion.Cambio1(nombreApellidos, "Ej : Federic Gonzalez");
		    Marcadores_de_Posicion.Cambio1(EmailT, "Ej : federicgonz@gmail.com");
		    Marcadores_de_Posicion.Cambio1(TelefonoT, "Ej : 674 324 115");
		    
		    b.add(botonVolver);
		    botonVolver.setVisible(true);
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(registerN == e.getSource()) {
			char [] password  = passwordT.getPassword();
			if(password.length == 0) {
				JOptionPane.showMessageDialog(null, "Password Field must be filled", "Information", JOptionPane.INFORMATION_MESSAGE);
			}else {
				if(!EmailT.getText().contains("@")) {
					JOptionPane.showMessageDialog(null, "Invalid email address. Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}else if(botonVolver == e.getSource()) {
			new Inicio();
			b.dispose();
		}
		
		
	}
	
}
