package Windows;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

import Classes.ShirtsPants;
import main.LoadMore;
import main.Main;

public class ProdWindow extends JFrame {

	public static Iterator<ShirtsPants> i = Main.ShirtsPants.iterator();
	public static int currentProd = 0;
	public static int untilProd = 0;
	public static JPanel panCat = new JPanel();
	public static JScrollPane scroll;
	public static JButton seeMore;

	public static void verMas() {
		untilProd += 6;
		panCat.remove(seeMore);
		for (; untilProd <= untilProd; untilProd++) {
			panCat.add(new JLabel("image " + untilProd));
			panCat.add(new JLabel("text " + untilProd));
			panCat.validate();
			scroll.revalidate();
		}
		panCat.add(seeMore);
	}

	public ProdWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Product window");
		scroll = new JScrollPane(panCat);
		scroll.setLayout(new ScrollPaneLayout());
		scroll.getVerticalScrollBar().setUnitIncrement(16);

		panCat.setLayout(new GridLayout(0, 2));

		seeMore = new JButton("See more ");

		// Menu
		JMenuBar bar = new JMenuBar();
		JMenuItem register = new JMenuItem("Register");
		JMenuItem logIn = new JMenuItem("Log In");
		JMenu myAccount = new JMenu("My account");
		JMenuItem profile = new JMenuItem("Profile");
		JMenuItem orders = new JMenuItem("Orders");
		JMenuItem favourite = new JMenuItem("favourite");
		JMenuItem closeSession = new JMenuItem("Close session");

		bar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		logIn.setMaximumSize(new Dimension(120, 30));

		register.setMaximumSize(new Dimension(120, 30));
		setJMenuBar(bar);
		myAccount.add(profile);
		myAccount.add(orders);
		myAccount.add(favourite);
		myAccount.add(closeSession);
		bar.add(logIn);
		bar.add(register);

		panCat.add(seeMore);

		seeMore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoadMore().run();
			}
		});
		new LoadMore().run();

		pack();
		setVisible(true);
		setSize(800, 600);
		add(scroll);

	}

	public String getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPrize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
