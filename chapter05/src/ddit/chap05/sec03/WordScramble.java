package ddit.chap05.sec03;

import java.util.Scanner;

public class WordScramble {
	private String[] word = { "apple", "banana", "orange", "persimmon", "hope" };

	// 임의의 단어 선택(0~4사이의 난수)
	public String getWord() {
		int rnd = (int) (Math.random() * word.length);
		return word[rnd];
	}

	public String shuffle(String str) {
		char[] ch = str.toCharArray();
		for (int i = 0; i < 1000; i++) {
			int rnd = (int) (Math.random() * ch.length);
			char temp = ch[0];
			ch[0] = ch[rnd];
			ch[rnd] = temp;
		}
		return new String(ch);
	}

	public void answer(String str) {
		int count = 0; // 시도횟수
		Scanner sc = new Scanner(System.in);
		String anStr = "";

		while (true) {
			System.out.print("정답 : ");
			anStr = sc.nextLine();
			count++;
			
			if(str.equalsIgnoreCase(anStr)) {
				System.out.println("================");
				System.out.println("정답입니다");
				System.out.println("시도횟수 : "+count);
				System.out.println("================");
				break;
			}
		}
		System.out.println("프로그램 종료");
	}
}
