package dao;

import java.util.List;

import util.JDBCUtil;

public class DetailOrderDAO {
	private static DetailOrderDAO instance = null;
	private DetailOrderDAO() {}
	public static DetailOrderDAO getInstance() {
		if(instance == null) 
			instance = new DetailOrderDAO();
		return instance;
	}
	
	// JDBC�� �θ���.
	JDBCUtil jdbc = JDBCUtil.getInstance();	// �굵 �̱���
	
	public int createOrderNumber() { /////////////
		String sql = " select nvl(max(dorder_no),0)+1 from dorder"; // ����Ŭ�̶� ' '.. ���� ������ �ȳ��µ�..

		return jdbc.selectIntValue(sql);
	}
	
	public int insert(List<Object> param) { // ORDER_NO�� createDetailOrderNumber()����
		String sql = "INSERT INTO DORDER(ORDER_NO, MENU_NO, DORDER_COUNT) ";
		sql = sql + "  VALUES(?, ?, ?) ";

		return jdbc.update(sql, param);
	}
}
