
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;


public class User extends JFrame implements ActionListener{
	  private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	  private JComboBox<String> mes = new JComboBox<>(meses);
	  private int start = 1900;
	  private Integer[] Dias = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
	  private JComboBox<Integer> Dia = new JComboBox<>(Dias);
	  private Integer[] Años = new Integer[123];
	  private JComboBox<Integer> Año;
	  private ImageIcon volver = new ImageIcon("cap.png");	 
	  private JButton botonVolver = new JButton(volver);
	  private Font fuente = new Font("Oswald", Font.ITALIC, 15);
	  private JTextField nombreApellidos = new JTextField("");
	  private JLabel nameSurn = new JLabel("Nombre Apellidos:");
	  private JLabel Fecha = new JLabel("Fecha Nacimiento:");
	  private JLabel Email = new JLabel("Email:");
	  private JTextField EmailT = new JTextField("");
	  private JLabel Telefono = new JLabel("Telefono:");
	  private JTextField TelefonoT = createNumericTextField(10);;
	  private JButton addFondos = new JButton("AÑADIR QUEVEDOS");
	  private JButton actualizarDatos = new JButton("Actualizar Datos");
	  private JButton historialReservas = new JButton("Historial de reservas");
	  private JTextField FondosT = createNumericTextField(10);;
	  private JLabel Fondos = new JLabel("FONDOS:");
	  private JPasswordField passwordT = new JPasswordField("");
	  private ImageIcon Hide = new ImageIcon("hide.png");
	  private ImageIcon Show = new ImageIcon("show.png");
	  private JButton ShowHideButton = new JButton(Show);
	  private JPasswordField passwordField = new JPasswordField(15);
	  
	  public User() {
		mes.setFont(fuente);
	  	passwordT.setFont(fuente);
	  	Dia.setFont(fuente);				  	
	  	for (int i = 0; i < Años.length; i++) {
	  		if(start != 2023) {
	  			Años[i]= start++;
	  		}
		}
	  	Año = new JComboBox<>(Años);
	  	Año.setFont(fuente);
	  	ImageIcon image = new ImageIcon("logot.jpg");			
		ImageIcon imagenFondo = new ImageIcon("fondoo.jpg");
        Image fondo = imagenFondo.getImage();
        ImageIcon logo = new ImageIcon("logo.png");
        JLabel logo2 = new JLabel();
        logo2.setIcon(logo);
        logo2.setBounds(165, -15, 300, 200);
        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondo, 0, 135, getWidth(), 500, this);
                this.setBackground(Color.white);
            }
        });
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 500);             
        this.setLayout(null);
        this.setTitle("BOOK4YOU");
        this.setIconImage(image.getImage());	     
        this.setLocationRelativeTo(null);
        this.add(logo2);
        this.setResizable(false);
        this.setVisible(true);
        ShowHideButton.setBorderPainted(false);
        ShowHideButton.setOpaque(false);
        ShowHideButton.setContentAreaFilled(false);
	    botonVolver.setBorderPainted(false);
	    JPanel base1 = new JPanel();
	    base1.setBackground(Color.WHITE);
        base1.setBounds(10, 138, getWidth() - 35 , 407);     
        base1.setLayout(null);
	    this.add(base1);
	    nameSurn.setForeground(Color.black);
	    nameSurn.setBounds((base1.getWidth() / 2) - 270, 0, 200, 35);
	    nameSurn.setFont(fuente);
	    botonVolver.setOpaque(false);
	    botonVolver.setContentAreaFilled(false);
	    botonVolver.addActionListener(this);
	    botonVolver.setBounds(10, 55, 40, 40);
	    nombreApellidos.setBounds((base1.getWidth() / 2) - 270, 25, 200, 35);
	    nombreApellidos.setFont(fuente);
	    Fecha.setBounds((base1.getWidth() / 2) + 55, 0, 200, 35);
	    Fecha.setFont(fuente);
	    Email.setBounds((base1.getWidth() / 2) - 270, 75, 200, 35);
	    Email.setFont(fuente);
	    EmailT.setBounds((base1.getWidth() / 2) - 270, 100, 200, 35);
	    EmailT.setFont(fuente);
	    Telefono.setBounds((base1.getWidth() / 2) + 55, 75, 200, 35);
	    Telefono.setFont(fuente);
	    TelefonoT.setFont(fuente);	   
	    Fondos.setFont(fuente);
	    Fondos.setBounds((base1.getWidth() / 2)-30, 245, 200, 30); 
	    FondosT.setFont(fuente);	
	    FondosT.setBounds((base1.getWidth() / 2) - 270, 275, 200, 35); 
	    TelefonoT.setBounds((base1.getWidth() / 2) + 55, 100, 200, 35);
	    Marcadores_de_Posicion.estiloBoton(addFondos);
	    addFondos.addActionListener(this);	  
	    Marcadores_de_Posicion.estiloBoton(historialReservas);
	    historialReservas.addActionListener(this);	  
	    Marcadores_de_Posicion.estiloBoton(actualizarDatos);
	    actualizarDatos.addActionListener(this);  
	    mes.setBounds((base1.getWidth() / 2) + 110, 25, 90, 30);
	    Dia.setBounds((base1.getWidth() / 2) + 55, 25, 55, 30);
	    Año.setBounds((base1.getWidth() / 2) + 200, 25, 65, 30);
	    actualizarDatos.setBounds((base1.getWidth() / 2) - 105, 145, 200, 30);
	    historialReservas.setBounds((base1.getWidth() / 2) - 133, 190, 255, 30); 
	    addFondos.setBounds((base1.getWidth() / 2) + 55, 275, 200, 35); 
	    ShowHideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle between showing and hiding the password
                if (passwordField.getEchoChar() == 0) {
                    // Password is currently shown, so hide it
                    passwordField.setEchoChar('\u2022'); // Replaces the password with bullets
                    ShowHideButton.setIcon(Show);
                } else {
                    // Password is currently hidden, so show it
                    passwordField.setEchoChar((char) 0); // Shows the plain text
                    ShowHideButton.setIcon(Hide);
                }
            }
        });
	    base1.add(nameSurn);
	    base1.add(Fondos);
	    base1.add(FondosT);
	    base1.add(nombreApellidos);
	    base1.add(Fecha);
	    base1.add(Año);
	    base1.add(mes);
	    base1.add(Dia);
	    base1.add(Email);
	    base1.add(EmailT);
	    base1.add(Telefono);
	    base1.add(TelefonoT);
	    base1.add(actualizarDatos);
	    base1.add(historialReservas);
	    base1.add(addFondos);
	    this.add(botonVolver);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(botonVolver == e.getSource()) {
			new Inicio();
			this.dispose();
		}else if(addFondos == e.getSource()) {
			
		}else if(actualizarDatos == e.getSource()) {
			showConfirmationDialog();
		}else if(historialReservas == e.getSource()) {
			
		}else if (passwordT.getEchoChar() == 0) {//Ocultar password
            passwordT.setEchoChar('*');
            ShowHideButton.setIcon(Show);
        } else {//Mostrar password
            passwordT.setEchoChar((char) 0);
            ShowHideButton.setIcon(Hide);
        }
	}
	private void showConfirmationDialog() {
        String password = "your_actual_password"; // Set your actual password here
        JDialog confirmationDialog = new JDialog(this, "Confirmation", true);
        confirmationDialog.setLayout(new FlowLayout());
        confirmationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");

        // Add ActionListener to the Confirm button
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] enteredPassword = passwordField.getPassword();
                String enteredPasswordStr = new String(enteredPassword);
                if (enteredPasswordStr.equals(password)) {
                    // Password is correct, proceed with the update
                    confirmationDialog.dispose();
                 // Add your code to update the data here
                } else {
                    JOptionPane.showMessageDialog(confirmationDialog, "Incorrect password. Try again.");
                }
            }
        });

        // Add ActionListener to the Cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmationDialog.dispose();
            }
        });
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    confirmButton.doClick();
                }
            }
        });

        confirmationDialog.add(new JLabel("Enter password: "));
        confirmationDialog.add(passwordField);
        confirmationDialog.add(ShowHideButton);
        confirmationDialog.add(confirmButton);
        confirmationDialog.add(cancelButton);
        confirmationDialog.pack();
        confirmationDialog.setLocationRelativeTo(null);
        confirmationDialog.setVisible(true);
    }

	private JTextField createNumericTextField(int columns) {
	    JTextField textField = new JTextField(columns);
	    PlainDocument doc = (PlainDocument) textField.getDocument();
	    doc.setDocumentFilter(new DocumentFilter() {
	        @Override
	        public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
	            if (string.matches("[0-9]*")) {
	                super.insertString(fb, offset, string, attr);
	            }
	        }
	        @Override
	        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	            if (text.matches("[0-9]*")) {
	                super.replace(fb, offset, length, text, attrs);
	            }
	        }
	    });
	    return textField;
	}
}