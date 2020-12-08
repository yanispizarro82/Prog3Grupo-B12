package Ventanas;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

import main.Main;

public class Producto extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6449967614834433658L;
	public static int productoActual = 0;
	public static int hastaProducto = 0;
	public static JPanel panelCatalogo = new JPanel();
	public static JScrollPane scroll;
	public static JButton verMas;

	public Producto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ventana de Productos");
		scroll = new JScrollPane(panelCatalogo);
		scroll.setLayout(new ScrollPaneLayout());
		scroll.getVerticalScrollBar().setUnitIncrement(16);

		panelCatalogo.setLayout(new GridLayout(0, 2));

		// Menu
		JMenuBar barra = new JMenuBar();
		JMenuItem registrarse = new JMenuItem("Registrarse");
		JMenuItem iniciarSesion = new JMenuItem("Iniciar sesion");
		JMenu cuentaPersonal = new JMenu("Mi cuenta");
		JMenuItem perfil = new JMenuItem("Perfil");
		JMenuItem pedidos = new JMenuItem("Pedidos");
		JMenuItem deseados = new JMenuItem("Lista de deseados");
		JMenuItem cerrarSesion = new JMenuItem("Cerrar sesion");
		
		registrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.ventana.dispose();
				Main.ventana=new Registro();
			}
		});
		iniciarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Main.ventana, Principal.inicioSesionGeneral,"Iniciar sesion",JOptionPane.QUESTION_MESSAGE);
				barra.removeAll();
				barra.add(cuentaPersonal);
				validate();
				repaint();
				
			}
		});
		cerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				barra.removeAll();
				barra.add(iniciarSesion);
				barra.add(registrarse);
				validate();
				repaint();
			}
		});
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

		pack();
		setVisible(true);
		setSize(800, 600);
		add(scroll);

	}

}
