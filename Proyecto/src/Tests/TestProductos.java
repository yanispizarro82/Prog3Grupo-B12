package Tests;

import org.junit.Before;
import org.junit.Test;

import Clases.CamisetasPantalones;
import Clases.Productos;
import Clases.Tallas;
import Clases.Zapatos;

public class TestProductos {
	Productos Pantalon;
	Productos Zapatos;
	Productos Gorro;

	private void assertEquals(String string, String nombre) {
		// TODO Auto-generated method stub

	}

	private void assertEquals(double precio, double descuento) {
		// TODO Auto-generated method stub

	}

	@Before
	public void setUp() {
		Pantalon = new CamisetasPantalones("pantalon vaquero", 25.0, 1.0, "Rojo", Tallas.M, "Algodon");
		Zapatos = new Zapatos("Oxford", 30, 1.3, "Azul", 42, "Cuero");
		Gorro = new Productos("Gorro de Carpintero", 21, 0.5, "Rojo");

	}

	@Test
	public void testNombre() {
		assertEquals("Camiseta Adidas", Pantalon.getNombre());
		assertEquals("Oxford", Zapatos.getNombre());
		assertEquals("Gorro de Santa Claus", Gorro.getNombre());
	}

	@Test
	public void testPrecioFinal() {
		assertEquals(25.0, Pantalon.getPrecio() * Pantalon.getDescuento());
		assertEquals(6.12, Zapatos.getPrecio() * Zapatos.getDescuento());
		assertEquals(3.55, Gorro.getPrecio() * Gorro.getDescuento());
	}

	@Test
	public void testTalla() {
		assertEquals("L", ((CamisetasPantalones) Pantalon).getTalla().letra());
		assertEquals(52, ((CamisetasPantalones) Pantalon).getTalla().TallaESP());
		assertEquals(8, ((CamisetasPantalones) Pantalon).getTalla().TallaUSA());

	}

}
