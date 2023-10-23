import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
                	caja.setFont(new Font("Oswald", Font.PLAIN, 13));
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
    
    public static boolean Fecha(String meses, int dia) {
        SimpleDateFormat Formato = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date FechaActual = new java.util.Date();
        try {
            String Fecha = Mes(meses) + "/" + dia + "/" + añoactual();
            java.util.Date Actual = Formato.parse(Fecha);
            if (Actual.before(FechaActual) ) {
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }




    
	private static int Mes(String meses) {
        switch (meses) {
            case "Enero": return 1;
            case "Febrero": return 2;
            case "Marzo": return 3;
            case "Abril": return 4;
            case "Mayo": return 5;
            case "Junio": return 6;
            case "Julio": return 7;
            case "Agosto": return 8;
            case "Septiembre": return 9;
            case "Octubre": return 10;
            case "Noviembre": return 11;
            case "Diciembre": return 12;
            default: return 0; // o
        }
        
    }

	 private static  int añoactual() {
         return Calendar.getInstance().get(Calendar.YEAR);
     }
	 
	 
	 public static boolean Fecha2(String meses_entrada, int dia_entrada, int año_entrada,String meses_salida, int dia_salida, int año_salida) {
	        SimpleDateFormat Formato = new SimpleDateFormat("MM/dd/yyyy");
	        try {
	            String Fecha1 = Mes(meses_entrada) + "/" + dia_entrada + "/" + año_entrada;
	            java.util.Date Primera = Formato.parse(Fecha1);
	            String Fecha2 = Mes(meses_salida) + "/" + dia_salida + "/" + año_salida;
	            java.util.Date Segunda = Formato.parse(Fecha2);
	            if (Segunda.before(Primera) ) {
	                return false;
	            } else {
	                return true;
	            }
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 public static void estiloBoton(JButton boton) {
		 boton.setFont(new Font("Oswald", Font.PLAIN, 13));
		    boton.setForeground(Color.BLACK);
		    boton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); 
		    boton.setFocusPainted(false);
		    boton.setContentAreaFilled(false);

	    }
	 
	 
	
       
    }


