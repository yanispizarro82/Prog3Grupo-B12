package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import BaseDatos.JDBC;
import main.Main;

public class inicioSesion {

	public static void iniciar(String usuar) {

		JPanel UserPassw = new JPanel(new BorderLayout(5, 5));

		JPanel jpLabel = new JPanel(new GridLayout(0, 1, 2, 2));
		JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		JTextField username = new JTextField();

		jpLabel.add(new JLabel("username", SwingConstants.RIGHT));
		jpLabel.add(new JLabel("password", SwingConstants.RIGHT));
		UserPassw.add(jpLabel, BorderLayout.WEST);

		controls.add(username);
		JPasswordField password = new JPasswordField();
		controls.add(password);
		UserPassw.add(controls, BorderLayout.CENTER);
		username.setText(usuar);
		password.setText("");
		int opcion = JOptionPane.showConfirmDialog(Main.ventana, UserPassw, "Log in",
				JOptionPane.OK_CANCEL_OPTION);

		if (JOptionPane.OK_OPTION == opcion) {
			if (!username.getText().equals("")) {
				if (JDBC.comprobarUsuario(username.getText())) {
					if (JDBC.comprobarPassw(username.getText(), password.getText())) {
						Main.usuarioIniciado = Main.mapaUsuario.get(username.getText());
						Principal.barra.removeAll();
						Principal.barra.add(Principal.Cuenta);
						Main.ventana.validate();
						Main.ventana.repaint();

					} else {
						JOptionPane.showMessageDialog(Main.ventana, "Wrong Password", "Wrong Password",
								JOptionPane.ERROR_MESSAGE);
						iniciar(username.getText());
					}
				} else {
					JOptionPane.showMessageDialog(Main.ventana, "Username not found", "Unknown username",
							JOptionPane.ERROR_MESSAGE);
					iniciar(username.getText());
				}

			} else {
				JOptionPane.showMessageDialog(Main.ventana, "Introduce username", "Introduce username",
						JOptionPane.ERROR_MESSAGE);
				iniciar(username.getText());
			}
		}
	}

	public static void registrar() {
		JPanel registro = new JPanel(new BorderLayout());
		JPanel label = new JPanel(new GridLayout(0, 1));

		JLabel lPassw = new JLabel("Password:");
		JLabel lConfirmar = new JLabel("Confirm Password:");
		JLabel lCorreo = new JLabel("E-Mail:");

		label.add(lCorreo);
		label.add(lPassw);
		label.add(lConfirmar);
		registro.add(label, BorderLayout.WEST);

		JPanel texto = new JPanel(new GridLayout(0, 1));

		JPasswordField tConfirmar = new JPasswordField(20);
		JPasswordField tContrasenya = new JPasswordField(20);
		JTextField tCorreo = new JTextField(20);

		texto.add(tCorreo);
		texto.add(tContrasenya);
		texto.add(tConfirmar);
		registro.add(texto, BorderLayout.EAST);

		JButton bRegistrarse = new JButton("Register");

		bRegistrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tCorreo.getText().length() <= 30 && tCorreo.getText().trim().length() > 0) {
					if (tContrasenya.getText().length() <= 50 && tContrasenya.getText().trim().length() > 0) {
						if (tConfirmar.getText().equals(tContrasenya.getText())) {
							JDBC.crearUsuario(tCorreo.getText(), tContrasenya.getText());
							Main.ventana.dispose();
							Main.ventana = new Principal();
						} else {
							JOptionPane.showMessageDialog(Main.ventana, "Passwords don't match",
									"Passwords must match.", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(Main.ventana, "Invalid Password",
								"Introduced password is invalid.", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(Main.ventana, "Invalid E-Mail",
							"Introduced E-Mail is invalid.", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		registro.add(bRegistrarse, BorderLayout.SOUTH);
		JOptionPane.showOptionDialog(Main.ventana, registro, "Register", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, new Object[] {}, null);

	}
}
