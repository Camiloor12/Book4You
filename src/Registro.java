import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Registro implements ActionListener{
	  private ImageIcon volver = new ImageIcon("cap.jpg");
	  private JButton botonVolver = new JButton(volver);
	public Registro() {
		Base b = new Base();
		botonVolver.setBorderPainted(false);
        botonVolver.setOpaque(false);
        botonVolver.setContentAreaFilled(false);
        botonVolver.addActionListener(this);
        botonVolver.setBounds(10, 35, 100, 77);
        b.add(botonVolver);   
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
