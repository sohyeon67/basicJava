package ddit.chap06.sec01;

public class TvExample {

	public static void main(String[] args) {
		Tv t1 = new Tv("필립스", 2020, 55.0);
		System.out.println("제조사 : "+t1.company);
		System.out.println("생산년도 : "+t1.year);
		System.out.println("크기 : "+t1.size+"인치");
		
		Tv t2 = new Tv("삼성전자", 2021, 75.0);
		System.out.println("제조사 : "+t2.company);
		System.out.println("생산년도 : "+t2.year);
		System.out.println("크기 : "+t2.size+"인치");
		
	}
}
