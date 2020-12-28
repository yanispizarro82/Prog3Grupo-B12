package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import Clases.CamisetasPantalones;
import Ventanas.Producto;
import Ventanas.SelecProd;

public class CargarMas extends Thread {

	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			SelecProd.mostrar(Main.usuarioIniciado, Main.mapaProducto.get(((JButton) e.getSource()).getName()));
		}
	};

	@Override
	public void run() {
		Producto.hastaProd += 5;
		Producto.panCat.remove(Producto.verMas);
		for (; Producto.prodAct <= Producto.hastaProd
				&& Producto.i.hasNext(); Producto.prodAct++) {
			CamisetasPantalones c;
			while (Producto.i.hasNext()) {
				c = Producto.i.next();
				if (!c.Disponible()) {

					URL icono = Main.ventana.getClass().getResource("/" + c.getImagen());

					JButton iconito = new JButton(new ImageIcon(icono));
					iconito.setName(String.valueOf(c.getId()));
					iconito.addActionListener(listener);
					Producto.panCat.add(iconito);
					break;
				}
			}

			Producto.panCat.validate();
			Producto.scroll.revalidate();
		}
		Producto.panCat.add(Producto.verMas);

	}
}
