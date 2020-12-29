package Clases;

public class Zapatos extends Productos {
	private int id;
	private String material;
	private int talla;

	public Zapatos(int id, String nombre, double precio, double descuento, String color, String imagen, int talla,
			String material, boolean disponible) {
		super(id, nombre, precio, descuento, color, imagen, disponible);
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
