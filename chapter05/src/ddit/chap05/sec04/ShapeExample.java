package ddit.chap05.sec04;

public class ShapeExample {

	public static void main(String[] args) {
		Triangle t1 = new Triangle(new Point(100, 100), new Point(500, 100), new Point(250, 250));
		
		t1.draw();
	}
}
