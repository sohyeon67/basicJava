package ddit.chap04.sec01;

import java.util.Scanner;

public class IfStatementExample03 {

	public static void main(String[] args) {
		method1();
	}
	
	public static void method1() {
		//Ű����� ���̵�� �н����带 �Է¹޾� �α��εǴ� �����̴�.
		//���� ���̵� ���Ͽ� ���̵� ��ġ�ϸ� ��й�ȣ�� ���ϰ�
		//���̵� ��ġ���� ������ "���̵� ��ġ���� �ʽ��ϴ�"�� ����ϰ�
		//���α׷� ������ �����ϸ�, ��й�ȣ�� ���� ������� ���Ͽ�
		//��� ��ġ�ϸ� "xx�� ȯ���մϴ�"��� �޽����� ���
		String id = "e1004";
		String pw = "1234";
		
		Scanner sc=new Scanner(System.in);
		System.out.print("���̵� : ");
		String uid=sc.nextLine();
		
		System.out.print("��ȣ : ");
		String upw=sc.nextLine();
		
		if(id.equals(uid)) {
			if(pw.equals(upw)) {
				System.out.println(uid+"�� ȯ���մϴ�.");
			} else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
			}
		} else {
			System.out.println("���̵� ��ġ���� �ʽ��ϴ�");
		}
	}

}
