package ddit.chap06.sec01;

public class GradeExample {

	public static void main(String[] args) {
		Grade g1 = new Grade();
		g1.score = new int[] { 80, 95, 85 };
		System.out.println("���� : "+g1.getSum());
		System.out.println("��� : "+g1.getAvg());
	}
}
