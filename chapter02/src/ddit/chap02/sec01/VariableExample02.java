package ddit.chap02.sec01;
//1-100 ������ ��

public class VariableExample02 {

	public static void main(String[] args) {		
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
		}
		System.out.println("1���� 100������ �� : "+sum);
		
		myMethod();
	}

	//ù ���� 100�� ��°������ ������ �ι辿 �����Ѵٸ� ���ʷ� 100������ �Ѵ� ����
	//��ĥ�� ����� ���̸� �׶������� �ݾ���?
	
	public static void myMethod() {
		int sum = 0;	//���� �Ѿ�
		int days = 1;	//����ϼ�
		int money = 100;//������ �׼�
		
		while(true) {
			sum = sum+money;
			if(sum>=1000000)
				break;
			money=money*2;
			days++;
		}
		System.out.println("����ϼ� : "+days);
		System.out.println("����ݾ� : "+sum);
	}
}