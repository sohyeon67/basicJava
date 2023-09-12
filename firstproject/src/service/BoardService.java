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
		System.out.println("-- 게시판 목록 --");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("---------------------------------------");
		List<Map<String, Object>> list = dao.list();
		// List 
		// 0 Map
		// 1 Map
		// 2 Map
		// ...
		if(list==null) {
			System.out.println("게시글이 없습니다!!");
			System.out.println("---------------------------------------");
			System.out.println("2.등록 0.종료");
		} else {
			for(Map<String, Object> item : list) {
				System.out.print(item.get("BOARD_NUMBER"));
				System.out.print("\t" + item.get("TITLE"));
				System.out.print("\t" + item.get("MEM_ID"));
				System.out.print("\t" + item.get("DATETIME"));
				System.out.println();
			}
			System.out.println("---------------------------------------");
			System.out.println("1.상세 2.등록 3.수정 4.삭제 0.종료");
		}
		
		
		System.out.print("번호 선택 >> ");
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
		
		System.out.println("게시글 등록");
		//게시글 번호 생성
		String result = dao.createBoardNumber(dt);
		System.out.println("글번호 : "+result);
		param.add(result);
		
		System.out.print("제목 : ");
		String title = ScanUtil.nextLine();
		param.add(title);
		
		System.out.print("내용 : ");
		String content = ScanUtil.nextLine();
		param.add(content);
		
		if(Controller.sessionStorage.get("loginInfo")==null) {
			System.out.println("로그인하지 않았습니다.");
			System.out.println("게시글은 로그인 후 작성할 수 있습니다.");
			return View.MEMBER_LOGIN;
		}
		
		String memID = Controller.sessionStorage.get("loginInfo").toString();
		System.out.print("작성자 : "+memID+"\n");
		param.add(memID);
		
		System.out.println("작성일자 : "+dt);
		param.add(dt);
		
		int res=dao.insert(param);
		if(res>0) {
			System.out.println("게시글이 등록됐습니다.");
		} else {
			System.out.println("게시글이 등록되지 않았습니다.");
		}
		
		return View.HOME;
	}
}










