package Clases;

import java.util.*;

public class Pedidos {

	public static int idActual = 1;
	private int id;
	private HashMap<Productos, Integer> productos;
	private double precioBase;
	private double precioFinal;
	private Date fechaEntrega;

	public Pedidos(HashMap<Productos, Integer> productos, double precioFinal, double precioBase) {
		super();
		this.id = idActual;
		idActual += 1;
		this.productos = productos;
		this.precioBase = precioBase;
		this.precioFinal = precioFinal;
		this.fechaEntrega = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	public HashMap<Productos, Integer> getProductos() {
		return productos;
	}

	public void setProductos(HashMap<Productos, Integer> productos) {
		this.productos = productos;
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
				+ ". El precio total es de: " + precioFinal + " y la fecha de entrega ser� el = " + fechaEntrega + ".";
	}

}