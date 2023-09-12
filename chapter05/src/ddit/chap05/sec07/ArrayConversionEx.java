package ddit.chap05.sec07;

import java.util.Random;

public class ArrayConversionEx {

	public static void main(String[] args) {
		ArrayConversion ac = new ArrayConversion();
		ac.histogram();
		System.out.println();
		ac.conversion();
		ac.printHisto();
	}
}

class ArrayConversion {
	private int[] dice = new int[6];
	private Random random = new Random(); // ������ ���� �߻� class ����
	// ����Ŭ���� ����
	private char[][] histo; // ��������� ����

	public ArrayConversion() { // ������ �޼��� : �Ű����� �ʱ�ȭ
		for (int i = 0; i < 50; i++) { // ���� Ƚ�� 50ȸ
			// random class�� nextInt() : ������ ���� �ϳ� �߻�
			// nextInt(n) : 0~n-1 ������ ������ ���� 1�� �߻�
			int rnd = random.nextInt(6) + 1;
			dice[rnd - 1]++;
			// 1~6������ ���� �߻��Ǿ����� ������ ����� 0���� �����ϹǷ� -1 ���־����
		}
	}

	// ���� �׷��� ���
	public void histogram() {
		for (int i = 0; i < dice.length; i++) {
			System.out.print((i + 1) + "|");
			for (int j = 0; j < dice[i]; j++) {
				System.out.print("*");
			}
			System.out.println(dice[i]);
		}
	}

	// ���� �׷���
	public int getMaxNum() {
		int rowCount = dice[0]; // �ӽ� �ִ밪(���� ����)
		for (int i = 1; i < dice.length; i++) {
			// dice[0]�� �ڱ� �ڽŰ��̱⶧���� i=0�� �ʿ� ����
			if (rowCount < dice[i]) {
				rowCount = dice[i];
			}
		}
		return rowCount;
	}

	// ���� �׷���
	public void conversion() {
		int r = getMaxNum(); // ���� ��

		histo = new char[r][6]; // #

		for (int i = 0; i < dice.length; i++) { // i=��(6��)
			for (int j = 0; j < dice[i]; j++) { // j=��(�ִ밪)
				histo[j][i] = '#';
			}
		}
	}

	public void printHisto() {
		for (int i = histo.length - 1; i >= 0; i--) { // ��
			System.out.print("|");
			for (int j = 0; j < histo[i].length; j++) { // 6�� ����
				System.out.printf("%5c", histo[i][j]);
			}
			System.out.println();
		}
		System.out.println("|---------------------------------");
		System.out.println(" ");
		for (int k = 1; k <= 6; k++) {
			System.out.printf("%5d", k);
		}
	}
}