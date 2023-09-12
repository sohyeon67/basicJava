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
		// 관리자면 모든 기능이 가능
		// 사용자이지만 내가 작성한 게시글에 대해서만 수정, 삭제가 가능
		
		// 게시판 전체 리스트가 보여지고
		List<Map<String,Object>> result = null;
		result = memberDao.selectAll();
		System.out.println("회원번호      암호                회원명    전화번호                          마일리지");
		System.out.println("==============================================");
		for(int i=0; i<result.size(); i++) {
			System.out.printf("%-8s", result.get(i).get("MEM_ID"));
			System.out.printf("%-10s", result.get(i).get("MEM_PASS"));
			System.out.printf("%-8s", result.get(i).get("MEM_NAME"));
			System.out.printf("%-15s", result.get(i).get("MEM_HP"));
			String str = String.valueOf(result.get(i).get("MEM_MILEAGE"));
			System.out.printf("%6d\n", Integer.parseInt(str));
		}
		// 1. 등록 2. 수정 3. 삭제
		
		return 0;
	}
}
