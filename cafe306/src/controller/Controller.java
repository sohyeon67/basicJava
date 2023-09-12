package controller;

import java.util.HashMap;
import java.util.Map;

import service.NoticeService;
import service.OrderService;
import service.ReviewService;
import service.AdminService;
import service.LoginService;
import service.MemberService;
import service.MenuService;
import util.ScanUtil;
import util.View;

public class Controller {
	// 세션
	public static Map<String, Object> sessionStorage = new HashMap<>(); // 다형성

	////// 객체들
	MemberService memberService = MemberService.getInstance();
	LoginService loginService = LoginService.getInstance();
	NoticeService noticeService = NoticeService.getInstance();
	ReviewService reviewService = ReviewService.getInstance();
	MenuService menuService = MenuService.getInstance();
	OrderService orderService = OrderService.getInstance();
	AdminService adminService = AdminService.getInstance();

	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		sessionStorage.put("login", false); // false: 로그인 안됨
		sessionStorage.put("loginInfo", null); // (String/키, Object/값) 쌍
		sessionStorage.put("role", "MEM");
		int view = View.HOME;
		while (true) {
			switch (view) {
			/* -------------- 메인 화면 ------------- */
			case View.HOME:
				view = home(); // 반환값 view에 넣어줌
				break;
			case View.MEMBER_LOGIN:
				view = loginService.login();
				break;

			case View.USERHOME:
				view = memberService.userhome();
				break;

			case View.MEMBER_SIGNUP:
				view = memberService.signUp();
				break;

			// 관리자
			case View.ADMIN_MENU:
				view = adminService.adminMenu();
				break;

			case View.ADMIN_LOGIN:
				view = adminService.login();
				break;
			case View.ADMIN_TOTAL:
				view = adminService.totalRevenue();
				break;

			// 메뉴
			case View.MENU_LIST:
				view = menuService.list();
				break;
//			case View.MENU_INSERT: view = menuService.insert(); break;
//			case View.MENU_UPDATE: view = menuService.update(); break;
//			case View.MENU_DELETE: view = menuService.delete(); break;

			// 주문
			case View.ORDER_LIST:
				view = orderService.list();
				break;
			case View.ORDER_INSERT:
				view = orderService.insert();
				break;
//				case View.MENU_UPDATE: view = menuService.update(); break;
//				case View.MENU_DELETE: view = menuService.delete(); break;

			// 공지사항
			case View.NOTICE_LIST:
				view = noticeService.list();
				break;
			case View.NOTICE_DETAIL:
				view = noticeService.detail();
				break;
			case View.NOTICE_INSERT:
				view = noticeService.insert();
				break;
			case View.NOTICE_UPDATE:
				view = noticeService.update();
				break;
			case View.NOTICE_DELETE:
				view = noticeService.delete();
				break;

			// 리뷰
			case View.REVIEW_LIST:
				view = reviewService.list();
				break;
			case View.REVIEW_INSERT:
				view = reviewService.insert();
				break;
			case View.REVIEW_DETAIL:
				view = reviewService.detail();
				break;
			case View.REVIEW_UPDATE:
				view = reviewService.update();
				break;
			case View.REVIEW_DELETE:
				view = reviewService.delete();
				break;
			}
		}
	}

	private int home() {
		sessionStorage.put("login", false); // false: 로그인 안됨
		sessionStorage.put("loginInfo", null); // (String/키, Object/값) 쌍
		sessionStorage.put("role", "MEM");
		
		System.out.println(" ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄ ");
		System.out.println("▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌ ▐░░░░░░░░░▌ ▐░░░░░░░░░░░▌");
		System.out.println("▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀█░▌▐░█░█▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ");
		System.out.println("▐░▌          ▐░▌       ▐░▌▐░▌          ▐░▌                         ▐░▌▐░▌▐░▌    ▐░▌▐░▌          ");
		System.out.println("▐░▌          ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄█░▌▐░▌ ▐░▌   ▐░▌▐░█▄▄▄▄▄▄▄▄▄ ");
		System.out.println("▐░▌          ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░░░░░░░░░░░▌");
		System.out.println("▐░▌          ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀█░▌▐░▌   ▐░▌ ▐░▌▐░█▀▀▀▀▀▀▀█░▌");
		System.out.println("▐░▌          ▐░▌       ▐░▌▐░▌          ▐░▌                         ▐░▌▐░▌    ▐░▌▐░▌▐░▌       ▐░▌");
		System.out.println("▐░█▄▄▄▄▄▄▄▄▄ ▐░▌       ▐░▌▐░▌          ▐░█▄▄▄▄▄▄▄▄▄       ▄▄▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄█░█░▌▐░█▄▄▄▄▄▄▄█░▌");
		System.out.println("▐░░░░░░░░░░░▌▐░▌       ▐░▌▐░▌          ▐░░░░░░░░░░░▌     ▐░░░░░░░░░░░▌ ▐░░░░░░░░░▌ ▐░░░░░░░░░░░▌");
		System.out.println(" ▀▀▀▀▀▀▀▀▀▀▀  ▀         ▀  ▀            ▀▀▀▀▀▀▀▀▀▀▀       ▀▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀ ");            

		System.out.println("================ 카페306 ================");
		System.out.println("1.로그인 2.회원가입 3.관리자 로그인  4.공지사항 5.리뷰");
		System.out.println("========================================");
		System.out.print("번호 입력 >> ");
		switch (ScanUtil.nextInt()) {
		case 1:
			return View.MEMBER_LOGIN;
		case 2:
			return View.MEMBER_SIGNUP;
		case 3:
			return View.ADMIN_LOGIN;
		case 4:
			return View.NOTICE_LIST;
		case 5:
			return View.REVIEW_LIST;
		default:
			return View.HOME;
		}
	}

}