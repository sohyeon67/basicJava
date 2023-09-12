package ddit.chap06.sec02;

public class Rectangle {
	private Point p1; //클래스 포함관계
	private double width;
	private double height;

	Rectangle(Point p1, double width, double height) {
		this.p1 = p1;
		this.width = width;
		this.height = height;
	}

	public void getArea() {
		double area = width * height;
		System.out.println(p1 + "위치에 존재하는 사각형의 넓이 : " + area);
	}
}
