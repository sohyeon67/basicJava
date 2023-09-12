package ddit.chap05.sec07;

import java.util.Random;

public class ArrayConversionEx {

	public static void main(String[] args) {
		ArrayConversion ac = new ArrayConversion();
		ac.histogram();
		System.out.println();
		ac.conversion();
		ac.printHisto();
	}
}

class ArrayConversion {
	private int[] dice = new int[6];
	private Random random = new Random(); // 정수형 난수 발생 class 생성
	// 랜덤클래스 생성
	private char[][] histo; // 멤버변수로 선언

	public ArrayConversion() { // 생성자 메서드 : 매개변수 초기화
		for (int i = 0; i < 50; i++) { // 실험 횟수 50회
			// random class의 nextInt() : 정수형 난수 하나 발생
			// nextInt(n) : 0~n-1 사이의 정수형 난수 1개 발생
			int rnd = random.nextInt(6) + 1;
			dice[rnd - 1]++;
			// 1~6사이의 난수 발생되어지기 때문에 배얼은 0부터 시작하므로 -1 해주어야함
		}
	}

	// 가로 그래프 출력
	public void histogram() {
		for (int i = 0; i < dice.length; i++) {
			System.out.print((i + 1) + "|");
			for (int j = 0; j < dice[i]; j++) {
				System.out.print("*");
			}
			System.out.println(dice[i]);
		}
	}

	// 세로 그래프
	public int getMaxNum() {
		int rowCount = dice[0]; // 임시 최대값(행의 개수)
		for (int i = 1; i < dice.length; i++) {
			// dice[0]은 자기 자신값이기때문에 i=0은 필요 없음
			if (rowCount < dice[i]) {
				rowCount = dice[i];
			}
		}
		return rowCount;
	}

	// 세로 그래프
	public void conversion() {
		int r = getMaxNum(); // 행의 수

		histo = new char[r][6]; // #

		for (int i = 0; i < dice.length; i++) { // i=열(6개)
			for (int j = 0; j < dice[i]; j++) { // j=행(최대값)
				histo[j][i] = '#';
			}
		}
	}

	public void printHisto() {
		for (int i = histo.length - 1; i >= 0; i--) { // 행
			System.out.print("|");
			for (int j = 0; j < histo[i].length; j++) { // 6열 고정
				System.out.printf("%5c", histo[i][j]);
			}
			System.out.println();
		}
		System.out.println("|---------------------------------");
		System.out.println(" ");
		for (int k = 1; k <= 6; k++) {
			System.out.printf("%5d", k);
		}
	}
}