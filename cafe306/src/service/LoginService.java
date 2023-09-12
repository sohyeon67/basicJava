package service;

import java.util.Map;

import controller.Controller;
import dao.LoginDAO;
import util.ScanUtil;
import util.View;

public class LoginService {
	// 싱글톤 패턴을 만든다.
	private static LoginService instance = null;
	private LoginService() {}
	public static LoginService getInstance() {
		if(instance == null) 
			instance = new LoginService();
		return instance;
	}
	
	public static int loginCount = 0; // 로그인 횟수. 기억공간 하나
	
	// Dao를 부른다
	LoginDAO dao = LoginDAO.getInstance();
	int pageNo = 0;
	
	public int login(){
		System.out.print("아이디 입력>>> ");
		String id = ScanUtil.nextLine();
		System.out.print("비밀번호 입력>>> ");
		String pass = ScanUtil.nextLine();
		
		Map<String, Object> result = dao.login(id,pass);

		if(result != null && result.get("MEM_ID").equals(id)){ // 쿼리가 조회가 되면 아이디 패스워드 있는 것.
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("loginInfo", result.get("MEM_ID"));
			Controller.sessionStorage.put("role", "MEM");
			System.out.println(result.get("MEM_NAME") + "님! 로그인 되었습니다");
			pageNo = View.USERHOME;
		}else{
			System.out.println("다시 로그인해주세요!");
			pageNo = View.HOME;
		}
		return pageNo;
	}
}
