package ddit.chap07.sec04;

public class ShapeExample {

	public static void main(String[] args) {
		Shape p1 = new Circle("원", new Point(200,100),15);
		p1.draw(); //오버라이딩된 메서드 호출
		
	}

}
