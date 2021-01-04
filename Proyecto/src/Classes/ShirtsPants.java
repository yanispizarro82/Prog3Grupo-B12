package Classes;

public class ShirtsPants extends Products {

	private Sizes size;
	private String material;
	private boolean isShirt;

	public ShirtsPants(int id, String name, double price, double discount, String colour, String image, boolean available, Sizes size, String material, boolean isShirt) {
		super(id, name, price, discount, colour, material, available);
		this.size = size;
		this.material = material;
		this.isShirt = isShirt;
	}

	public Sizes getSize() {
		return size;
	}

	public void setSize(Sizes size) {
		this.size = size;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public boolean isIsShirt() {
		return isShirt;
	}

	public void setIsShirt(boolean isShirt) {
		this.isShirt = isShirt;
	}
	
	public String toString() {
		return "Las camisetas y los pantalones tienen las tallas: " + size + " y los materiales:" + material + ".";
	}

}