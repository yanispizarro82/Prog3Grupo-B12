package Windows;

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

import DataBase.JDBC;
import main.Main;

public class LogInWindow {

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
		int option = JOptionPane.showConfirmDialog(Main.window, UserPassw, "Log in",
				JOptionPane.OK_CANCEL_OPTION);

		if (JOptionPane.OK_OPTION == option) {
			if (!username.getText().equals("")) {
				if (JDBC.checkUser(username.getText())) {
					if (JDBC.comprobarPassw(username.getText(), password.getText())) {
						Main.userIni = Main.userMap.get(username.getText());
						Principal.bar.removeAll();
						Principal.bar.add(Principal.myAccount);
						Main.window.validate();
						Main.window.repaint();

					} else {
						JOptionPane.showMessageDialog(Main.window, "Wrong Password", "Wrong Password",
								JOptionPane.ERROR_MESSAGE);
						iniciar(username.getText());
					}
				} else {
					JOptionPane.showMessageDialog(Main.window, "Username not found", "Unknown username",
							JOptionPane.ERROR_MESSAGE);
					iniciar(username.getText());
				}

			} else {
				JOptionPane.showMessageDialog(Main.window, "Introduce username", "Introduce username",
						JOptionPane.ERROR_MESSAGE);
				iniciar(username.getText());
			}
		}
	}

	public static void registrar() {
		JPanel registro = new JPanel(new BorderLayout());
		JPanel label = new JPanel(new GridLayout(0, 1));

		JLabel lPassw = new JLabel("Password:");
		JLabel lConfirm = new JLabel("Confirm Password:");
		JLabel lMail = new JLabel("E-Mail:");

		label.add(lMail);
		label.add(lPassw);
		label.add(lConfirm);
		registro.add(label, BorderLayout.WEST);

		JPanel texto = new JPanel(new GridLayout(0, 1));

		JPasswordField tConfirm = new JPasswordField(20);
		JPasswordField tPassword = new JPasswordField(20);
		JTextField tMail = new JTextField(20);

		texto.add(tMail);
		texto.add(tPassword);
		texto.add(tConfirm);
		registro.add(texto, BorderLayout.EAST);

		JButton bRegistrarse = new JButton("Register");

		bRegistrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tMail.getText().length() <= 30 && tMail.getText().trim().length() > 0) {
					if (tPassword.getText().length() <= 50 && tPassword.getText().trim().length() > 0) {
						if (tConfirm.getText().equals(tPassword.getText())) {
							JDBC.crearUsuario(tMail.getText(), tPassword.getText());
							Main.window.dispose();
							Main.window = new Principal();
						} else {
							JOptionPane.showMessageDialog(Main.window, "Passwords don't match",
									"Passwords must match.", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(Main.window, "Invalid Password",
								"Introduced password is invalid.", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(Main.window, "Invalid E-Mail",
							"Introduced E-Mail is invalid.", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		registro.add(bRegistrarse, BorderLayout.SOUTH);
		JOptionPane.showOptionDialog(Main.window, registro, "Register", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, new Object[] {}, null);

	}
}
