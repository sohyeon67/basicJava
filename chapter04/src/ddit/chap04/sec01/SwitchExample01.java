package ddit.chap04.sec01;

import java.util.Scanner;

public class SwitchExample01 {

	public static void main(String[] args) {
		//method1();
		//method2();
		method3();
	}

	public static void method1() {
		// 키보드로 입력받은 수를 평가하여 짝수와 홀수를 구별하시오
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 : ");
		int num = sc.nextInt();
		switch (num % 2) {
		case 0:
			System.out.println(num + "은 짝수입니다...");
			break;
		case 1:
			System.out.println(num + "은 홀수입니다...");
		}
	}

	public static void method2() {
		// 1~12 사이의 숫자를 입력받아 그 값이
		// 3-5 이면 "봄입니다."
		// 6-8 이면 "여름입니다."
		// 9-11 이면 " 가을입니다."
		// 12,1,2 이면 "겨울입니다."를 출력하시오.

		int month=6;
		
		switch(month) {
		case 3: case 4: case 5:
			System.out.println("봄입니다.");
			break;
		case 6: case 7: case 8:
			System.out.println("여름입니다.");
			break;
		case 9: case 10: case 11:
			System.out.println("가을입니다.");
			break;
		case 12: case 1: case 2:
			System.out.println("겨울입니다.");
			break;
		default:
			System.out.println("월의 선택이 잘못되었습니다..");
		}
	}
	
	public static void method3() {
		//회원들의 마일리지에 따라 
		//마일리지가 1000 - 3999에 속하면 "일반회원"
		//   ""  4000 - 6000   "  "우수회원"
		// 그 이상이면 VIP회원을 비고에 출력하시오
		//입력자료는 회원번호, 회원명, 마일리지이고
		//출력은 회원번호, 회원명, 마일리지, 비고이다
		Scanner sc = new Scanner(System.in);
		
		System.out.print("회원번호 : ");
		String mid = sc.nextLine();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("마일리지 : ");
		int mileage = sc.nextInt();
		
		String kind="";
		
		//case 1000개씩 쓰지마!!!!!!!!!!!!!!!!!
		switch(mileage/1000) {
		case 1: case 2: case 3:
			kind = "일반회원";
			break;
		case 4: case 5: case 6:
			kind = "우수회원";
			break;
		default:
			kind = "VIP회원";
		}
		System.out.println("회원번호 : "+mid);
		System.out.println("회원명 : "+name);
		System.out.println("마일리지 : "+mileage);
		System.out.println("비고 : "+kind);
	}
}
