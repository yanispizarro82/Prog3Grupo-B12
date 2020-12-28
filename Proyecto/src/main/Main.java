package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import BaseDatos.JDBC;
import Clases.CamisetasPantalones;
import Clases.Productos;
import Clases.Usuarios;
import Clases.Zapatos;
import Ventanas.Principal;

public class Main {
	public static Map<String, Usuarios> mapaUsuario = new HashMap<String, Usuarios>();
	public static Map<String, Productos> mapaProducto = new HashMap<String, Productos>();
	public static Usuarios usuarioIniciado = null;
	public static JFrame ventana;
	public static Thread cargarMas;
	public static Set<CamisetasPantalones> CamisetasPantalones = new HashSet<CamisetasPantalones>();
	public static Set<Zapatos> zapatos = new HashSet<Zapatos>();
	public static Set<Usuarios> usuarios = new HashSet<Usuarios>();

	public static void main(String[] args) {

		JDBC.importar();
		JDBC.conectarBD();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ventana = new Principal();
			}

		});

	}

}
