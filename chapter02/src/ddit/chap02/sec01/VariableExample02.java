package ddit.chap02.sec01;
//1-100 사이의 합

public class VariableExample02 {

	public static void main(String[] args) {		
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
		}
		System.out.println("1부터 100까지의 합 : "+sum);
		
		myMethod();
	}

	//첫 날에 100원 둘째날부터 전날의 두배씩 저축한다면 최초로 100만원을 넘는 날은
	//며칠이 경과된 날이며 그때까지의 금액은?
	
	public static void myMethod() {
		int sum = 0;	//저축 총액
		int days = 1;	//경과일수
		int money = 100;//저축할 액수
		
		while(true) {
			sum = sum+money;
			if(sum>=1000000)
				break;
			money=money*2;
			days++;
		}
		System.out.println("경과일수 : "+days);
		System.out.println("저축금액 : "+sum);
	}
}