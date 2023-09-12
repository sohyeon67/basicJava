package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.MemberDAO;
import util.ScanUtil;
import util.View;

public class MemberService {
	private static MemberService instance = null;
	private MemberService() {}
	public static MemberService getInstance() {
		if(instance == null) instance = new MemberService();
		return instance;
	}
	
	MemberDAO dao = MemberDAO.getInstance(); //new������ ����. �̱���
	
	public int login() {
		if((boolean) Controller.sessionStorage.get("login")) {
			System.out.println("�̹� �α��εǾ��ֽ��ϴ�.");
			return View.HOME;
		}
		System.out.println("-- �α��� --");
		System.out.print("���̵� >> ");
		String id = ScanUtil.nextLine();
		System.out.print("��й�ȣ >> ");
		String pass = ScanUtil.nextLine();
		Map<String, Object> row = dao.login(id, pass);
		if(row == null) {
			System.out.println("���̵� �����ϴ�.");
			return View.HOME;
		}else {
			Controller.sessionStorage.put("login", true);
			System.out.println(row.get("MEM_NAME") + "�� ȯ���մϴ�!");
			return View.BOARD_LIST;
		}
	}
	public int signUp() {
		System.out.println("-- ȸ������ --");
		System.out.print("���̵� >> ");
		String id = ScanUtil.nextLine();

		System.out.print("��й�ȣ >> ");
		String pass = ScanUtil.nextLine();
		
		System.out.print("�̸� >> ");
		String name = ScanUtil.nextLine();
		
		
		List<Object> param = new ArrayList<>();
		param.add(id);
		param.add(pass);
		param.add(name);
		
		int result = dao.signUp(param);
		if(result>0) {
			System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println("ȸ������ ����!");
		}
		return View.HOME;
	}
}







