package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.BoardDAO;
import util.ScanUtil;
import util.View;

public class BoardService {
	private static BoardService instance = null;
	private BoardService() {}
	public static BoardService getInstance() {
		if(instance == null) instance = new BoardService();
		return instance;
	}
	
	BoardDAO dao = BoardDAO.getInstance();
	
	public int list() {
		System.out.println("-- �Խ��� ��� --");
		System.out.println("��ȣ\t����\t�ۼ���\t�ۼ���");
		System.out.println("---------------------------------------");
		List<Map<String, Object>> list = dao.list();
		// List 
		// 0 Map
		// 1 Map
		// 2 Map
		// ...
		if(list==null) {
			System.out.println("�Խñ��� �����ϴ�!!");
			System.out.println("---------------------------------------");
			System.out.println("2.��� 0.����");
		} else {
			for(Map<String, Object> item : list) {
				System.out.print(item.get("BOARD_NUMBER"));
				System.out.print("\t" + item.get("TITLE"));
				System.out.print("\t" + item.get("MEM_ID"));
				System.out.print("\t" + item.get("DATETIME"));
				System.out.println();
			}
			System.out.println("---------------------------------------");
			System.out.println("1.�� 2.��� 3.���� 4.���� 0.����");
		}
		
		
		System.out.print("��ȣ ���� >> ");
		switch(ScanUtil.nextInt()) {
		case 1: return View.BOARD_DETAIL;
		case 2: return View.BOARD_INSERT;
		case 3: return View.BOARD_UPDATE;
		case 4: return View.BOARD_DELETE;
		default: return View.HOME;
		}
	}
	
	public int insert() {
		List<Object> param = new ArrayList<>();
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String dt=format.format(now);
		
		System.out.println("�Խñ� ���");
		//�Խñ� ��ȣ ����
		String result = dao.createBoardNumber(dt);
		System.out.println("�۹�ȣ : "+result);
		param.add(result);
		
		System.out.print("���� : ");
		String title = ScanUtil.nextLine();
		param.add(title);
		
		System.out.print("���� : ");
		String content = ScanUtil.nextLine();
		param.add(content);
		
		if(Controller.sessionStorage.get("loginInfo")==null) {
			System.out.println("�α������� �ʾҽ��ϴ�.");
			System.out.println("�Խñ��� �α��� �� �ۼ��� �� �ֽ��ϴ�.");
			return View.MEMBER_LOGIN;
		}
		
		String memID = Controller.sessionStorage.get("loginInfo").toString();
		System.out.print("�ۼ��� : "+memID+"\n");
		param.add(memID);
		
		System.out.println("�ۼ����� : "+dt);
		param.add(dt);
		
		int res=dao.insert(param);
		if(res>0) {
			System.out.println("�Խñ��� ��ϵƽ��ϴ�.");
		} else {
			System.out.println("�Խñ��� ��ϵ��� �ʾҽ��ϴ�.");
		}
		
		return View.HOME;
	}
}










