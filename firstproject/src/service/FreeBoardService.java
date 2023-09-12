package service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.FreeBoardDAO;
import util.View;

public class FreeBoardService {
	// 1. �̱��� �����
	private static FreeBoardService instance = null;
	private FreeBoardService() {}
	public static FreeBoardService getInstance() {
		if(instance == null) 
			instance = new FreeBoardService();
		return instance;
	}
	
	// 2. DAO ȣ���ϱ� ���� �� �����
	FreeBoardDAO dao = FreeBoardDAO.getInstance();
	
	// �����Խ��� ��ü ����Ʈ ��ȸ
	// int�� ������ ��������ȣ
	public int list(){
		int result = 0;
		// ��ü ����Ʈ ��ȸ�ϱ� ���� ����
		// ��ü����Ʈ ��ȸ�� �ϱ����� ������ ����
		// select * from freeboard
		// 1. �Ķ���Ͱ� �ʿ��մϱ�? �ʿ����
		// 2. ������ ��Ե���?
		//   - select * from freeboard
		// 3. ����� ��� ����?
		// Dao���� �Ѱ��� ����� �Ʒ� Ÿ������ �޴´�.
		//   - List<Map<String, Object>> 
		List<Map<String, Object>> freeBoardList = dao.list();
		
		// ���� �����͸� ���
		for (int i = 0; i < freeBoardList.size(); i++) {
			Map<String, Object> map = freeBoardList.get(i);
			System.out.print(map.get("BO_NO") + " " + map.get("BO_TITLE") + " " + map.get("BO_CONTENT"));
			System.out.println();
		}
		
		System.out.println();
		System.out.println("������ ���� �޴��� �����Ұſ���? >>> ");
		System.out.println("1. Ȩ���ΰ��� 2. ��ȸ�ϱ�");
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		switch (input) {
		case 1:
			System.out.println("Ȩ���ΰ��� Ŭ��!");
			result = View.HOME;
			break;
		case 2:
			System.out.println("��ȸ�ϱ� Ŭ��!");
			break;
		default:
			break;
		}
		return result; 
	}
}
