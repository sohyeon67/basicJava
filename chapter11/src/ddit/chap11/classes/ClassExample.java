package ddit.chap11.classes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class ClassExample {

	public static void main(String[] args) throws Exception {
		// �ڹٿ��� ���Ǵ� ��� class�� interface���� �Ϲ��� ����
		// Class c1 = Book.class;
		Class c2 = Byte.class;
		Class c3 = Class.forName("ddit.chap07.sec03.Book"); // ���� �ε����?

//		// getName() : Ŭ������(��Ű�� ����) Ȯ��
//		System.out.println(c1.getName());
//
//		// getSimpleName() : Ŭ������(��Ű�� ������) Ȯ��
//		System.out.println(c1.getSimpleName());
//
//		// getPackage() : ��Ű�� ���
//		System.out.println(c1.getPackage());

		// getConstructors() : �����ڸ޼��� ������ȯ -> Constructor Ŭ���� Ÿ���� �迭�� ��ȯ
		Constructor[] constructors = c3.getConstructors();
		Method[] methods = c3.getDeclaredMethods();
		Field[] fields = c3.getFields(); // public �ʵ常 ��ȯ
		Field[] fieldInher = c3.getDeclaredFields(); // ��ӹ��� �ʵ常 ��ȯ

		for (Constructor c : constructors) {
			System.out.println("������ : " + c);
		}

		for (Method m : methods) {
			System.out.println("�޼��� : " + m);
		}

		for (Field f : fields) {
			System.out.println("�ʵ�� : " + f.getName());
			System.out.println("�ʵ�Ÿ�� : " + f.getType());
		}
	}

}

//package ddit.chap11.classes;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.Member;
//
//import ddit.chap11.object.ObjectExample02;
//
//public class ClassExample {
//
//	public static void main(String[] args) throws Exception {
//		// �ڹٿ��� ���Ǵ� ��� class�� interface���� �Ϲ��� ����
//		Class c1 = ObjectExample02.class;
//		Class c2 = Byte.class;
//
//		// getName() : Ŭ������(��Ű�� ����) Ȯ��
//		System.out.println(c1.getName());
//
//		// getSimpleName() : Ŭ������(��Ű�� ������) Ȯ��
//		System.out.println(c1.getSimpleName());
//
//		// getPackage() : ��Ű�� ���
//		System.out.println(c1.getPackage());
//
//		// getConstructors() : �����ڸ޼��� ������ȯ -> Constructor Ŭ���� Ÿ���� �迭�� ��ȯ
//		Constructor[] constructors = c2.getConstructors();
//		Byte b1 = null;
//		for(Constructor c : constructors) {
//			b1=(Byte)c.newInstance("1");
//			System.out.println(b1.toString());
//		}
//	}
//
//}
