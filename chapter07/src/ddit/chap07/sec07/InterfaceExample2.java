package ddit.chap07.sec07;

public class InterfaceExample2 {

	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B());
		a.methodA(new C());
	}

}
