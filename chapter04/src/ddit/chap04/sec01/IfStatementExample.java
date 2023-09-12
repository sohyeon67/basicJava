package ddit.chap04.sec01;

import java.util.Scanner;

public class IfStatementExample {

	public static void main(String[] args) {
		// method01();
		// method02();
		//method03();
		//method04();
		method05();
	}

	public static void method01() {
		// ������ �ϳ� �Է� �޾� 60�� �̻��̸� "�հ�"�� ���
		int score = 65;
		if (score >= 60) {
			System.out.println("�հ�");
		}
	}

	public static void method02() {
		// ������ �ϳ� �Է� �޾� 60�� �̻��̸� "�հ�", 60�� �̸��̸� "���հ�"�� ���
		int score = 70;
		if (score >= 60) {
			System.out.println("�հ�");
		} else {
			System.out.println("���հ�");
		}
	}

	public static void method03() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�� : ");
		int month = sc.nextInt();
		String season = "";

		if (month < 0 || month > 12) {
			System.out.println("�߸��� �� �Է��Դϴ�.");
		} else {
			if (month >= 3 && month <= 5)
				season = "��";
			else if (month >= 6 && month <= 8)
				season = "����";
			else if (month >= 9 && month <= 11)
				season = "����";
			else
				season = "�ܿ�";
			System.out.println(season);
		}
	}
	
	public static void method04() {
		System.out.print("����");
		int score = 94;
		String grade="";
		
		if(score>=90) {
			grade="A";
			if(score>96) {
				grade=grade+"+";
			} else if(score>92) {
				grade=grade+"0";
			} else {
				grade=grade+"-";
			}
		} else if(score>=80) {
			grade="B";
			if(score>86) {
				grade=grade+"+";
			} else if(score>82) {
				grade=grade+"0";
			} else {
				grade=grade+"-";
			}
		} else {
			grade="F";
		}
		System.out.println(score+"������ ������ "+grade+"�Դϴ�");
	}
	
	public static void method05() {
		Scanner sc = new Scanner(System.in);
		double bmi, height, weight;
		System.out.print("Ű(m) : ");
		height = sc.nextDouble();
		System.out.print("������(kg) : ");
		weight = sc.nextDouble();
		bmi=weight/(height*height);
		
		String res="";
		
		if(bmi>=0 && bmi<=18.4)
			res="��ü��";
		else if(bmi>=18.5 && bmi<=22.9)
			res="����";
		else if(bmi>=23.0 && bmi<=24.9)
			res="��ü��";
		else if(bmi>=25 && bmi<=29.9)
			res="��";
		else
			res="����";
		
		System.out.println(res+"�Դϴ�");
	}
}

class Account {
	private static Account instance = null;

	private Account() {
	}

	public static Account getInstance() {
		if (instance == null)
			instance = new Account();
		return instance;
	}
}
