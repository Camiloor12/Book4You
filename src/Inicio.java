import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.toedter.calendar.JCalendar;

public class Inicio extends JFrame implements ActionListener {

    private ImageIcon logo;
    private JLabel logo2;
    private JLabel x;
    private String x1= ("¿Dónde quieres ir?");
    private ImageIcon logout = new ImageIcon("logout.png");
    private JButton botonLogOut = new JButton(logout);
    private ImageIcon user = new ImageIcon("user.png");
    private JButton user2 = new JButton(user);
    private ImageIcon image;
    private JCalendar Calendario;
    private JTextField Lugar;
    private Font Fuente = new Font("Hammersmith One", Font.ITALIC, 120);

    public Inicio() {
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
        this.setTitle("BOOK4YOU");

        System.out.println("Existo!!");

        logo = new ImageIcon("logo.png");
        logo2 = new JLabel();
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
        user2.setBounds(1800, 40, 100, 100);
        user2.addActionListener(this);
        x = new JLabel("Elije tu nueva aventura...");
        x.setForeground(Color.white);
        x.setFont(Fuente);
        x.setBounds(45, 250, 1500, 200);
        Lugar = new JTextField();
        Lugar.setForeground(Color.BLACK); 
        Lugar.setBounds(45, 440, 400, 45);
        Marcadores_de_Posicion.Cambio1(Lugar, "¿Dónde quieres ir?");

       
        this.add(logo2);
        this.add(botonLogOut);
        this.add(user2);
        this.add(x);
        this.add(Lugar);

        this.setIconImage(image.getImage());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonLogOut) {
            this.dispose();
        }
        if (e.getSource() == user2) {
            this.dispose();
        }
    }}
