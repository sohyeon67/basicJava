package ddit.chap04.sec04;

import java.io.IOException;
import java.util.Scanner;

public class WhileExample01 {

	public static void main(String[] args) {
		WhileStatement ws = new WhileStatement();
		ws.whileMethod02();
	}

}

class WhileStatement {
	public void whileMethod01() {
		// 1~100 사이의 홀수와 짝수의 합
		int cnt = 1; // 1~100사이의 값 보관
		int even = 0; // 짝수의 합
		int odd = 0; // 홀수의 합

		while (cnt <= 100) {
			if (cnt % 2 == 0) {
				even += cnt;
			} else {
				odd += cnt;
			}
			cnt++;
		}
		System.out.println("홀수의 합 = " + odd);
		System.out.println("짝수의 합 = " + even);
	}

	public void whileMethod02() {
		// 키보드로 숫자하나를 입력 받아 각 자리수의 합을
		// 구하시오 (ex 23456 => 2+3+4+5+6 = 20)
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력 : ");
		int num = sc.nextInt();
		int sum = 0;

		while (num != 0) {
			sum = sum + (num % 10);
			num = num / 10;
		}

		System.out.println(sum);

	}

	public void whileMethod03() throws IOException {
		// 컴퓨터가 1-50 사이의 난수를 하나 발생시키고
		// 사용자가 그 숫자를 맞추는 게임
		// 컴퓨터 난수>사용자입력 숫자 => "더 큰수 입력"
		// 컴퓨터 난수<사용자입력 숫자 => "더 작은수 입력"
		// 컴퓨터 난수=사용자입력 숫자 => "정답입니다" 출력 후 시도횟수까지 출력
		int ch = 0;
		int randomNum = (int) (Math.random() * 50) + 1;
		int cnt = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력(1~50) : ");
		int answer = 0;

		do {
			answer = sc.nextInt();
			while(true) {
				if (answer == randomNum) {
					System.out.println("정답입니다");
					System.out.println("시도횟수 : " + cnt);
					break;
				} else if (answer > randomNum) {
					System.out.print("더 작은 수를 입력하세요 : ");
				} else {
					System.out.print("더 큰 수를 입력하세요 : ");
				}
				cnt++;
			}
			System.out.println("계속하겠습니까?");
		} while ((char) (ch = System.in.read()) == 'y');

	}
}