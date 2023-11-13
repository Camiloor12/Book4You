import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import com.formdev.flatlaf.FlatLightLaf;


public class Inicio extends JFrame implements ActionListener {
	private JLabel L1 = new JLabel();
	ImageIcon i;
	ImageIcon i2;
	ImageIcon i3;
	ImageIcon i4;
	ImageIcon i5;
	ImageIcon i6;
	ImageIcon i7;
	ImageIcon i8;
	ImageIcon i9;
	ImageIcon i10;
	private JLabel NombreH1;
	private JLabel UbicaionH1;
	private JLabel DescripcionH1;
	private JLabel PNocheH1;
	private JLabel PrecioTH1;
	private JButton ReservaH1;
	private JLabel Ubi;
	private ImageIcon Ubi1; 
	private JLabel Estrellas;
	private ImageIcon Estrellas1; 
	private int currentImg = 0;
	private Timer textAnimationTimer;
	private ImageIcon logo;
	private boolean isDone = false;
	private int textX, textY;
	private int textYtf;
	private int TextY2;
	private JLabel logo2;
	private JLabel lblFechaSalida;
	private JLabel lblAdultos;
	private JLabel lblNiños;
	private JLabel lblLugar;
	private JLabel lblFechaEntrada;
	public static boolean InicioS = false;
	public static boolean Inicio2 = false;
	private JLabel x;
	private ImageIcon logout = new ImageIcon("logout.png");
	private JButton botonLogOut = new JButton(logout);
	private ImageIcon user = new ImageIcon("user.png");
	private JButton user2 = new JButton(user);
	private String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
			"Octubre", "Noviembre", "Diciembre" };
	private JComboBox<String> mes;
	private JComboBox<String> mes2;
	private Integer[] Dias = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
			25, 26, 27, 28, 29, 30, 31 };
	private JComboBox<Integer> Dia;
	private int imgLim = 0;
	private JComboBox<Integer> Dia2;
	private Integer[] Años = { 2023, 2024 };
	private JComboBox<Integer> Año;
	private JComboBox<Integer> Año2;
	private Integer[] Personas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
	private Integer[] Personas2 = {0,1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }; // los criajos
	private JComboBox<Integer> Adultos;
	private JComboBox<Integer> Niños;
	private int height = 360;
	private Image fondo;
	private JPanel divContainer; // Panel to hold divs
    private JScrollPane scrollPane; 
	private JTextField lugar;
	public static JLabel creditos = new JLabel();
	public static JLabel nom = new JLabel();
	private JButton Busqueda = new JButton("Buscar");
	private JButton iniciarSesionButton = new JButton("Iniciar Sesion");
	private ImageIcon alante = new ImageIcon("alante.png");
	private ImageIcon atra = new ImageIcon("atras.png");
	private JButton palante = new JButton(alante);
	private JButton patras= new JButton(atra);
	private JButton crearCuentaButton = new JButton("Crear cuenta nueva");
	private Font fuente = new Font("Oswald", Font.PLAIN, 60);
	private Font fuente3 = new Font("Oswald", Font.PLAIN, 30);
	public static Font fuente2 = (new Font("Oswald", Font.PLAIN, 13));
	protected static String correo = "";
	


	public Inicio() {
		user2.setBounds(890, 45, 60, 60);
		user2.setBorderPainted(false);
		user2.setOpaque(false);
		user2.setContentAreaFilled(false);
		textYtf = 360;
		FlatLightLaf.setup();
		ImageIcon image = new ImageIcon("logot.jpg");
		String imagenFondo = "fondoo.jpg";
		fondo = new ImageIcon(imagenFondo).getImage();
		
		pintarVerde();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setTitle("BOOK4YOU");

		System.out.println("Existo!!");

		logo = new ImageIcon("logo.png");
		logo2 = new JLabel();
		logo2.setIcon(logo);
		int frameWidth = this.getWidth();
		int logoWidth = logo.getIconWidth();
		int logoX = (frameWidth - logoWidth) / 2;
		logo2.setBounds(logoX, -10, logoWidth, 200);
		InicioSesion();
		palante.setBorderPainted(false);
		palante.setOpaque(false);
		palante.setContentAreaFilled(false);
		palante.setBounds(315,100,35,35);
		palante.addActionListener(this);
		patras.setBorderPainted(false);
		patras.setOpaque(false);
		patras.setContentAreaFilled(false);
		patras.setBounds(4,100,35,35);
		patras.addActionListener(this);
		botonLogOut.setBorderPainted(false);
		botonLogOut.setOpaque(false);
		botonLogOut.setContentAreaFilled(false);
		botonLogOut.setBounds(3, 25, 100, 100);
		botonLogOut.addActionListener(this);

		iniciarSesionButton.setBounds(getWidth()-180, getHeight()-560, 150, 35);
		iniciarSesionButton.addActionListener(this);
		Marcadores_de_Posicion.estiloBoton(iniciarSesionButton);

		crearCuentaButton.setBounds(820, 80, 150, 35);
		crearCuentaButton.addActionListener(this);
		Marcadores_de_Posicion.estiloBoton(crearCuentaButton);

		x = new JLabel("Elije tu nueva aventura...");
		x.setForeground(Color.white);
		x.setFont(fuente);
		textX = 10;
		textY = 250;
		x.setBounds(textX, textY, 700, 80);

		lugar = new JTextField();
		lugar.setForeground(Color.BLACK);
		lugar.setBackground(new Color(255, 255, 255));
		lugar.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100)));
		lugar.setBounds(10, textYtf, 200, 35);
		Marcadores_de_Posicion.Cambio1(lugar, "¿Dónde quieres ir?");
		lugar.setFont(fuente2);

		lblLugar = new JLabel("Lugar:");
		lblLugar.setFont(fuente2);
		lblLugar.setForeground(Color.white);
		TextY2 = 330;
		lblLugar.setBounds(10, TextY2, 100, 30);

		mes = new JComboBox<>(meses);
		mes.setBounds(220, textYtf, 100, 35);
		mes.setFont(fuente2);

		lblFechaEntrada = new JLabel("Fecha de Entrada:");
		lblFechaEntrada.setFont(fuente2);
		lblFechaEntrada.setForeground(Color.white);
		lblFechaEntrada.setBounds(220, TextY2, 200, 30);
		
		divContainer = new JPanel(new GridLayout(0,1));
        divContainer.setPreferredSize(new Dimension(getWidth(), 2250)); 
        
       
        scrollPane = new JScrollPane(divContainer);
        scrollPane = new JScrollPane(divContainer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(0, 282, getWidth()-15, 288);
        scrollPane.setBorder(null);
		Dia = new JComboBox<>(Dias);
		Dia.setBounds(320, textYtf, 50, 35);
		Dia.setFont(fuente2);

		Año = new JComboBox<>(Años);
		Año.setBounds(370, textYtf, 70, 35);
		Año.setFont(fuente2);

		mes2 = new JComboBox<>(meses);
		mes2.setBounds(465, textYtf, 100, 35);
		mes2.setFont(fuente2);

		lblFechaSalida = new JLabel("Fecha de Salida:");
		lblFechaSalida.setFont(fuente2);
		lblFechaSalida.setForeground(Color.white);
		lblFechaSalida.setBounds(465, TextY2, 200, 30);

		Dia2 = new JComboBox<>(Dias);
		Dia2.setBounds(565, textYtf, 50, 35);

		Año2 = new JComboBox<>(Años);
		Año2.setBounds(615, textYtf, 70, 35);
		Año2.setFont(fuente2);
		Adultos = new JComboBox<>(Personas);
		Adultos.setBounds(700, 360, 70, 35);
		Adultos.setFont(fuente2);
		lblAdultos = new JLabel("Adultos:");
		lblAdultos.setFont(fuente2);
		lblAdultos.setForeground(Color.white);
		lblAdultos.setBounds(700, TextY2, 100, 30);

		Niños = new JComboBox<>(Personas2);
		Niños.setBounds(785, 360, 70, 35);
		Niños.setFont(fuente2);
		lblNiños = new JLabel("Niños:");
		lblNiños.setFont(fuente2);
		lblNiños.setForeground(Color.white);
		lblNiños.setBounds(785, TextY2, 100, 30);

		Busqueda.setBounds(870, 360, 100, 30);
		Marcadores_de_Posicion.estiloBoton(Busqueda);
		Busqueda.setForeground(Color.BLACK);
		Busqueda.setContentAreaFilled(true);
		
		Busqueda.addActionListener(this);
		user2.addActionListener(this);
		textAnimationTimer = new Timer(8, this); // Adjust the delay as needed
		scrollPane.setVisible(false);
		Inicio.creditos.setBounds(875, 100, 140, 60);
		Inicio.creditos.setFont(fuente2);
		Inicio.nom.setBounds(875, 85, 140, 60);
		Inicio.nom.setFont(fuente2);
		
		Ubi1 = new ImageIcon ("ubi.png");
		Ubi= new JLabel(Ubi1);
		Estrellas1= new ImageIcon("Estrellas.png");
		Estrellas= new JLabel(Estrellas1);
		
		this.add(logo2);
		this.add(botonLogOut);
		this.add(user2);
		this.add(x);
		this.add(lugar);
		this.add(Inicio.creditos);
		this.add(lblLugar);
		this.add(mes);
		this.add(lblFechaEntrada);
		this.add(Dia);
		this.add(Año);
		this.add(mes2);
		this.add(lblFechaSalida);
		this.add(Dia2);
		this.add(Año2);
		this.add(Adultos);
		this.add(lblAdultos);
		this.add(Niños);
		this.add(lblNiños);
		this.add(Busqueda);
		this.add(crearCuentaButton);
		this.add(iniciarSesionButton);
		this.add(scrollPane);
		this.add(Inicio.nom);
		this.setIconImage(image.getImage());
		this.setVisible(true);
		this.setResizable(false);
	}
	private JPanel createDiv(String text) {
		JLabel Lab = new JLabel(text);
		Lab.setBounds(8,0,100,20);
		Lab.setForeground(Color.black); 
		Lab.setFont(fuente2);
	    JPanel div = new JPanel() {
	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            this.setBackground(Color.white);
	        
	        }
	    };
	    div.add(Lab); 	    
	    return div;
	}

	private void addDivsToContainer() {
		scrollPane.setVisible(true);
        for (int i = 0; i < 10; i++) {
            JPanel div = modifyApartments(i);
            div.setLayout(null);
            divContainer.add(div);     
        }
        divContainer.setBorder(null);
        divContainer.revalidate(); // Refresh layout
        
    }
	
	private void pintarVerde() {
		setContentPane(new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				this.setBackground(Color.white);
				g.drawImage(fondo, 0, 140, getWidth(), height, this);
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {		
		if (e.getSource() == textAnimationTimer && !isDone) {	
			if(textY > 124) {
				textY -= 1;
				TextY2 -= 1;
				textYtf -= 1;
			}
			x.setLocation(textX, textY);
			lblFechaEntrada.setLocation(220, TextY2);
			lblAdultos.setLocation(700, TextY2);
			lblNiños.setLocation(785, TextY2);
			lblLugar.setLocation(10, TextY2);
			lblFechaSalida.setLocation(465, TextY2);
			lugar.setLocation(10, textYtf);
			mes.setLocation(220, textYtf);
			Dia.setLocation(320, textYtf);
			Año.setLocation(370, textYtf);
			mes2.setLocation(465, textYtf);
			Dia2.setLocation(565, textYtf);
			Año2.setLocation(615, textYtf);
			Adultos.setLocation(700, textYtf);
			Niños.setLocation(785, textYtf);
			Busqueda.setLocation(870, textYtf);	
			height--;
			this.repaint();
			if (height <= 140) {
				textAnimationTimer.stop();
				isDone = true;
				addDivsToContainer();				
			}
		}else if (e.getSource() == botonLogOut) {
			if (!InicioS || Inicio2) {
				JOptionPane.showMessageDialog(null, "Try and log in or create an account first !", "Information",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Logged out succesfully !", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				InicioS = false;
				InicioSesion();
			}
		} else if (e.getSource() == user2) {
			this.dispose();
			new User();// Frame user
		} else if (e.getSource() == Busqueda) {
			Marcadores_de_Posicion.crearHotel();
			boolean error = false;
			if (!error) {
				String Entrada = (String) mes.getSelectedItem();
				int Dia_Entrada = (int) Dia.getSelectedItem();
				String Salida = (String) mes2.getSelectedItem();
				int Dia_Salida = (int) Dia2.getSelectedItem();
				int Año_Entrada = (int) Año.getSelectedItem();
				int Año_Salida = (int) Año2.getSelectedItem();

				if (Entrada.equals("Febrero") && Dia_Entrada > 28) {
					JOptionPane.showMessageDialog(this, " Fecha de entrada: Febrero solo tiene 28 días.");
					error = true;
				} else if ((Entrada.equals("Abril") || Entrada.equals("Junio") || Entrada.equals("Septiembre")
						|| Entrada.equals("Noviembre")) && Dia_Entrada == 31) {
					JOptionPane.showMessageDialog(this, "Fecha de entrada: Este mes  solo tiene 30 días.");
				} else if (Salida.equals("Febrero") && Dia_Salida > 28) {
					JOptionPane.showMessageDialog(this, "Fecha de Salida: Febrero solo tiene 28 días.");
					error = true;
				} else if ((Salida.equals("Abril") || Salida.equals("Junio") || Salida.equals("Septiembre")
						|| Salida.equals("Noviembre")) && Dia_Salida == 31) {
					JOptionPane.showMessageDialog(this, "Fecha de Salida: Este mes  solo tiene 30 días.");
					error = true;
				}
				boolean esFechaValidaEntrada = Marcadores_de_Posicion.Fecha(Entrada, Dia_Entrada, Año_Entrada);
				boolean esFechaValidaSalida = Marcadores_de_Posicion.Fecha(Salida, Dia_Salida, Año_Entrada);
				if (Año_Salida == 2024 || Año_Entrada == 2024) {
					esFechaValidaEntrada = true;
					esFechaValidaSalida = true;
				}
				if (!esFechaValidaEntrada) {
					JOptionPane.showMessageDialog(this, "Fecha Entrada: Fecha Invalida, La fecha ya ha pasado");
					error = true;
				} else if (!esFechaValidaSalida) {
					JOptionPane.showMessageDialog(this, "Fecha Salida: Fecha Invalida, La fecha ya ha pasado");
					error = true;
				}
				boolean Valida = Marcadores_de_Posicion.Fecha2(Entrada, Dia_Entrada, Año_Entrada, Salida, Dia_Salida,
						Año_Salida);

				if (!Valida) {
					JOptionPane.showMessageDialog(this, "La Fecha de salida no puede ser posterior a la entrada");
					error = true;
				}

				if (lugar.getText().equals("¿Dónde quieres ir?")) {
					JOptionPane.showMessageDialog(this, "No has escogido ningún destino");
					error = true;
				}
			}
			if (!error) {
				textAnimationTimer.start();
				
			}
		}else if (e.getSource() == iniciarSesionButton) {
			new IniciarSesion();
			this.dispose();

		}else if (e.getSource() == crearCuentaButton) {
			new Registro();
			this.dispose();
		}else if(e.getSource() == palante) {
			if(currentImg<imgLim-1) {
				currentImg++;
				changeImg();
			}else {
				currentImg=0; 
				changeImg();
			}
		}else if(e.getSource() == patras) {
			if(!(currentImg<=0)) {
				currentImg--;
			}
			if(currentImg>0) {
				changeImg();
			}else if(currentImg==0) {
				currentImg=imgLim-1;
				changeImg();
			}
		}
	}
	protected JPanel modifyApartments(int apartment) {
		JPanel div = null;
		switch(apartment) {
		case 0:
			div = createDiv("Apartment 0");
			changeImgText("Apartment 0");
			L1 = new JLabel(i);
			L1.setBounds(28,22,300,186);
			NombreH1= new JLabel(Marcadores_de_Posicion.p1.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p1.getDireccion() + ", " + Marcadores_de_Posicion.p1.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			String descripcion = Marcadores_de_Posicion.p1.getDescripcion();
			int anchoMaximo = 400;
			StringBuilder sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			String[] palabras = descripcion.split("\\s+");
			int anchoActual = 0;
			for (String palabra : palabras) {
			    JLabel tempLabel = new JLabel(palabra + " ");
			    tempLabel.setFont(fuente2);
			    int anchoPalabra = tempLabel.getPreferredSize().width;
			    if (anchoActual + anchoPalabra > anchoMaximo) {
			        sb.append("<br>"); 
			        anchoActual = 0;
			    }

			    sb.append(palabra).append(" ");
			    anchoActual += anchoPalabra;
			}
			sb.append("</body></html>");
			JLabel DescripcionH1 = new JLabel(sb.toString());
			DescripcionH1.setBounds(380, -130, 440, 500);
			DescripcionH1.setFont(fuente2);
			changeImg();
			Estrellas.setBounds(485,-85,300,300);
			Estrellas.setVisible(true);
			L1.setBounds(28,32,300,156);
			PNocheH1= new JLabel("Precio Noche: " + String.valueOf(Marcadores_de_Posicion.p1.getPrecio()) + " Q");
			PNocheH1.setFont(fuente2);
			PNocheH1.setBounds(820,60,120,70);
			PrecioTH1= new JLabel("Precio Total: " + "1200 Q");
			PrecioTH1.setFont(fuente2);
			PrecioTH1.setBounds(820,85,120,70);
			ReservaH1= new JButton("Reservar");
			Marcadores_de_Posicion.estiloBoton(ReservaH1);
			ReservaH1.setBackground(Color.gray);
			ReservaH1.setBounds(820,145,110,25);
			div.add(palante);
			div.add(patras);
			div.add(L1);
			div.add(NombreH1);
			div.add(Ubi);
			div.add(UbicaionH1);
			div.add(DescripcionH1);
			div.add(DescripcionH1);
			div.add(Estrellas);
			div.add(PNocheH1);
			div.add(PrecioTH1);
			div.add(ReservaH1);
			imgLim = 9;
			break;
		case 1:
			div = createDiv("Apartment " + 1);
			changeImgText("Apartment "+ apartment);
			break;
		case 2:
			div = createDiv("Apartment " + 2);
			break;
		case 3:
			div = createDiv("Apartment " + 3);
			break;
		case 4:
			div = createDiv("Apartment " + 4);
			break;
		case 5:
			div = createDiv("Apartment " + 5);
			break;
		case 6:
			div = createDiv("Apartment " + 6);
			break;
		case 7:
			div = createDiv("Apartment " + 7);
			break;
		case 8:
			div = createDiv("Apartment " + 8);
			break;
		case 9:
			div = createDiv("Apartment " + 9);
			break;
		}
		return div;
	}
	protected void InicioSesion() {
		if (InicioS) { // Si se ha iniciado sesion
			correo = IniciarSesion.EmailT.getText();
			Marcadores_de_Posicion.Obtener();
			user2.setVisible(true);
			iniciarSesionButton.setVisible(false);
			crearCuentaButton.setVisible(false);
			botonLogOut.setVisible(true);
			creditos.setVisible(true);
			nom.setVisible(true);
		}

		else if (Inicio2) { // Si se ha iniciado sesion
			correo = Registro.EmailT.getText();
			Marcadores_de_Posicion.Obtener();
			user2.setVisible(true);
			Marcadores_de_Posicion.Obtener();
			iniciarSesionButton.setVisible(false);
			crearCuentaButton.setVisible(false);
			botonLogOut.setVisible(true);
			creditos.setVisible(true);
			nom.setVisible(true);
		}

		else {
			iniciarSesionButton.setVisible(true);
			crearCuentaButton.setVisible(true);
			user2.setVisible(false);
			botonLogOut.setVisible(false);
			creditos.setVisible(false);
			nom.setVisible(false);

		}
	}
	protected void changeImg() {		
		switch(currentImg) {
		case 0:
			L1.setIcon(i);
			break;
		case 1:
			L1.setIcon(i2);
			break;
		case 2:
			L1.setIcon(i3);
			break;
		case 3:
			L1.setIcon(i4);
			break;
		case 4:
			L1.setIcon(i5);
			break;
		case 5:
			L1.setIcon(i6);
			break;
		case 6:
			L1.setIcon(i7);
			break;
		case 7:
			L1.setIcon(i8);
			break;
		case 8:
			L1.setIcon(i9);
			break;
		case 9:
			L1.setIcon(i10);
			break;
		default:
			break;
		}
	}
	protected void changeImgText(String text) {
		switch(text) {
		case "Apartment 0":
			i = new ImageIcon("imgApart/ap1.jpg");
			i2 = new ImageIcon("imgApart/ap1-2.jpg");
			i3 = new ImageIcon("imgApart/ap1-3.jpg");
			i4 = new ImageIcon("imgApart/ap1-4.jpg");
			i5 = new ImageIcon("imgApart/ap1-5.jpg");
			i6 = new ImageIcon("imgApart/ap1-6.jpg");
			i7 = new ImageIcon("imgApart/ap1-7.jpg");
			i8 = new ImageIcon("imgApart/ap1-8.jpg");
			i9 = new ImageIcon("imgApart/ap1-9.jpg");
			break;
		case "Apartment 1":
			
			
			break;
		case "Apartment 2":
			break;
		case "Apartment 3":
			break;
		case "Apartment 4":
			break;
		case "Apartment 5":
			break;
		case "Apartment 6":
			break;
		case "Apartment 7":
			break;
		case "Apartment 8":
			break;
		case "Apartment 9":
			break;
		}
	}
	
}
	
