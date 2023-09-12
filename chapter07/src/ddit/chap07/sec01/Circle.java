package ddit.chap07.sec01;

public class Circle extends Shape {
	private int radius;
	private final double PI = 3.1415926;

	Circle(String kind, int radius) {
		super(kind);
		this.radius = radius;
	}

	@Override
	public double calcurateArea() {
		return radius * radius * PI;
	}

}
