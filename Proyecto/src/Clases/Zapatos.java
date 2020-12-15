package Clases;

public class Zapatos extends Productos {
	private int id;
	private String material;
	private int talla;

	public Zapatos(String nombre, double precio, double descuento, String color, int id, String imagen, int talla,
			String material) {
		super(nombre, precio, descuento, color, imagen);
		this.id = id;
		this.material = material;
		this.talla = talla;

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

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}

	public String toString() {
		return "El Zapato con el identificador: " + id + "esta fabricado con " + material + ".";
	}

}
