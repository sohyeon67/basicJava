package ddit.chap04.sec01;

import java.util.Scanner;

public class IfStatementExample03 {

	public static void main(String[] args) {
		method1();
	}
	
	public static void method1() {
		//키보드로 아이디와 패스워드를 입력받아 로그인되는 과정이다.
		//먼저 아이디를 비교하여 아이디가 일치하면 비밀번호를 비교하고
		//아이디가 일치하지 않으면 "아이디가 일치하지 않습니다"를 출력하고
		//프로그램 실행을 종료하며, 비밀번호도 같은 방법으로 비교하여
		//모두 일치하면 "xx님 환영합니다"라는 메시지를 출력
		String id = "e1004";
		String pw = "1234";
		
		Scanner sc=new Scanner(System.in);
		System.out.print("아이디 : ");
		String uid=sc.nextLine();
		
		System.out.print("암호 : ");
		String upw=sc.nextLine();
		
		if(id.equals(uid)) {
			if(pw.equals(upw)) {
				System.out.println(uid+"님 환영합니다.");
			} else {
				System.out.println("비밀번호가 일치하지 않습니다");
			}
		} else {
			System.out.println("아이디가 일치하지 않습니다");
		}
	}

}
