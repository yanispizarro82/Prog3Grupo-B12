package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Ventanas.Principal;


public class Main {
	public static JFrame ventana;
	public static void main(String[] args) {
		

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				ventana = new Principal();
				
			}

		});
	}

}
