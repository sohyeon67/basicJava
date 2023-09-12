package ddit.chap03.sec01;

import java.util.Scanner;

public class TrinominalOperatorExample {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// 삼항연산자
		// (조건문)? 명령문1:명령문2
		// - 조건이 참(true) 명령문 1을 수행하고, 조건이 거짓(false)이면
		// 명령문2를 수행
		// 나이를 입력 받아 성년인지 미성년인지를 판단
		//method1();
		method2();
	}

	public static void method1() {
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		String str = (age >= 18) ? "성년자 입니다" : "미성년자 입니다";
		System.out.println(str);
	}

	public static void method2() {
		//비교(관계)연산: 크기비교(>,<,==,>=,<=,!=(<>))
		// 결과는 true/false이고, 주로 조건문에 사용
		//키보드로 입력받은 점수가 
		// 90-100 : A학점
		//  80-89 : B학점
		//  70-79 : C학점
		//  60-69 : D학점
		//   그 이하 : F학점
		System.out.print("점수 : ");
		int score=sc.nextInt();
		String str=(score>=90? "A학점":(score>=80? "B학점":
					(score>=70? "C학점":(score>=60? "D학점" : "F학점"))));
		System.out.println(score+"=>"+str);
	}
}
