package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.MemberDAO;
import dao.MenuDAO;
import util.ScanUtil;
import util.View;

public class MemberService {
	private static MemberService instance = null;

	private MemberService() {
	}

	public static MemberService getInstance() {
		if (instance == null)
			instance = new MemberService();
		return instance;
	}

	MenuService menuService = MenuService.getInstance();
	OrderService orderService = OrderService.getInstance();

	MemberDAO memberDao = MemberDAO.getInstance(); // new연산자 없음. 싱글톤
	MenuDAO menuDao = MenuDAO.getInstance();

	public int signUp() {
		System.out.println("-- 회원가입 --");
		System.out.print("아이디 >> ");
		String id = ScanUtil.nextLine();

		// 아이디 중복 체크
		int check = memberDao.checkId(id);
		if (check > 0) {
			System.out.println("이미 등록된 ID 입니다.");
			return View.HOME;
		} else {
			System.out.println("사용가능한 ID 입니다.");
		}

		System.out.print("비밀번호 >> ");
		String pass = ScanUtil.nextLine();

		System.out.print("이름 >> ");
		String name = ScanUtil.nextLine();

		System.out.print("연락처>> ");
		String tel = ScanUtil.nextLine();

		int mileage = 0;

		List<Object> param = new ArrayList<>();
		param.add(id);
		param.add(pass);
		param.add(name);
		param.add(tel);
		param.add(mileage);
		int result = memberDao.signUp(param);
		if (result > 0) {
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			System.out.println("회원가입 실패!");
		}
		return View.HOME;
	}

	public int userhome() {
		System.out.println("============== user home ==============");
		System.out.println("1.주문하기 2.마일리지 조회 3.리뷰관리 4.주문내역 0.홈");
		System.out.println("=======================================");
		System.out.print("번호 입력 >> ");

		switch (ScanUtil.nextInt()) {
		case 1:
			return View.ORDER_INSERT; // 주문하고 유저홈
		case 2:
			mileage_list(); // 마일리지 조회하고 유저홈
			return View.USERHOME;
		case 3:
			return View.REVIEW_LIST;
		case 4:
			return View.ORDER_LIST;
		default:
			return View.HOME;
		}

	}

	public void mileage_list() {
		String memID = Controller.sessionStorage.get("loginInfo").toString();

		Map<String, Object> list = memberDao.mileage_list(memID);

		System.out.print(list.get("MEM_NAME") + "님의 마일리지 : ");
		System.out.println(list.get("MEM_MILE"));
		System.out.println();
	}

}