package ddit.chap06.sec03;
//Circle는 반지름, 원주율(상수:3.1415926), 원의 면적을 반환하는 메서드(getArea())

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
