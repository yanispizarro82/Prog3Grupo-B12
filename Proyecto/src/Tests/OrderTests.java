package Tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

import Classes.Order;
import Classes.Products;
import Classes.ShirtsPants;
import Classes.Shoes;
import Classes.Sizes;

public class OrderTests {

	Order order1;
	Order order2;
	Order order3;
	Products Pants;
	Products Shoes;


	@Before
	public void setUp() {
		order1 = new Order(new HashMap<Products, Integer>(), 12, 0);
		order2 = new Order(new HashMap<Products, Integer>(), 20, 0);
	
		Pants = new ShirtsPants(0, "pantalon vaquero", 25.0, 1.0, "Rojo", "img/pantalon", false, Sizes.M, "Algodon", true);
		Shoes = new Shoes(0, "Oxford", 30, 1.3, "Azul", "img/zapatos", 42, "Cuero", false);
		
		

		order1.getProductos().put(Pants, 3);
		order1.getProductos().put(Shoes, 1);
		

	}

	@Test
	public void testId() {
		assertEquals(4, order1.getId());
		assertEquals(5, order2.getId());
		assertEquals(6, order3.getId());
	}

	@Test
	public void testProductos() {
		assertTrue(order1.getProductos().get(Pants) == 3);
		assertFalse(order1.getProductos().get(Shoes) == 3);
		order2.getProductos().put(Pants, 4);
		order1.getProductos().clear();
		assertEquals(4, order2.getProductos().get(Pants), 0);
		assertFalse(order1.getProductos().containsKey(Pants));
	}

}
