package ddit.chap04.sec02;

public class ForExample01 {

	public static void main(String[] args) {
		// forMethod01();
		// forMethod02();
		// forMethod03();
		forMethod04();
	}

	public static void forMethod01() {
		// 1���� 10������ ���� �ٿ��� ���
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%-3d ", i);
		}
	}

	public static void forMethod02() {
		// ���ĺ� A~Z���� ���ٿ� ����Ͻÿ�
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			// int ch='A' ����, char�� ����ȯ�ؼ� ����ϸ� ��
			System.out.printf("%c", ch);
		}
	}

	public static void forMethod03() {
		// 0~50������ fibonacci number(�Ǻ���ġ ����) ���� ���Ͻÿ�
		// �Ǻ���ġ ���� : ù ��°�� 2��° ���� 1�� �־����� 3��° ������ �� �� ���� ����
		// ���� ���� �Ǵ� ����(1,1,2,3,5,8,13,...)

		int p = 1; // ���
		int pp = 1; // �����
		int current = 0; // �����

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
		System.out.printf("��� = %7.2f", sum);

	}
}
