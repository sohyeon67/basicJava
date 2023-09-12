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
			System.out.println("�α������� �ʾҽ��ϴ�. \n�α��� �� �ֹ��� �� �ֽ��ϴ�.");
			return View.MEMBER_LOGIN;
		}
		
		if(Controller.sessionStorage.get("role").equals("MEM")) { // ��
			System.out.println("1.Ŀ��  2.���̵�  3.�������ֽ�  4.������  5.����Ʈ ");
			System.out.print("�ֹ��� �޴��� ������ �����Ͻÿ� (���� : -1) : ");
			kindno = ScanUtil.nextInt();
			if(kindno == -1) {
				return -1;
			}
		} else { // ������
			System.out.println("1.Ŀ��  2.���̵�  3.�������ֽ�  4.������  5.����Ʈ ");
			System.out.print("��ȸ�� �޴��� ������ �����Ͻÿ� : ");
			kindno = ScanUtil.nextInt();
		}

		List<Map<String, Object>> result = null;
		result = menuDao.menuList(kindno);
		
		System.out.println("�޴���ȣ     ����               �޴���    ");
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
