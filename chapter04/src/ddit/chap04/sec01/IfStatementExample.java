package ddit.chap04.sec01;

import java.util.Scanner;

public class IfStatementExample {

	public static void main(String[] args) {
		// method01();
		// method02();
		//method03();
		//method04();
		method05();
	}

	public static void method01() {
		// 점수를 하나 입력 받아 60점 이상이면 "합격"을 출력
		int score = 65;
		if (score >= 60) {
			System.out.println("합격");
		}
	}

	public static void method02() {
		// 점수를 하나 입력 받아 60점 이상이면 "합격", 60점 미만이면 "불합격"을 출력
		int score = 70;
		if (score >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}

	public static void method03() {
		Scanner sc = new Scanner(System.in);
		System.out.print("월 : ");
		int month = sc.nextInt();
		String season = "";

		if (month < 0 || month > 12) {
			System.out.println("잘못된 월 입력입니다.");
		} else {
			if (month >= 3 && month <= 5)
				season = "봄";
			else if (month >= 6 && month <= 8)
				season = "여름";
			else if (month >= 9 && month <= 11)
				season = "가을";
			else
				season = "겨울";
			System.out.println(season);
		}
	}
	
	public static void method04() {
		System.out.print("점수");
		int score = 94;
		String grade="";
		
		if(score>=90) {
			grade="A";
			if(score>96) {
				grade=grade+"+";
			} else if(score>92) {
				grade=grade+"0";
			} else {
				grade=grade+"-";
			}
		} else if(score>=80) {
			grade="B";
			if(score>86) {
				grade=grade+"+";
			} else if(score>82) {
				grade=grade+"0";
			} else {
				grade=grade+"-";
			}
		} else {
			grade="F";
		}
		System.out.println(score+"점수의 학점은 "+grade+"입니다");
	}
	
	public static void method05() {
		Scanner sc = new Scanner(System.in);
		double bmi, height, weight;
		System.out.print("키(m) : ");
		height = sc.nextDouble();
		System.out.print("몸무게(kg) : ");
		weight = sc.nextDouble();
		bmi=weight/(height*height);
		
		String res="";
		
		if(bmi>=0 && bmi<=18.4)
			res="저체중";
		else if(bmi>=18.5 && bmi<=22.9)
			res="정상";
		else if(bmi>=23.0 && bmi<=24.9)
			res="과체중";
		else if(bmi>=25 && bmi<=29.9)
			res="비만";
		else
			res="고도비만";
		
		System.out.println(res+"입니다");
	}
}

class Account {
	private static Account instance = null;

	private Account() {
	}

	public static Account getInstance() {
		if (instance == null)
			instance = new Account();
		return instance;
	}
}
