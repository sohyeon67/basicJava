package ddit.chap06.sec02;

public class Point {
	private int x;
	private int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() { //객체 내용을 문자열로 반환
		return "("+x+", "+y+")";
		//return getClass().getName()+'@'+Integer.toHexString(hashCode()); 주소 정수=>16진수
		//return getClass().getName()+'@'+hashCode();
	}
}
