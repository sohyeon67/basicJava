package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import dao.AdminDAO;
import dao.NoticeDAO;
import dao.OrderDAO;
import controller.Controller;
import util.ScanUtil;
import util.View;

public class AdminService {
	// 싱글톤 패턴을 만든다.
	private static AdminService instance = null;

	private AdminService() {
	}

	public static AdminService getInstance() {
		if (instance == null)
			instance = new AdminService();
		return instance;
	}

	public static int AloginCount = 0; // 로그인 횟수. 기억공간 하나

	// Dao를 부른다
	AdminDAO adminLoginDao = AdminDAO.getInstance();
	OrderDAO orderDao = OrderDAO.getInstance();

	int pageNo = 0;

	public int login() {
		System.out.print("관리자 아이디 >> ");
		String id = ScanUtil.nextLine();
		System.out.print("관리자 비밀번호 >> ");
		String pass = ScanUtil.nextLine();

		Map<String, Object> result = adminLoginDao.login(id, pass);

		if (result != null && result.get("ADMIN_ID").equals(id)) { // 쿼리가 조회가 되면 아이디 패스워드 있는 것.
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("loginInfo", result.get("ADMIN_ID"));
			Controller.sessionStorage.put("role", "ADMIN");
			System.out.println(result.get("ADMIN_NAME") + "님! 로그인 되었습니다");

			pageNo = View.ADMIN_MENU;
		} else {
			System.out.println("다시 로그인해주세요!");
			pageNo = View.HOME;
		}
		return pageNo;
	}

	public int adminMenu() {
		List<Object> param = new ArrayList<>();
		int sel = 0;

		System.out.println("----------- 관리자 메뉴 -----------");
		System.out.println("1.공지관리  2.리뷰관리  3.총매출액  0.뒤로가기");
		System.out.println("-------------------------------");

		System.out.print("번호 선택 >> ");
		switch (ScanUtil.nextInt()) {
		case 1:
			return View.NOTICE_LIST;
		case 2:
			return View.REVIEW_LIST;
		case 3:
			return View.ADMIN_TOTAL;
		default:
			return View.HOME;
		}

	}

	public int totalRevenue() {

		if (!Controller.sessionStorage.get("role").equals("ADMIN")) {
			System.out.println("총매출액은 관리자만 볼 수 있습니다.");
			return View.ADMIN_LOGIN;
		}
		System.out.println("날짜                     총 매출액");

		List<Map<String, Object>> total = adminLoginDao.totalRevenue();

		for (Map<String, Object> item : total) {
			System.out.print(item.get("ORDER_DATE"));
			System.out.print("  " + item.get("TOTAL_ORDER_PRICE"));

			System.out.println();
		}

		System.out.println();
		return View.ADMIN_MENU;

	}

}