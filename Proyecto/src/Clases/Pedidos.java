package Clases;

import java.util.*;

public class Pedidos {

	public static int idActual = 1;
	private int id;
	private HashMap<Productos, Integer> productos;
	private double importeFinal;
	private Date fechaEntrega;

	public Pedidos(HashMap<Productos, Integer> productos, double importeFinal) {
		super();
		this.id = idActual;
		idActual += 1;
		this.productos = productos;
		this.importeFinal = importeFinal;
		this.fechaEntrega = null;
	}

	public int getId() {
		return id;
	}

	public HashMap<Productos, Integer> getProductos() {
		return productos;
	}

	public void setProductos(HashMap<Productos, Integer> productos) {
		this.productos = productos;
	}

	public double importeFinal() {
		return importeFinal;
	}

	public void setimporteFinal(double importeFinal) {
		this.importeFinal = importeFinal;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	@Override
	public String toString() {
		return "El identificador del producto es " + id + ", los productos comprados son: " + productos
				+ ". El precio total es de: " + importeFinal + " y la fecha de entrega ser� el = " + fechaEntrega + ".";
	}

}