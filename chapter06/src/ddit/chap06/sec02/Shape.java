package ddit.chap06.sec02;
//������ ������ ��ǥ(x,y)�� �Ǽ� Ÿ���� ���ο� ���θ� �Է¹޾� �簢���� �����
//Ŭ������ �����ϰ�, �簢���� ������ ����ϴ� �޼��带 ���Խ�Ű�ÿ�.
public class Shape {

	public static void main(String[] args) {
		Point p1 = new Point(100,200);
		System.out.println("p1="+p1); //p1.toString() �޼��� ������ ��

		Rectangle rec1 = new Rectangle(new Point(100, 200), 25.5, 10.5);
		rec1.getArea();
	}
}
