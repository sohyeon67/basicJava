package ddit.chap07.sec01;

public class Rectangle extends Shape {
	private int width;
	private int height;

	Rectangle(String kind, int width, int height) {
		super(kind);
		this.width = width;
		this.height = height;
	}

	@Override
	public double calcurateArea() {
		return (double) width * height;
	}
}
