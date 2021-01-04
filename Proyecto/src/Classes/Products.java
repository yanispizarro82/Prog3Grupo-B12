package Classes;

public class Products {

	private int id;
	private String name;
	private double prize;
	private double discount;
	private String colour;
	private boolean available;
	private String image;

	public Products(int id, String name, double prize, double discount, String colour, String image, boolean available) {
		super();
		this.id = id;
		this.name = name;
		this.prize = prize;
		this.discount = discount;
		this.colour = colour;
		this.available = available;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public boolean available() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "El nombre del producto es un " + name + ", vale " + prize + " euros y tiene un descuento del "
				+ discount + "%. Tiene un color " + colour + ". " + available + " esta disponible.";
	}

}
