package ddit.chap02.sec02;

public class IntegerExample {

	public static void main(String[] args) {
		byteInteger();
		shortInteger();
		intInteger();
		longInteger();
	}

	public static void byteInteger() {
		// byte : 1byte ����
		// 127 ~ -128 ���� ����
		// 127���� ũ�ų� -128���� ���� literal�� �����߻�
		// ���Ŀ� ���� ������ �ʰ��ϴ� ��� ��ȯ����� ���� ���(128�� -128��, 129�̸� -127��)

		// byte b1 = 128; ����
		byte res = 127;
		// res+1���� 1�� int(�⺻��)�̶� ����. ���Ҷ� ū���� ����. ��������� byte�� ����
		System.out.println(++res);
		System.out.println(++res);
	}

	public static void shortInteger() {
		// short : 2byte ����
		// 32767 ~ -32768 ���� ����
		// 32767���� ũ�ų� -32768���� ���� literal�� �����߻�
		// ���Ŀ� ���� ������ �ʰ��ϴ� ��� ��ȯ����� ���� ���(32768�� -32768��, 32769�̸� -32767��)

		short sh1 = 200;
		short sh2 = 10;
		// short res=sh1+10; //10�� int, short(=>int)+int = int...short+(short)int=short(o)
		// short res=sh1+sh2; //���Ŀ��� int���� ������ int�� �ٲ�
		short res = (short) (sh1 + sh2); // ��������ȯ cast
		System.out.println(res);
	}

	public static void intInteger() {
		// int : 4byte ����
		// �⺻ ����Ÿ��
		// 2147483647 ~ - 2147483648
		// ������ ����� literal�� �����߻�
		// ���Ŀ� ���� ������ �ʰ��ϴ� ��� ��ȯ����� ��
		int num = 200;
		int res = 1000000*1000000;
		//res=10000000000; ����
		System.out.println("res : "+res);
	}
	
	public static void longInteger() {
		//long : 8byte
		//		 2^63-1 ~ -2^63
		//		 ���ͷ� ���� L(l)�߰��Ͽ� longŸ���� �������� ǥ��
		long num = 100L;
		long res1 = 1000000*1000000;
		long res2 = 1000000L*1000000L;	//�ϳ��� L �ٿ��� ��
		
		System.out.println("res1 : "+res1);
		System.out.println("res2 : "+res2);
	}
}
