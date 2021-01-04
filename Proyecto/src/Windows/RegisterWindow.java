package Windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import main.Main;

public class RegisterWindow extends JFrame {

	private static final long serialVersionUID = -2166905813751874979L;

	public RegisterWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Register");

		JLabel jlName = new JLabel("Nombre: ");
		JLabel jlMail = new JLabel("E-Mail: ");
		JLabel jlPassword = new JLabel("Contraseña: ");
		JLabel jlDir = new JLabel("Dir. Envio: ");
		JLabel jlBDate = new JLabel("Fcha. NCMT: ");
		JTextField jtName = new JTextField(20);
		JTextField jtPassword = new JTextField(20);
		JTextField jtMail = new JTextField(20);
		JTextField jtBDate = new JTextField(20);
		JTextField jtDir = new JTextField(20);
		JButton jbReg = new JButton("Registrarse");

		setLayout(new GridLayout(6, 1));

		JPanel jpName = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpPassword = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpBDate = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpDir = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel jpReg = new JPanel(new FlowLayout(FlowLayout.CENTER));

		jpName.add(jlName);
		jpName.add(jtName);
		add(jpName);

		jpPassword.add(jlPassword);
		jpPassword.add(jtPassword);
		add(jpPassword);

		jpMail.add(jlMail);
		jpMail.add(jpMail);
		add(jpMail);

		jpBDate.add(jlBDate);
		jpBDate.add(jtBDate);
		add(jpBDate);

		jpDir.add(jlDir);
		jpDir.add(jtDir);
		add(jpDir);

		jbReg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Main.window.dispose();
				Main.window = new Principal();
			}
		});

		add(jbReg);
		setVisible(true);
		setSize(600, 600);
	}

}