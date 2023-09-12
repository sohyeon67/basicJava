package ddit.chap10.sec01;

public class ExceptionExample03 {

	public static void main(String[] args) {
		ExceptionExample03 ex03 = new ExceptionExample03();
		try { // 예외를 미룬 메서드에서 정의한 모든 예외클래스를 정의해야하며(catch블록에서) 범위를 좁힐 수 없다
			ex03.sample();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void sample() throws Exception {
		//throws는 sample() 메서드를 호출하는 곳에서 try~catch처리를 해야함
		Person1 p1 = null;

		System.out.println("[회원정보]");
		System.out.println(p1.toString()); //예외 발생 위험
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
		return "이름 : " + name + "\n나이  : " + age;
	}
}