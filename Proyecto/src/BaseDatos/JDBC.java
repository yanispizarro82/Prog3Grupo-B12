package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static void importar() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha cargado el driver de la base de datos");
		}
	}

	public static void conectarBD() {
		try {
			Connection conn = DriverManager.getConnection("Producto.db");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO Producto VALUES('zapatos','pantalones')");
			ResultSet rs = stmt.executeQuery("SELECT * FROM Producto");

			conn.close();
		} catch (SQLException e) {
			System.out.println("Error de SQL");
		}
	}

	public static boolean comprobarUsuario(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean comprobarPassw(String text, String text2) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void crearUsuario(String text, String text2) {
		// TODO Auto-generated method stub
		
	}

}
