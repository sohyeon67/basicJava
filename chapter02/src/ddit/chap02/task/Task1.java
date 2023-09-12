package ddit.chap02.task;

public class Task1 {

	public static void main(String[] args) {
		byteSum();
		shortSum();
		intSum();
		longSum();
	}

	public static void byteSum() {
		//byte : -128~127
		byte a = 100;
		byte b = 28;
		
		//정수 타입 byte, short 변수는 int 타입으로 자동 타입 변환되어 연산 수행
		byte sum = (byte)(a+b);	//casting, 순환적용된 값
		System.out.println(sum);
	}
	
	public static void shortSum() {
		//short : -32768~32767
		short a = 32760;
		short b = 9;
		
		short sum = (short)(a+b);	//casting, 순환적용된 값
		System.out.println(sum);
	}
	
	public static void intSum() {
		byte a = 100;
		short b = 20;
		
		//int 타입보다 작은 byte, short 타입의 변수는 int 타입으로 자동 타입 변환되어 연산을 수행
		int sum = a+b;
		System.out.println(sum);
	}
	
	public static void longSum() {
		int a = 200;
		long b = 300;
		
		//두 피연산자 중 허용 범위가 큰 타입으로 변환되어 연산 수행
		long sum = a+b;
		System.out.println(sum);
		
	}
}
