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
		System.out.println(p1+"과 "+p2+"연결합니다");
		System.out.println(p2+"과 "+p3+"연결합니다");
		System.out.println(p3+"과 "+p1+"연결합니다");
	}
}
