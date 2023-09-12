package ddit.chap06.sec01;

public class Grade {
	int[] score;
	private int sum;
	private double avg;

	public int getSum() {
		for (int i = 0; i < score.length; i++) {
			sum = sum+score[i];
		}
		return sum;
	}
	
	public double getAvg() {
		return (double)sum/3;
	}
}
