package ddit.chap06.sec02;

public class Point {
	private int x;
	private int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() { //��ü ������ ���ڿ��� ��ȯ
		return "("+x+", "+y+")";
		//return getClass().getName()+'@'+Integer.toHexString(hashCode()); �ּ� ����=>16����
		//return getClass().getName()+'@'+hashCode();
	}
}
