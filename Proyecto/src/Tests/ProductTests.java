package Tests;

import org.junit.Before;
import org.junit.Test;

import Classes.Products;
import Classes.ShirtsPants;
import Classes.Shoes;
import Classes.Sizes;

public class ProductTests {
	Products Pants;
	Products Shoes;

	private void assertEquals(String string, String name) {
		// TODO Auto-generated method stub

	}

	private void assertEquals(double prize, double discount) {
		// TODO Auto-generated method stub

	}

	private void assertFalse(boolean is) {
		// TODO Auto-generated method stub

	}

	private void assertTrue(boolean is) {
		// TODO Auto-generated method stub

	}

	@Before
	public void setUp() {
		Pants = new ShirtsPants(0, "pantalon vaquero", 25.0, 1.0, "Rojo", "img/pantalon", true, Sizes.M, "Algodon",
				false);
		Shoes = new Shoes(0, "Oxford", 30, 1.3, "Azul", "img/zapatos", 42, "Cuero", false);

	}

	@Test
	public void testNombre() {
		assertEquals("Camiseta Adidas", Pants.getName());
		assertEquals("Oxford", Shoes.getName());
	}

	@Test
	public void testPrecioFinal() {
		assertEquals(25.0, Pants.getPrize() * Pants.getDiscount());
		assertEquals(6.12, Shoes.getPrize() * Shoes.getDiscount());
	}

	@Test
	public void testAvailable() {
		Pants.setAvailable(true);
		assertTrue(Pants.available());
		assertFalse(Shoes.available());

	}

	@Test
	public void testTalla() {
		assertEquals("L", ((ShirtsPants) Pants).getSize().letter());
		assertEquals(52, ((ShirtsPants) Pants).getSize().SizeESP());
		assertEquals(8, ((ShirtsPants) Pants).getSize().SizeUSA());

	}

}
