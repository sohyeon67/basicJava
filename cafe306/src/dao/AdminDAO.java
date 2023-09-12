package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

// 관리자 로그인
public class AdminDAO {

	private static AdminDAO instance = null;

	private AdminDAO() {
	}

	public static AdminDAO getInstance() {
		if (instance == null)
			instance = new AdminDAO();
		return instance;
	}
//	NoticeDAO dao = NoticeDAO.getInstance();

	JDBCUtil jdbc = JDBCUtil.getInstance();

	public Map<String, Object> login(String id, String pass) {

		String sql = " SELECT * FROM ADMIN WHERE ADMIN_ID = ? AND ADMIN_PW = ?";
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pass);

		return jdbc.selectOne(sql, param); // 관리자 로그인 다오
	}

	public List<Map <String , Object>> totalRevenue() { // 매출
		String sql = "SELECT SUBSTR(order_date, 1, 10) AS order_date, SUM(ORDER_PRICE) AS total_order_price "
				+ "FROM ORDERS " 
				+ "GROUP BY SUBSTR(order_date, 1, 10)";

		return jdbc.selectList(sql);

	}
}
