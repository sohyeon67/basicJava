package ddit.chap10.sec01;

public class ExceptionExample05 {

	public static void main(String[] args) throws Exception { // 이렇게 쓸 수도 있다.. 잘 안씀!!
		ExceptionExample05 ex05 = new ExceptionExample05();
//		main 선언부에 throws Exception 안해줄 시
//		try {
//			ex05.method01();
//		} catch (Exception e) {}
		ex05.method01();
	}

	public void method01() throws Exception {
		method02();
	}

	public void method02() throws Exception {
		method03();
	}

	public void method03() throws Exception {
		Class c1 = Class.forName("ddit.chap06.sec02.Circle");
	}
}
