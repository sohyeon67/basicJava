package ddit.chap05.sec04;

public class Triangle {
	Point p1;
	Point p2;
	Point p3;
	
	Triangle(Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		
	}
	
	public void draw() {
		System.out.println(p1+"�� "+p2+"�����մϴ�");
		System.out.println(p2+"�� "+p3+"�����մϴ�");
		System.out.println(p3+"�� "+p1+"�����մϴ�");
	}
}
