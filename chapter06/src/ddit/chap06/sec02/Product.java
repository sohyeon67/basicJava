package ddit.chap06.sec02;

public class Product {
	static int pid; // ��ǰ��ȣ
	static String pName = "��Ŀ��"; // ��ǰ��

	Product() { // ������ : ����ʵ�(����) �ʱ�ȭ
		pid++;
		pName = "��Ŀ��";
	}

	public static void showProduct() { // ��ü ���� ������ ����
		System.out.println("��ǰ��ȣ : " + (++pid));
		System.out.println("��ǰ�� : " + pName);
	}
}
