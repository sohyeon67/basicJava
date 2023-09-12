package ddit.chap10.sec01;

public class ExceptionExample01 {

	public static void main(String[] args) {
		Person p1 = null;
		System.out.println("회원명 : " + p1.name);
	}

}

class Person {
	String name = "홍길동";

}