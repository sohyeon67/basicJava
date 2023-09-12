package ddit.chap04.sec01;

import java.util.Scanner;

public class IfStatementExample02 {

	public static void main(String[] args) {
		//method1();
		method2();
		
	}

	public static void method1() {
		// Ű����� �����ϳ�(1~10)�� �Է¹ް�,
		// ��ǻ�Ϳ��� ����(1~10)�� �Է¹޾� �� ���� ���Ͽ�
		// ���� ���̸� "�����Դϴ�"�� ����Ͻÿ�
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է�(1~10) : ");
		int userNum = sc.nextInt();

		int comNum = (int) (Math.random() * 10) + 1; // 1~10 ������ ������ ����

		if (userNum == comNum) {
			System.out.println("�����Դϴ�");
		} else {
			System.out.println("������ �ƴմϴ�" + comNum);
		}
	}

	public static void method2() {
		// Ű����� �����ϳ�(1~10)�� �Է¹ް�,
		// ��ǻ�Ϳ��� ����(1~10)�� �Է¹޾� �� ���� ���Ͽ�
		// 1)��ǻ�Ϳ��� ������ ���� ������� ���ں��� �� ū ���̸�(com>user)
		// "�� ū ���� �Է��ϼ���"�� ����ϰ�
		// 2)��ǻ�Ϳ��� ������ ���� ������� ���ں��� �� ���� ���̸�(com<user)
		// "�� ���� ���� �Է��ϼ���"�� ����ϰ�
		// ���� ���̸� "�����Դϴ�"�� ����Ͻÿ�.
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է�(1~10) : ");
		int userNum;

		int comNum = (int) (Math.random() * 10) + 1; // 1~10 ������ ������ ����

		while (true) {
			userNum = sc.nextInt();
			if (userNum < comNum) {
				System.out.println("�� ū ���� �Է��ϼ���");
			} else if (userNum > comNum) {
				System.out.println("�� ���� ���� �Է��ϼ���");
			} else {
				System.out.println("�����Դϴ�");
				break;
			}
		}

	}

}
