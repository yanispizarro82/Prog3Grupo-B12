package Classes;

public class Shoes extends Products {
	private int id;
	private String material;
	private int size;

	public Shoes(int id, String name, double price, double discount, String colour, String image, int size,
			String material, boolean available) {
		super(id, name, price, discount, colour, image, available);
		this.id = id;
		this.material = material;
		this.size = size;

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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String toString() {
		return "El Zapato con el identificador: " + id + "esta fabricado con " + material + ".";
	}

}
