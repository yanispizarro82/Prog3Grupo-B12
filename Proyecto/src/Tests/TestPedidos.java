package Tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import Clases.CamisetasPantalones;
import Clases.Pedidos;
import Clases.Productos;
import Clases.Tallas;
import Clases.Zapatos;

public class TestPedidos {

	Pedidos pedido1;
	Pedidos pedido2;
	Pedidos pedido3;
	Productos Pantalon;
	Productos Zapatos;
	Productos Gorro;

	@Before
	public void setUp() {
		pedido1 = new Pedidos(new HashMap<Productos, Integer>(), 12, 10);
		pedido2 = new Pedidos(new HashMap<Productos, Integer>(), 20, 14);
		pedido3 = new Pedidos(new HashMap<Productos, Integer>(), 8, 6);

		Pantalon = new CamisetasPantalones("pantalon vaquero", 25.0, 1.0, "Rojo", Tallas.M, "Algodon");
		Zapatos = new Zapatos("Oxford", 30, 1.3, "Azul", 42, "Cuero");
		Gorro = new Productos("Gorro de Carpintero", 21, 0.5, "Rojo");

		pedido1.getProductos().put(Pantalon, 3);
		pedido1.getProductos().put(Zapatos, 1);
		pedido3.getProductos().put(Gorro, 10);

	}

	@Test
	public void testId() {
		assertEquals(4, pedido1.getId());
		assertEquals(5, pedido2.getId());
		assertEquals(6, pedido3.getId());
	}

	@Test
	public void testProductos() {
		assertTrue(pedido1.getProductos().get(Pantalon) == 3);
		assertFalse(pedido1.getProductos().get(Zapatos) == 3);
		assertTrue(pedido3.getProductos().containsKey(Gorro));
		pedido2.getProductos().put(Pantalon, 4);
		pedido1.getProductos().clear();
		assertEquals(4, pedido2.getProductos().get(Pantalon), 0);
		assertFalse(pedido1.getProductos().containsKey(Pantalon));
	}

}
