package ddit.chap02.sec03;

public class PromotionExample {

	public static void main(String[] args) {
		byte b1=15;
		char ch1='b';
		short s1=15;
		int num1=100;
		long l1=1000L;
		float f1=0f;
		
		short res1=0;
		int res=0;
		float res2=0f;
		
		res=s1+ch1;	//int�� �ٲ�� ���� ����
		res1=(short)(s1+b1);	//int���� �����ֵ� �� int�� �ٲ�, ������ short�� ��ȯ�ص� ���� �� int�� �ȴ�. cast
		res2=l1+f1;	//promotion
		
		System.out.println(res2);
		
	}

}
