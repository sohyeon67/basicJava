package ddit.chap10.sec01;
// 사용자 예외 클래스 생성
// 사용형식
// 접근지정자 class 예외클래스명 extends Exception|RuntimeException {
//     예외클래스명(String message) {
//         super(message);
//     }
// }
// ** 예외클래스 호출
// throw 예외클래스 객체명 ex) throw new Exception();
public class ExceptionExample04 {

	public static void main(String[] args) {
		try {
			exceptionSample("genious");
			exceptionSample("fool"); // 예외처리 안하면 여기서 끝
		} catch(MyException e) {
			e.printStackTrace();
		} 
		System.out.println("프로그램종료"); // 예외처리하지 않으면 이게 실행안됨. 보통 데이터베이스 커밋
	}
	
	public static void exceptionSample(String nickName) throws MyException {
		if("fool".equals(nickName)) {
			throw new MyException("사용자정의 예외");
		}
		System.out.println("별명은 "+nickName+"입니다...");
	}
}

class MyException extends RuntimeException {
	MyException(String msg) {
		super(msg); //RuntimeException
	}
}