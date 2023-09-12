package service;

import java.util.List;
import java.util.Map;

import dao.MemberDAO;
import dao.TestBoardDAO;

public class TestBoardService {
	private static TestBoardService instance = null;
	private TestBoardService() {}
	public static TestBoardService getInstance() {
		if(instance == null) instance = new TestBoardService();
		return instance;
	}
	
	TestBoardDAO dao = TestBoardDAO.getInstance();
	MemberDAO memberDao = MemberDAO.getInstance();
	
	public int list(){
		// �����ڸ� ��� ����� ����
		// ����������� ���� �ۼ��� �Խñۿ� ���ؼ��� ����, ������ ����
		
		// �Խ��� ��ü ����Ʈ�� ��������
		List<Map<String,Object>> result = null;
		result = memberDao.selectAll();
		System.out.println("ȸ����ȣ      ��ȣ                ȸ����    ��ȭ��ȣ                          ���ϸ���");
		System.out.println("==============================================");
		for(int i=0; i<result.size(); i++) {
			System.out.printf("%-8s", result.get(i).get("MEM_ID"));
			System.out.printf("%-10s", result.get(i).get("MEM_PASS"));
			System.out.printf("%-8s", result.get(i).get("MEM_NAME"));
			System.out.printf("%-15s", result.get(i).get("MEM_HP"));
			String str = String.valueOf(result.get(i).get("MEM_MILEAGE"));
			System.out.printf("%6d\n", Integer.parseInt(str));
		}
		// 1. ��� 2. ���� 3. ����
		
		return 0;
	}
}
