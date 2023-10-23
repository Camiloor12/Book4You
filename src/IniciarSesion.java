
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class IniciarSesion implements ActionListener {
	private Base b = new Base();
	private ImageIcon volver = new ImageIcon("cap.jpg");
	private JButton botonVolver = new JButton(volver);
	private JButton IniciarS = new JButton("Sign in");
	private JButton CrearC = new JButton("Create Account");
	private Font fuente = new Font("Oswald", Font.ITALIC, 15);
	private JLabel Email = new JLabel("Email:");
	private JTextField EmailT = new JTextField("");
	private JLabel password = new JLabel("Password:");
	private JPasswordField passwordT = new JPasswordField("");

	public IniciarSesion() {
		password.setFont(fuente);
		passwordT.setFont(fuente);
		botonVolver.setBorderPainted(false);
		botonVolver.setOpaque(false);
		botonVolver.setContentAreaFilled(false);
		botonVolver.addActionListener(this);
		botonVolver.setBounds(10, 35, 100, 77);
		IniciarS.setBounds(740, 85, 200, 35);
		IniciarS.addActionListener(this);
		CrearC.addActionListener(this);
		CrearC.setBounds(530, 85, 200, 35);
		Marcadores_de_Posicion.estiloBoton(IniciarS);
		Marcadores_de_Posicion.estiloBoton(CrearC);
		Email.setBounds(530, 5, 200, 35);
		Email.setFont(fuente);
		EmailT.setBounds(530, 35, 200, 35);
		EmailT.setFont(fuente);
		password.setBounds(740, 5, 200, 35);
		passwordT.setBounds(740, 35, 200, 35);
		b.add(Email);
		b.add(EmailT);
		b.add(password);
		b.add(passwordT);
		b.add(IniciarS);
		b.add(CrearC);
		b.add(botonVolver);
		botonVolver.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (botonVolver == e.getSource()) {
			new Inicio();
			b.dispose();
		} else if (IniciarS == e.getSource()) {
			if(selectLogin(EmailT.getText())) {//Si se ha iniciado sesion
				new Inicio();
				b.dispose();
			}
		} else if (CrearC == e.getSource()) {
			new Registro();
			b.dispose();
		}

	}

	public boolean selectLogin(String emailP) {

		String sql = "SELECT * FROM USUARIO WHERE E_MAIL = '" + emailP + "'";

		try {
			Statement st = Main.con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String Contraseña = rs.getString("CONTRASEÑA");
					if (Contraseña.equals(String.valueOf(passwordT.getPassword()))) { // Contraseña correcta
						String email = EmailT.getText();
						JOptionPane.showMessageDialog(null, "Welcome back "+ email+ "!", "WELCOME", JOptionPane.INFORMATION_MESSAGE);
						Inicio.InicioS = true;
						return true;
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect password. Please try again", "Error", JOptionPane.ERROR_MESSAGE);
					}

				}

			} else {
				JOptionPane.showMessageDialog(null, "We couldn't find your Book4u account.", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
