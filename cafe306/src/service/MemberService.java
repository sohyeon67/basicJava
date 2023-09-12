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

	MemberDAO memberDao = MemberDAO.getInstance(); // new������ ����. �̱���
	MenuDAO menuDao = MenuDAO.getInstance();

	public int signUp() {
		System.out.println("-- ȸ������ --");
		System.out.print("���̵� >> ");
		String id = ScanUtil.nextLine();

		// ���̵� �ߺ� üũ
		int check = memberDao.checkId(id);
		if (check > 0) {
			System.out.println("�̹� ��ϵ� ID �Դϴ�.");
			return View.HOME;
		} else {
			System.out.println("��밡���� ID �Դϴ�.");
		}

		System.out.print("��й�ȣ >> ");
		String pass = ScanUtil.nextLine();

		System.out.print("�̸� >> ");
		String name = ScanUtil.nextLine();

		System.out.print("����ó>> ");
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
			System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println("ȸ������ ����!");
		}
		return View.HOME;
	}

	public int userhome() {
		System.out.println("============== user home ==============");
		System.out.println("1.�ֹ��ϱ� 2.���ϸ��� ��ȸ 3.������� 4.�ֹ����� 0.Ȩ");
		System.out.println("=======================================");
		System.out.print("��ȣ �Է� >> ");

		switch (ScanUtil.nextInt()) {
		case 1:
			return View.ORDER_INSERT; // �ֹ��ϰ� ����Ȩ
		case 2:
			mileage_list(); // ���ϸ��� ��ȸ�ϰ� ����Ȩ
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

		System.out.print(list.get("MEM_NAME") + "���� ���ϸ��� : ");
		System.out.println(list.get("MEM_MILE"));
		System.out.println();
	}

}