package ddit.chap05.sec01;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample04 {

	public static void main(String[] args) {
		// 키보드로 1000원 단위의 돈을 입력받아 그 액수 만큼의 로또번호를 출력하시오
		int[] lotto = new int[45];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}

		Scanner sc = new Scanner(System.in);
		System.out.print("구입액수(1000) : ");
		int money = sc.nextInt();
		
		getLottoNumber(lotto, money);
	}
/*
	// 섞는 알고리즘
	public static void shuffle(int[] lotto) {
		for (int i = 0; i < 100000000; i++) {
			int rnd = (int) (Math.random() * lotto.length);	//0~44 난수
			int temp = lotto[0];
			lotto[0]=lotto[rnd];
			lotto[rnd]=temp;
		}
	}
*/
	public static void shuffle(int[] lotto) {
		for(int i=0; i<6; i++) {
			int rnd = (int)(Math.random()*lotto.length); //인덱스 0~44 랜덤
			int temp = lotto[i];
			lotto[i]=lotto[rnd];
			lotto[rnd]=temp;
		}
	}
	
	public static void getLottoNumber(int[] lotto, int money) {
		for(int i=0; i<money/1000; i++) {
			shuffle(lotto);
			System.out.print(((i+1)*1000)+"원 : [");
			for(int j=0; j<6; j++) {
				System.out.printf("%3d", lotto[j]);
			}
			System.out.println("]");
		}
	}
}
