import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	private static final String USER = "23_24_DAM2_KBDO";
	private static final String PWD = "123456";
	private static final String URL = "jdbc:oracle:thin:@  192.168.3.26 :1521:xe";
	public static Connection con = conectarBaseDatos();
	// Si est�is desde casa, la url ser� oracle.ilerna.com y no 192.168.3.26

	
	public static void main (String [] args) {
		new Inicio();
	}
	
	public static Connection conectarBaseDatos() {
		Connection con = null;
		System.out.println("Intentando conectarse a la base de datos");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver " + e);
		} catch (SQLException e) {
			System.out.println("Error en las credenciales o en la URL " + e);
		}

		System.out.println("Conectados a la base de datos");

		return con;
	}

}
