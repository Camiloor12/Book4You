import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HistorialReservas extends JFrame implements ActionListener {
	private JLabel Nom = new JLabel();
	public static Font fuente2 = (new Font("Oswald", Font.PLAIN, 13));
	private JLabel idR = new JLabel("ID");
	private JLabel FeEntrada = new JLabel("ENTRADA");
	private JLabel FeSalida = new JLabel("SALIDA");
	private JLabel Noche = new JLabel("NOCHES");
	private JLabel Niño = new JLabel("NIÑOS");
	private JLabel Adulto = new JLabel("ADULTO");
	private JLabel Precio_T = new JLabel("PRECIO");
	private JLabel idH = new JLabel("ID HOTEL");
	private JLabel Estado = new JLabel("ESTADO");
	private JPanel divContainer;
	private JScrollPane scrollPane;
	private ImageIcon volver = new ImageIcon("cap.png");
	private JButton botonVolver = new JButton(volver);
	private static ImageIcon user = new ImageIcon("user.png");
	public static JButton user2 = new JButton(user);
	public static boolean Inicio3;
	public static boolean Inicio4;
	public static int A;
	private int height = 35;
	boolean confirmado = false;

	public HistorialReservas(String Nombre) {
		ImageIcon image = new ImageIcon("logot.jpg");
		divContainer = new JPanel(new GridLayout(0, 1));
		divContainer.setPreferredSize(new Dimension(getWidth(), 2060));

		scrollPane = new JScrollPane(divContainer);
		scrollPane = new JScrollPane(divContainer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPane.setVisible(true);		
		scrollPane.getVerticalScrollBar().setUnitIncrement(12);
		scrollPane.getVerticalScrollBar().setBlockIncrement(10);
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
		this.setSize(700, 400);
		this.setLayout(null);
		this.setTitle("BOOK4YOU");
		this.setIconImage(image.getImage());
		this.setLocationRelativeTo(null);
		this.add(logo2);
		this.setResizable(false);
		this.setVisible(true);
		createDiv("");
		addDivsToContainer(devolverNumReservas()); // Contador de reservas
		Precio_T.setFont(Inicio.fuente2);
		botonVolver.setOpaque(false);
		botonVolver.setContentAreaFilled(false);
		botonVolver.addActionListener(this);
		botonVolver.setBorderPainted(false);
		botonVolver.setBounds(10, 55, 40, 40);
		Nom.setText(Nombre);
		Nom.setFont(fuente);
		Nom.setBounds(50, 255, 300, 200);
		user2.setBounds(getWidth() - 100, 45, 60, 60);
		user2.setBounds(getWidth() - 100, 45, 60, 60);
		user2.setBorderPainted(false);
		user2.setOpaque(false);
		user2.addActionListener(this);
		user2.setContentAreaFilled(false);
		user2.setVisible(true);
		scrollPane.setBounds(0, 135, this.getWidth(), 495);
		idR.setBounds(20, 10, 50, 20);
		FeEntrada.setBounds(50, 10, 65, 20);
		FeSalida.setBounds(150, 10, 50, 20);
		Noche.setBounds(238, 10, 65, 20);
		Niño.setBounds(315, 10, 50, 20);
		Adulto.setBounds(385, 10, 65, 20);
		Precio_T.setBounds(455, 10, 65, 20);
		idH.setBounds(525, 10, 100, 20);
		Estado.setBounds(595, 10, 100, 20);
		this.add(logo2);
		this.add(botonVolver);
		this.add(user2);
		this.add(scrollPane);
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botonVolver) {
				new User(1);
				this.dispose();
		}
		if (e.getSource() == user2) {
			new User(1);
		}
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
	            this.setBackground(Color.black);
	        
	        }
	    };
	    div.add(Lab); 	    
	    return div;
	}

	private void addDivsToContainer(int reservas) {
		scrollPane.setVisible(true);
		addReservas(reservas);
        divContainer.setBorder(null);
        divContainer.revalidate(); // Refresh layout
        
    }
	protected void addReservas(int reservas) {
		JButton[] botones = new JButton[reservas];
		JPanel div = new JPanel(); 
		div.setLayout(null);
		for (int i = 1; i <= reservas; i++) {
			if(i == 1) {
				idR.setFont(Inicio.fuente2);
				FeEntrada.setFont(Inicio.fuente2);
				FeSalida.setFont(Inicio.fuente2);
				Noche.setFont(Inicio.fuente2);
				Niño.setFont(Inicio.fuente2);
				Adulto.setFont(Inicio.fuente2);
				Estado.setFont(Inicio.fuente2);
				idH.setFont(Inicio.fuente2);
				Precio_T.setFont(Inicio.fuente2);
				div.add(idR);
				div.add(FeEntrada);
				div.add(FeSalida);
				div.add(Noche);
				div.add(Niño);
				div.add(Adulto);
				div.add(idH);
				div.add(Precio_T);
				div.add(Estado);
			}			
			String res = Marcadores_de_Posicion.devolverReserva(i);
			String [] valores = res.split(",");
			JLabel id_R= new JLabel(valores[0]);
			JLabel FeEntrada= new JLabel(valores[1]);
			JLabel FeSalida= new JLabel(valores[2]);
			JLabel Noche= new JLabel(valores[3]);
			JLabel Niño= new JLabel(valores[4]);
			JLabel Adulto= new JLabel(valores[5]);
			JLabel Precio_T= new JLabel(valores[6]);
			JLabel Id_Hotel= new JLabel(valores[7]);
			id_R.setBounds(20,height,50,20);
			FeEntrada.setBounds(50,height,100,20);
			FeSalida.setBounds(150,height,100,20);
			Noche.setBounds(240,height,100,20);
			Niño.setBounds(320,height,100,20);
			Adulto.setBounds(390,height,100,20);
			Precio_T.setBounds(455,height,100,20);
			Id_Hotel.setBounds(525,height,100,20);
			div.add(FeEntrada);
			div.add(FeSalida);
			div.add(Noche);
			div.add(Id_Hotel);
			div.add(Niño);
			div.add(Adulto);
			div.add(Precio_T);	
			div.add(id_R);
			height+=35;
	        divContainer.add(div);     
		}
	}
	public static int devolverNumReservas() {
		int numReservas = 0;
		
		String sql = "SELECT COUNT(ID_RESERVA) as CUENTA FROM RESERVA WHERE E_MAIL = '"
				+ Inicio.correo + "' ";
		try {
			Statement st = Main.con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					numReservas = rs.getInt("CUENTA");
				}
			} else {
				System.out.println("No se encontró nada.");
			}
		} catch (SQLException e2) {
			System.out.println("Ha habido un error en el SELECT " + e2);
		}

		return numReservas;
	}
}
