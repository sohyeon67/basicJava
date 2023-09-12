package ddit.chap04.sec03;

public class NestedForExample01 {

	public static void main(String[] args) {
		//nestedForMethod01();
		nestedForMethod02();
	}
	
	public static void nestedForMethod01() {
		//1부터 10까지의 수를 붙여서 5줄 인쇄하시오
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<10; j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
	}
	
	public static void nestedForMethod02() {
		//2단~9단까지 구구단을 출력
		for(int i=2; i<10; i++) {	//단
			System.out.println("[[ "+i+"단 ]]");
			for(int j=1; j<10; j++) {	//곱해지는 수(승수)
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println();
		}
	}

}
