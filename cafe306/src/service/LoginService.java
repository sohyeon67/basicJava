package service;

import java.util.Map;

import controller.Controller;
import dao.LoginDAO;
import util.ScanUtil;
import util.View;

public class LoginService {
	// �̱��� ������ �����.
	private static LoginService instance = null;
	private LoginService() {}
	public static LoginService getInstance() {
		if(instance == null) 
			instance = new LoginService();
		return instance;
	}
	
	public static int loginCount = 0; // �α��� Ƚ��. ������ �ϳ�
	
	// Dao�� �θ���
	LoginDAO dao = LoginDAO.getInstance();
	int pageNo = 0;
	
	public int login(){
		System.out.print("���̵� �Է�>>> ");
		String id = ScanUtil.nextLine();
		System.out.print("��й�ȣ �Է�>>> ");
		String pass = ScanUtil.nextLine();
		
		Map<String, Object> result = dao.login(id,pass);

		if(result != null && result.get("MEM_ID").equals(id)){ // ������ ��ȸ�� �Ǹ� ���̵� �н����� �ִ� ��.
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("loginInfo", result.get("MEM_ID"));
			Controller.sessionStorage.put("role", "MEM");
			System.out.println(result.get("MEM_NAME") + "��! �α��� �Ǿ����ϴ�");
			pageNo = View.USERHOME;
		}else{
			System.out.println("�ٽ� �α������ּ���!");
			pageNo = View.HOME;
		}
		return pageNo;
	}
}
