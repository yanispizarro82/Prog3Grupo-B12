package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classes.Products;
import Classes.ShirtsPants;
import Classes.Shoes;
import Classes.Sizes;
import Classes.Users;
import main.Main;

public class JDBC {
	public static void importar() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver could not be found in DB");
		}
	}

	public static void conectarBD() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM camiseta");
			while (rs.next()) {

				int id = rs.getInt("idProducto");
				String name = rs.getString("name");
				float price = rs.getFloat("precio");
				float discount = rs.getFloat("descuento");
				String colour = rs.getString("color");
				String image = rs.getString("imagen");
				boolean available = (rs.getInt("disponible") == 1);
				Sizes size = Sizes.valueOf(rs.getString("talla"));
				String material = rs.getString("material");
				boolean isShirt = (rs.getInt("esCamiseta") == 1);
				Products shirt = new ShirtsPants(id, name, price, discount, colour, image, available,
						size, material, isShirt);
				Main.ShirtsPants.add((ShirtsPants) shirt);
				Main.prodMap.put(String.valueOf(rs.getInt("idProducto")), shirt);
			}
			rs = stmt.executeQuery("SELECT * FROM zapatos");
			while (rs.next()) {

				int id = rs.getInt("idProduct");
				String name = rs.getString("name");
				float price = rs.getFloat("price");
				float discount = rs.getFloat("discount");
				String colour = rs.getString("colour");
				String image = rs.getString("image");
				boolean available = (rs.getInt("available") == 1);
				int talla = rs.getInt("talla");
				String material = rs.getString("material");
				Products shoes = new Shoes(id, name, price, discount, colour, image, talla, material, available);
				Main.Shoes.add((Shoes) shoes);
				Main.prodMap.put(String.valueOf(rs.getInt("idProduct")), shoes);
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL error");
		}
	}

	public static boolean checkUser(String mail) {
		boolean exists = false;
		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				if (rs.getString("mail").equals(mail)) {
					exists = true;
				}
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL error");
		}
		return exists;
	}

	public static boolean checkPassword(String mail, String password) {
		boolean match = false;
		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				if (rs.getString("mail").equals(mail) && rs.getString("password").equals(password)) {
					match = true;
				}
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("SQL error");
		}
		return match;
	}

	public static void loadUser() {

		try {

			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario");
			while (rs.next()) {
				Users user = new Users(rs.getString("correo"), rs.getString("contrasenya"));
				Main.Users.add(user);
				Main.userMap.put(user.getMail(), user);
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
				JOptionPane.showMessageDialog(Main.window, "Cuenta creada", "El usuario ha sido creado con éxito",
						JOptionPane.INFORMATION_MESSAGE);
				stmt.setString(1, usu);
				stmt.setString(2, contra);
				stmt.execute();
				Users user = new Users(usu, contra);
				Main.Users.add(user);
				Main.userMap.put(user.getMail(), user);
			} else {
				JOptionPane.showMessageDialog(Main.window, "Usuario ya existe", "El usuario ya existe",
						JOptionPane.ERROR_MESSAGE);
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("Error de SQL");
		}

	}

	public static boolean loDesea(Users usu, String id) {
		boolean desea = false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM deseados WHERE correo=?;");
			stmt.setString(1, usu.getMail());
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

	public static ArrayList<Products> productosDeseados(Users usuario) {
		ArrayList<Products> productos = new ArrayList<Products>();
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:tienda.db");
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM deseados WHERE correo=?;");
			stmt.setString(1, usuario.getMail());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("idCamiseta").isEmpty()) {
					productos.add(Main.prodMap.get(rs.getInt("idShoes")));
				} else {
					productos.add(Main.prodMap.get(rs.getInt("idShirts")));
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
