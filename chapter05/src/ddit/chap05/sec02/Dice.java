package ddit.chap05.sec02;

import java.util.Arrays;

public class Dice {
	private int[] dice = new int[6];
	
	public void setDice() {
		for(int i=0; i<50; i++) {
			int rnd = (int)(Math.random()*6)+1;
			dice[rnd-1]++;
		}
	}
	
	public void getDiagram() {
		setDice();
		for(int i=0; i<dice.length; i++) {
			System.out.print((i+1)+"|");
			for(int j=0; j<dice[i]; j++) {	//발생횟수 만큼
				System.out.print("*");
			}
			System.out.println(dice[i]);
		}
		System.out.println("-----------------------");
	}
}
