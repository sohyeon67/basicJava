package ddit.chap02.sec01;

public class VariableExample01 {
//static 만들어진 시점이 과거
	
	static int result = 0;	

	public static void main(String[] args) {
		int score1 = 100;
		int score2 = 95;
		int score3 = 70;
		
		result = score1+score2+score3;
		System.out.println("총점 : "+result);
		method1();
	}
	
	public static void method1() {
		System.out.println("평균 : "+result/3);
	}

}
