package ddit.chap05.sec02;

import java.util.Arrays;

public class SortExample {

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort();
		
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.selectionSort();
		selectionSort.printData();
	}
}

class BubbleSort {
	private int[] number; // 멤버필드. private은 이 클래스 내에서만 접근 가능

	BubbleSort() { // 생성자, 멤버 필드 초기화
		// n = 10
		number = new int[] { 27, 35, 19, 5, 47, 80, 15, 65, 50, 12 };
	}

	public void sort() { // 메서드
		boolean flag = true;

		System.out.println("[원본 데이터]");
		System.out.println(Arrays.toString(number));
		for (int i = 0; i < number.length - 1; i++) { // n-1=9 회전
			flag = true;
			for (int j = 0; j < number.length - 1 - i; j++) { // j의 인덱스가 i=0일때 0~8
				if (number[j] > number[j + 1]) {
					int temp = number[j];
					number[j] = number[j + 1];
					number[j + 1] = temp;
					flag = false; // 자리바꿈이 일어났을 때
				}
			}
			if (flag)
				break; // 각 회전에서 자리바꿈이 없는지 확인
		}
		System.out.println("[정렬된 데이터]");
		System.out.println(Arrays.toString(number));
	}

}

class SelectionSort {
	private int[] num;
	// num에는 10개의 데이터가 저장될 수 있는 주소값 들어감
	// 배열의 값은 0으로 초기화 되어 있음
	// 인스턴스 변수, 멤버 필드

	public SelectionSort() { // 생성자 : 인스턴스변수(num) 초기화
		num = new int[] { 35, 40, 70, 16, 95, 19, 27, 63, 88, 57 };
	}

	public void selectionSort() { // 클래스 내에 있는 함수이므로 num에 접근 가능
		System.out.println("[정렬 전 자료]");
		System.out.println(Arrays.toString(num));
		
		for (int i = 0; i < num.length - 1; i++) { // 회전
			for (int j = i + 1; j < num.length; j++) { // 각 회전에서 비교 담당
				if (num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}

	public void printData() {
		System.out.println("[정렬 후 자료]");
		for (int su : num) {
			System.out.printf("%3d", su);
		}
	}
}
