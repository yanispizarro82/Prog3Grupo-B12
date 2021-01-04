package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Classes.Products;
import Classes.ShirtsPants;
import Classes.Shoes;
import Classes.Users;
import DataBase.JDBC;
import Windows.Principal;

public class Main {
	public static Map<String, Users> userMap = new HashMap<String, Users>();
	public static Map<String, Products> prodMap = new HashMap<String, Products>();
	public static Users userIni = null;
	public static JFrame window;
	public static Thread loadMore;
	public static Set<ShirtsPants> ShirtsPants = new HashSet<ShirtsPants>();
	public static Set<Shoes> Shoes = new HashSet<Shoes>();
	public static Set<Users> Users = new HashSet<Users>();

	public static void main(String[] args) {

		JDBC.importar();
		JDBC.conectarBD();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				window = new Principal();
			}

		});

	}

}
