import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JLabel FeEntrada = new JLabel();
	private JLabel FeSalida = new JLabel();
	private JLabel Noche = new JLabel();
	private JLabel Niño = new JLabel();
	private JLabel Adulto = new JLabel();
	private JLabel Precio_T = new JLabel();
	private JLabel Precio_N = new JLabel();
	private JPanel divContainer;
	private JScrollPane scrollPane;
	private ImageIcon volver = new ImageIcon("cap.png");
	private JButton botonVolver = new JButton(volver);
	private static ImageIcon user = new ImageIcon("user.png");
	public static JButton user2 = new JButton(user);
	public static boolean Inicio3;
	public static boolean Inicio4;
	public static int A;
	private String FEntrada1, FSalida1;
	private int Adultos1, Niños1, Noches1, id_hotel1;
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
		this.setSize(700, 480);
		this.setLayout(null);
		this.setTitle("BOOK4YOU");
		this.setIconImage(image.getImage());
		this.setLocationRelativeTo(null);
		this.add(logo2);
		this.setResizable(false);
		this.setVisible(true);
		createDiv("");
		addDivsToContainer();
		Precio_T.setText("Precio Total: " + A + " Q");
		Precio_T.setFont(Inicio.fuente2);
		botonVolver.setOpaque(false);
		botonVolver.setContentAreaFilled(false);
		botonVolver.addActionListener(this);
		botonVolver.setBorderPainted(false);
		botonVolver.setBounds(10, 55, 40, 40);
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
		user2.setBounds(getWidth() - 100, 45, 60, 60);
		user2.setBounds(getWidth() - 100, 45, 60, 60);
		user2.setBorderPainted(false);
		user2.setOpaque(false);
		user2.addActionListener(this);
		user2.setContentAreaFilled(false);
		user2.setVisible(true);
		scrollPane.setBounds(0, 135, this.getWidth(), 495);
		this.add(logo2);
		this.add(Nom);
		this.add(botonVolver);
		this.add(FeEntrada);
		this.add(FeSalida);
		this.add(Noche);
		this.add(Precio_N);
		this.add(Niño);
		this.add(Adulto);
		this.add(Precio_T);
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
	            this.setBackground(Color.white);
	        
	        }
	    };
	    div.add(Lab); 	    
	    return div;
	}

	private void addDivsToContainer() {
		scrollPane.setVisible(true);
        for (int i = 0; i < 10; i++) {
            JPanel div = addReservas(i);
            div.setLayout(null);
            divContainer.add(div);     
        }
        divContainer.setBorder(null);
        divContainer.revalidate(); // Refresh layout
        
    }
	protected JPanel addReservas(int reservas) {
		JPanel div = new JPanel(); //Solo pueden haber 10 reservas activas
		switch(reservas) {
		case 0:
		
			break;
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		case 8:
			
			break;
		case 9:
			
			break;
		}
		return div;
	}
}
