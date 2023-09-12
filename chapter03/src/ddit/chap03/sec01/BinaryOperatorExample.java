package ddit.chap03.sec01;

import java.util.Scanner;

public class BinaryOperatorExample {

	public static void main(String[] args) {
		//arithmethicOperator();
		//relationalOperator();
		//relationalOperator2();
		logicalOperator();
	}

	public static void arithmethicOperator() {
		//+,-,*,/,%
		//1~100사이의 짝수의 합과 홀수의 합을 출력
		int even=0;
		int odd=0;
		
		for(int i=1;i<101;i++) {
			if(i%2==0) {
				even+=i;
			}
			else
				odd+=i;
		}
		
		System.out.println("짝수의 합 : "+even);
		System.out.println("홀수의 합 : "+odd);
	}
	
	public static void relationalOperator() {
		//비교(관계)연산: 크기비교(>,<,==,>=,<=,!=(<>))
		// 결과는 true/false이고, 주로 조건문에 사용
		//키보드로 입력받은 점수가 
		// 90-100 : A학점
		//  80-89 : B학점
		//  70-79 : C학점
		//  60-69 : D학점
		//   그 이하 : F학점
		String grade="";
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 : ");
		int score=sc.nextInt();
		if(score>=90) {
			grade="A학점";
		} else if (score>=80) {
			grade="B학점";
		} else if (score>=70) {
			grade="C학점";
		} else if (score>=60) {
			grade="D학점";
		} else {
			grade="F학점";
		}
		
		System.out.println(score+"점수는 "+grade+"입니다.");
		
	}
	
	public static void relationalOperator2() {
		//키보드로 나이(10세 이상)를 입력받아 그 사람이 어느 구간에 속하는지 출력
		// ex) 35세이면 -> "30대입니다", 56세이면 "50대입니다"
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		//int age = sc.nextInt();
		int age=Integer.parseInt(sc.nextLine());
		
		int age1=(age/10)*10;	//10의 자리 이용
		String message = age1+"대입니다.";
		System.out.println(age+"세는 "+message);
	}
	
	public static void logicalOperator() {
		//논리연산자 : !(not), &&(and), ||(or)
		//자신의 출생년도를 입력 받아 윤년과 평년을 판단하시오
		//윤년:(4의 배수이면서 100의 배수가 아닌해)이거나 (400의 배수가 되는 해)
		Scanner sc=new Scanner(System.in);
		System.out.print("년도 : ");
		int year=Integer.parseInt(sc.nextLine());
		//그냥 next는 공백 입력하기 전까지 입력받음
		
		if((year%4==0 && year%100!=0)||(year%400==0)) {
			System.out.println(year+"년은 윤년입니다...");
		} else {
			System.out.println(year+"년은 평년입니다...");			
		}
		
	}
}
