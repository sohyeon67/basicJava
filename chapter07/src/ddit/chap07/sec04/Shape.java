package ddit.chap07.sec04;

public abstract class Shape {
	String kind;

	Shape(String kind) {
		this.kind = kind;
	}

	public abstract void draw(); // 추상메서드

	@Override
	public String toString() { // 오버라이딩하는 메서드의 접근제한자 범위 좁힐 수 없음
		return kind;
	}
}

class Circle extends Shape {
	private Point p;
	private int radius;

	Circle(String kind, Point p, int radius) {
		super(kind);
		this.p = p;
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		System.out.println("원점이 "+p+"이고 반지름이 "+radius+"인 원을 그리다");
	}
}