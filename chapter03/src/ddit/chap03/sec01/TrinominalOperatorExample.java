package ddit.chap03.sec01;

import java.util.Scanner;

public class TrinominalOperatorExample {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// ���׿�����
		// (���ǹ�)? ��ɹ�1:��ɹ�2
		// - ������ ��(true) ��ɹ� 1�� �����ϰ�, ������ ����(false)�̸�
		// ��ɹ�2�� ����
		// ���̸� �Է� �޾� �������� �̼��������� �Ǵ�
		//method1();
		method2();
	}

	public static void method1() {
		System.out.print("���� : ");
		int age = Integer.parseInt(sc.nextLine());
		String str = (age >= 18) ? "������ �Դϴ�" : "�̼����� �Դϴ�";
		System.out.println(str);
	}

	public static void method2() {
		//��(����)����: ũ���(>,<,==,>=,<=,!=(<>))
		// ����� true/false�̰�, �ַ� ���ǹ��� ���
		//Ű����� �Է¹��� ������ 
		// 90-100 : A����
		//  80-89 : B����
		//  70-79 : C����
		//  60-69 : D����
		//   �� ���� : F����
		System.out.print("���� : ");
		int score=sc.nextInt();
		String str=(score>=90? "A����":(score>=80? "B����":
					(score>=70? "C����":(score>=60? "D����" : "F����"))));
		System.out.println(score+"=>"+str);
	}
}
