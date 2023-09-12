package ddit.chap06.sec02;

public class Product {
	static int pid; // 제품번호
	static String pName = "마커펜"; // 제품명

	Product() { // 생성자 : 멤버필드(변수) 초기화
		pid++;
		pName = "마커팬";
	}

	public static void showProduct() { // 객체 생성 전부터 존재
		System.out.println("제품번호 : " + (++pid));
		System.out.println("제품명 : " + pName);
	}
}
