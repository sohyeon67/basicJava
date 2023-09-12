package ddit.chap11.object;

public class ObjectExample01 {

	public static void main(String[] args) {
		Person p1 = new Person("������");
		Person p2 = new Person("������");
		
		System.out.println("p1="+p1);
		System.out.println("p2="+p2);	
//		System.out.println("p1="+p1.toString());
//		System.out.println(p1.classInfo());
		if(p1==p2) {
			System.out.println("���� ��ü");
		} else {
			System.out.println("�ٸ� ��ü");
		}
		
		if(p1.toString().equals(p2.toString())) { //p1.equlas(p2)�� �ٸ� ���� ����..
			System.out.println("���� ����");
		} else {
			System.out.println("�ٸ� ����");
		}
	}

}

class Person {
	String name;
	
	Person() {}

	Person(String name) {
		this.name = name;
	}
	
	public String classInfo() {
		return getClass().getName()+'@'+hashCode(); // 10����
	}
	
	@Override
	public String toString() {
		return name;
	}
}
