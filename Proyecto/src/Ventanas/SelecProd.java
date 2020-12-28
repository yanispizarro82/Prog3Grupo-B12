package Ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Clases.Productos;
import Clases.Tallas;
import Clases.Usuarios;
import main.Main;

public class SelecProd {
	static JDialog selection;

	public static void mostrar(Usuarios user, Productos productos) {
		selection = new JDialog(Main.ventana, productos.getNombre(), true);
		selection.setLayout(new GridLayout(2, 2));
		JPanel info = new JPanel(new BorderLayout());

		URL icon = Main.ventana.getClass().getResource("/" + productos.getImagen());
		Image img = new ImageIcon(icon).getImage();
		Image resizedImage = img.getScaledInstance(220, 220, java.awt.Image.SCALE_SMOOTH);
		JLabel imagen = new JLabel(new ImageIcon(resizedImage));
		selection.add(imagen);

		JLabel name = new JLabel(productos.getNombre());
		JLabel price = new JLabel(String.valueOf(productos.getPrecio() * productos.getDescuento()));
		JComboBox<Tallas> tallas = new JComboBox<Tallas>();
		tallas.setModel(new DefaultComboBoxModel<Tallas>(Tallas.values()));
		info.add(name, BorderLayout.NORTH);
		info.add(price, BorderLayout.WEST);
		info.add(tallas, BorderLayout.EAST);

		selection.add(info);

		JButton jbFavor = new JButton("Add to favourites.");
		JButton jbConfirm = new JButton("Add to basket");

		selection.add(jbFavor);
		selection.add(jbConfirm);

		selection.setSize(800, 600);
		selection.setVisible(true);
		selection.setResizable(false);

	}

}
