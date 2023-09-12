package ddit.chap05.sec01;

public class ArrayExample02 {

	public static void main(String[] args) {
		//5명의 친구이름을 배열로 저장(name)하고 3번째 저장된 친구이름을 출력
		String[] name = new String[5];	//지역변수 초기화 필요. 안해주면 오류. 배열을 생성
		name[0]="홍길동";
		name[1]="이순신";
		name[2]="강감찬";
		name[3]="홍길순";
		name[4]="정몽주";
		
		String[] name1 = new String[] {"홍길동", "이순신", "강감찬", "홍길순", "정몽주"};
		
		String[] name2 = {"홍길동", "이순신", "강감찬", "홍길순", "정몽주"};
		
		System.out.println(name[2]);
	}
}
