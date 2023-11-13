
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.formdev.flatlaf.FlatLightLaf;


public class Inicio extends JFrame implements ActionListener {
	private JLabel L1 = new JLabel();
	private JLabel L2 = new JLabel();
	private JLabel L3 = new JLabel();
	private JLabel L4 = new JLabel();
	private JLabel L5 = new JLabel();
	private JLabel L6 = new JLabel();
	private JLabel L7 = new JLabel();
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
	private JLabel PNocheH1;
	private JLabel PrecioTH1;
	private JButton ReservaH1;
	private JLabel Ubi;
	private ImageIcon Ubi1; 
	private ImageIcon Estrellas1 = new ImageIcon("Estrellas.png"); 
	private JLabel Estrellas = new JLabel(Estrellas1);
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
	private JButton crearCuentaButton = new JButton("Crear cuenta nueva");
	private Font fuente = new Font("Oswald", Font.PLAIN, 60);
	private Font fuente3 = new Font("Oswald", Font.PLAIN, 30);
	private botones b1 = new botones(4,100);
	private botones b2 = new botones(4,100);
	private botones b3 = new botones(4,100);
	private botones b4 = new botones(4,100);
	private botones b5 = new botones(4,100);
	private botones b6 = new botones(4,100);
	private botones b7 = new botones(4,100);
	private botones b8 = new botones(4,100);
	private botones b9 = new botones(4,100);
	private botones b10 = new botones(4,100);
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
		addListenerButtons();
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
        divContainer.setPreferredSize(new Dimension(getWidth(), 1950)); 
        
       
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
		Busqueda.setBackground(Color.white);
		Busqueda.addActionListener(this);
		user2.addActionListener(this);
		textAnimationTimer = new Timer(8, this); // Adjust the delay as needed
		scrollPane.setVisible(false);
		Inicio.creditos.setBounds(875, 100, 140, 60);
		Inicio.creditos.setFont(fuente2);
		Inicio.nom.setBounds(875, 85, 140, 60);
		Inicio.nom.setFont(fuente2);
		scrollPane.getVerticalScrollBar().setUnitIncrement(25);
		scrollPane.getVerticalScrollBar().setBlockIncrement(20);
		Ubi1 = new ImageIcon ("ubi.png");
		Ubi= new JLabel(Ubi1);
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
		}
		if (e.getSource() == b1.getPalante() || e.getSource() == b1.getPatras()) { // Logica botones imagenes
	        handleButton(b1, L1, 1,e);
	    } else if (e.getSource() == b2.getPalante() || e.getSource() == b2.getPatras()) {
	        handleButton(b2, L2, 2,e);
	    } else if (e.getSource() == b3.getPalante() || e.getSource() == b3.getPatras()) {
	        handleButton(b3, L3, 3,e);
	    } else if (e.getSource() == b4.getPalante() || e.getSource() == b4.getPatras()) {
	        handleButton(b4, L4, 4,e);
	    } else if (e.getSource() == b5.getPalante() || e.getSource() == b5.getPatras()) {
	        handleButton(b5, L5, 5,e);
	    } else if (e.getSource() == b6.getPalante() || e.getSource() == b6.getPatras()) {
	        handleButton(b6, L6, 6,e);
	    }
	}
	protected JPanel modifyApartments(int apartment) {
		JPanel div = null;
		switch(apartment) {
		case 0:
			 ImageIcon Estrellas1 = new ImageIcon("Estrellas.png"); 
			 JLabel Estrellas = new JLabel(Estrellas1);
			Ubi1 = new ImageIcon ("ubi.png");
			Ubi= new JLabel(Ubi1);
			div = createDiv("Resultado 1");
			changeImgText("Resultado 1");
			L1.setBounds(28,22,300,186);
			NombreH1= new JLabel(Marcadores_de_Posicion.p1.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p1.getDireccion() + ", " + Marcadores_de_Posicion.p1.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			String descripcion1 = Marcadores_de_Posicion.p1.getDescripcion();
			int anchoMaximo = 400;
			StringBuilder sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			String[] palabras = descripcion1.split("\\s+");
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
			changeImg(b1.getCon(), L1);
			Estrellas.setBounds(518,-85,300,300);
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
			div.add(b1.getPalante());
			div.add(b1.getPatras());
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
			Estrellas1 = new ImageIcon("Estrellas.png"); 
			Estrellas = new JLabel(Estrellas1);
			Ubi1 = new ImageIcon ("ubi.png");
			Ubi= new JLabel(Ubi1);
			div = createDiv("Resultado 2");
			changeImgText("Resultado "+ (apartment+1));
			changeImg(b2.getCon(), L2);
			L2.setBounds(28,32,300,156);
			NombreH1= new JLabel(Marcadores_de_Posicion.p2.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p2.getDireccion() + ", " + Marcadores_de_Posicion.p2.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			String descripcion2 = Marcadores_de_Posicion.p2.getDescripcion();
			 anchoMaximo = 400;
			 sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			palabras = descripcion2.split("\\s+");
			 anchoActual = 0;
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
			 DescripcionH1 = new JLabel(sb.toString());
			DescripcionH1.setBounds(380, -130, 440, 500);
			DescripcionH1.setFont(fuente2);
			Estrellas.setBounds(518,-85,300,300);
			Estrellas.setVisible(true);
			PNocheH1= new JLabel("Precio Noche: " + String.valueOf(Marcadores_de_Posicion.p2.getPrecio()) + " Q");
			PNocheH1.setFont(fuente2);
			PNocheH1.setBounds(820,60,120,70);
			PrecioTH1= new JLabel("Precio Total: " + "1200 Q");
			PrecioTH1.setFont(fuente2);
			PrecioTH1.setBounds(820,85,120,70);
			ReservaH1= new JButton("Reservar");
			Marcadores_de_Posicion.estiloBoton(ReservaH1);
			ReservaH1.setBackground(Color.gray);
			ReservaH1.setBounds(820,145,110,25);
			div.add(NombreH1);
			div.add(Ubi);
			div.add(UbicaionH1);
			div.add(DescripcionH1);
			div.add(DescripcionH1);
			div.add(Estrellas);
			div.add(PNocheH1);
			div.add(PrecioTH1);
			div.add(ReservaH1);
			div.add(b2.getPalante());
			div.add(b2.getPatras());
			div.add(L2);
			imgLim=7;
			break;
		case 2:
			div = createDiv("Resultado 3");
			changeImgText("Resultado "+ (apartment+1));
			Estrellas1 = new ImageIcon("Estrellas3.png"); 
			Estrellas = new JLabel(Estrellas1);
			Ubi1 = new ImageIcon ("ubi.png");
			Ubi= new JLabel(Ubi1);
			NombreH1= new JLabel(Marcadores_de_Posicion.p3.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p3.getDireccion() + ", " + Marcadores_de_Posicion.p3.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			 descripcion2 = Marcadores_de_Posicion.p3.getDescripcion();
			 anchoMaximo = 400;
			 sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			palabras = descripcion2.split("\\s+");
			 anchoActual = 0;
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
			 DescripcionH1 = new JLabel(sb.toString());
			DescripcionH1.setBounds(380, -130, 440, 500);
			DescripcionH1.setFont(fuente2);
			Estrellas.setBounds(575,-85,300,300);
			Estrellas.setVisible(true);
			PNocheH1= new JLabel("Precio Noche: " + String.valueOf(Marcadores_de_Posicion.p3.getPrecio()) + " Q");
			PNocheH1.setFont(fuente2);
			PNocheH1.setBounds(820,60,120,70);
			PrecioTH1= new JLabel("Precio Total: " + "1200 Q");
			PrecioTH1.setFont(fuente2);
			PrecioTH1.setBounds(820,85,120,70);
			ReservaH1= new JButton("Reservar");
			Marcadores_de_Posicion.estiloBoton(ReservaH1);
			ReservaH1.setBackground(Color.gray);
			ReservaH1.setBounds(820,145,110,25);
			div.add(NombreH1);
			div.add(Ubi);
			div.add(UbicaionH1);
			div.add(DescripcionH1);
			div.add(DescripcionH1);
			div.add(Estrellas);
			div.add(PNocheH1);
			div.add(PrecioTH1);
			div.add(ReservaH1);
			changeImg(b3.getCon(), L3);
			L3.setBounds(28,32,300,156);
			div.add(b3.getPalante());
			div.add(b3.getPatras());
			div.add(L3);
			imgLim=9;
			break;
		case 3:
			div = createDiv("Resultado 4");
			changeImgText("Resultado "+ (apartment+1));
			changeImg(b4.getCon(), L4);
			Estrellas1 = new ImageIcon("Estrellas2.png"); 
			Estrellas = new JLabel(Estrellas1);
			Ubi1 = new ImageIcon ("ubi.png");
			Ubi= new JLabel(Ubi1);
			NombreH1= new JLabel(Marcadores_de_Posicion.p4.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p4.getDireccion() + ", " + Marcadores_de_Posicion.p4.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			 descripcion2 = Marcadores_de_Posicion.p4.getDescripcion();
			 anchoMaximo = 400;
			 sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			palabras = descripcion2.split("\\s+");
			 anchoActual = 0;
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
			 DescripcionH1 = new JLabel(sb.toString());
			DescripcionH1.setBounds(380, -130, 440, 500);
			DescripcionH1.setFont(fuente2);
			Estrellas.setBounds(560,-85,300,300);
			Estrellas.setVisible(true);
			PNocheH1= new JLabel("Precio Noche: " + String.valueOf(Marcadores_de_Posicion.p4.getPrecio()) + " Q");
			PNocheH1.setFont(fuente2);
			PNocheH1.setBounds(820,60,120,70);
			PrecioTH1= new JLabel("Precio Total: " + "1200 Q");
			PrecioTH1.setFont(fuente2);
			PrecioTH1.setBounds(820,85,120,70);
			ReservaH1= new JButton("Reservar");
			Marcadores_de_Posicion.estiloBoton(ReservaH1);
			ReservaH1.setBackground(Color.gray);
			ReservaH1.setBounds(820,145,110,25);
			div.add(NombreH1);
			div.add(Ubi);
			div.add(UbicaionH1);
			div.add(DescripcionH1);
			div.add(DescripcionH1);
			div.add(Estrellas);
			div.add(PNocheH1);
			div.add(PrecioTH1);
			div.add(ReservaH1);
			L4.setBounds(28,32,300,156);
			div.add(b4.getPalante());
			div.add(b4.getPatras());
			div.add(L4);
			imgLim=10;
			break;
		case 4:
			div = createDiv("Resultado 5");
			changeImgText("Resultado "+ (apartment+1));
			changeImg(b5.getCon(), L5);
			L5.setBounds(28,32,300,156);
			Estrellas1 = new ImageIcon("Estrellas.png"); 
			Estrellas = new JLabel(Estrellas1);
			Ubi1 = new ImageIcon ("ubi.png");
			Ubi= new JLabel(Ubi1);
			NombreH1= new JLabel(Marcadores_de_Posicion.p5.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p5.getDireccion() + ", " + Marcadores_de_Posicion.p5.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			 descripcion2 = Marcadores_de_Posicion.p5.getDescripcion();
			 anchoMaximo = 400;
			 sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			palabras = descripcion2.split("\\s+");
			 anchoActual = 0;
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
			 DescripcionH1 = new JLabel(sb.toString());
			DescripcionH1.setBounds(380, -130, 440, 500);
			DescripcionH1.setFont(fuente2);
			Estrellas.setBounds(560,-85,300,300);
			Estrellas.setVisible(true);
			PNocheH1= new JLabel("Precio Noche: " + String.valueOf(Marcadores_de_Posicion.p5.getPrecio()) + " Q");
			PNocheH1.setFont(fuente2);
			PNocheH1.setBounds(820,60,120,70);
			PrecioTH1= new JLabel("Precio Total: " + "1200 Q");
			PrecioTH1.setFont(fuente2);
			PrecioTH1.setBounds(820,85,120,70);
			ReservaH1= new JButton("Reservar");
			Marcadores_de_Posicion.estiloBoton(ReservaH1);
			ReservaH1.setBackground(Color.gray);
			ReservaH1.setBounds(820,145,110,25);
			div.add(NombreH1);
			div.add(Ubi);
			div.add(UbicaionH1);
			div.add(DescripcionH1);
			div.add(DescripcionH1);
			div.add(Estrellas);
			div.add(PNocheH1);
			div.add(PrecioTH1);
			div.add(ReservaH1);
			div.add(b5.getPalante());
			div.add(b5.getPatras());
			div.add(L5);
			imgLim=8;
			break;
		case 5:
			div = createDiv("Resultado " + 6);
			changeImgText("Resultado "+ (apartment+1));
			changeImg(b6.getCon(), L6);
			L6.setBounds(28,32,300,156);
			Estrellas1 = new ImageIcon("Estrellas3.png"); 
			Estrellas = new JLabel(Estrellas1);
			Ubi1 = new ImageIcon ("ubi.png");
			Ubi= new JLabel(Ubi1);
			NombreH1= new JLabel(Marcadores_de_Posicion.p6.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p6.getDireccion() + ", " + Marcadores_de_Posicion.p6.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			 descripcion2 = Marcadores_de_Posicion.p6.getDescripcion();
			 anchoMaximo = 400;
			 sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			palabras = descripcion2.split("\\s+");
			 anchoActual = 0;
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
			 DescripcionH1 = new JLabel(sb.toString());
			DescripcionH1.setBounds(380, -130, 440, 500);
			DescripcionH1.setFont(fuente2);
			Estrellas.setBounds(560,-85,300,300);
			Estrellas.setVisible(true);
			PNocheH1= new JLabel("Precio Noche: " + String.valueOf(Marcadores_de_Posicion.p6.getPrecio()) + " Q");
			PNocheH1.setFont(fuente2);
			PNocheH1.setBounds(820,60,120,70);
			PrecioTH1= new JLabel("Precio Total: " + "1200 Q");
			PrecioTH1.setFont(fuente2);
			PrecioTH1.setBounds(820,85,120,70);
			ReservaH1= new JButton("Reservar");
			Marcadores_de_Posicion.estiloBoton(ReservaH1);
			ReservaH1.setBackground(Color.gray);
			ReservaH1.setBounds(820,145,110,25);
			div.add(NombreH1);
			div.add(Ubi);
			div.add(UbicaionH1);
			div.add(DescripcionH1);
			div.add(DescripcionH1);
			div.add(Estrellas);
			div.add(PNocheH1);
			div.add(PrecioTH1);
			div.add(ReservaH1);
			div.add(b6.getPalante());
			div.add(b6.getPatras());
			div.add(L6);
			imgLim=8;
			break;
		case 6:
			div = createDiv("Resultado " + 7);
			Estrellas1 = new ImageIcon("Estrellas2.png"); 
			Estrellas = new JLabel(Estrellas1);
			Ubi1 = new ImageIcon ("ubi.png");
			Ubi= new JLabel(Ubi1);
			NombreH1= new JLabel(Marcadores_de_Posicion.p7.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p7.getDireccion() + ", " + Marcadores_de_Posicion.p7.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			 descripcion2 = Marcadores_de_Posicion.p7.getDescripcion();
			 anchoMaximo = 400;
			 sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			palabras = descripcion2.split("\\s+");
			 anchoActual = 0;
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
			 DescripcionH1 = new JLabel(sb.toString());
			DescripcionH1.setBounds(380, -130, 440, 500);
			DescripcionH1.setFont(fuente2);
			Estrellas.setBounds(560,-85,300,300);
			Estrellas.setVisible(true);
			PNocheH1= new JLabel("Precio Noche: " + String.valueOf(Marcadores_de_Posicion.p7.getPrecio()) + " Q");
			PNocheH1.setFont(fuente2);
			PNocheH1.setBounds(820,60,120,70);
			PrecioTH1= new JLabel("Precio Total: " + "1200 Q");
			PrecioTH1.setFont(fuente2);
			PrecioTH1.setBounds(820,85,120,70);
			ReservaH1= new JButton("Reservar");
			Marcadores_de_Posicion.estiloBoton(ReservaH1);
			ReservaH1.setBackground(Color.gray);
			ReservaH1.setBounds(820,145,110,25);
			div.add(NombreH1);
			div.add(Ubi);
			div.add(UbicaionH1);
			div.add(DescripcionH1);
			div.add(DescripcionH1);
			div.add(Estrellas);
			div.add(PNocheH1);
			div.add(PrecioTH1);
			div.add(ReservaH1);
			break;
		case 7:
			div = createDiv("Resultado " + 8);
			Estrellas1 = new ImageIcon("Estrellas.png"); 
			Estrellas = new JLabel(Estrellas1);
			Ubi1 = new ImageIcon ("ubi.png");
			Ubi= new JLabel(Ubi1);
			NombreH1= new JLabel(Marcadores_de_Posicion.p8.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p8.getDireccion() + ", " + Marcadores_de_Posicion.p8.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			 descripcion2 = Marcadores_de_Posicion.p8.getDescripcion();
			 anchoMaximo = 400;
			 sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			palabras = descripcion2.split("\\s+");
			 anchoActual = 0;
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
			 DescripcionH1 = new JLabel(sb.toString());
			DescripcionH1.setBounds(380, -130, 440, 500);
			DescripcionH1.setFont(fuente2);
			Estrellas.setBounds(560,-85,300,300);
			Estrellas.setVisible(true);
			PNocheH1= new JLabel("Precio Noche: " + String.valueOf(Marcadores_de_Posicion.p8.getPrecio()) + " Q");
			PNocheH1.setFont(fuente2);
			PNocheH1.setBounds(820,60,120,70);
			PrecioTH1= new JLabel("Precio Total: " + "1200 Q");
			PrecioTH1.setFont(fuente2);
			PrecioTH1.setBounds(820,85,120,70);
			ReservaH1= new JButton("Reservar");
			Marcadores_de_Posicion.estiloBoton(ReservaH1);
			ReservaH1.setBackground(Color.gray);
			ReservaH1.setBounds(820,145,110,25);
			div.add(NombreH1);
			div.add(Ubi);
			div.add(UbicaionH1);
			div.add(DescripcionH1);
			div.add(DescripcionH1);
			div.add(Estrellas);
			div.add(PNocheH1);
			div.add(PrecioTH1);
			div.add(ReservaH1);
			break;
		case 8:
			div = createDiv("Resultado " + 9);
			Estrellas1 = new ImageIcon("Estrellas3.png"); 
			Estrellas = new JLabel(Estrellas1);
			Ubi1 = new ImageIcon ("ubi.png");
			Ubi= new JLabel(Ubi1);
			NombreH1= new JLabel(Marcadores_de_Posicion.p9.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p9.getDireccion() + ", " + Marcadores_de_Posicion.p9.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			 descripcion2 = Marcadores_de_Posicion.p9.getDescripcion();
			 anchoMaximo = 400;
			 sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			palabras = descripcion2.split("\\s+");
			 anchoActual = 0;
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
			 DescripcionH1 = new JLabel(sb.toString());
			DescripcionH1.setBounds(380, -130, 440, 500);
			DescripcionH1.setFont(fuente2);
			Estrellas.setBounds(560,-85,300,300);
			Estrellas.setVisible(true);
			PNocheH1= new JLabel("Precio Noche: " + String.valueOf(Marcadores_de_Posicion.p9.getPrecio()) + " Q");
			PNocheH1.setFont(fuente2);
			PNocheH1.setBounds(820,60,120,70);
			PrecioTH1= new JLabel("Precio Total: " + "1200 Q");
			PrecioTH1.setFont(fuente2);
			PrecioTH1.setBounds(820,85,120,70);
			ReservaH1= new JButton("Reservar");
			Marcadores_de_Posicion.estiloBoton(ReservaH1);
			ReservaH1.setBackground(Color.gray);
			ReservaH1.setBounds(820,145,110,25);
			div.add(NombreH1);
			div.add(Ubi);
			div.add(UbicaionH1);
			div.add(DescripcionH1);
			div.add(DescripcionH1);
			div.add(Estrellas);
			div.add(PNocheH1);
			div.add(PrecioTH1);
			div.add(ReservaH1);
			break;
		case 9:
			div = createDiv("Resultado " + 10);
			Estrellas1 = new ImageIcon("Estrellas.png"); 
			Estrellas = new JLabel(Estrellas1);
			Ubi1 = new ImageIcon ("ubi.png");
			Ubi= new JLabel(Ubi1);
			NombreH1= new JLabel(Marcadores_de_Posicion.p10.getNombre());
			NombreH1.setFont(fuente3);
			NombreH1.setBounds(380,-10,300,100);
			Ubi.setBounds(380,60,15,15);
			UbicaionH1= new JLabel(Marcadores_de_Posicion.p10.getDireccion() + ", " + Marcadores_de_Posicion.p10.getCp() + ", " + lugar.getText() );
			UbicaionH1.setBounds(400,40,300,50);
			UbicaionH1.setFont(fuente2);
			 descripcion2 = Marcadores_de_Posicion.p10.getDescripcion();
			 anchoMaximo = 400;
			 sb = new StringBuilder("<html><body style='width: " + anchoMaximo + "px;'>");
			palabras = descripcion2.split("\\s+");
			 anchoActual = 0;
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
			 DescripcionH1 = new JLabel(sb.toString());
			DescripcionH1.setBounds(380, -130, 440, 500);
			DescripcionH1.setFont(fuente2);
			Estrellas.setBounds(560,-85,300,300);
			Estrellas.setVisible(true);
			PNocheH1= new JLabel("Precio Noche: " + String.valueOf(Marcadores_de_Posicion.p10.getPrecio()) + " Q");
			PNocheH1.setFont(fuente2);
			PNocheH1.setBounds(820,60,120,70);
			PrecioTH1= new JLabel("Precio Total: " + "1200 Q");
			PrecioTH1.setFont(fuente2);
			PrecioTH1.setBounds(820,85,120,70);
			ReservaH1= new JButton("Reservar");
			Marcadores_de_Posicion.estiloBoton(ReservaH1);
			ReservaH1.setBackground(Color.gray);
			ReservaH1.setBounds(820,145,110,25);
			div.add(NombreH1);
			div.add(Ubi);
			div.add(UbicaionH1);
			div.add(DescripcionH1);
			div.add(DescripcionH1);
			div.add(Estrellas);
			div.add(PNocheH1);
			div.add(PrecioTH1);
			div.add(ReservaH1);
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
	protected void changeImg(int cont,JLabel L) {		
		switch(cont) {
		case 0:
			L.setIcon(i);
			break;
		case 1:
			L.setIcon(i2);
			break;
		case 2:
			L.setIcon(i3);
			break;
		case 3:
			L.setIcon(i4);
			break;
		case 4:
			L.setIcon(i5);
			break;
		case 5:
			L.setIcon(i6);
			break;
		case 6:
			L.setIcon(i7);
			break;
		case 7:
			L.setIcon(i8);
			break;
		case 8:
			L.setIcon(i9);
			break;
		case 9:
			L.setIcon(i10);
			break;
		default:
			break;
		}
	}
	protected void changeImgText(String text) {
		switch(text) {
		case "Resultado 1":
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
		case "Resultado 2":
			i = new ImageIcon("imgApart/ap2.jpg");
			i2 = new ImageIcon("imgApart/ap2-2.jpg");
			i3 = new ImageIcon("imgApart/ap2-3.jpg");
			i4 = new ImageIcon("imgApart/ap2-4.jpg");
			i5 = new ImageIcon("imgApart/ap2-5.jpg");
			i6 = new ImageIcon("imgApart/ap2-6.jpg");
			i7 = new ImageIcon("imgApart/ap2-7.jpg");			
			break;
		case "Resultado 3":
			i = new ImageIcon("imgApart/ap3.jpg");
			i2 = new ImageIcon("imgApart/ap3-2.jpg");
			i3 = new ImageIcon("imgApart/ap3-3.jpg");
			i4 = new ImageIcon("imgApart/ap3-4.jpg");
			i5 = new ImageIcon("imgApart/ap3-5.jpg");
			i6 = new ImageIcon("imgApart/ap3-6.jpg");
			i7 = new ImageIcon("imgApart/ap3-7.jpg");
			i8 = new ImageIcon("imgApart/ap3-8.jpg");	
			i9 = new ImageIcon("imgApart/ap3-9.jpg");	
			break;
		case "Resultado 4":
			i = new ImageIcon("imgApart/ap4.jpg");
			i2 = new ImageIcon("imgApart/ap4-2.jpg");
			i3 = new ImageIcon("imgApart/ap4-3.jpg");
			i4 = new ImageIcon("imgApart/ap4-4.jpg");
			i5 = new ImageIcon("imgApart/ap4-5.jpg");
			i6 = new ImageIcon("imgApart/ap4-6.jpg");
			i7 = new ImageIcon("imgApart/ap4-7.jpg");
			i8 = new ImageIcon("imgApart/ap4-8.jpg");
			i9 = new ImageIcon("imgApart/ap4-9.jpg");
			i10 = new ImageIcon("imgApart/ap4-10.jpg");	
			break;
		case "Resultado 5":
			i = new ImageIcon("imgApart/ap5.jpg");
			i2 = new ImageIcon("imgApart/ap5-2.jpg");
			i3 = new ImageIcon("imgApart/ap5-3.jpg");
			i4 = new ImageIcon("imgApart/ap5-4.jpg");
			i5 = new ImageIcon("imgApart/ap5-5.jpg");
			i6 = new ImageIcon("imgApart/ap5-6.jpg");
			i7 = new ImageIcon("imgApart/ap5-7.jpg");
			i8 = new ImageIcon("imgApart/ap5-8.jpg");
			break;
		case "Resultado 6":
			i = new ImageIcon("imgApart/ap6.jpg");
			i2 = new ImageIcon("imgApart/ap6-2.jpg");
			i3 = new ImageIcon("imgApart/ap6-3.jpg");
			i4 = new ImageIcon("imgApart/ap6-4.jpg");
			i5 = new ImageIcon("imgApart/ap6-5.jpg");
			i6 = new ImageIcon("imgApart/ap6-6.jpg");
			i7 = new ImageIcon("imgApart/ap6-7.jpg");
			break;
		case "Resultado 7":
			i = new ImageIcon("imgApart/ap7.jpg");
			i2 = new ImageIcon("imgApart/ap7-2.jpg");
			i3 = new ImageIcon("imgApart/ap7-3.jpg");
			i4 = new ImageIcon("imgApart/ap7-4.jpg");
			i5 = new ImageIcon("imgApart/ap7-5.jpg");
			i6 = new ImageIcon("imgApart/ap7-6.jpg");
			i7 = new ImageIcon("imgApart/ap7-7.jpg");
			i8 = new ImageIcon("imgApart/ap7-8.jpg");
			i9 = new ImageIcon("imgApart/ap7-9.jpg");
			break;
		case "Resultado 8":
			break;
		case "Resultado 9":
			break;
		case "Resultado 10":
			break;
		}
	}
	private void handleButton(botones button, JLabel label, int index,ActionEvent e) {
	    changeImgText("Resultado " + index);
	    int currentImg = button.getCon();
	   switch(index) {
	   case 1:
		   imgLim = 9;
		   break;
	   case 2:
		   imgLim = 7;
		   break;
	   case 3:
		   imgLim = 9;
		   break;
	   case 4:
		   imgLim = 10;
		   break;
	   case 5:
		   imgLim = 8;
		   break;
	   case 6:
		   imgLim = 7;
		   break;
	   case 7:
		   imgLim = 9;
		   break;
	   case 8:
		   break;
	   case 9:
		   break;
	   case 10:
		   break;
	   }
	    

	    if (e.getSource() == button.getPalante()) {
	    	if(currentImg<imgLim-1) {
				currentImg++;
				changeImg(currentImg, label);
				button.setCon(currentImg);
			}else {
				currentImg=0; 
				changeImg(currentImg, label);
				button.setCon(currentImg);
			}
	    } else if (e.getSource() == button.getPatras()) {
	    	if(!(currentImg<=0)) {
				currentImg--;
				changeImg(currentImg, label);
				button.setCon(currentImg);
			}
			if(currentImg>0) {
				changeImg(currentImg, label);
				button.setCon(currentImg);
			}else if(currentImg==0) {
				currentImg=imgLim-1;
				changeImg(currentImg, label);
				button.setCon(currentImg);
			}
	    }
	}
	





	private void addListenerButtons() {
		b1.getPalante().addActionListener(this);
		b1.getPatras().addActionListener(this);
		b2.getPalante().addActionListener(this);
		b2.getPatras().addActionListener(this);
		b3.getPalante().addActionListener(this);
		b3.getPatras().addActionListener(this);
		b4.getPalante().addActionListener(this);
		b4.getPatras().addActionListener(this);
		b5.getPalante().addActionListener(this);
		b5.getPatras().addActionListener(this);
		b6.getPalante().addActionListener(this);
		b6.getPatras().addActionListener(this);
		b7.getPalante().addActionListener(this);
		b7.getPatras().addActionListener(this);
		b8.getPalante().addActionListener(this);
		b8.getPatras().addActionListener(this);
		b9.getPalante().addActionListener(this);
		b9.getPatras().addActionListener(this);
		b10.getPalante().addActionListener(this);
		b10.getPatras().addActionListener(this);
	}
}