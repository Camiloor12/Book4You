
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registro implements ActionListener{
	  private int start = 1900;
	  private ImageIcon volver = new ImageIcon("cap.jpg");
	  private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	  private JComboBox<String> mes;
	  private Integer[] Dias = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
	  private JComboBox<Integer> Dia;
	  private Integer[] Años = new Integer[123];
      private JComboBox<Integer> Año;
	  private JButton botonVolver = new JButton(volver);
	  private Font fuente = new Font("Hammersmith One", Font.ITALIC, 13);
	  private JTextField nombreApellidos = new JTextField("");
	  private JLabel nameSurn = new JLabel("Nombre Apellidos");
	  private JTextField FechaNacimiento = new JTextField("");
	  private JLabel Fecha = new JLabel("Fecha Nacimiento");

	  public Registro() {
		  	for (int i = 0; i < Años.length; i++) {
		  		Años[0] = start;
		  		if(Años[i] !=2023) {
		  			Años[i]= start++;
		  		}
			}
		    Base b = new Base();
		    botonVolver.setBorderPainted(false);
		    JPanel p = b.getBase1();
		    nameSurn.setForeground(Color.black);
		    nameSurn.setBounds((p.getWidth() / 2) - 115, 0, 200, 35);
		    nameSurn.setFont(fuente);
		    botonVolver.setOpaque(false);
		    botonVolver.setContentAreaFilled(false);
		    botonVolver.addActionListener(this);
		    botonVolver.setBounds(10, 35, 100, 77);
		    
		    // Add the text fields to the base1 panel
		    nombreApellidos.setBounds((p.getWidth() / 2) - 115, 25, 200, 35);
		    FechaNacimiento.setBounds((p.getWidth() / 2) - 115, 80, 200, 35);
		    p.add(nameSurn);
		    p.add(nombreApellidos);
		    p.add(Fecha);
		    p.add(FechaNacimiento);
		    
		    // Call Marcadores_de_Posicion.Cambio1 after adding components to the panel
		    Marcadores_de_Posicion.Cambio1(nombreApellidos, "Ej : Federic Gonzalez");
		    Marcadores_de_Posicion.Cambio1(FechaNacimiento, "Ej : 01/05/2023");
		    
		    b.add(botonVolver);
		    botonVolver.setVisible(true);
		}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
