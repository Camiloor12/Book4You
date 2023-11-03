import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Marcadores_de_Posicion {

	public static void Cambio1(JTextField caja, String palabra) {
		caja.setText(palabra);
		caja.setForeground(Color.GRAY );
		caja.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

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

	public static boolean Fecha(String meses, int dia, int Año) {
		SimpleDateFormat Formato = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date FechaActual = new java.util.Date();
		try {
			String Fecha = Mes(meses) + "/" + dia + "/" + Año;
			java.util.Date Actual = Formato.parse(Fecha);
			if (Actual.before(FechaActual)) {
				return false;
			} else {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	protected static int Mes(String meses) {
		switch (meses) {
		case "Enero":
			return 1;
		case "Febrero":
			return 2;
		case "Marzo":
			return 3;
		case "Abril":
			return 4;
		case "Mayo":
			return 5;
		case "Junio":
			return 6;
		case "Julio":
			return 7;
		case "Agosto":
			return 8;
		case "Septiembre":
			return 9;
		case "Octubre":
			return 10;
		case "Noviembre":
			return 11;
		case "Diciembre":
			return 12;
		default:
			return 0; // o
		}

	}

	public static String Mes2(int meses) {
		switch (meses) {
		case 1:
			return "Enero";
		case 2:
			return "Febrero";
		case 3:
			return "Marzo";
		case 4:
			return "Abril";
		case 5:
			return "Mayo";
		case 6:
			return "Junio";
		case 7:
			return "Julio";
		case 8:
			return "Agosto";
		case 9:
			return "Septiembre";
		case 10:
			return "Octubre";
		case 11:
			return "Noviembre";
		case 12:
			return "Diciembre";
		default:
			return ""; // o
		}

	}

	public static boolean Fecha2(String meses_entrada, int dia_entrada, int año_entrada, String meses_salida,
			int dia_salida, int año_salida) {
		SimpleDateFormat Formato = new SimpleDateFormat("MM/dd/yyyy");
		try {
			String Fecha1 = Mes(meses_entrada) + "/" + dia_entrada + "/" + año_entrada;
			java.util.Date Primera = Formato.parse(Fecha1);
			String Fecha2 = Mes(meses_salida) + "/" + dia_salida + "/" + año_salida;
			java.util.Date Segunda = Formato.parse(Fecha2);
			if (Segunda.before(Primera)) {
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

	public static String devolverUsuarioInfo() {
		String nombreCompleto = "";
		int telefono = 0;
		int quevedos = 0;
		Date Fechadenacimiento = null;
		String sql = "SELECT NOMBRE_APELLIDO, TELEFONO, QUEVEDOS,FECHA_DE_NACIMIENTO FROM USUARIO WHERE E_MAIL = '"
				+ IniciarSesion.EmailT.getText() + "'";
		try {
			Statement st = Main.con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					nombreCompleto = rs.getString("NOMBRE_APELLIDO");
					telefono = rs.getInt("TELEFONO");
					quevedos = rs.getInt("QUEVEDOS");
					Fechadenacimiento = rs.getDate("FECHA_DE_NACIMIENTO");
					System.out.println(Fechadenacimiento);
				}
			} else {
				System.out.println("No se encontró nada.");
			}
		} catch (SQLException e2) {
			System.out.println("Ha habido un error en el SELECT " + e2);
		}

		return nombreCompleto + "," + telefono + "," + quevedos + "," + Fechadenacimiento;
	}

	public static boolean actualizarQuevedos() {
		int nuevaCantidadQuevedos = User.Quevedosn + User.Quevedos;
		Inicio.creditos.setText("Saldo Actual: " + (String.valueOf(nuevaCantidadQuevedos) + " Q"));
		String sql = "UPDATE USUARIO SET QUEVEDOS = " + nuevaCantidadQuevedos + " WHERE E_MAIL = '" + Inicio.correo
				+ "'";
		try {
			Statement st = Main.con.createStatement();
			st.executeUpdate(sql);
			System.out.println("Cantidad de Quevedos actualizada exitosamente.");
			return true;
		} catch (SQLException e) {
			System.out.println("Error al actualizar Quevedos: " + e);
			return false;
		}
	}

	public static boolean Cambio_Datos(String Correo_id, String nombre, String Correo, String Contra, int Telefono) {
		String sql = "BEGIN actualizar_informacion(" + Correo_id + ",'" + nombre + "'," + Telefono + ",'" + Correo + "','"
				+ Contra + "');" +"END;";
		try {
			Statement st = Main.con.createStatement();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static void Obtener () {
		String devolver = devolverUsuarioInfo();
		String[] valores = devolver.split(",");
		Inicio.creditos.setText("Saldo Actual: " + (String.valueOf(valores[2]) + " Q"));
	}

}
