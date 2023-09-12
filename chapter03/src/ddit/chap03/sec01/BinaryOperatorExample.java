package ddit.chap03.sec01;

import java.util.Scanner;

public class BinaryOperatorExample {

	public static void main(String[] args) {
		//arithmethicOperator();
		//relationalOperator();
		//relationalOperator2();
		logicalOperator();
	}

	public static void arithmethicOperator() {
		//+,-,*,/,%
		//1~100������ ¦���� �հ� Ȧ���� ���� ���
		int even=0;
		int odd=0;
		
		for(int i=1;i<101;i++) {
			if(i%2==0) {
				even+=i;
			}
			else
				odd+=i;
		}
		
		System.out.println("¦���� �� : "+even);
		System.out.println("Ȧ���� �� : "+odd);
	}
	
	public static void relationalOperator() {
		//��(����)����: ũ���(>,<,==,>=,<=,!=(<>))
		// ����� true/false�̰�, �ַ� ���ǹ��� ���
		//Ű����� �Է¹��� ������ 
		// 90-100 : A����
		//  80-89 : B����
		//  70-79 : C����
		//  60-69 : D����
		//   �� ���� : F����
		String grade="";
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int score=sc.nextInt();
		if(score>=90) {
			grade="A����";
		} else if (score>=80) {
			grade="B����";
		} else if (score>=70) {
			grade="C����";
		} else if (score>=60) {
			grade="D����";
		} else {
			grade="F����";
		}
		
		System.out.println(score+"������ "+grade+"�Դϴ�.");
		
	}
	
	public static void relationalOperator2() {
		//Ű����� ����(10�� �̻�)�� �Է¹޾� �� ����� ��� ������ ���ϴ��� ���
		// ex) 35���̸� -> "30���Դϴ�", 56���̸� "50���Դϴ�"
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		//int age = sc.nextInt();
		int age=Integer.parseInt(sc.nextLine());
		
		int age1=(age/10)*10;	//10�� �ڸ� �̿�
		String message = age1+"���Դϴ�.";
		System.out.println(age+"���� "+message);
	}
	
	public static void logicalOperator() {
		//�������� : !(not), &&(and), ||(or)
		//�ڽ��� ����⵵�� �Է� �޾� ����� ����� �Ǵ��Ͻÿ�
		//����:(4�� ����̸鼭 100�� ����� �ƴ���)�̰ų� (400�� ����� �Ǵ� ��)
		Scanner sc=new Scanner(System.in);
		System.out.print("�⵵ : ");
		int year=Integer.parseInt(sc.nextLine());
		//�׳� next�� ���� �Է��ϱ� ������ �Է¹���
		
		if((year%4==0 && year%100!=0)||(year%400==0)) {
			System.out.println(year+"���� �����Դϴ�...");
		} else {
			System.out.println(year+"���� ����Դϴ�...");			
		}
		
	}
}
