import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Marcadores_de_Posicion {

    public static void Cambio1(JTextField caja, String palabra) {
    	caja.setText(palabra);
    	caja.setForeground(Color.BLACK);

    	caja.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (caja.getText().equals(palabra)) {
                	caja.setText("");
                	caja.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (caja.getText().isEmpty()) {
                	caja.setText(palabra);
                	caja.setForeground(Color.GRAY);
                }
            }
        });
    }
}
