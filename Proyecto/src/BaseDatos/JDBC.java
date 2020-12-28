package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Clases.CamisetasPantalones;
import Clases.Productos;
import Clases.Tallas;
import Clases.Usuarios;
import Clases.Zapatos;
import main.Main;

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
			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM camiseta");
			while (rs.next()) {

				int id = rs.getInt("idProducto");
				String nombre = rs.getString("nombre");
				float precio = rs.getFloat("precio");
				float descuento = rs.getFloat("descuento");
				String color = rs.getString("color");
				String imagen = rs.getString("imagen");
				boolean disponible = (rs.getInt("disponible") == 1);
				Tallas talla = Tallas.valueOf(rs.getString("talla"));
				String material = rs.getString("material");
				boolean esCamiseta = (rs.getInt("esCamiseta") == 1);
				Productos camiseta = new CamisetasPantalones(nombre, precio, descuento, color, imagen, disponible,
						talla, material, esCamiseta);
				Main.CamisetasPantalones.add((CamisetasPantalones) camiseta);
				Main.mapaProducto.put(String.valueOf(rs.getInt("idProducto")), camiseta);
			}
			rs = stmt.executeQuery("SELECT * FROM zapatos");
			while (rs.next()) {

				int id = rs.getInt("idProducto");
				String nombre = rs.getString("nombre");
				float precio = rs.getFloat("precio");
				float descuento = rs.getFloat("descuento");
				String color = rs.getString("color");
				String imagen = rs.getString("imagen");
				boolean disponible = (rs.getInt("disponible") == 1);
				int talla = rs.getInt("talla");
				String material = rs.getString("material");
				Productos zapato = new Zapatos(nombre, precio, descuento, color, id, imagen, talla, material, disponible);
				Main.zapatos.add((Zapatos) zapato);
				Main.mapaProducto.put(String.valueOf(rs.getInt("idProducto")), zapato);
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("Error de SQL");
		}
	}

	public static boolean comprobarUsuario(String correo) {
		boolean existe = false;
		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				if (rs.getString("correo").equals(correo)) {
					existe = true;
				}
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("Error de SQL");
		}
		return existe;
	}

	public static boolean comprobarContrasenya(String correo, String contrasenya) {
		boolean coincide = false;
		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				if (rs.getString("correo").equals(correo) && rs.getString("contrasenya").equals(contrasenya)) {
					coincide = true;
				}
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("Error de SQL");
		}
		return coincide;
	}

	public static void cargarUsuarios() {

		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				Usuarios usuario = new Usuarios(rs.getString("correo"), rs.getString("contrasenya"));
				Main.usuarios.add(usuario);
				Main.mapaUsuario.put(usuario.getCorreo(), usuario);
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("Error de SQL");
		}

	}

	public static void crearUsuario(String usu, String contra) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) AS conteo FROM usuario WHERE correo=?;");
			stmt.setString(1, usu);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			if (rs.getInt("conteo") == 0) {
				stmt = conn.prepareStatement("INSERT INTO usuario VALUES(?,?)");
				JOptionPane.showMessageDialog(Main.ventana, "Cuenta creada", "El usuario ha sido creado con éxito",
						JOptionPane.INFORMATION_MESSAGE);
				stmt.setString(1, usu);
				stmt.setString(2, contra);
				stmt.execute();
				Usuarios usuario = new Usuarios(usu, contra);
				Main.usuarios.add(usuario);
				Main.mapaUsuario.put(usuario.getCorreo(), usuario);
			} else {
				JOptionPane.showMessageDialog(Main.ventana, "Usuario ya existe", "El usuario ya existe",
						JOptionPane.ERROR_MESSAGE);
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("Error de SQL");
		}

	}

	public static boolean loDesea(Usuarios usu, String id) {
		boolean desea = false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM deseados WHERE correo=?;");
			stmt.setString(1, usu.getCorreo());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("idCamiseta").isEmpty()) {
					if (rs.getString("idZapatos").equals(id)) {
						desea = true;
					}
				} else {
					if (rs.getString("idCamiseta").equals(id)) {
						desea = true;
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
		}
		return desea;
	}

	public static ArrayList<Productos> productosDeseados(Usuarios usuario) {
		ArrayList<Productos> productos = new ArrayList<Productos>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM deseados WHERE correo=?;");
			stmt.setString(1, usuario.getCorreo());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("idCamiseta").isEmpty()) {
					productos.add(Main.mapaProducto.get(rs.getInt("idZapatos")));
				} else {
					productos.add(Main.mapaProducto.get(rs.getInt("idCamiseta")));
				}
			}
		} catch (SQLException e) {
			System.out.println("Error de SQL");
		}
		return productos;
	}

	public static boolean comprobarPassw(String text, String text2) {
		// TODO Auto-generated method stub
		return false;
	}
}
