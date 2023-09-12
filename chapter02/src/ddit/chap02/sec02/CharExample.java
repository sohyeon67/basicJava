package ddit.chap02.sec02;

public class CharExample {

	public static void main(String[] args) {
		// char : 2byte(부호 없는 정수 : 0 ~ 65535)
		// ' '안에 표현하는 한 글자 저장, '대한민국'
		// ASCII로 변환하여 저장
		char ch1 = 'a';
		char ch2 = '대'; // 개수는 하나, 한글 3byte
		char ch3 = '한';

		System.out.println("ch1 : " + ch1);
		System.out.println("ch1 : " + (ch1 + 1));
		System.out.println("ch2 : " + (int) ch2);
		System.out.println(ch2 + ch3); // 수식에서 int보다 작은 값은 int로 바뀜

		// ABCD...Z
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.print(c);
		}

		System.out.println();

		for (int i = 65; i <= 90; i++) {
			System.out.print((char) i);
		}

		byte b1 = 100;
		short s1 = 67;
		// char ch4=s1; (byte->char (x)) char는 음수표현이 불가능
		// char ch5=b1; (short->char (x)) ''

		char ch6 = 'a';
		short s2 = (short) ch6; // short s2=ch6; (x) 양수 범위가 달라서. 형변환 해줘야함

		int res = ch6;

	}

}
