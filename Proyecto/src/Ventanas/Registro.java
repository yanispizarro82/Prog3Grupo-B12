package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import main.Main;

public class Registro extends JFrame {

	private static final long serialVersionUID = -2166905813751874979L;

	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registrar");

		JLabel jlNombre = new JLabel("Nombre: ");
		JLabel jlCorreo = new JLabel("E-Mail: ");
		JLabel jlPassword = new JLabel("Contraseña: ");
		JLabel jlDir = new JLabel("Dir. Envio: ");
		JLabel jlFNacimiento = new JLabel("Fcha. NCMT: ");
		JTextField jtNombre = new JTextField(20);
		JTextField jtPassword = new JTextField(20);
		JTextField jtCorreo = new JTextField(20);
		JTextField jtFNacimiento = new JTextField(20);
		JTextField jtDir = new JTextField(20);
		JButton jbReg = new JButton("Registrarse");

		setLayout(new GridLayout(6, 1));

		JPanel jpNombre = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpPassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpCorreo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpFNacimiento = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpDir = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpReg = new JPanel(new FlowLayout(FlowLayout.CENTER));

		jpNombre.add(jlNombre);
		jpNombre.add(jtNombre);
		add(jpNombre);

		jpPassword.add(jlPassword);
		jpPassword.add(jtPassword);
		add(jpPassword);

		jpCorreo.add(jlCorreo);
		jpCorreo.add(jtCorreo);
		add(jpCorreo);

		jpFNacimiento.add(jlFNacimiento);
		jpFNacimiento.add(jtFNacimiento);
		add(jpFNacimiento);

		jpDir.add(jlDir);
		jpDir.add(jtDir);
		add(jpDir);

		jbReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.ventana.dispose();
				Main.ventana = new Principal();
			}
		});

		add(jbReg);
		setVisible(true);
		setSize(600, 600);
	}

}