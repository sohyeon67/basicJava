package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MenuDAO {
	private static MenuDAO instance = null;

	private MenuDAO() {
	}

	public static MenuDAO getInstance() {
		if (instance == null)
			instance = new MenuDAO();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> list() {
		return jdbc.selectList(" SELECT * FROM NOTICE ORDER BY NOTICE_NUMBER ASC ");
	}

	public String createNoticeNumber(String dt) {
		String sql = "SELECT fn_create_board_number('" + dt + "') FROM DUAL"; // 오라클이라서 ' '.. 빼도 오류는 안나는데..

		return jdbc.selectValue(sql);
	}

	public int insert(List<Object> param) {
		String sql = "INSERT INTO NOTICE(NOTICE_NUMBER, TITLE, CONTENT, MEM_ID, DATETIME) ";
		sql = sql + "  VALUES(?, ?, ?, ?, ?) ";

		return jdbc.update(sql, param);
	}

	public List<Map<String, Object>> menuList(int kindno) {
		String sql = "SELECT MENU_NO, MENU_NAME, MENU_PRICE FROM MENU WHERE KIND_NO="+kindno;
		return jdbc.selectList(sql);
	}

}
