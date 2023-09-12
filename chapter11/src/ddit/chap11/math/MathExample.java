package ddit.chap11.math;

import java.util.Arrays;

public class MathExample {

	public static void main(String[] args) {
		// ������ ����� �����ϴ� �޼��� ���� - random()
		// max(val1, val2) : �� �Ű�����(val1, val2) �� ū���� ��ȯ
		// 10���� ���ϸ����� �迭�� ������ �� �� ���� 1000�̸��̸� 1000�� �ο��Ͻÿ�
		// ����Ŭ���� SELECT MEM_NAME ȸ����, GREATEST(1000,MEM_MILEAGE) ���渶�ϸ���, MEM_MILEAGE �������ϸ��� FROM MEMBER;

		int[] mileage = { 1000, 2300, 3500, 1700, 6500, 2700, 800, 1500, 900, 1100 };
		System.out.println("���� : " + Arrays.toString(mileage));
		for(int i=0; i<mileage.length; i++) {
			mileage[i]=Math.max(1000, mileage[i]);
		}
		System.out.println("���� : " + Arrays.toString(mileage));

	}

}
