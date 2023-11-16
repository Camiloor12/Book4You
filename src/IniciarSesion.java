
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class IniciarSesion implements ActionListener {
	private Base b = new Base();
	private ImageIcon volver = new ImageIcon("cap.png");
	private JButton botonVolver = new JButton(volver);
	private JButton IniciarS = new JButton("Sign in");
	private JButton CrearC = new JButton("Create Account");
	private Font fuente = new Font("Oswald", Font.PLAIN, 15);
	private JLabel Email = new JLabel("Email:");
	public static JTextField EmailT = new JTextField("bordesalex8@gmail.com");
	private JLabel password = new JLabel("Password:");
	private ImageIcon Hide = new ImageIcon("hide.png");
	private ImageIcon Show = new ImageIcon("show.png");
	private JButton ShowHideButton = new JButton(Show);
	private JPasswordField passwordT = new JPasswordField("Alex");
	

	public IniciarSesion() {
		password.setFont(fuente);
		passwordT.setFont(fuente);
		botonVolver.setBorderPainted(false);
		botonVolver.setOpaque(false);
		botonVolver.setContentAreaFilled(false);
		botonVolver.addActionListener(this);
		botonVolver.setBounds(8, (175/2)-35, 40, 40);
		IniciarS.setBounds(540, 85, 200, 35);
		IniciarS.addActionListener(this);
		CrearC.addActionListener(this);
		ShowHideButton.addActionListener(this);
		CrearC.setBounds(330, 85, 200, 35);
		Marcadores_de_Posicion.estiloBoton(IniciarS);
		Marcadores_de_Posicion.estiloBoton(CrearC);
		Email.setBounds(330, 5, 200, 35);
		Email.setFont(fuente);
		EmailT.setBounds(330, 35, 200, 35);
		EmailT.setFont(fuente);
		password.setBounds(540, 5, 200, 35);
		passwordT.setBounds(540, 35, 200, 35);
		ShowHideButton.setBorderPainted(false);
		ShowHideButton.setOpaque(false);
		ShowHideButton.setContentAreaFilled(false);
		ShowHideButton.setBounds(744, 38, 30, 30);
		b.add(Email);
		b.add(EmailT);
		b.add(password);
		b.add(passwordT);
		b.add(IniciarS);
		b.add(CrearC);
		b.add(botonVolver);
		b.add(ShowHideButton);
		botonVolver.setVisible(true);
		passwordT.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    IniciarS.doClick(); 
                }
            }
        });
		


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
		}else if (passwordT.getEchoChar() == 0) {//Ocultar password
            passwordT.setEchoChar('*');
            ShowHideButton.setIcon(Show);
        } else {//Mostrar password
            passwordT.setEchoChar((char) 0);
            ShowHideButton.setIcon(Hide);
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
						JOptionPane.showMessageDialog(null, "Welcome Back!!"+ email+ "!", "Actualización", JOptionPane.INFORMATION_MESSAGE);
						Inicio.InicioS = true;
						return true;
					} else {
						JOptionPane.showMessageDialog(null, "Incorret Password or Email", "Error", JOptionPane.ERROR_MESSAGE);
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
