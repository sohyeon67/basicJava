package ddit.chap07.sec04;

public abstract class Shape {
	String kind;

	Shape(String kind) {
		this.kind = kind;
	}

	public abstract void draw(); // �߻�޼���

	@Override
	public String toString() { // �������̵��ϴ� �޼����� ���������� ���� ���� �� ����
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
		System.out.println("������ "+p+"�̰� �������� "+radius+"�� ���� �׸���");
	}
}