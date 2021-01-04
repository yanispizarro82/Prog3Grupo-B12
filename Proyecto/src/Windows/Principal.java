package Windows;

import javax.swing.*;

import main.Main;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class Principal extends JFrame {

	public static JMenuBar bar = new JMenuBar();
	public static JMenuItem register = new JMenuItem("Registrarse");
	public static JMenuItem logIn = new JMenuItem("Iniciar sesión");
	public static JMenu myAccount = new JMenu("Cuenta");
	public static JMenuItem profile = new JMenuItem("Perfil");
	public static JMenuItem orders = new JMenuItem("Pedidos");
	public static JMenuItem favourite = new JMenuItem("Favoritos");
	public static JMenuItem cerrarSesion = new JMenuItem("Cerrar sesión");

	public static URL icono;
	public static Image img;
	public static Image resizedImage;
	public static JButton button1;
	public static JPanel superior;

	private static final long serialVersionUID = 8848933392510367245L;
	public static JPanel inicioSesionGeneral = new JPanel(new BorderLayout(6, 6));

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Principal");
		setLayout(new GridLayout(2, 1));

		bar = new JMenuBar();
		register = new JMenuItem("Registrarse");
		logIn = new JMenuItem("Iniciar sesi���");
		myAccount = new JMenu("Mi cuenta");
		profile = new JMenuItem("Perfil");
		orders = new JMenuItem("Pedidos");
		favourite = new JMenuItem("Lista de deseados");
		cerrarSesion = new JMenuItem("Cerrar sesi���");

		register.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main.Main.window.dispose();
				Main.window = new RegisterWindow();
			}
		});

		logIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Main.window, inicioSesionGeneral, "Iniciar sesión",
						JOptionPane.QUESTION_MESSAGE);
				bar.removeAll();
				bar.add(myAccount);
				validate();
				repaint();

			}
		});

		cerrarSesion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bar.removeAll();
				bar.add(logIn);
				bar.add(register);
				validate();
				repaint();
			}
		});

		ActionListener abrirProductos = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.window.dispose();
				Main.window = new RegisterWindow();
			}
		};

		bar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		logIn.setMaximumSize(new Dimension(120, 70));

		register.setMaximumSize(new Dimension(120, 70));
		setJMenuBar(bar);
		myAccount.add(profile);
		myAccount.add(orders);
		myAccount.add(favourite);
		myAccount.add(cerrarSesion);
		bar.add(logIn);
		bar.add(register);
		// Menu barra de pagina principal

		JButton Jb1 = new JButton();
		JButton Jb2 = new JButton();
		JButton Jb3 = new JButton();

		superior = new JPanel();
		JPanel North = new JPanel();
		JPanel South = new JPanel();
		JPanel West = new JPanel();
		JPanel East = new JPanel();

		JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
		label.add(new JLabel("Usuario/E-Mail", SwingConstants.RIGHT));
		label.add(new JLabel("Contraseña", SwingConstants.RIGHT));
		inicioSesionGeneral.add(label, BorderLayout.WEST);

		Jb1.addActionListener(abrirProductos);
		Jb2.addActionListener(abrirProductos);
		Jb3.addActionListener(abrirProductos);
		North.add(Jb1);
		East.add(Jb3);
		South.add(West);
		South.add(East);
		add(North);
		add(South);

		setVisible(true);
		setSize(1200, 1000);
	}

}
