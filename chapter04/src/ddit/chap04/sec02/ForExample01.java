package ddit.chap04.sec02;

public class ForExample01 {

	public static void main(String[] args) {
		// forMethod01();
		// forMethod02();
		// forMethod03();
		forMethod04();
	}

	public static void forMethod01() {
		// 1부터 10사이의 수를 붙여서 출력
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%-3d ", i);
		}
	}

	public static void forMethod02() {
		// 알파벳 A~Z까지 한줄에 출력하시오
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			// int ch='A' 가능, char로 형변환해서 출력하면 됨
			System.out.printf("%c", ch);
		}
	}

	public static void forMethod03() {
		// 0~50사이의 fibonacci number(피보나치 수열) 값을 구하시오
		// 피보나치 수열 : 첫 번째와 2분째 수가 1로 주어지고 3번째 수부터 전 두 수의 합이
		// 현재 수가 되는 수열(1,1,2,3,5,8,13,...)

		int p = 1; // 前數
		int pp = 1; // 前前數
		int current = 0; // 현재수

		System.out.printf("%-3d %-3d", p, pp);
		while (true) {
			current = p + pp;
			if (current >= 50)
				break;
			System.out.printf(" %-3d", current);
			pp = p;
			p = current;
		}
	}

	public static void forMethod04() {
		// 1 + 1/2 + 1/3 + ... + 1/10 = ?
		double sum = 0;

		for (int i = 1; i < 11; i++) {
			sum = sum + 1 / (double) i;
		}
		System.out.printf("결과 = %7.2f", sum);

	}
}
