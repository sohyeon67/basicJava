package ddit.chap04.sec03;

public class NestedForExample01 {

	public static void main(String[] args) {
		//nestedForMethod01();
		nestedForMethod02();
	}
	
	public static void nestedForMethod01() {
		//1���� 10������ ���� �ٿ��� 5�� �μ��Ͻÿ�
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<10; j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
	}
	
	public static void nestedForMethod02() {
		//2��~9�ܱ��� �������� ���
		for(int i=2; i<10; i++) {	//��
			System.out.println("[[ "+i+"�� ]]");
			for(int j=1; j<10; j++) {	//�������� ��(�¼�)
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
	}

}
