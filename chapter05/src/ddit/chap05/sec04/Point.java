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
	public String toString() { //메서드 재정의(오버라이딩)
		return "("+x+", "+y+")"; //주소값이 아니라 이것을 리턴해줌
	}
}
