package dao;

import java.util.List;
import java.util.Map;

import service.MenuService;
import util.JDBCUtil;

public class OrderDAO {
	private static OrderDAO instance = null;

	private OrderDAO() {
	}

	public static OrderDAO getInstance() {
		if (instance == null)
			instance = new OrderDAO();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> list() {
		return jdbc.selectList(" SELECT * FROM NOTICE ORDER BY NOTICE_NUMBER ASC ");
	}

	public int createOrderNumber() { /////////////
		String sql = " select nvl(max(order_no),0)+1 from orders";
		return jdbc.selectIntValue(sql);
	}

	public int insert(List<Object> param) { // ORDER_NO는 createDetailOrderNumber()에서
		String sql = "INSERT INTO ORDERS(ORDER_NO, ORDER_DATE, ORDER_PRICE, MEM_ID) ";
		sql = sql + "  VALUES(?, ?, ?, ?) ";

		return jdbc.update(sql, param);
	}

	public int price(int menuNum) { // 총결제금액
		String sql = " SELECT MENU_PRICE FROM MENU WHERE MENU_NO = " + menuNum;

		return jdbc.selectIntValue(sql);
	}

	public int update(List<Object> param) { // 총결제금액, mem_id, order_no
		String sql = "UPDATE ORDERS SET ORDER_PRICE = ? WHERE ORDER_NO = ? ";

		return jdbc.update(sql, param);
	}

	public List<Map<String, Object>> orderList(String memid) {
		String sql = "SELECT A.ORDER_NO, B.ORDER_DATE, B.ORDER_PRICE, A.DORDER_COUNT, C.MENU_NAME "
				+ "FROM DORDER A, ORDERS B, MENU C "
				+ "WHERE A.ORDER_NO = B.ORDER_NO AND A.MENU_NO = C.MENU_NO AND B.MEM_ID='" + memid + "' "
				+ "ORDER BY ORDER_NO ASC ";

		return jdbc.selectList(sql);
	}
	
	public List<Map<String, Object>> receipt(int orderNum) {
		String sql = "SELECT B. MENU_NAME, A. DORDER_COUNT " + 
				"FROM DORDER A, MENU B " + 
				"WHERE A. MENU_NO = B. MENU_NO AND A. ORDER_NO='" + orderNum + "' ";
	

		return jdbc.selectList(sql);
	}

}
