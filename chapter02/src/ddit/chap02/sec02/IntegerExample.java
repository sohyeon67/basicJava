package ddit.chap02.sec02;

public class IntegerExample {

	public static void main(String[] args) {
		byteInteger();
		shortInteger();
		intInteger();
		longInteger();
	}

	public static void byteInteger() {
		// byte : 1byte 공간
		// 127 ~ -128 저장 가능
		// 127보다 크거나 -128보다 작은 literal은 오류발생
		// 수식에 의한 범위를 초과하는 경우 순환적용된 값이 출력(128은 -128로, 129이면 -127로)

		// byte b1 = 128; 오류
		byte res = 127;
		// res+1에서 1은 int(기본값)이라서 오류. 더할때 큰값에 맞춤. 저장공간이 byte라서 오류
		System.out.println(++res);
		System.out.println(++res);
	}

	public static void shortInteger() {
		// short : 2byte 공간
		// 32767 ~ -32768 저장 가능
		// 32767보다 크거나 -32768보다 작은 literal은 오류발생
		// 수식에 의한 범위를 초과하는 경우 순환적용된 값이 출력(32768은 -32768로, 32769이면 -32767로)

		short sh1 = 200;
		short sh2 = 10;
		// short res=sh1+10; //10이 int, short(=>int)+int = int...short+(short)int=short(o)
		// short res=sh1+sh2; //수식에서 int보다 작으면 int로 바뀜
		short res = (short) (sh1 + sh2); // 강제형변환 cast
		System.out.println(res);
	}

	public static void intInteger() {
		// int : 4byte 공간
		// 기본 정수타입
		// 2147483647 ~ - 2147483648
		// 범위를 벗어나는 literal은 오류발생
		// 수식에 의한 범위를 초과하는 경우 순환적용된 값
		int num = 200;
		int res = 1000000*1000000;
		//res=10000000000; 에러
		System.out.println("res : "+res);
	}
	
	public static void longInteger() {
		//long : 8byte
		//		 2^63-1 ~ -2^63
		//		 리터럴 끝에 L(l)추가하여 long타입의 정수임을 표현
		long num = 100L;
		long res1 = 1000000*1000000;
		long res2 = 1000000L*1000000L;	//하나만 L 붙여도 됨
		
		System.out.println("res1 : "+res1);
		System.out.println("res2 : "+res2);
	}
}
