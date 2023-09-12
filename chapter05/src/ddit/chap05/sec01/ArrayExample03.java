package ddit.chap05.sec01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample03 {
	Scanner sc = new Scanner(System.in); // ����ʵ�. �������� sc�� static�� ���� main���� �� �� ����.

	public static void main(String[] args) {
		// �����迭 10��(score)�� �����ϰ� Ű���带 ���Ͽ� �Էµ� ������ �ʱ�ȭ�� ��
		// �ִ밪�� �ּҰ��� ���Ͻÿ�.
		int[] num = new ArrayExample03().setData(); // num�̶�� �����ҿ� ��ȯ�� �ּҰ� ����
		new ArrayExample03().getMaxMin(num);
	}

	// ����, �ʱ�ȭ
	public int[] setData() {
		int[] number = new int[10];
		for (int i = 0; i < number.length; i++) {
			System.out.print("number[" + i + "] = ");
			number[i] = Integer.parseInt(sc.nextLine());
			// nextInt()�� �������� ���еǾ��� ������ ����, ����Ű�� �����ͷ� ���. nextLine()�� ����Ű ġ�� �� �Է¹��� ��� �ڷḦ
			// ���ڿ��� ��ȯ
		}
		return number; // �迭��, �迭�� ���� �ּҰ�
	}

	// �ּҰ�, �ִ밪
	public void getMaxMin(int[] num) {
		int tmax = num[0]; // �ӽ� �ִ밪
		int tmin = num[0]; // �ӽ� �ּҰ�

		for (int i = 1; i < num.length; i++) {
			if (tmax < num[i])
				tmax = num[i];
			if (tmin > num[i])
				tmin = num[i];
		}
		
		System.out.println("���� �迭 : "+Arrays.toString(num));
		System.out.println("�ִ밪 = "+tmax);
		System.out.println("�ּҰ� = "+tmin);
	}

}
