package ddit.chap07.sec01;

public class ShapeExample {

	public static void main(String[] args) {
		Circle circle = new Circle("¿ø", 10);
		System.out.println(circle.kind + "ÀÇ ³ÐÀÌ : " + circle.calcurateArea());

		Triangle t1 = new Triangle("»ï°¢Çü", 25, 15);
		System.out.println(t1.kind + "ÀÇ ³ÐÀÌ : " + t1.calcurateArea());

		Rectangle r = new Rectangle("»ç°¢Çü", 10, 20);
		System.out.println(r.kind + "ÀÇ ³ÐÀÌ : " + r.calcurateArea());
	}

}
