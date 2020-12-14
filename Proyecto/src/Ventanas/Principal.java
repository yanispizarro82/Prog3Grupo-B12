package Ventanas;

import javax.swing.*;

import main.Main;

import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8848933392510367245L;
	public static JPanel inicioSesionGeneral = new JPanel(new BorderLayout(6, 6));

	public Principal() {
		JFrame MainFrame = new JFrame();
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Principal");
		setLayout(new GridLayout(2, 1));
		Thread hilo = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}

				}
			}
		});
		hilo.start();

		// Menu barra de pagina principal

		JMenuBar barra = new JMenuBar();
		JMenuItem registrarse = new JMenuItem("Registrarse");
		JMenuItem inicioSesion = new JMenuItem("Iniciar sesión");
		JMenu Cuenta = new JMenu("Cuenta");
		JMenuItem perfil = new JMenuItem("Perfil");
		JMenuItem pedidos = new JMenuItem("Pedidos");
		JMenuItem favoritos = new JMenuItem("Favoritos");
		JMenuItem cerrarSesion = new JMenuItem("Cerrar sesión");

		JButton Jb1 = new JButton();
		JButton Jb2 = new JButton();
		JButton Jb3 = new JButton();

		JPanel Norte = new JPanel();
		JPanel Sur = new JPanel();
		JPanel Oeste = new JPanel();
		JPanel Este = new JPanel();

		// Ventana para Iniciar sesion

		JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
		label.add(new JLabel("Usuario/E-Mail", SwingConstants.RIGHT));
		label.add(new JLabel("Contraseña", SwingConstants.RIGHT));
		inicioSesionGeneral.add(label, BorderLayout.WEST);
		JPanel textos = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField usuario = new JTextField();
		JPasswordField password = new JPasswordField();
		
		textos.add(usuario);
		textos.add(password);
		inicioSesionGeneral.add(textos, BorderLayout.CENTER);

		// ActionListeners para todo

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
				hilo.interrupt();
				Main.ventana = new Registro();
			}
		};

		// añadir todo a la pantalla principal

		barra.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

		inicioSesion.setMaximumSize(new Dimension(120, 70));

		registrarse.setMaximumSize(new Dimension(120, 70));
		setJMenuBar(barra);
		Cuenta.add(perfil);
		Cuenta.add(cerrarSesion);
		Cuenta.add(pedidos);
		Cuenta.add(favoritos);
		barra.add(registrarse);
		barra.add(inicioSesion);

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
