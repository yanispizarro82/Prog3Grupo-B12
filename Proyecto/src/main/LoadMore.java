package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Classes.ShirtsPants;
import Windows.ProdWindow;
import Windows.SelecProdWindow;

public class LoadMore extends Thread {

	ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			SelecProdWindow.show(Main.userIni, Main.prodMap.get(((JButton) e.getSource()).getName()));
		}
	};

	@Override
	public void run() {
		ProdWindow.untilProd += 5;
		ProdWindow.panCat.remove(ProdWindow.seeMore);
		for (; ProdWindow.untilProd <= ProdWindow.untilProd
				&& ProdWindow.i.hasNext(); ProdWindow.untilProd++) {
			ShirtsPants c;
			while (ProdWindow.i.hasNext()) {
				c = ProdWindow.i.next();
				if (!c.available()) {

					URL icono = Main.window.getClass().getResource("/" + c.getImage());

					JButton icon = new JButton(new ImageIcon(icono));
					icon.setName(String.valueOf(c.getId()));
					icon.addActionListener(listener);
					ProdWindow.panCat.add(icon);
					break;
				}
			}

			ProdWindow.panCat.validate();
			ProdWindow.scroll.revalidate();
		}
		ProdWindow.panCat.add(ProdWindow.seeMore);

	}
}
