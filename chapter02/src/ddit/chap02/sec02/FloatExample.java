package ddit.chap02.sec02;

//�Ǽ��ڷ��� : float, double
public class FloatExample {

	public static void main(String[] args) {
		// 1)float : 4byte(1bit(��ȣ), 8bit(����), 23bit(����:�Ҽ��� ������ ��)
		// 1.4e-45 ~ 3.4e+38(long���� ū ����)
		// ���ͷ� ���� F(f) �߰��ؾ� ��. ex)3.1415926f
		// 2)double : 8byte(1bit(��ȣ), 11bit(����), 52bit(����:�Ҽ��� ������ ��)
		// 4.9e-324 ~ 1.8e+308
		// �⺻�Ǽ� Ÿ��
		// ���ͷ� ���� D(d) �߰��ϰų� ������ �� ����

		float f1 = 3.14f;
		float f2 = 0.1f;

		double d1 = 3.14;
		double d = 3.14d;
		double d2 = 0.1;
		double d3 = f2;
		
		if(f2==d2) {
			System.out.println("���� ũ���� ��");
		}
		else {
			System.out.println("�ٸ� ũ���� ��");
			System.out.println("d3 : "+d3);
		}
		
	}

}
