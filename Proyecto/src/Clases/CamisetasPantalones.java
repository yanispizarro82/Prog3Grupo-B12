package Clases;

public class CamisetasPantalones extends Productos {

	private Tallas tallas;
	private String material;

	public CamisetasPantalones(String nombre, double precio, double descuento, String color, String imagen, Tallas tallas, String material) {
		super(nombre, precio, descuento, color, material);
		this.tallas = tallas;
		this.material = material;
	}

	public Tallas getTalla() {
		return tallas;
	}

	public void setTalla(Tallas talla) {
		this.tallas = talla;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String toString() {
		return "Las camisetas y los pantalones tienen las tallas: " + tallas + " y los materiales:" + material + ".";
	}

}