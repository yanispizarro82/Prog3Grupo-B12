package Clases;

public class CamisetasPantalones extends Productos {

	private Tallas tallas;
	private String material;
	private boolean esCamiseta;

	public CamisetasPantalones(String nombre, double precio, double descuento, String color, String imagen,boolean disponible, Tallas tallas, String material, boolean esCamiseta) {
		super(nombre, precio, descuento, color, material, disponible);
		this.tallas = tallas;
		this.material = material;
		this.esCamiseta = esCamiseta;
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

	public boolean isEsCamiseta() {
		return esCamiseta;
	}

	public void setEsCamiseta(boolean esCamiseta) {
		this.esCamiseta = esCamiseta;
	}
	
	public String toString() {
		return "Las camisetas y los pantalones tienen las tallas: " + tallas + " y los materiales:" + material + ".";
	}

}