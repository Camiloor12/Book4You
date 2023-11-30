import java.awt.Color;
import java.awt.Font;
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

public class Reserva extends JFrame implements ActionListener {
	private JLabel Nom= new JLabel();
	private JLabel FeEntrada= new JLabel();
	private JLabel FeSalida= new JLabel();
	private JLabel Noche= new JLabel();
	private JLabel Niño= new JLabel();
	private JLabel Adulto= new JLabel();
	private JLabel Precio_T= new JLabel();
	private JLabel Precio_N= new JLabel();
	private ImageIcon volver = new ImageIcon("cap.png");	 
	private JButton botonVolver = new JButton(volver);
	public static  JButton iniciarSesionButton = new JButton("Iniciar Sesion");
	public  static JButton crearCuentaButton = new JButton("Crear cuenta nueva");
	private JButton BotonF= new JButton("Finalizar");
	private static ImageIcon user = new ImageIcon("user.png");
	public static JButton user2 = new JButton(user);
	public static boolean Inicio3;
	public static boolean Inicio4;
	public static int A;
	private String FEntrada1, FSalida1;
	private int Adultos1, Niños1, Noches1, id_hotel1;
	boolean confirmado=false;
    public Reserva (int precio, String Nombre, String FEntrada, String FSalida, int Niños, int Adultos, JLabel Imagen, int Noches, int id_hotel ) {
    	 FEntrada1 = FEntrada;
    	 FSalida1= FSalida;
    	 Adultos1=Adultos;
    	 Niños1=Niños;
    	 id_hotel1=id_hotel;
    	 
	ImageIcon image = new ImageIcon("logot.jpg");			
	ImageIcon imagenFondo = new ImageIcon("fondoo.jpg");
    Image fondo = imagenFondo.getImage();
    ImageIcon logo = new ImageIcon("logo.png");
    JLabel logo2 = new JLabel();
    Font fuente = new Font("Oswald", Font.PLAIN, 30);
    logo2.setIcon(logo);
    logo2.setBounds(150, -13, 300, 200);
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
    this.setSize(700, 480);             
    this.setLayout(null);
    this.setTitle("BOOK4YOU");
    this.setIconImage(image.getImage());	     
    this.setLocationRelativeTo(null);
    this.add(logo2);
    this.setResizable(false);
    this.setVisible(true);
    

	Nom.setText(Nombre);
	Nom.setFont(fuente);
	
	FeEntrada.setText("Fecha Entrada: " + FEntrada);
	FeEntrada.setFont(Inicio.fuente2);
	FeSalida.setText("Fecha Salida: " + FSalida);
	FeSalida.setFont(Inicio.fuente2);
	
	Noche.setFont(Inicio.fuente2);
	Precio_N.setText("Precio Noche: " + precio + " Q");
	Precio_N.setFont(Inicio.fuente2);
	Niño.setText("Niños: " + Niños);
	Niño.setFont(Inicio.fuente2);
	Adulto.setText("Adultos: " + Adultos);
	Adulto.setFont(Inicio.fuente2);

	if (Noches==1) {
		Noches=1;
		Noches1=Noches;
		Noche.setText("Noches: " + Noches);
	}
	else {
		Noches=Noches-1;
		Noches1=Noches;
		Noche.setText("Noches: " + Noches);
	}
	
	 A= Marcadores_de_Posicion.calcularPrecioTotal(Noches, Niños, Adultos, precio);
	Precio_T.setText("Precio Total: " + A  + " Q");
	Precio_T.setFont(Inicio.fuente2);
	botonVolver.setOpaque(false);
    botonVolver.setContentAreaFilled(false);
    botonVolver.addActionListener(this);
    botonVolver.setBorderPainted(false);
    botonVolver.setBounds(10, 55, 40, 40);
    Marcadores_de_Posicion.estiloBoton(BotonF);
    Imagen.setBounds(30, 80, 400, 350);
    Nom.setText(Nombre);
    Nom.setFont(fuente);
    Nom.setBounds(50, 255, 300, 200);
    int yOffset = 25;
    FeEntrada.setBounds(400, 90, 300, 200); 
    FeSalida.setBounds(400, 90 + yOffset, 300, 200);
    Noche.setBounds(400, 90 + 2 * yOffset, 300, 200);
    Precio_N.setBounds(400, 90 + 3 * yOffset, 300, 200);
    Niño.setBounds(400, 90 + 4 * yOffset, 300, 200);
    Adulto.setBounds(400, 90 + 5 * yOffset, 300, 200);
    Precio_T.setBounds(400, 90 + 6 * yOffset, 300, 200);
    BotonF.setBounds(400, 90 + 11 * yOffset, 120, 30);
    BotonF.addActionListener(this);
    iniciarSesionButton.setBounds(getWidth() - 180, 35, 150, 35);
    crearCuentaButton.setBounds(getWidth() - 180, 80, 150, 35);
    user2.setBounds(getWidth() - 100, 45, 60, 60);
    user2.setBounds(getWidth() - 100, 45, 60, 60);
    user2.setBorderPainted(false);
    user2.setOpaque(false);
    user2.addActionListener(this);
    user2.setContentAreaFilled(false);
    
    iniciarSesionButton.addActionListener(this);
    Marcadores_de_Posicion.estiloBoton(iniciarSesionButton);
    crearCuentaButton.addActionListener(this);
    Marcadores_de_Posicion.estiloBoton(crearCuentaButton);
    
    if (Inicio3 || Inicio4 ) {
    	iniciarSesionButton.setVisible(false);
    	crearCuentaButton.setVisible(false);
    	user2.setVisible(true);
		 
		}
    else {
    	iniciarSesionButton.setVisible(true);
    	crearCuentaButton.setVisible(true);
    	user2.setVisible(false);
	}
 
    
   

	
	
    this.add(logo2);
    this.add(Imagen);
    this.add(Nom);
    this.add(botonVolver);
    this.add(FeEntrada);
    this.add(FeSalida);
    this.add(Noche);
    this.add(Precio_N);
    this.add(Niño);
    this.add(Adulto);
    this.add(Precio_T);
    this.add(BotonF);
    this.add(user2);
    this.add(crearCuentaButton);
    this.add(iniciarSesionButton);
	this.setBackground(Color.white);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    

}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== botonVolver) {
			 int result = JOptionPane.showConfirmDialog(null, "Si vuelves al inicio perderas todo el progreso", "Confirmación", JOptionPane.YES_NO_OPTION);
		        
		        if (result == JOptionPane.YES_OPTION) {
		             new Inicio();
		             this.dispose();
		        } 
		}
		if (e.getSource()== crearCuentaButton) {
			new Registro(1);
		}
		if (e.getSource()== iniciarSesionButton) {
			new IniciarSesion(1);
		}
		if (e.getSource() == user2) {
			new User(1);
		}
		if (e.getSource()== BotonF ) {
			
			if (Inicio3 || Inicio4 ) {
				String devolver = Marcadores_de_Posicion.devolverUsuarioInfo();
				String[] valores = devolver.split(",");
				int Q = Integer.parseInt(String.valueOf(valores[2]));			
				boolean Saldo=true;				
				if ( A > Q) {
					JOptionPane.showMessageDialog(null, "Saldo Insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
					Saldo= false;
				}
				if (Saldo) {
					confirmado= Marcadores_de_Posicion.Reserva(0, FEntrada1, FSalida1, Adultos1, Niños1, A, Noches1, id_hotel1, Inicio.correo) ;
				}
				
				if (confirmado || Saldo) {
					Marcadores_de_Posicion.actualizarQuevedos(0);
					JOptionPane.showMessageDialog(null, "Reserva hecha con éxito", "Information", JOptionPane.ERROR_MESSAGE);
					this.dispose();
					new Inicio();
				}else {
					JOptionPane.showMessageDialog(null, "Reserva no realizada", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Debes iniciar Sesion O Registrarte", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
