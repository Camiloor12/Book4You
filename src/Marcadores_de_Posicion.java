
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Marcadores_de_Posicion {
	public static Productos p1;
	public static Productos p2;
	public static Productos p3;
	public static Productos p4;
	public static Productos p5;
	public static Productos p6;
	public static Productos p7;
	public static Productos p8;
	public static Productos p9;
	public static Productos p10;
	public static int quevedos;
	public static int nuevaCantidadQuevedos;

	public static void Cambio1(JTextField caja, String palabra) {
		caja.setText(palabra);
		caja.setForeground(Color.GRAY);
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

	public static void Cambio2(JLabel marca) {
		marca.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		marca.setBackground(Color.BLACK);
		marca.setFont(new Font("Oswald", Font.PLAIN, 13));
	}

	public static boolean Fecha(String meses, int dia, int Año) {
		SimpleDateFormat Formato = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date FechaActual = new java.util.Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(FechaActual);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		Date fechaConHorasCero = calendar.getTime();
		try {
			String Fecha = Mes(meses) + "/" + dia + "/" + Año;
			java.util.Date FechaReserva = Formato.parse(Fecha);
			if (FechaReserva.equals(fechaConHorasCero)) {
				return true;
			} else if (FechaReserva.before(fechaConHorasCero)) {
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
			}
			if (Segunda.equals(Primera)) {
				return false;
			}

			else {
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
				+ Inicio.correo + "'";
		try {
			Statement st = Main.con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					nombreCompleto = rs.getString("NOMBRE_APELLIDO");
					telefono = rs.getInt("TELEFONO");
					quevedos = rs.getInt("QUEVEDOS");
					Fechadenacimiento = rs.getDate("FECHA_DE_NACIMIENTO");
				}
			} else {
				System.out.println("No se encontró nada.");
			}
		} catch (SQLException e2) {
			System.out.println("Ha habido un error en el SELECT " + e2);
		}

		return nombreCompleto + "," + telefono + "," + quevedos + "," + Fechadenacimiento;
	}

	public static void actualizarQuevedos(int Valor) {
		String devolver = devolverUsuarioInfo();
		String[] valores = devolver.split(",");
		int a = (Integer.parseInt(valores[2])) ;
		if (Valor == 1) {
			nuevaCantidadQuevedos = User.Quevedosn + a;
		} else if (Valor == 0) {
			nuevaCantidadQuevedos = a - Reserva.A ;
		}
			Inicio.creditos.setText("Saldo Actual: " + (String.valueOf(nuevaCantidadQuevedos) + " Q"));
			String sql = "UPDATE USUARIO SET QUEVEDOS = " + nuevaCantidadQuevedos + " WHERE E_MAIL = '" + Inicio.correo
					+ "'";
			try {
				Statement st = Main.con.createStatement();
				st.executeUpdate(sql);
				System.out.println("Cantidad de Quevedos actualizada exitosamente.");

			} catch (SQLException e) {
				System.out.println("Error al actualizar Quevedos: " + e);

			}
		 
	
	}

	public static boolean Cambio_Datos(String Correo_id, String nombre, String Correo, String Contra, int Telefono) {
		String sql = "BEGIN actualizar_informacion(" + " p_correo => ?," + " p_nuevo_nombre => ?,"
				+ " p_nuevo_telefono => ?," + " p_nuevo_correo => ?," + " p_nueva_contrasena => ?);" + " COMMIT; END;";

		try {
			PreparedStatement pstmt = Main.con.prepareStatement(sql);
			pstmt.setString(1, Correo_id);
			pstmt.setString(2, nombre);
			pstmt.setInt(3, Telefono);
			pstmt.setString(4, Correo);
			pstmt.setString(5, Contra);

			pstmt.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void Obtener() {
		String devolver = devolverUsuarioInfo();
		String[] valores = devolver.split(",");
		Inicio.creditos.setText("Saldo Actual: " + (String.valueOf(valores[2]) + " Q"));
		Inicio.nom.setText("Usuario: " + (String.valueOf(valores[0])));
	}

	public static void crearHotel() {
		int id = 0;
		String direccion = "";
		int cp = 0;
		String Nombre = "";
		String Descripcion = "";
		int Precio = 0;
		String sql = "SELECT * FROM LUGAR_HOTEL";
		try {
			Statement st = Main.con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					id = rs.getInt("ID_HOTEL");
					direccion = rs.getString("DIRECCION");
					cp = rs.getInt("CP");
					Nombre = rs.getString("NOMBRE");
					Descripcion = rs.getString("DESCRIPCION");
					Precio = rs.getInt("PRECIO");
					switch (id) {
					case 1:
						p1 = new Productos(id, direccion, cp, Nombre, Descripcion, Precio);
						break;
					case 2:
						p2 = new Productos(id, direccion, cp, Nombre, Descripcion, Precio);
						break;
					case 3:
						p3 = new Productos(id, direccion, cp, Nombre, Descripcion, Precio);
						break;
					case 4:
						p4 = new Productos(id, direccion, cp, Nombre, Descripcion, Precio);
						break;
					case 5:
						p5 = new Productos(id, direccion, cp, Nombre, Descripcion, Precio);
						break;
					case 6:
						p6 = new Productos(id, direccion, cp, Nombre, Descripcion, Precio);
						break;
					case 7:
						p7 = new Productos(id, direccion, cp, Nombre, Descripcion, Precio);
						break;
					case 8:
						p8 = new Productos(id, direccion, cp, Nombre, Descripcion, Precio);
						break;
					case 9:
						p9 = new Productos(id, direccion, cp, Nombre, Descripcion, Precio);
						break;
					case 10:
						p10 = new Productos(id, direccion, cp, Nombre, Descripcion, Precio);
						break;

					}

				}
			} else {
				System.out.println("No se encontró nada.");
			}
		} catch (SQLException e) {
			System.out.println("Error" + e);

		}
	}

	public static boolean Ciudad(String Ciudad) {

		String sql = "SELECT * FROM CIUDADES WHERE CIUDADES = '" + Ciudad + "'";

		try {
			Statement st = Main.con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String Ciudades = rs.getString("CIUDADES");
					if (Ciudades.equals(Ciudad)) {
						return true;
					}

				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static String[] obtenerFechaActual() {
		// Obtener la fecha actual
		Date fecha = new Date();

		// Crear un objeto SimpleDateFormat para formatear la fecha
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		// Formatear la fecha
		String fechaFormateada = formato.format(fecha);

		// Dividir la fecha formateada en día, mes y año
		String[] partesFecha = fechaFormateada.split("/");

		return partesFecha;
	}

	public static long calcularDiferenciaEnDias(String meses_entrada, int dia_entrada, int año_entrada,
			String meses_salida, int dia_salida, int año_salida) {
		SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
		try {
			String fechaEntrada = Mes(meses_entrada) + "/" + dia_entrada + "/" + año_entrada;
			java.util.Date fechaInicial = formato.parse(fechaEntrada);

			String fechaSalida = Mes(meses_salida) + "/" + dia_salida + "/" + año_salida;
			java.util.Date fechaFinal = formato.parse(fechaSalida);

			long diferenciaEnMillis = fechaFinal.getTime() - fechaInicial.getTime();

			return diferenciaEnMillis / (24 * 60 * 60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static int calcularPrecioTotal(int noches, int cantidadNinos, int cantidadAdultos, int precioBasePorNoche) {
		if (noches != 1) {
			noches--;
		}

		int precioAdulto = precioBasePorNoche;
		int Precionniño = precioBasePorNoche / 2;
		int Niño = (cantidadNinos * Precionniño) * noches;
		int Adulto = (cantidadAdultos * precioAdulto) * noches;

		if (cantidadNinos == 0) {
			return Adulto;
		}

		else {
			return Niño + Adulto;
		}
	}

	public static boolean Reserva(int ID_RESERVA, String FECHA_R_E, String FECHA_R_S, int ADULTOS, int NIÑOS,
			int PRECIO_TOTAL, int NOCHES, int ID_HOTEL, String E_MAIL) {

		String sql = "INSERT INTO RESERVA (ID_RESERVA, FECHA_R_E, FECHA_R_S, ADULTOS, NIÑOS, PRECIO_TOTAL, NOCHES, ID_HOTEL, E_MAIL) "
				+ "VALUES (?, TO_DATE(?, 'DD/MM/YYYY'), TO_DATE(?, 'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ps = Main.con.prepareStatement(sql);
			ps.setInt(1, ID_RESERVA);
			ps.setString(2, FECHA_R_E);
			ps.setString(3, FECHA_R_S);
			ps.setInt(4, ADULTOS);
			ps.setInt(5, NIÑOS);
			ps.setInt(6, PRECIO_TOTAL);
			ps.setInt(7, NOCHES);
			ps.setInt(8, ID_HOTEL);
			ps.setString(9, E_MAIL);

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.out.println("Ha habido un error en el Insert " + e);
		}
		return false;
	}
	public static String devolverReserva(int reserva) {
		String idReserva = "";
		Date fecha_e = null;
		Date fecha_s = null;
		int adultos = 0;
		int ninos = 0;
		int precioT = 0;
		int noches = 0;
		int id_hotel = 0;
		String correo = "";
		String sql = "SELECT ID_RESERVA, FECHA_R_E, FECHA_R_S,ADULTOS,NIÑOS,PRECIO_TOTAL,NOCHES,ID_HOTEL,E_MAIL FROM RESERVA WHERE E_MAIL = '"
				+ Inicio.correo + "' AND ID_RESERVA ="+ reserva;
		try {
			Statement st = Main.con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					idReserva = rs.getString("ID_RESERVA");
					fecha_e = rs.getDate("FECHA_R_E");
					fecha_s = rs.getDate("FECHA_R_S");
					adultos = rs.getInt("ADULTOS");
					ninos = rs.getInt("NIÑOS");
					precioT = rs.getInt("PRECIO_TOTAL");
					noches = rs.getInt("NOCHES");
					id_hotel = rs.getInt("ID_HOTEL");
					correo = rs.getString("E_MAIL");
				}
			} else {
				System.out.println("No se encontró nada.");
			}
		} catch (SQLException e2) {
			System.out.println("Ha habido un error en el SELECT " + e2);
		}

		return idReserva + "," + fecha_e + "," + fecha_s + "," + adultos + "," + ninos + "," + precioT + "," + noches + "," + id_hotel+ "," + correo;
	}
	
	public static boolean Errorp(String CORREO) {
		String sql = "SELECT * FROM USUARIO WHERE E_MAIL = '" + CORREO + "'";

		try {
			Statement st = Main.con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.isBeforeFirst()) {
				while (rs.next()) {
					String CORREO2 = rs.getString("E_MAIL");
					if (CORREO.equals(CORREO2)){ 
						return true;
}
				}}}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
