package ddit.chap06.sec01;

public class TvExample {

	public static void main(String[] args) {
		Tv t1 = new Tv("�ʸ���", 2020, 55.0);
		System.out.println("������ : "+t1.company);
		System.out.println("����⵵ : "+t1.year);
		System.out.println("ũ�� : "+t1.size+"��ġ");
		
		Tv t2 = new Tv("�Ｚ����", 2021, 75.0);
		System.out.println("������ : "+t2.company);
		System.out.println("����⵵ : "+t2.year);
		System.out.println("ũ�� : "+t2.size+"��ġ");
		
	}
}
