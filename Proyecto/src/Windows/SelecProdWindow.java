package Windows;

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

import Classes.Products;
import Classes.Sizes;
import Classes.Users;
import main.Main;

public class SelecProdWindow {
	static JDialog selection;

	public static void show(Users user, Products products) {
		selection = new JDialog(Main.window, products.getName(), true);
		selection.setLayout(new GridLayout(2, 2));
		JPanel info = new JPanel(new BorderLayout());

		URL icon = Main.window.getClass().getResource("/" + products.getImage());
		Image image = new ImageIcon(icon).getImage();
		Image resizedImage = image.getScaledInstance(220, 220, java.awt.Image.SCALE_SMOOTH);
		JLabel jlImage = new JLabel(new ImageIcon(resizedImage));
		selection.add(jlImage);

		JLabel name = new JLabel(products.getName());
		JLabel price = new JLabel(String.valueOf(products.getPrize() * products.getDiscount()));
		JComboBox<Sizes> sizes = new JComboBox<Sizes>();
		sizes.setModel(new DefaultComboBoxModel<Sizes>(Sizes.values()));
		info.add(name, BorderLayout.NORTH);
		info.add(price, BorderLayout.WEST);
		info.add(sizes, BorderLayout.EAST);

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
