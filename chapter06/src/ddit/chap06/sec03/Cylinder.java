package ddit.chap06.sec03;
/* 
 * ���� 5. ������ ������ Circle Ŭ������ ����� ������ �����ϴ� Cylinder Ŭ������ �ۼ��Ͻÿ�.
�� ������ ��Ÿ���� Cylinder Ŭ������ Circle���� ���� �Ǽ����� ���̸� �ʵ�� ����
�� �޼ҵ� getVolume()�� ������ ���Ǹ� ��ȯ
�� CylinderEx Ŭ������ main() �޼ҵ忡�� �������� 2.8, ���̰� 5.6�� ������ ���Ǹ� ���
 */

public class Cylinder {
	Circle c;
	double height;

	Cylinder(Circle c, double height) {
		this.c = c;
		this.height = height;
	}

	public void getVolume() {
		System.out.println("������� ���� : " + c.getArea() * height);
	}
}
