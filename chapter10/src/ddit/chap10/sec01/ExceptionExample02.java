package ddit.chap10.sec01;

public class ExceptionExample02 {

	public static void main(String[] args) {
		exceptionMethod01();
	}

	public static void exceptionMethod01() {
		// 1/5 + 1/4 + 1/3 + 1/2 ...
		double sum = 0;
		try {
			for (int i = 5; i >= 0; i--) {
				sum = sum + (1 / i);
			}
			System.out.println("합=" + sum);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("예외발생");
			System.out.println(e.getMessage()); // printStackTrace와 유사
		} finally {
			System.out.println("예외처리 종료");
		}
	}
}
