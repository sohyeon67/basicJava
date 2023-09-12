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
		// 1~100 ������ Ȧ���� ¦���� ��
		int cnt = 1; // 1~100������ �� ����
		int even = 0; // ¦���� ��
		int odd = 0; // Ȧ���� ��

		while (cnt <= 100) {
			if (cnt % 2 == 0) {
				even += cnt;
			} else {
				odd += cnt;
			}
			cnt++;
		}
		System.out.println("Ȧ���� �� = " + odd);
		System.out.println("¦���� �� = " + even);
	}

	public void whileMethod02() {
		// Ű����� �����ϳ��� �Է� �޾� �� �ڸ����� ����
		// ���Ͻÿ� (ex 23456 => 2+3+4+5+6 = 20)
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է� : ");
		int num = sc.nextInt();
		int sum = 0;

		while (num != 0) {
			sum = sum + (num % 10);
			num = num / 10;
		}

		System.out.println(sum);

	}

	public void whileMethod03() throws IOException {
		// ��ǻ�Ͱ� 1-50 ������ ������ �ϳ� �߻���Ű��
		// ����ڰ� �� ���ڸ� ���ߴ� ����
		// ��ǻ�� ����>������Է� ���� => "�� ū�� �Է�"
		// ��ǻ�� ����<������Է� ���� => "�� ������ �Է�"
		// ��ǻ�� ����=������Է� ���� => "�����Դϴ�" ��� �� �õ�Ƚ������ ���
		int ch = 0;
		int randomNum = (int) (Math.random() * 50) + 1;
		int cnt = 0;

		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է�(1~50) : ");
		int answer = 0;

		do {
			answer = sc.nextInt();
			while(true) {
				if (answer == randomNum) {
					System.out.println("�����Դϴ�");
					System.out.println("�õ�Ƚ�� : " + cnt);
					break;
				} else if (answer > randomNum) {
					System.out.print("�� ���� ���� �Է��ϼ��� : ");
				} else {
					System.out.print("�� ū ���� �Է��ϼ��� : ");
				}
				cnt++;
			}
			System.out.println("����ϰڽ��ϱ�?");
		} while ((char) (ch = System.in.read()) == 'y');

	}
}