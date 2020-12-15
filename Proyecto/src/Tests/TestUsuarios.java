package Tests;

import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;
import Clases.CamisetasPantalones;
import Clases.Pedidos;
import Clases.Productos;
import Clases.Tallas;
import Clases.Usuarios;
import Clases.Zapatos;

public class TestUsuarios {

	Usuarios Mario;
	Usuarios Luigi;
	Usuarios Toad;
	Productos Pantalon;
	Productos Zapatos;
	// Productos Gorro;

	private void assertEquals(String string, String correo) {
		// TODO Auto-generated method stub

	}

	private void assertFalse(boolean contains) {
		// TODO Auto-generated method stub

	}

	private void assertTrue(boolean contains) {
		// TODO Auto-generated method stub

	}

	@Before
	public void setUp() {
		Mario = new Usuarios("Mario@gmail.com", "Password1", new HashSet<Pedidos>());
		Luigi = new Usuarios("Luigi@gmail.com", "Password2", new HashSet<Pedidos>());
		Toad = new Usuarios("Toad@gmail.com", "Password3", new HashSet<Pedidos>());

		Pantalon = new CamisetasPantalones("pantalon vaquero", 25.0, 1.0, "Rojo", "img/pantalon", Tallas.M, "Algodon");
		Zapatos = new Zapatos("Oxford", 30, 1.3, "Azul", 1234, "img/zapatos", 42, "Cuero");
		// Gorro = new Productos("Gorro de Carpintero", 21, 0.5, "img/gorro", "Rojo");

		Mario.getCesta().add(Pantalon);
		Mario.getCesta().add(Zapatos);
		// Mario.getCesta().add(Gorro);
	}

	@Test
	public void testCorreo() {
		assertEquals("Mario@gmail.com", Mario.getCorreo());
		assertEquals("Luigi@gmail.com", Luigi.getCorreo());
		assertEquals("Toad@gmail.com", Toad.getCorreo());
	}

	@Test
	public void testCesta() {
		assertTrue(Mario.getCesta().contains(Pantalon));
		assertFalse(Luigi.getCesta().contains(Zapatos));
		// assertTrue(Mario.getCesta().contains(Gorro));
		assertFalse(Luigi.getCesta().contains(Pantalon));
		// Toad.getCesta().add(Gorro);
		Mario.getCesta().remove(Pantalon);
		assertFalse(Mario.getCesta().contains(Pantalon));
		// assertTrue(Toad.getCesta().contains(Gorro));
	}

}
