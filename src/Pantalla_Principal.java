import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pantalla_Principal extends JFrame implements ActionListener {

    private ImageIcon logo;
    private JLabel logo2;
    private JLabel x;
    private ImageIcon logout = new ImageIcon("logout.png");
    private JButton botonLogOut = new JButton(logout);
    private ImageIcon user = new ImageIcon("user.png");
    private JButton user2 = new JButton(user);
    private ImageIcon image;
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
    private ImageIcon Buscar = new ImageIcon("Buscar.png");
    private JButton Busqueda = new JButton(Buscar);
    private JButton iniciarSesionButton = new JButton("Iniciar Sesion");
    private JButton crearCuentaButton = new JButton("Crear cuenta nueva");
    private Font fuente = new Font("Hammersmith One", Font.ITALIC, 65);

    public Pantalla_Principal() {
        ImageIcon image = new ImageIcon("logot.jpg");
        String imagenFondo = "fondoo.jpg";
        Image fondo = new ImageIcon(imagenFondo).getImage();

        setContentPane(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                this.setBackground(Color.white);
                g.drawImage(fondo, 0, 130, getWidth(), 400, this);
            }
        });
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1200, 620);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("BOOK4YOU");

        logo = new ImageIcon("logo.png");
        logo2 = new JLabel();
        logo2.setIcon(logo);
        int frameWidth = this.getWidth();
        int logoWidth = logo.getIconWidth();
        int logoX = (frameWidth - logoWidth) / 2;
        logo2.setBounds(logoX, -15, logoWidth, 200);

        botonLogOut.setBorderPainted(false);
        botonLogOut.setOpaque(false);
        botonLogOut.setContentAreaFilled(false);
        botonLogOut.setBounds(0, 20, 100, 100);
        botonLogOut.addActionListener(this);

        iniciarSesionButton.setBounds(1020, 40, 150, 35);
        Marcadores_de_Posicion.estiloBoton(iniciarSesionButton);
        iniciarSesionButton.addActionListener(this);

        crearCuentaButton.setBounds(1020, 80, 150, 35);
        Marcadores_de_Posicion.estiloBoton(crearCuentaButton);
        crearCuentaButton.addActionListener(this);
      

        x = new JLabel("Reserva Ahora...");
        x.setForeground(Color.white);
        x.setFont(fuente);
        x.setBounds(10, 160, 700, 80);

        lugar = new JTextField();
        lugar.setForeground(Color.BLACK);
        lugar.setBounds(10, 265, 220, 35);
        Marcadores_de_Posicion.Cambio1(lugar, "¿Dónde quieres ir?");

        JLabel lblLugar = new JLabel("Lugar:");
        lblLugar.setForeground(Color.white);
        lblLugar.setBounds(10, 240, 100, 30);

        mes = new JComboBox<>(meses);
        mes.setBounds(220, 400, 100, 35);
        
        JLabel lblFechaEntrada = new JLabel("Fecha de Entrada:");
        lblFechaEntrada.setForeground(Color.white);
        lblFechaEntrada.setBounds(230, 330, 200, 30);

        Dia = new JComboBox<>(Dias);
        Dia.setBounds(320, 400, 50, 35);

        Año = new JComboBox<>(Años);
        Año.setBounds(370, 360, 70, 35);

        mes2 = new JComboBox<>(meses);
        mes2.setBounds(465, 400, 100, 35);

        JLabel lblFechaSalida = new JLabel("Fecha de Salida:");
        lblFechaSalida.setForeground(Color.white);
        lblFechaSalida.setBounds(465, 330, 200, 30);

        Dia2 = new JComboBox<>(Dias);
        Dia2.setBounds(565, 360, 50, 35);

        Año2 = new JComboBox<>(Años);
        Año2.setBounds(615, 360, 70, 35);

        Adultos = new JComboBox<>(Personas);
        Adultos.setBounds(700, 360, 70, 35);

        JLabel lblAdultos = new JLabel("Adultos:");
        lblAdultos.setForeground(Color.white);
        lblAdultos.setBounds(700, 330, 100, 30);

        Niños = new JComboBox<>(Personas);
        Niños.setBounds(785, 360, 70, 35);

        JLabel lblNiños = new JLabel("Niños:");
        lblNiños.setForeground(Color.white);
        lblNiños.setBounds(785, 330, 100, 30);

        Busqueda.setBorderPainted(false);
        Busqueda.setOpaque(false);
        Busqueda.setContentAreaFilled(false);
        Busqueda.setBounds(870, 360, 100, 35);
        Busqueda.addActionListener(this);

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
            this.dispose();
        }
        if (e.getSource() == user2) {
            this.dispose();
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
            if (Año_Salida==2024 || Año_Entrada==2024) {
            	esFechaValidaEntrada= true;
            	esFechaValidaSalida=true;}
            if (!esFechaValidaEntrada) {
                JOptionPane.showMessageDialog(this, "Fecha Entrada: Fecha Invalida, La fecha ya ha pasado");
            } else if (!esFechaValidaSalida) {
                JOptionPane.showMessageDialog(this, "Fecha Salida: Fecha Invalida, La fecha ya ha pasado");
            }
            boolean Valida = Marcadores_de_Posicion.Fecha2(Entrada,Dia_Entrada,Año_Entrada,Salida,Dia_Salida,Año_Salida);
         
            if (!Valida) {
                JOptionPane.showMessageDialog(this, "La Fecha de salida no puede ser posterior a la entrada");
            } 
            
            if (lugar.getText().equals("¿Dónde quieres ir?")) {
					JOptionPane.showMessageDialog(this, "No has escogido ningun destino");
				}
            
            else {
                // Perform your search or other action here.
            }
        }
        if (e.getSource()==iniciarSesionButton) {
			
		}
        if (e.getSource()==crearCuentaButton) {
			
		}
    }

   
}
