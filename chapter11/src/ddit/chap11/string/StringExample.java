package ddit.chap11.string;

public class StringExample {

	public static void main(String[] args) {
		// String class : �Һ�(immutable)�� ���ڿ� �ڷ� ���
		// 1. �κй��ڿ� ���� : substring(int startindex, int endindex) endindex-1 ����
		String str = "����ȭ ���� �Ǿ����ϴ�.";
		System.out.println(str.substring(0, str.length() - 1));
		System.out.println(str.substring(0, 6));
		// �⺻Ÿ�� => ���ڿ�
		// String.valueOf(�⺻ Ÿ�� ������);
		// �⺻ Ÿ�� ������ + ""
		int num = 1001;
		String numStr = String.valueOf(num);
		System.out.println(numStr + 99);
		System.out.println(num + "" + 99);
		// ���ڿ� => �⺻
		// Wrapper.parse�⺻Ÿ�� (���ڿ�)
		String flag1 = "true";
		boolean flag = Boolean.parseBoolean(flag1);
		System.out.println(!flag);
	}

}
