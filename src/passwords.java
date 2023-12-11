import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class passwords implements ActionListener{
	private ImageIcon Hide = new ImageIcon("hide.png");
	private ImageIcon Show = new ImageIcon("show.png");
	private JButton ShowHideButton = new JButton(Show);
	private JPasswordField p;
	public passwords(int x, int y,JPasswordField Pass,JFrame f) {
		ShowHideButton.setBorderPainted(false);
		ShowHideButton.setOpaque(false);
		ShowHideButton.setContentAreaFilled(false);
		ShowHideButton.setBounds(x, y, 30, 30);
		ShowHideButton.addActionListener(this);
		this.p = Pass;
		f.add(ShowHideButton);
	}
	public JButton gButtn() {
		return ShowHideButton;
	}
	public void sButtn(JButton showHideButton) {
		ShowHideButton = showHideButton;
	}
	public passwords(int x, int y,JPasswordField Pass,JPanel f) {
		ShowHideButton.setBorderPainted(false);
		ShowHideButton.setOpaque(false);
		ShowHideButton.setContentAreaFilled(false);
		ShowHideButton.setBounds(x, y, 30, 30);
		ShowHideButton.addActionListener(this);
		this.p = Pass;
		f.add(ShowHideButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 if (p.getEchoChar() == 0) {//Ocultar password
	            p.setEchoChar('*');
	            ShowHideButton.setIcon(Show);
	        } else {//Mostrar password
	            p.setEchoChar((char) 0);
	            ShowHideButton.setIcon(Hide);
	        }
		
	}
}
