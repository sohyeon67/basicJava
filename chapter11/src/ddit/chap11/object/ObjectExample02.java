package ddit.chap11.object;

import java.util.Arrays;

public class ObjectExample02 {

	public static void main(String[] args) {
		objectClone();
	}

	public static void objectClone() {
		// �ڱ⺹��
		int[] num1 = { 10, 20, 30, 40, 50 };
		int[] num2 = num1.clone();

		System.out.println("num1=" + Arrays.toString(num1));
		System.out.println("num2=" + Arrays.toString(num2));

		Student s1 = new Student("�̼���");
		// ��ü�� clone() ����ϱ� ���ؼ��� �ش簴ü�� ��������
		// Cloneable �������̽��� �����ؾ��ϰ� clone()�� ������(override)�ؾ���
		Student s2 = (Student) s1.clone(); // Object�� Student�� downcast
		// s1�� s2�� �ٸ� ����
		
		System.out.println("s1.name = "+s1.name);
		System.out.println("s2.name = "+s2.name);
	}
}

class Student implements Cloneable { // ��ӹ޾ƾ� ��
	String name;

	Student(String name) {
		this.name = name;
	}

//	@Override
//	public String toString() {
//		return name;
//	}

	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {

		}
		return obj;
	}
}
