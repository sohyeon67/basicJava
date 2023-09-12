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
	
	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();	// 얘도 싱글톤
	
	public int createOrderNumber() { /////////////
		String sql = " select nvl(max(dorder_no),0)+1 from dorder"; // 오라클이라서 ' '.. 빼도 오류는 안나는데..

		return jdbc.selectIntValue(sql);
	}
	
	public int insert(List<Object> param) { // ORDER_NO는 createDetailOrderNumber()에서
		String sql = "INSERT INTO DORDER(ORDER_NO, MENU_NO, DORDER_COUNT) ";
		sql = sql + "  VALUES(?, ?, ?) ";

		return jdbc.update(sql, param);
	}
}
