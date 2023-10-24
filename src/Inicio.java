import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Inicio extends JFrame implements ActionListener {

    private ImageIcon logo;
    private JLabel logo2;
    public static boolean InicioS;
    private JLabel x;
    private ImageIcon logout = new ImageIcon("logout.png");
    private JButton botonLogOut = new JButton(logout);
    private ImageIcon user = new ImageIcon("user.png");
    private JButton user2 = new JButton(user);
    private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private JComboBox<String> mes;
    private JComboBox<String> mes2;
    private Integer[] Dias = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private JComboBox<Integer> Dia;
    private JComboBox<Integer> Dia2;
    private Integer[] Años = {2023, 2024};
    private JComboBox<Integer> Año;
    private JComboBox<Integer> Año2;
    private Integer[] Personas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private JComboBox<Integer> Adultos;
    private JComboBox<Integer> Niños;
    private JTextField lugar;
    private JButton Busqueda = new JButton("Buscar");
    private JButton iniciarSesionButton = new JButton("Iniciar Sesion");
    private JButton crearCuentaButton = new JButton("Crear cuenta nueva");
    private Font fuente = new Font("c", Font.PLAIN, 60);
    private Font fuente2 = (new Font("Oswald", Font.PLAIN, 13));

    public Inicio() {
    	user2.setBounds(890, 45, 60, 60);    	
    	user2.setBorderPainted(false);
		user2.setOpaque(false);
        user2.setContentAreaFilled(false);  
        InicioSesion();
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            // Manejar la excepción de LookAndFeel si es necesario
        }

        ImageIcon image = new ImageIcon("logot.jpg");
        String imagenFondo = "fondoo.jpg";
        Image fondo = new ImageIcon(imagenFondo).getImage();

        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                this.setBackground(Color.white);
                g.drawImage(fondo, 0, 140, getWidth(), 380, this);
            }
        });
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

        botonLogOut.setBorderPainted(false);
        botonLogOut.setOpaque(false);
        botonLogOut.setContentAreaFilled(false);
        botonLogOut.setBounds(3, 20, 100, 100);
        botonLogOut.addActionListener(this);

        iniciarSesionButton.setBounds(820, 40, 150, 35);
        iniciarSesionButton.addActionListener(this);
        Marcadores_de_Posicion.estiloBoton(iniciarSesionButton);
        
        crearCuentaButton.setBounds(820, 80, 150, 35);
        crearCuentaButton.addActionListener(this);
        Marcadores_de_Posicion.estiloBoton(crearCuentaButton);

        x = new JLabel("Elije tu nueva aventura...");
        x.setForeground(Color.white);
        x.setFont(fuente);
        x.setBounds(10, 250, 700, 80);

        lugar = new JTextField();
        lugar.setForeground(Color.BLACK);
        lugar.setBackground(new Color(240, 240, 240));
        lugar.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100))); 
        lugar.setBounds(10, 360, 200, 35);
        Marcadores_de_Posicion.Cambio1(lugar, "¿Dónde quieres ir?");
        lugar.setFont(fuente2);

        JLabel lblLugar = new JLabel("Lugar:");
        lblLugar.setFont(fuente2);
        lblLugar.setForeground(Color.white);
        lblLugar.setBounds(10, 330, 100, 30);


        mes = new JComboBox<>(meses);
        mes.setBounds(220, 360, 100, 35);
        mes.setFont(fuente2);

        JLabel lblFechaEntrada = new JLabel("Fecha de Entrada:");
        lblFechaEntrada.setFont(fuente2);
        lblFechaEntrada.setForeground(Color.white);
        lblFechaEntrada.setBounds(220, 330, 200, 30);

        Dia = new JComboBox<>(Dias);
        Dia.setBounds(320, 360, 50, 35);
        Dia.setFont(fuente2);

        Año = new JComboBox<>(Años);
        Año.setBounds(370, 360, 70, 35);
        Año.setFont(fuente2);
        

        mes2 = new JComboBox<>(meses);
        mes2.setBounds(465, 360, 100, 35);
        mes2.setFont(fuente2);

        JLabel lblFechaSalida = new JLabel("Fecha de Salida:");
        lblFechaSalida.setFont(fuente2);
        lblFechaSalida.setForeground(Color.white);
        lblFechaSalida.setBounds(465, 330, 200, 30);

        Dia2 = new JComboBox<>(Dias);
        Dia2.setBounds(565, 360, 50, 35);

        Año2 = new JComboBox<>(Años);
        Año2.setBounds(615, 360, 70, 35);
        Año2.setFont(fuente2);

        Adultos = new JComboBox<>(Personas);
        Adultos.setBounds(700, 360, 70, 35);
        Adultos.setFont(fuente2);

        JLabel lblAdultos = new JLabel("Adultos:");
        lblAdultos.setFont(fuente2);
        lblAdultos.setForeground(Color.white);
        lblAdultos.setBounds(700, 330, 100, 30);

        Niños = new JComboBox<>(Personas);
        Niños.setBounds(785, 360, 70, 35);
        Niños.setFont(fuente2);
        

        JLabel lblNiños = new JLabel("Niños:");
        lblNiños.setFont(fuente2);
        lblNiños.setForeground(Color.white);
        lblNiños.setBounds(785, 330, 100, 30);

        Busqueda.setBounds(870, 360, 100, 30);
        Marcadores_de_Posicion.estiloBoton(Busqueda);
        Busqueda.setForeground(Color.BLACK);
        Busqueda.setContentAreaFilled(true);
        Busqueda.addActionListener(this);
        user2.addActionListener(this);
        this.add(logo2);
        this.add(botonLogOut);
        this.add(user2);
        this.add(x);
        this.add(lugar);
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
        this.setIconImage(image.getImage());
        this.setVisible(true);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonLogOut) {
        	InicioS = false;        	
        	JOptionPane.showMessageDialog(null, "Logged out succesfully !", "Information", JOptionPane.INFORMATION_MESSAGE);
        	InicioSesion();
        }
        if (e.getSource() == user2) {
        	this.dispose();
        	new User();//Frame user
        }
        if (e.getSource() == Busqueda) {
            String Entrada = (String) mes.getSelectedItem();
            int Dia_Entrada = (int) Dia.getSelectedItem();
            String Salida = (String) mes2.getSelectedItem();
            int Dia_Salida = (int) Dia2.getSelectedItem();
            int Año_Entrada = (int) Año.getSelectedItem();
            int Año_Salida = (int) Año2.getSelectedItem();

            if (Entrada.equals("Febrero") && Dia_Entrada > 28) {
                JOptionPane.showMessageDialog(this, " Fecha de entrada: Febrero solo tiene 28 días.");
            } else if ((Entrada.equals("Abril") || Entrada.equals("Junio") || Entrada.equals("Septiembre") || Entrada.equals("Noviembre"))
                    && Dia_Entrada == 31) {
                JOptionPane.showMessageDialog(this, "Fecha de entrada: Este mes  solo tiene 30 días.");
            } else if (Salida.equals("Febrero") && Dia_Salida > 28) {
                JOptionPane.showMessageDialog(this, "Fecha de Salida: Febrero solo tiene 28 días.");
            } else if ((Salida.equals("Abril") || Salida.equals("Junio") || Salida.equals("Septiembre") || Salida.equals("Noviembre"))
                    && Dia_Salida == 31) {
                JOptionPane.showMessageDialog(this, "Fecha de Salida: Este mes  solo tiene 30 días.");
            }
            boolean esFechaValidaEntrada = Marcadores_de_Posicion.Fecha(Entrada, Dia_Entrada);
            boolean esFechaValidaSalida = Marcadores_de_Posicion.Fecha(Salida, Dia_Salida);
            if (Año_Salida == 2024 || Año_Entrada == 2024) {
                esFechaValidaEntrada = true;
                esFechaValidaSalida = true;
            }
            if (!esFechaValidaEntrada) {
                JOptionPane.showMessageDialog(this, "Fecha Entrada: Fecha Invalida, La fecha ya ha pasado");
            } else if (!esFechaValidaSalida) {
                JOptionPane.showMessageDialog(this, "Fecha Salida: Fecha Invalida, La fecha ya ha pasado");
            }
            boolean Valida = Marcadores_de_Posicion.Fecha2(Entrada, Dia_Entrada, Año_Entrada, Salida, Dia_Salida, Año_Salida);

            if (!Valida) {
                JOptionPane.showMessageDialog(this, "La Fecha de salida no puede ser posterior a la entrada");
            }

            if (lugar.getText().equals("¿Dónde quieres ir?")) {
                JOptionPane.showMessageDialog(this, "No has escogido ningún destino");
            } else {
                new Pantalla_Principal();
            }
        }
        if (e.getSource() == iniciarSesionButton) {
        	new IniciarSesion();
        	this.dispose();
        }
        if (e.getSource() == crearCuentaButton) {
        	new Registro();
        	this.dispose();
        }
    }
    private void InicioSesion() {
    	if(InicioS) { //Si se ha iniciado sesion  
    		user2.setVisible(true);
    		iniciarSesionButton.setVisible(false);
    		crearCuentaButton.setVisible(false);
    	}else {
    		iniciarSesionButton.setVisible(true);
    		crearCuentaButton.setVisible(true);
    		user2.setVisible(false);
    	}
    }
}