package ddit.chap07.sec01;

public class ShapeExample {

	public static void main(String[] args) {
		Circle circle = new Circle("��", 10);
		System.out.println(circle.kind + "�� ���� : " + circle.calcurateArea());

		Triangle t1 = new Triangle("�ﰢ��", 25, 15);
		System.out.println(t1.kind + "�� ���� : " + t1.calcurateArea());

		Rectangle r = new Rectangle("�簢��", 10, 20);
		System.out.println(r.kind + "�� ���� : " + r.calcurateArea());
	}

}
