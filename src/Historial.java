import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class Historial extends JFrame implements ActionListener {

	private JLabel Nom = new JLabel();
	public static Font fuente2 = (new Font("Oswald", Font.PLAIN, 13));
	private static JLabel FeEntrada = new JLabel("ENTRADA");
	private static JLabel FeSalida = new JLabel("SALIDA");
	private static JLabel Noche = new JLabel("NOCHES");
	private static JLabel Niño = new JLabel("NIÑOS");
	private static JLabel Adulto = new JLabel("ADULTO");
	private static JLabel Precio_T = new JLabel("PRECIO");
	private static JLabel idH = new JLabel("ID HOTEL");
	private static JLabel Estado = new JLabel("ESTADO");
	private static JLabel Ciudad = new JLabel("CIUDAD");
	public static JPanel panel;
	private JPanel divContainer;
	private int Numero=0;
	private JScrollPane scrollPane;
	private ImageIcon volver = new ImageIcon("cap.png");
	private ImageIcon image = new ImageIcon("logot.jpg");
	private JButton botonVolver = new JButton(volver);
	private static ImageIcon user = new ImageIcon("user.png");
	public static boolean Inicio3;
	public static boolean Inicio4;
	public static int A;
	private static int height = 35;
	boolean confirmado = false;
	public static int Devolver = 0;
	public static int yPos = 50; 

	
	
	public Historial () {

		ImageIcon imagenFondo = new ImageIcon("fondoo.jpg");
		Image fondo = imagenFondo.getImage();
		ImageIcon logo = new ImageIcon("logo.png");
		JLabel logo2 = new JLabel();
		Font fuente = new Font("Oswald", Font.PLAIN, 30);
		logo2.setIcon(logo);
		logo2.setBounds(300, -13, 300, 200);
		setContentPane(new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fondo, 0, 135, getWidth(), 4, this);
				this.setBackground(Color.white);
			}
		});
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(980, 500);
		this.setLayout(null);
		this.setTitle("BOOK4YOU");
		this.setIconImage(image.getImage());
		this.setLocationRelativeTo(null);
		this.add(logo2);
		this.setResizable(false);
		this.setVisible(true);
		
		Precio_T.setFont(Inicio.fuente2);
		botonVolver.setOpaque(false);
		botonVolver.setContentAreaFilled(false);
		botonVolver.addActionListener(this);
		botonVolver.setBorderPainted(false);
		botonVolver.setBounds(10, 55, 40, 40);
		Nom.setBounds(50, 255, 300, 200);
		FeEntrada.setBounds(50, 10, 65, 20);
		FeSalida.setBounds(150, 10, 50, 20);
		Noche.setBounds(238, 10, 65, 20);
		Niño.setBounds(315, 10, 50, 20);
		Adulto.setBounds(385, 10, 65, 20);
		Precio_T.setBounds(455, 10, 65, 20);
		idH.setBounds(525, 5, 100, 30);
		Ciudad.setBounds(605, 10, 100, 20);
		Ciudad.setFont(Inicio.fuente2);
		Estado.setBounds(700, 10, 100, 20);
	   panel = new JPanel();
       panel.setLayout(null);
       panel.setPreferredSize(new Dimension(1800, 1900));
       scrollPane = new JScrollPane(panel);
       scrollPane.setBounds(0, 145, 960, 600);
       scrollPane.setBorder(null);
       scrollPane.getVerticalScrollBar().setUnitIncrement(13);
       Marcadores_de_Posicion.devolverReserva();
       this.add(scrollPane);
	   this.add(logo2);
	   this.add(botonVolver);
	   this.add(scrollPane);
	   this.setBackground(Color.white);
	   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}


public static void AgregarP (String Entrada, String Salida, int Noches, int Niños, int Adultos, int Precio, int ID_Hotel, int id, String City ) {
	System.out.println("Añadido");
	FeEntrada.setFont(Inicio.fuente2);
	FeSalida.setFont(Inicio.fuente2);
	Noche.setFont(Inicio.fuente2);
	Niño.setFont(Inicio.fuente2);
	Adulto.setFont(Inicio.fuente2);
	Estado.setFont(Inicio.fuente2);
	idH.setFont(Inicio.fuente2);
	Precio_T.setFont(Inicio.fuente2);
	panel.add(FeEntrada);
	panel.add(FeSalida);
	panel.add(Noche);
	panel.add(Niño);
	panel.add(Adulto);
	panel.add(idH);
	panel.add(Precio_T);
	panel.add(Estado);
	panel.add(Ciudad);
    JLabel Entra = new JLabel(Entrada);
    Entra.setFont(Inicio.fuente2);
    panel.add(Entra);
    JLabel Sal = new JLabel(Salida);
    Sal.setFont(Inicio.fuente2);
    JLabel Noche= new JLabel(Integer.toString(Noches));
    Noche.setFont(Inicio.fuente2);
    JLabel nen= new JLabel(Integer.toString(Niños));
    nen.setFont(Inicio.fuente2);
    JLabel Adul= new JLabel(Integer.toString(Adultos) );
    Adul.setFont(Inicio.fuente2);
    JLabel PT= new JLabel(Integer.toString(Precio)+ "Q");
    PT.setFont(Inicio.fuente2);
    JLabel id_Hotel= new JLabel(Integer.toString(ID_Hotel));
    id_Hotel.setFont(Inicio.fuente2);
    String A1= Marcadores_de_Posicion.estado(Entrada);
    JLabel Estat= new JLabel(A1);
   JLabel Ci= new JLabel(City);
   JButton Action= new JButton("Cancelar Reserva");
    Ci.setFont(Inicio.fuente2);
	
	Marcadores_de_Posicion.estiloBoton(Action);
	if (A1.equals("Reserva Activa")) {
		Devolver= Precio;
		Action.setBounds(820,yPos,100,20);
		panel.add(Action);
		Action.setVisible(true);
		Action.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(null, "Seguro que deseas eliminar tu reserva?" , "Confirmación", JOptionPane.YES_NO_OPTION);
				  if (opcion == JOptionPane.YES_OPTION) {	
				Marcadores_de_Posicion.actualizarQuevedos(2);
				Marcadores_de_Posicion.Borrar(id);
			  ((JFrame) SwingUtilities.getWindowAncestor(panel)).dispose();
			
				new User(0);
				  }	
			}
		});
		
		
	}
    Estat.setFont(Inicio.fuente2);
   
    Entra.setBounds(50, yPos, 100, 20);
    Sal.setBounds(150, yPos, 100, 20);
    Noche.setBounds(240, yPos, 100, 20);
    nen.setBounds(320, yPos, 100, 20);
    Adul.setBounds(390, yPos, 100, 20);
    PT.setBounds(455, yPos, 100, 20);
    id_Hotel.setBounds(525, yPos, 100, 20);
    Estat.setBounds(700, yPos, 100, 20);
    Ci.setBounds(605, yPos, 100, 20);
    yPos += 35;
	panel.add(Entra);
	panel.add(Sal);
	panel.add(Noche);
	panel.add(PT);
	panel.add(nen);
	panel.add(Adul);
	panel.add(PT);	
	panel.add(Estat);
	panel.add(id_Hotel);
	panel.add(Ci);
	height+=35;   
    panel.setBackground(Color.WHITE);
    }

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == botonVolver) {
		new User(0);
	
		this.dispose();
	}
	
}}