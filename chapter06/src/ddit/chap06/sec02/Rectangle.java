package ddit.chap06.sec02;

public class Rectangle {
	private Point p1; //Ŭ���� ���԰���
	private double width;
	private double height;

	Rectangle(Point p1, double width, double height) {
		this.p1 = p1;
		this.width = width;
		this.height = height;
	}

	public void getArea() {
		double area = width * height;
		System.out.println(p1 + "��ġ�� �����ϴ� �簢���� ���� : " + area);
	}
}
