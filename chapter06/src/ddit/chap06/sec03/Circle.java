package ddit.chap06.sec03;
//Circle�� ������, ������(���:3.1415926), ���� ������ ��ȯ�ϴ� �޼���(getArea())

public class Circle {
	private double radius;
	private final double PI = 3.1415926;
	
	Circle(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius*radius*PI;
	}
}
