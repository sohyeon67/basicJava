package ddit.chap02.sec03;

import java.util.Scanner;

public class CastExample {

	public static void main(String[] args) {
		round();		
	}

	public static void round() {
		//여러 자리의 소숫점을 포함하는 실수를 키보드로 입력 받아 소숫점 3자리에서 반올림 후 출력하시오.
		
		//키보드로 입력
		// 1) Scanner class import
		//	  import java.util.Scanner;
		// 2) Scanner class 객체 생성 - new 연산자 사용
		//	  Scanner sc = new Scanner(System.in);
		// 3) 입력메시지 출력 - System.out.print("메시지")
		//	  System.out.print("실수자료 입력 : ");
		// 4) 입력자료 저장 - Scanner class의 입력자료형에 맞는 메서드 사용
		//    정수입력 : nextInt(), 실수 : nextFloat(), nextDouble(),
		//    문자열 : next(), nextLine(), ...
		
		Scanner sc = new Scanner(System.in);
		System.out.print("실수자료 입력 : ");
		double number = sc.nextDouble();
		double number1 = number;
		
		number1 = (int)((number*100)+0.5)/100.;
		System.out.println("number1="+number1);
		
		number=number*100;
		number=number+0.5;
		number=(int)number;		
		number=number/100;
		System.out.println("number="+number);
	}
}
