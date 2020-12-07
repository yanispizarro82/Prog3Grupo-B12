package Clases;

public enum Tallas {

	S("S", 37, 2, 14), M("M", 39, 3, 15), L("L", 41, 4, 16), XL("XL", 43, 5, 17), XXL("XXL", 45, 6, 18);

	private final String letra;
	private final int TallaESP;
	private final int TallaUSA;
	private int TallaUK;

	Tallas(String letra, int TallaESP, int TallaUSA, int TallaUK) {
		this.letra = letra;
		this.TallaESP = TallaESP;
		this.TallaUSA = TallaUSA;
		this.TallaUK = TallaUK;

	}

	public String letra() {
		return letra;
	}

	public int TallaESP() {
		return TallaESP;
	}

	public int TallaUSA() {
		return TallaUSA;
	}

	public int TallaUK() {
		return TallaUK;
	}
}
