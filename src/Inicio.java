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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inicio extends JFrame implements ActionListener {

    private ImageIcon logo;
    private JLabel logo2;
    private JLabel x;
    private ImageIcon logout = new ImageIcon("logout.png");
    private JButton botonLogOut = new JButton(logout);
    private ImageIcon user = new ImageIcon("user.png");
    private JButton user2 = new JButton(user);
    private ImageIcon image;
    private String[] meses = {"Enero", "Febrero", "Marzo", "Abril",
    		"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    private JComboBox<String> mes;
    private JComboBox<String> mes2;
    private Integer [] Dias= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
    private JComboBox<Integer> Dia;
    private JComboBox<Integer> Dia2;
    private Integer [] Años= {2023,2024};
    private JComboBox<Integer> Año;
    private JComboBox<Integer> Año2;
    private Integer [] Personas= {1,2,3,4,5,6,7,8};
    private JComboBox<Integer> Adultos;
    private JComboBox<Integer> Niños;
    private JTextField lugar;
    private ImageIcon Buscar = new ImageIcon("Buscar.png");
    private JButton Busqueda = new JButton(Buscar);
    private Font fuente = new Font("Hammersmith One", Font.ITALIC, 60);

    public Inicio() {
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
        this.setSize(1000, 600); 
        this.setLayout(null);
        this.setTitle("BOOK4YOU");

        System.out.println("Existo!!");

        logo = new ImageIcon("logo.png");
        logo2 = new JLabel();
        logo2.setIcon(logo);
        logo2.setBounds(300,-15, 300, 200);

        botonLogOut.setBorderPainted (false);
        botonLogOut.setOpaque(false);
        botonLogOut.setContentAreaFilled(false);
        botonLogOut.setBounds(0, 20, 100, 100);
        botonLogOut.addActionListener(this);

        user2.setBorderPainted(false);
        user2.setOpaque(false);
        user2.setContentAreaFilled(false);
        user2.setBounds(850, 20, 100, 100);
        user2.addActionListener(this);

        x = new JLabel("Elije tu nueva aventura...");
        x.setForeground(Color.white);
        x.setFont(fuente);
        x.setBounds(45, 250, 700, 80);

        lugar = new JTextField();
        lugar.setForeground(Color.BLACK);
        lugar.setBounds(45, 360, 200, 35);
        Marcadores_de_Posicion.Cambio1(lugar, "¿Dónde quieres ir?");
        
        JLabel lblLugar = new JLabel("Lugar:");
        lblLugar.setForeground(Color.white);
        lblLugar.setBounds(45, 330, 100, 30);
        
        mes = new JComboBox<>(meses);
        mes.setBounds(260, 360, 100, 35);
        
        JLabel lblFechaEntrada = new JLabel("Fecha de Entrada:");
        lblFechaEntrada.setForeground(Color.white);
        lblFechaEntrada.setBounds(260, 330, 200, 30);
        
        Dia = new JComboBox<>(Dias);
        Dia.setBounds(360,360,50,35);
        
        Año = new JComboBox<>(Años);
        Año.setBounds(410,360,70,35);
        
        mes2 = new JComboBox<>(meses);
        mes2.setBounds(495, 360, 100, 35);
        
        JLabel lblFechaSalida = new JLabel("Fecha de Salida:");
        lblFechaSalida.setForeground(Color.white);
        lblFechaSalida.setBounds(495, 330, 200, 30);
        
        Dia2 = new JComboBox<>(Dias);
        Dia2.setBounds(595,360,50,35);
        
        Año2 = new JComboBox<>(Años);
        Año2.setBounds(645,360,70,35);
        
        Adultos = new JComboBox<>(Personas);
        Adultos.setBounds(730,360,70,35);
        
        JLabel lblAdultos = new JLabel("Adultos:");
        lblAdultos.setForeground(Color.white);
        lblAdultos.setBounds(730, 330, 100, 30);
        
        Niños = new JComboBox<>(Personas);
        Niños.setBounds(815,360,70,35);
        
        JLabel lblNiños = new JLabel("Niños:");
        lblNiños.setForeground(Color.white);
        lblNiños.setBounds(815, 330, 100, 30);
        
        Busqueda.setBorderPainted (false);
        Busqueda.setOpaque(false);
        Busqueda.setContentAreaFilled(false);
        Busqueda.setBounds(330,320, 300, 300);
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
    }
}
