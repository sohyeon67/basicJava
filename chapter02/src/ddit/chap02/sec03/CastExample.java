package ddit.chap02.sec03;

import java.util.Scanner;

public class CastExample {

	public static void main(String[] args) {
		round();		
	}

	public static void round() {
		//���� �ڸ��� �Ҽ����� �����ϴ� �Ǽ��� Ű����� �Է� �޾� �Ҽ��� 3�ڸ����� �ݿø� �� ����Ͻÿ�.
		
		//Ű����� �Է�
		// 1) Scanner class import
		//	  import java.util.Scanner;
		// 2) Scanner class ��ü ���� - new ������ ���
		//	  Scanner sc = new Scanner(System.in);
		// 3) �Է¸޽��� ��� - System.out.print("�޽���")
		//	  System.out.print("�Ǽ��ڷ� �Է� : ");
		// 4) �Է��ڷ� ���� - Scanner class�� �Է��ڷ����� �´� �޼��� ���
		//    �����Է� : nextInt(), �Ǽ� : nextFloat(), nextDouble(),
		//    ���ڿ� : next(), nextLine(), ...
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�Ǽ��ڷ� �Է� : ");
		double number = sc.nextDouble();
		double number1 = number;
		
		number1 = (int)((number*100)+0.5)/100.;
		System.out.println("number1="+number1);
		
		number=number*100;
		number=number+0.5;
		number=(int)number;		
		number=number/100;
		System.out.println("number="+number);
	}
}
