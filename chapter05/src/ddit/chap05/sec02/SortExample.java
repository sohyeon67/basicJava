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
	private int[] number; // ����ʵ�. private�� �� Ŭ���� �������� ���� ����

	BubbleSort() { // ������, ��� �ʵ� �ʱ�ȭ
		// n = 10
		number = new int[] { 27, 35, 19, 5, 47, 80, 15, 65, 50, 12 };
	}

	public void sort() { // �޼���
		boolean flag = true;

		System.out.println("[���� ������]");
		System.out.println(Arrays.toString(number));
		for (int i = 0; i < number.length - 1; i++) { // n-1=9 ȸ��
			flag = true;
			for (int j = 0; j < number.length - 1 - i; j++) { // j�� �ε����� i=0�϶� 0~8
				if (number[j] > number[j + 1]) {
					int temp = number[j];
					number[j] = number[j + 1];
					number[j + 1] = temp;
					flag = false; // �ڸ��ٲ��� �Ͼ�� ��
				}
			}
			if (flag)
				break; // �� ȸ������ �ڸ��ٲ��� ������ Ȯ��
		}
		System.out.println("[���ĵ� ������]");
		System.out.println(Arrays.toString(number));
	}

}

class SelectionSort {
	private int[] num;
	// num���� 10���� �����Ͱ� ����� �� �ִ� �ּҰ� ��
	// �迭�� ���� 0���� �ʱ�ȭ �Ǿ� ����
	// �ν��Ͻ� ����, ��� �ʵ�

	public SelectionSort() { // ������ : �ν��Ͻ�����(num) �ʱ�ȭ
		num = new int[] { 35, 40, 70, 16, 95, 19, 27, 63, 88, 57 };
	}

	public void selectionSort() { // Ŭ���� ���� �ִ� �Լ��̹Ƿ� num�� ���� ����
		System.out.println("[���� �� �ڷ�]");
		System.out.println(Arrays.toString(num));
		
		for (int i = 0; i < num.length - 1; i++) { // ȸ��
			for (int j = i + 1; j < num.length; j++) { // �� ȸ������ �� ���
				if (num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
	}

	public void printData() {
		System.out.println("[���� �� �ڷ�]");
		for (int su : num) {
			System.out.printf("%3d", su);
		}
	}
}
