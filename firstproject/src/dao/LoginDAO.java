package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

// �����ͺ��̽��� ������ ������ ����� ��´�.
public class LoginDAO {
	// �̱��� ������ �����.
	private static LoginDAO instance = null;
	private LoginDAO() {}
	public static LoginDAO getInstance() {
		if(instance == null) 
			instance = new LoginDAO();
		return instance;
	}
	
	// JDBC�� �θ���.
	JDBCUtil jdbc = JDBCUtil.getInstance();	// �굵 �̱���
	
	public Map<String, Object> login(String id, String pass){ // Map Ÿ�� ��ȯ
		// �α���
		// ���� �Է��� ���̵�, ��й�ȣ�� �ش��ϴ� ȸ�������� �ּ���
		// SELECT * FROM MEMBER WHERE MEM_ID = ? AND MEM_PW = ?
		// SELECT * FROM MEMBER WHERE MEM_ID = 'admin' AND MEM_PW = '1234'
		String sql = "SELECT * FROM TMEMBER WHERE MEM_ID = ? AND MEM_PASS = ?"; // ��������
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pass);
		
		return jdbc.selectOne(sql, param); //���񽺷� �Ѱ���
	}
}
