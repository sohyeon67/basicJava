package ddit.chap07.sec09;

import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		new Controller().start();
	}

	public void start() {
		int view = View.HOME;
		while(true) {
			switch(view) {
			case View.HOME:
				view=home();
				break;
			case View.MEMBER_LOGIN:
			//	view=memberService.logIn();
				break;
			case View.MEMBER_SIGNUP:
			//	view=memberService.signUp();
				break;
			case View.ADMIN_LOGIN:
			//	view=memberService.adminLogIn();
				break;
			}
		}
	}
	
	public int home() {
		System.out.println("       ((ȸ������))");
		System.out.println(" (1) �α���    (2) ȸ������   (3) ������ ����");
		System.out.println("[����]");
		Scanner sc = new Scanner(System.in);
		switch(sc.nextInt()) {
		case 1:
			return View.MEMBER_LOGIN;
		case 2:
			return View.MEMBER_SIGNUP;
		case 3:
			return View.ADMIN_LOGIN;
		default :
			return View.HOME;
		}
	}
}
