package ddit.chap05.sec01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample04 {

	public static void main(String[] args) {
		// Ű����� 1000�� ������ ���� �Է¹޾� �� �׼� ��ŭ�� �ζǹ�ȣ�� ����Ͻÿ�
		int[] lotto = new int[45];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("���Ծ׼�(1000) : ");
		int money = sc.nextInt();
		
		getLottoNumber(lotto, money);
	}
/*
	// ���� �˰���
	public static void shuffle(int[] lotto) {
		for (int i = 0; i < 100000000; i++) {
			int rnd = (int) (Math.random() * lotto.length);	//0~44 ����
			int temp = lotto[0];
			lotto[0]=lotto[rnd];
			lotto[rnd]=temp;
		}
	}
*/
	public static void shuffle(int[] lotto) {
		for(int i=0; i<6; i++) {
			int rnd = (int)(Math.random()*lotto.length); //�ε��� 0~44 ����
			int temp = lotto[i];
			lotto[i]=lotto[rnd];
			lotto[rnd]=temp;
		}
	}
	
	public static void getLottoNumber(int[] lotto, int money) {
		for(int i=0; i<money/1000; i++) {
			shuffle(lotto);
			System.out.print(((i+1)*1000)+"�� : [");
			for(int j=0; j<6; j++) {
				System.out.printf("%3d", lotto[j]);
			}
			System.out.println("]");
		}
	}
}
