package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.MemberDAO;
import dao.MenuDAO;
import util.ScanUtil;
import util.View;

public class MenuService {
	private static MenuService instance = null;

	private MenuService() {
	}

	public static MenuService getInstance() {
		if (instance == null)
			instance = new MenuService();
		return instance;
	}

	MenuDAO menuDao = MenuDAO.getInstance();
	MemberDAO memberDao = MemberDAO.getInstance();

	public int list() {
		int kindno = 0;
		
		if (Controller.sessionStorage.get("loginInfo") == null) {
			System.out.println("로그인하지 않았습니다. \n로그인 후 주문할 수 있습니다.");
			return View.MEMBER_LOGIN;
		}
		
		if(Controller.sessionStorage.get("role").equals("MEM")) { // 고객
			System.out.println("1.커피  2.에이드  3.생과일주스  4.스무디  5.디저트 ");
			System.out.print("주문할 메뉴의 종류를 선택하시오 (종료 : -1) : ");
			kindno = ScanUtil.nextInt();
			if(kindno == -1) {
				return -1;
			}
		} else { // 관리자
			System.out.println("1.커피  2.에이드  3.생과일주스  4.스무디  5.디저트 ");
			System.out.print("조회할 메뉴의 종류를 선택하시오 : ");
			kindno = ScanUtil.nextInt();
		}

		List<Map<String, Object>> result = null;
		result = menuDao.menuList(kindno);
		
		System.out.println("메뉴번호     가격               메뉴명    ");
		System.out.println("================================");
		for (int i = 0; i < result.size(); i++) {
			String menuno = String.valueOf(result.get(i).get("MENU_NO"));
			System.out.printf("%-8d", Integer.parseInt(menuno));
			String menuprice = String.valueOf(result.get(i).get("MENU_PRICE"));
			System.out.printf("%-10d", Integer.parseInt(menuprice));
			System.out.printf("%-15s\n", result.get(i).get("MENU_NAME"));

		}

		return 0;

	}

}
