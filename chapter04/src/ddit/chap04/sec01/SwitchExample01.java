package ddit.chap04.sec01;

import java.util.Scanner;

public class SwitchExample01 {

	public static void main(String[] args) {
		//method1();
		//method2();
		method3();
	}

	public static void method1() {
		// Ű����� �Է¹��� ���� ���Ͽ� ¦���� Ȧ���� �����Ͻÿ�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		switch (num % 2) {
		case 0:
			System.out.println(num + "�� ¦���Դϴ�...");
			break;
		case 1:
			System.out.println(num + "�� Ȧ���Դϴ�...");
		}
	}

	public static void method2() {
		// 1~12 ������ ���ڸ� �Է¹޾� �� ����
		// 3-5 �̸� "���Դϴ�."
		// 6-8 �̸� "�����Դϴ�."
		// 9-11 �̸� " �����Դϴ�."
		// 12,1,2 �̸� "�ܿ��Դϴ�."�� ����Ͻÿ�.

		int month=6;
		
		switch(month) {
		case 3: case 4: case 5:
			System.out.println("���Դϴ�.");
			break;
		case 6: case 7: case 8:
			System.out.println("�����Դϴ�.");
			break;
		case 9: case 10: case 11:
			System.out.println("�����Դϴ�.");
			break;
		case 12: case 1: case 2:
			System.out.println("�ܿ��Դϴ�.");
			break;
		default:
			System.out.println("���� ������ �߸��Ǿ����ϴ�..");
		}
	}
	
	public static void method3() {
		//ȸ������ ���ϸ����� ���� 
		//���ϸ����� 1000 - 3999�� ���ϸ� "�Ϲ�ȸ��"
		//   ""  4000 - 6000   "  "���ȸ��"
		// �� �̻��̸� VIPȸ���� ��� ����Ͻÿ�
		//�Է��ڷ�� ȸ����ȣ, ȸ����, ���ϸ����̰�
		//����� ȸ����ȣ, ȸ����, ���ϸ���, ����̴�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ȸ����ȣ : ");
		String mid = sc.nextLine();
		
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		System.out.print("���ϸ��� : ");
		int mileage = sc.nextInt();
		
		String kind="";
		
		//case 1000���� ������!!!!!!!!!!!!!!!!!
		switch(mileage/1000) {
		case 1: case 2: case 3:
			kind = "�Ϲ�ȸ��";
			break;
		case 4: case 5: case 6:
			kind = "���ȸ��";
			break;
		default:
			kind = "VIPȸ��";
		}
		System.out.println("ȸ����ȣ : "+mid);
		System.out.println("ȸ���� : "+name);
		System.out.println("���ϸ��� : "+mileage);
		System.out.println("��� : "+kind);
	}
}
