import javax.swing.ImageIcon;
import javax.swing.JButton;

public class botones {
	private ImageIcon alante = new ImageIcon("alante.png");
	private ImageIcon atra = new ImageIcon("atras.png");
	private int con = 1;
	public int getCon() {
		return con;
	}

	public void setCon(int con) {
		this.con = con;
	}

	public ImageIcon getAlante() {
		return alante;
	}

	public void setAlante(ImageIcon alante) {
		this.alante = alante;
	}

	public ImageIcon getAtra() {
		return atra;
	}

	public void setAtra(ImageIcon atra) {
		this.atra = atra;
	}

	public JButton getPalante() {
		return palante;
	}

	public void setPalante(JButton palante) {
		this.palante = palante;
	}

	public JButton getPatras() {
		return patras;
	}

	public void setPatras(JButton patras) {
		this.patras = patras;
	}

	private JButton palante = new JButton(alante);
	private JButton patras= new JButton(atra);
	
	public botones(int x, int y) {	// 100 = y	
		palante.setBorderPainted(false);
		palante.setOpaque(false);
		palante.setContentAreaFilled(false);
		palante.setBounds(311+x,y,35,35);		
		patras.setBorderPainted(false);
		patras.setOpaque(false);
		patras.setContentAreaFilled(false);
		patras.setBounds(x,y,35,35);
	}
}
