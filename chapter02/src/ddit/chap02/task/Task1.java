package ddit.chap02.task;

public class Task1 {

	public static void main(String[] args) {
		byteSum();
		shortSum();
		intSum();
		longSum();
	}

	public static void byteSum() {
		//byte : -128~127
		byte a = 100;
		byte b = 28;
		
		//���� Ÿ�� byte, short ������ int Ÿ������ �ڵ� Ÿ�� ��ȯ�Ǿ� ���� ����
		byte sum = (byte)(a+b);	//casting, ��ȯ����� ��
		System.out.println(sum);
	}
	
	public static void shortSum() {
		//short : -32768~32767
		short a = 32760;
		short b = 9;
		
		short sum = (short)(a+b);	//casting, ��ȯ����� ��
		System.out.println(sum);
	}
	
	public static void intSum() {
		byte a = 100;
		short b = 20;
		
		//int Ÿ�Ժ��� ���� byte, short Ÿ���� ������ int Ÿ������ �ڵ� Ÿ�� ��ȯ�Ǿ� ������ ����
		int sum = a+b;
		System.out.println(sum);
	}
	
	public static void longSum() {
		int a = 200;
		long b = 300;
		
		//�� �ǿ����� �� ��� ������ ū Ÿ������ ��ȯ�Ǿ� ���� ����
		long sum = a+b;
		System.out.println(sum);
		
	}
}
