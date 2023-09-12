package ddit.chap05.sec05;

import java.util.Arrays;

public class TwoDimArrayExample01 {
	static int[][] score; // �迭����X �迭�� ����O
	// Ŭ���� �ϴܿ� �����ϸ� ���� �޼��忡�� ��� ���� ����
	// ��, �ϴܿ��� �̿��Ϸ��� �ϴܰ� ���� static �����������

	static String[] name;

	public static void main(String[] args) {
		method01();
		printScore();
		sortData();
	}

	// �� ������ ������ ���
	public static void method01() {
		score = new int[][] { { 75, 80, 65, 0, 0, 1 }
							, { 95, 85, 85, 0, 0, 1 }
							, { 65, 85, 85, 0, 0, 1 }
							, { 90, 60, 85, 0, 0, 1 }
							, { 95, 90, 95, 0, 0, 1 } 
					};

		name = new String[] { "ȫ�浿", "�̼���", "ȫ���", "�̼���", "������" };

		for (int i = 0; i < score.length; i++) { // ��
			for (int j = 0; j < 3; j++) { // ��
				score[i][3] += score[i][j]; // ����
			}
			score[i][4] = score[i][3] / 3; // ���
		}
		getRank();
	}

	public static void printScore() {
		System.out.println("===================================");
		System.out.println("�� ��     ����     ����      ����    ����      ���      ���");
		System.out.println("===================================");
		for (int i = 0; i < score.length; i++) {// ��
			System.out.print(name[i] + " ");
			for (int j = 0; j < score[i].length; j++) {// ��
				System.out.printf("%5d", score[i][j]);
			}
			System.out.println();
		}
	}

	public static void getRank() {
		for (int i = 0; i < score.length; i++) {// ���ذ� ��ġ
			for (int j = 0; j < score.length; j++) {// �񱳰� ��ġ
				if (score[i][3] < score[j][3]) //���� �̿�
					score[i][5]++;	//���. 5��(score.length) �߿� �� ��?
			}
		}
	}

	public static void sortData() {
		// bubble sort
		for (int i = 0; i < score.length - 1; i++) { //ȸ��
			for (int j = 0; j < score.length - 1 - i; j++) { //��, ��
				if (score[j][3] < score[j + 1][3]) { // �������� ��������, ���� ���� ���� ������ ����
					String temp = name[j];
					name[j] = name[j + 1];
					name[j + 1] = temp;
					for (int k = 0; k < score[j].length; k++) { // ������(����, ����, ...)
						int t = score[j][k];
						score[j][k] = score[j + 1][k];
						score[j + 1][k] = t;
					}
				}
			}
		}
		System.out.println("\n\n\n");
		printScore();
	}
}