package Ventanas;

import javax.swing.*;

import main.Main;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Principal extends JFrame {

	public static JMenuBar barra = new JMenuBar();
	public static JMenuItem registrarse = new JMenuItem("Registrarse");
	public static JMenuItem inicioSesion = new JMenuItem("Iniciar sesión");
	public static JMenu Cuenta = new JMenu("Cuenta");
	public static JMenuItem perfil = new JMenuItem("Perfil");
	public static JMenuItem pedidos = new JMenuItem("Pedidos");
	public static JMenuItem favoritos = new JMenuItem("Favoritos");
	public static JMenuItem cerrarSesion = new JMenuItem("Cerrar sesión");

	public static URL icono;
	public static Image img;
	public static Image resizedImage;
	public static JButton boton1;
	public static JPanel superior;

	private static final long serialVersionUID = 8848933392510367245L;
	public static JPanel inicioSesionGeneral = new JPanel(new BorderLayout(6, 6));

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Principal");
		setLayout(new GridLayout(2, 1));

		barra = new JMenuBar();
		registrarse = new JMenuItem("Registrarse");
		inicioSesion = new JMenuItem("Iniciar sesi");
		Cuenta = new JMenu("Mi cuenta");
		perfil = new JMenuItem("Perfil");
		pedidos = new JMenuItem("Pedidos");
		favoritos = new JMenuItem("Lista de deseados");
		cerrarSesion = new JMenuItem("Cerrar sesi");

		registrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main.Main.ventana.dispose();
				Main.ventana = new Registro();
			}
		});

		inicioSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Main.ventana, inicioSesionGeneral, "Iniciar sesión",
						JOptionPane.QUESTION_MESSAGE);
				barra.removeAll();
				barra.add(Cuenta);
				validate();
				repaint();

			}
		});

		cerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				barra.removeAll();
				barra.add(inicioSesion);
				barra.add(registrarse);
				validate();
				repaint();
			}
		});

		ActionListener abrirProductos = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.ventana.dispose();
				Main.ventana = new Registro();
			}
		};
		
		barra.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		inicioSesion.setMaximumSize(new Dimension(120, 70));

		registrarse.setMaximumSize(new Dimension(120, 70));
		setJMenuBar(barra);
		Cuenta.add(perfil);
		Cuenta.add(pedidos);
		Cuenta.add(favoritos);
		Cuenta.add(cerrarSesion);
		barra.add(inicioSesion);
		barra.add(registrarse);
		// Menu barra de pagina principal

		JButton Jb1 = new JButton();
		JButton Jb2 = new JButton();
		JButton Jb3 = new JButton();

		superior = new JPanel();
		JPanel Norte = new JPanel();
		JPanel Sur = new JPanel();
		JPanel Oeste = new JPanel();
		JPanel Este = new JPanel();

		// Ventana para Iniciar sesion

		JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
		label.add(new JLabel("Usuario/E-Mail", SwingConstants.RIGHT));
		label.add(new JLabel("Contraseña", SwingConstants.RIGHT));
		inicioSesionGeneral.add(label, BorderLayout.WEST);

		Jb1.addActionListener(abrirProductos);
		Jb2.addActionListener(abrirProductos);
		Jb3.addActionListener(abrirProductos);
		Norte.add(Jb1);
		Este.add(Jb3);
		Sur.add(Oeste);
		Sur.add(Este);
		add(Norte);
		add(Sur);

		setVisible(true);
		setSize(1200, 1000);
	}

}
