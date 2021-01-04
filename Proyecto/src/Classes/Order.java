package Classes;

import java.util.*;

public class Order {

	public static int IDNow = 1;
	private int id;
	private HashMap<Products, Integer> products;
	private double initialPrice;
	private double finalPrice;
	private Date DeliveryDate;

	public Order(HashMap<Products, Integer> products, double finalPrice, double initialPrice) {
		super();
		this.id = IDNow;
		IDNow += 1;
		this.products = products;
		this.initialPrice = initialPrice;
		this.finalPrice = finalPrice;
		this.DeliveryDate = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(double initialPrice) {
		this.initialPrice = initialPrice;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public HashMap<Products, Integer> getProductos() {
		return products;
	}

	public void setProductos(HashMap<Products, Integer> productos) {
		this.products = productos;
	}

	public Date getDeliveryDate() {
		return DeliveryDate;
	}

	public void setDeliveryDate(Date DeliveryDate) {
		this.DeliveryDate = DeliveryDate;
	}

	@Override
	public String toString() {
		return "El identificador del producto es " + id + ", los productos comprados son: " + products
				+ ". El precio total es de: " + finalPrice + " y la fecha de entrega ser?�� el = " + DeliveryDate + ".";
	}

}