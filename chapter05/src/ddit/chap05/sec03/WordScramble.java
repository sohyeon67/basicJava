package ddit.chap05.sec03;

import java.util.Scanner;

public class WordScramble {
	private String[] word = { "apple", "banana", "orange", "persimmon", "hope" };

	// ������ �ܾ� ����(0~4������ ����)
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
		int count = 0; // �õ�Ƚ��
		Scanner sc = new Scanner(System.in);
		String anStr = "";

		while (true) {
			System.out.print("���� : ");
			anStr = sc.nextLine();
			count++;
			
			if(str.equalsIgnoreCase(anStr)) {
				System.out.println("================");
				System.out.println("�����Դϴ�");
				System.out.println("�õ�Ƚ�� : "+count);
				System.out.println("================");
				break;
			}
		}
		System.out.println("���α׷� ����");
	}
}
