package Clases;

public class Productos {

	private int id;
	private String nombre;
	private double precio;
	private double descuento;
	private String color;
	private boolean Disponible;
	private String imagen;

	public Productos(int id, String nombre, double precio, double descuento, String color, String imagen, boolean disponible) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.color = color;
		this.Disponible = disponible;
		this.imagen = imagen;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean Disponible() {
		return Disponible;
	}

	public void setDisponible(boolean Disponible) {
		this.Disponible = Disponible;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "El nombre del producto es un " + nombre + ", vale " + precio + " euros y tiene un descuento del "
				+ descuento + "%. Tiene un color " + color + ". " + Disponible + " esta disponible.";
	}

}
