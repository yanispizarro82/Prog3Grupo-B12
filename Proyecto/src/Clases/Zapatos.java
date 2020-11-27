package Clases;

public class Zapatos extends Productos {
	private int id;
	private String material;

	public Zapatos(String nombre, double precio, double descuento, String color, int id,
			String material) {
		super(nombre, precio, descuento, color);
		this.id = id;
		this.material = material;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String toString() {
		return "El Zapato con el identificador: " + id + "esta fabricado con " + material + ".";
	}

}
