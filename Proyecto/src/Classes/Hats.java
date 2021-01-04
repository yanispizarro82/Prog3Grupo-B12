package Classes;

public class Hats extends Products {
	private int id;
	private String material;
	private String type;

	public Hats(String name, double price, double discount, int id, String image, boolean available, String colour, String type, String material) {
		super(id, name, price, discount, colour, type, available);
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

	
	public String getType() {
		return type;
	}

	public void settype(String type) {
		this.type = type;
	}

	public String toString() {
		return "El Zapato con el identificador: " + id + "esta hecho de " + material + " y es de tipo: " + ".";
	}

}