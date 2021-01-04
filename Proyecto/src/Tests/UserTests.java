package Tests;

import java.util.HashSet;
import org.junit.Before;
import org.junit.Test;

import Classes.Order;
import Classes.Products;
import Classes.ShirtsPants;
import Classes.Shoes;
import Classes.Sizes;
import Classes.Users;

public class UserTests {

	Users Mario;
	Users Luigi;
	Users Toad;
	Products Pants;
	Products Shoes;

	private void assertEquals(String string, String mail) {
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
		Mario = new Users("Mario@gmail.com", "Password1", new HashSet<Order>());
		Luigi = new Users("Luigi@gmail.com", "Password2", new HashSet<Order>());
		Toad = new Users("Toad@gmail.com", "Password3", new HashSet<Order>());

		Pants = new ShirtsPants(0, "pantalon vaquero", 25.0, 1.0, "Rojo", "img/pantalon", true, Sizes.M, "Algodon",
				true);
		Shoes = new Shoes(0, "Oxford", 30, 1.3, "Azul", "img/zapatos", 42, "Cuero", true);

		Mario.getBasket().add(Pants);
		Mario.getBasket().add(Shoes);

	}

	@Test
	public void testCorreo() {
		assertEquals("Mario@gmail.com", Mario.getMail());
		assertEquals("Luigi@gmail.com", Luigi.getMail());
		assertEquals("Toad@gmail.com", Toad.getMail());
	}

	@Test
	public void testCesta() {
		assertTrue(Mario.getBasket().contains(Pants));
		assertFalse(Luigi.getBasket().contains(Shoes));

		assertFalse(Luigi.getBasket().contains(Pants));

		Mario.getBasket().remove(Pants);
		assertFalse(Mario.getBasket().contains(Pants));

	}

}
