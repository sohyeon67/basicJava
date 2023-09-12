package ddit.chap05.sec04;

public class Point {
	private int x;
	private int y;
	
	Point() {
		x=0;
		y=0;
	}
	
	Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public String toString() { //�޼��� ������(�������̵�)
		return "("+x+", "+y+")"; //�ּҰ��� �ƴ϶� �̰��� ��������
	}
}