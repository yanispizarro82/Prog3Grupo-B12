package main;

import java.awt.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import BaseDatos.JDBC;
import Clases.Productos;
import Ventanas.Principal;

public class CambiarImagen extends Thread {

	@Override
	public void run() {
		int actual = 0;
		ArrayList<Productos> productos = new ArrayList<Productos>();
		if (Main.usuarioIniciado != null) {
			List<Productos> productosDeseados = JDBC.productosDeseados(Main.usuarioIniciado);
			for (int i = 0; i < productosDeseados.size(); i++) {
				if (!productosDeseados.get(i).Disponible()) {
					productos.add(productosDeseados.get(i));
				}
			}
		} else {

			List<Productos> todosLosProductos = new ArrayList<Productos>(Main.mapaProducto.values());

			for (int i = 0; i < todosLosProductos.size(); i++) {
				if (!todosLosProductos.get(i).Disponible()) {
					productos.add(todosLosProductos.get(i));
				}
			}

		}

		while (true) {
			int maximo = productos.size();
			if (actual == maximo) {
				actual = 0;
			}
			try {
				Thread.sleep(3000);
				String ruta = "/" + Main.mapaProducto.get(String.valueOf(productos.get(actual).getId())).getImagen();

				URL icono = Main.ventana.getClass().getResource(ruta);
				Image img = new ImageIcon(icono).getImage();
				Image resizedImage = img.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
				Principal.boton1 = new JButton(new ImageIcon(resizedImage));

				Principal.superior.removeAll();
				Principal.superior.add(Principal.boton1);
				Main.ventana.revalidate();
				Main.ventana.validate();
				Main.ventana.repaint();
				actual += 1;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} catch (NullPointerException n) {
			}

		}
	}

}