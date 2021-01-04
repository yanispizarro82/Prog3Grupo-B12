package main;

import java.awt.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Classes.Products;
import DataBase.JDBC;
import Windows.Principal;

public class ChangeImage extends Thread {

	@Override
	public void run() {
		int current = 0;
		ArrayList<Products> products = new ArrayList<Products>();
		if (Main.userIni != null) {
			List<Products> wantProd = JDBC.wantProd(Main.userIni);
			for (int i = 0; i < wantProd.size(); i++) {
				if (!wantProd.get(i).available()) {
					products.add(wantProd.get(i));
				}
			}
		} else {

			List<Products> allProducts = new ArrayList<Products>(Main.prodMap.values());

			for (int i = 0; i < allProducts.size(); i++) {
				if (!allProducts.get(i).available()) {
					products.add(allProducts.get(i));
				}
			}

		}

		while (true) {
			int max = products.size();
			if (current == max) {
				current = 0;
			}
			try {
				Thread.sleep(3000);
				String route = "/" + Main.prodMap.get(String.valueOf(products.get(current).getId())).getImage();

				URL icon = Main.window.getClass().getResource(route);
				Image img = new ImageIcon(icon).getImage();
				Image resizedImage = img.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
				Principal.button1 = new JButton(new ImageIcon(resizedImage));

				Principal.superior.removeAll();
				Principal.superior.add(Principal.button1);
				Main.window.revalidate();
				Main.window.validate();
				Main.window.repaint();
				current += 1;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} catch (NullPointerException n) {
			}

		}
	}

}