package main;

import java.util.logging.Logger;
import java.util.logging.LogManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;

public class LoggerShop {

	private static Logger logger = Logger.getLogger(LoggerShop.class.getName());

	public static void main(String[] args) {

		try (FileInputStream fis = new FileInputStream("ficheros/logger.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "No se pudo leer el fichero de configuración del logger");
		}

		logger.info("Program started");

		for (int i = 0; i < 10; i++) {
			logger.log(Level.FINE, "I am on iteration: " + i);
		}

		try (FileInputStream fis = new FileInputStream("noexiste.txt")) {

		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "file not found 'noexiste.txt");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "file not found 'noexiste.txt");
		}

		logger.info("Program finalized");
	}
}