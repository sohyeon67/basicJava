package ddit.chap10.sec01;

public class ExceptionExample03 {

	public static void main(String[] args) {
		ExceptionExample03 ex03 = new ExceptionExample03();
		try { // ���ܸ� �̷� �޼��忡�� ������ ��� ����Ŭ������ �����ؾ��ϸ�(catch��Ͽ���) ������ ���� �� ����
			ex03.sample();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void sample() throws Exception {
		//throws�� sample() �޼��带 ȣ���ϴ� ������ try~catchó���� �ؾ���
		Person1 p1 = null;

		System.out.println("[ȸ������]");
		System.out.println(p1.toString()); //���� �߻� ����
	}
}

class Person1 {
	int age;
	String name;

	Person1(int age, String name) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "�̸� : " + name + "\n����  : " + age;
	}
}