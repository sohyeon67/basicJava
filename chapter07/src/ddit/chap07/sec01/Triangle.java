package ddit.chap07.sec01;

public class Triangle extends Shape {
	private int width;
	private int height;

	Triangle(String kind, int width, int height) {
		super(kind);
		this.width = width;
		this.height = height;
	}

	@Override
	public double calcurateArea() {
		return width * height * 0.5;
	}
}
