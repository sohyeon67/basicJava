package ddit.chap04.sec01;

import java.util.Scanner;

public class IfStatementExample02 {

	public static void main(String[] args) {
		//method1();
		method2();
		
	}

	public static void method1() {
		// 키보드로 숫자하나(1~10)를 입력받고,
		// 컴퓨터에서 난수(1~10)를 입력받아 두 수를 비교하여
		// 같은 값이면 "정답입니다"를 출력하시오
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력(1~10) : ");
		int userNum = sc.nextInt();

		int comNum = (int) (Math.random() * 10) + 1; // 1~10 사이의 정수형 난수

		if (userNum == comNum) {
			System.out.println("정답입니다");
		} else {
			System.out.println("정답이 아닙니다" + comNum);
		}
	}

	public static void method2() {
		// 키보드로 숫자하나(1~10)를 입력받고,
		// 컴퓨터에서 난수(1~10)를 입력받아 두 수를 비교하여
		// 1)컴퓨터에서 생성된 수가 사용자의 숫자보다 더 큰 수이면(com>user)
		// "더 큰 수를 입력하세요"를 출력하고
		// 2)컴퓨터에서 생성된 수가 사용자의 숫자보다 더 작은 수이면(com<user)
		// "더 작은 수를 입력하세요"를 출력하고
		// 같은 값이면 "정답입니다"를 출력하시오.
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력(1~10) : ");
		int userNum;

		int comNum = (int) (Math.random() * 10) + 1; // 1~10 사이의 정수형 난수

		while (true) {
			userNum = sc.nextInt();
			if (userNum < comNum) {
				System.out.println("더 큰 수를 입력하세요");
			} else if (userNum > comNum) {
				System.out.println("더 작은 수를 입력하세요");
			} else {
				System.out.println("정답입니다");
				break;
			}
		}

	}

}
