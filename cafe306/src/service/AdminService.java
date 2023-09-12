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
	// �̱��� ������ �����.
	private static AdminService instance = null;

	private AdminService() {
	}

	public static AdminService getInstance() {
		if (instance == null)
			instance = new AdminService();
		return instance;
	}

	public static int AloginCount = 0; // �α��� Ƚ��. ������ �ϳ�

	// Dao�� �θ���
	AdminDAO adminLoginDao = AdminDAO.getInstance();
	OrderDAO orderDao = OrderDAO.getInstance();

	int pageNo = 0;

	public int login() {
		System.out.print("������ ���̵� >> ");
		String id = ScanUtil.nextLine();
		System.out.print("������ ��й�ȣ >> ");
		String pass = ScanUtil.nextLine();

		Map<String, Object> result = adminLoginDao.login(id, pass);

		if (result != null && result.get("ADMIN_ID").equals(id)) { // ������ ��ȸ�� �Ǹ� ���̵� �н����� �ִ� ��.
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("loginInfo", result.get("ADMIN_ID"));
			Controller.sessionStorage.put("role", "ADMIN");
			System.out.println(result.get("ADMIN_NAME") + "��! �α��� �Ǿ����ϴ�");

			pageNo = View.ADMIN_MENU;
		} else {
			System.out.println("�ٽ� �α������ּ���!");
			pageNo = View.HOME;
		}
		return pageNo;
	}

	public int adminMenu() {
		List<Object> param = new ArrayList<>();
		int sel = 0;

		System.out.println("----------- ������ �޴� -----------");
		System.out.println("1.��������  2.�������  3.�Ѹ����  0.�ڷΰ���");
		System.out.println("-------------------------------");

		System.out.print("��ȣ ���� >> ");
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
			System.out.println("�Ѹ������ �����ڸ� �� �� �ֽ��ϴ�.");
			return View.ADMIN_LOGIN;
		}
		System.out.println("��¥                     �� �����");

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