package Clases;

public class Gorros extends Productos {
	private int id;
	private String material;
	private String tipo;

	public Gorros(String nombre, double precio, double descuento, String color, int id,
			String material, String tipo) {
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

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String toString() {
		return "El Zapato con el identificador: " + id + "esta hecho de " + material + " y es de tipo: " + ".";
	}

}