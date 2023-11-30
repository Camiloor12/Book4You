import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Recarga extends JFrame implements ActionListener {
	 private ImageIcon volver = new ImageIcon("cap.png");
	 private JButton botonVolver = new JButton(volver);
	 private String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	 private Integer [] Año =  {2023,2024,2025,2026,2027,2028,2029,2030};
	 private JComboBox<String> Mes;
	 private JComboBox<Integer> Años;
	 private JLabel Nombre;
	 private JLabel NUM_T;
	 private JLabel CVC;
	 private JLabel MES;
	 private JLabel AÑO;
	 private JTextField TNombre;
	 private JTextField TNUMT;
	 private JPasswordField TCVC;
	 private JButton Pagar;
	 private JButton Cancelar;
	 private ImageIcon logo;
	 private JLabel logo2;
	 private int Valor;
	  public Recarga(int valor) {
		  Valor=valor;
		  try {
	            UIManager.setLookAndFeel(new NimbusLookAndFeel());
	        } catch (UnsupportedLookAndFeelException e) {
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
	        this.setSize(600, 400);
	        this.setLocationRelativeTo(null);
	        this.setLayout(null);
	        this.setTitle("BOOK4YOU");
	        logo = new ImageIcon("logo.png");
	        logo2 = new JLabel();
	        logo2.setIcon(logo);
	        int frameWidth = this.getWidth();
	        int logoWidth = logo.getIconWidth();
	        int logoX = (frameWidth - logoWidth) / 2;
	        logo2.setBounds(logoX, -10, logoWidth, 200);
		  botonVolver.setBorderPainted(false);
		  botonVolver.setOpaque(false);
		  botonVolver.setContentAreaFilled(false);
		  botonVolver.addActionListener(this);
		  botonVolver.addActionListener(this);
		  botonVolver.setBounds(6, 60, 40, 40);
		  TNombre= new JTextField();
		  Nombre= new JLabel("NOMBRE:");
		  Nombre.setForeground(Color.white);
		  Nombre.setFont(Inicio.fuente2);
		  Nombre.setBounds(80,140,100,35);
		  TNombre.setBounds(80,170,200,35);
		  TNombre.setFont(Inicio.fuente2);
		  NUM_T= new JLabel ("NUMERO DE TARJETA:");
		  NUM_T.setForeground(Color.white);
		  NUM_T.setFont(Inicio.fuente2);
		  NUM_T.setBounds(300,140,200,35);
		  TNUMT=  new JTextField();;
		  TNUMT.setBounds(300,170,200,35);
		  TNUMT.setFont(Inicio.fuente2);
		  Mes= new JComboBox<>(meses);
		  Mes.setBounds(80,240,110,35);
		  Mes.setFont(Inicio.fuente2);
		  MES=new JLabel ("MES ");;
		  MES.setForeground(Color.white);
		  MES.setBounds(80,210,120,35);
		  MES.setFont(Inicio.fuente2);
		  Años= new JComboBox<>(Año);
		  Años.setBounds(197,240,80,35);
		  Años.setFont(Inicio.fuente2);
		  AÑO= new JLabel ("AÑO");;
		  AÑO.setForeground(Color.white);
		  AÑO.setBounds(197,210,80,35);
		  AÑO.setFont(Inicio.fuente2);
		  CVC= new JLabel ("CVC");;
		  CVC.setForeground(Color.white);
		  CVC.setBounds(300,210,200,35);
		  CVC.setFont(Inicio.fuente2);
	      TCVC=  new JPasswordField();
	      TCVC.setBounds(300,240,200,35);
	      TCVC.setFont(Inicio.fuente2);
	      Pagar = new JButton("PAGAR");
	      Marcadores_de_Posicion.estiloBoton(Pagar);
	      Pagar.setBounds(80,290,200,30);
	      Pagar.addActionListener(this);
	      Pagar.setBackground(Color.white);
	      Pagar.setContentAreaFilled(true);
	      Cancelar= new JButton("CANCELAR PAGO");
	      Cancelar.setBounds(300,290,200,30);
	      Cancelar.addActionListener(this);
	      Marcadores_de_Posicion.estiloBoton(Cancelar);
	      Cancelar.setBackground(Color.white);
	      Cancelar.setContentAreaFilled(true);
		 
		
		  this.add(AÑO);
		  this.add(Años);
		  this.add(CVC);
		  this.add(MES);
		  this.add(Mes);
		  this.add(NUM_T);
		  this.add(Nombre);
		  this.add(TCVC);
		  this.add(TNUMT);
		  this.add(TNombre);
		  this.add(Cancelar);
		  this.add(Pagar);
		  this.add(botonVolver);
		  this.add(logo2);
		  this.setVisible(true);
		  
	  }

    
   
    
     public void actionPerformed(ActionEvent e) {
    	 String Mese = (String) Mes.getSelectedItem();
         int Año = (int) Años.getSelectedItem();
         boolean si= Marcadores_de_Posicion.Fecha(Mese, 28, Año);
      if (Pagar == e.getSource()) {
		if (!si) {
			JOptionPane.showMessageDialog(null, "Fecha Invalida", "Information", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (TNombre.getText().isEmpty() || TNUMT.getText().isEmpty()|| String.valueOf(TCVC.getPassword()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "Existen Campos sin rellenar.", "Information", JOptionPane.ERROR_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Compra exitosa.", "Information", JOptionPane.INFORMATION_MESSAGE);
			Marcadores_de_Posicion.actualizarQuevedos(1);
			new User(Valor);
			this.dispose();
		}
    	  
    	  
	}
      
      else  if (Cancelar == e.getSource()) {
    	JOptionPane.showMessageDialog(null, "Operacion cancelada.", "Information", JOptionPane.ERROR_MESSAGE);
		new User(Valor);
		this.dispose();
	}
      
      else   if (botonVolver == e.getSource()) {
    	 new User(Valor);
  		this.dispose();
	}
          
    }
     
     

    
}
