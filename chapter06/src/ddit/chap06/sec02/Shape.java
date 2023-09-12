package ddit.chap06.sec02;
//정수형 원점의 좌표(x,y)와 실수 타입의 가로와 세로를 입력받아 사각형을 만드는
//클래스를 설계하고, 사각형의 면적을 계산하는 메서드를 포함시키시오.
public class Shape {

	public static void main(String[] args) {
		Point p1 = new Point(100,200);
		System.out.println("p1="+p1); //p1.toString() 메서드 생략된 것

		Rectangle rec1 = new Rectangle(new Point(100, 200), 25.5, 10.5);
		rec1.getArea();
	}
}
