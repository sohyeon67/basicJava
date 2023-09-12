package ddit.chap05.sec01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample03 {
	Scanner sc = new Scanner(System.in); // 멤버필드. 참조변수 sc는 static이 붙은 main에서 쓸 수 없음.

	public static void main(String[] args) {
		// 정수배열 10개(score)를 선언하고 키보드를 통하여 입력된 값으로 초기화한 수
		// 최대값과 최소값을 구하시오.
		int[] num = new ArrayExample03().setData(); // num이라는 기억장소에 반환된 주소값 저장
		new ArrayExample03().getMaxMin(num);
	}

	// 선언, 초기화
	public int[] setData() {
		int[] number = new int[10];
		for (int i = 0; i < number.length; i++) {
			System.out.print("number[" + i + "] = ");
			number[i] = Integer.parseInt(sc.nextLine());
			// nextInt()는 공백으로 구분되어진 데이터 저장, 엔터키도 데이터로 취급. nextLine()은 엔터키 치기 전 입력받은 모든 자료를
			// 문자열로 반환
		}
		return number; // 배열명, 배열의 시작 주소값
	}

	// 최소값, 최대값
	public void getMaxMin(int[] num) {
		int tmax = num[0]; // 임시 최대값
		int tmin = num[0]; // 임시 최소값

		for (int i = 1; i < num.length; i++) {
			if (tmax < num[i])
				tmax = num[i];
			if (tmin > num[i])
				tmin = num[i];
		}
		
		System.out.println("원본 배열 : "+Arrays.toString(num));
		System.out.println("최대값 = "+tmax);
		System.out.println("최소값 = "+tmin);
	}

}
