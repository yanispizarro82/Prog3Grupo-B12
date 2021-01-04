package Classes;

public enum Sizes {

	S("S", 37, 2, 14), M("M", 39, 3, 15), L("L", 41, 4, 16), XL("XL", 43, 5, 17), XXL("XXL", 45, 6, 18);

	private final String letter;
	private final int SizeESP;
	private final int SizeUSA;
	private int SizeUK;

	Sizes(String letter, int SizeESP, int SizeUSA, int SizeUK) {
		this.letter = letter;
		this.SizeESP = SizeESP;
		this.SizeUSA = SizeUSA;
		this.SizeUK = SizeUK;

	}

	public String letter() {
		return letter;
	}

	public int SizeESP() {
		return SizeESP;
	}

	public int SizeUSA() {
		return SizeUSA;
	}

	public int SizeUK() {
		return SizeUK;
	}
}
