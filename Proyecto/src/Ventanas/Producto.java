package Ventanas;

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

import Clases.CamisetasPantalones;
import main.CargarMas;
import main.Main;

public class Producto extends JFrame {

	public static Iterator<CamisetasPantalones> i = Main.CamisetasPantalones.iterator();
	public static int prodAct = 0;
	public static int hastaProd = 0;
	public static JPanel panCat = new JPanel();
	public static JScrollPane scroll;
	public static JButton verMas;

	public static void verMas() {
		hastaProd += 6;
		panCat.remove(verMas);
		for (; prodAct <= hastaProd; prodAct++) {
			panCat.add(new JLabel("imagen " + prodAct));
			panCat.add(new JLabel("texto " + prodAct));
			panCat.validate();
			scroll.revalidate();
		}
		panCat.add(verMas);
	}

	public Producto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana de Productos");
		scroll = new JScrollPane(panCat);
		scroll.setLayout(new ScrollPaneLayout());
		scroll.getVerticalScrollBar().setUnitIncrement(16);

		panCat.setLayout(new GridLayout(0, 2));

		verMas = new JButton("ver mas ");

		// Menu
		JMenuBar barra = new JMenuBar();
		JMenuItem registrarse = new JMenuItem("Registrarse");
		JMenuItem iniciarSesion = new JMenuItem("Iniciar sesion");
		JMenu cuentaPersonal = new JMenu("Mi cuenta");
		JMenuItem perfil = new JMenuItem("Perfil");
		JMenuItem pedidos = new JMenuItem("Pedidos");
		JMenuItem deseados = new JMenuItem("Lista de deseados");
		JMenuItem cerrarSesion = new JMenuItem("Cerrar sesion");

		barra.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		iniciarSesion.setMaximumSize(new Dimension(120, 30));

		registrarse.setMaximumSize(new Dimension(120, 30));
		setJMenuBar(barra);
		cuentaPersonal.add(perfil);
		cuentaPersonal.add(pedidos);
		cuentaPersonal.add(deseados);
		cuentaPersonal.add(cerrarSesion);
		barra.add(iniciarSesion);
		barra.add(registrarse);

		panCat.add(verMas);

		verMas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CargarMas().run();
			}
		});
		new CargarMas().run();

		pack();
		setVisible(true);
		setSize(800, 600);
		add(scroll);

	}

	public String getImagen() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getDescuento() {
		// TODO Auto-generated method stub
		return 0;
	}

}
