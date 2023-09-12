package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDAO {
	private static BoardDAO instance = null;
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		if(instance == null) instance = new BoardDAO();
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> list() {
		return jdbc.selectList(" SELECT * FROM BOARD ORDER BY BOARD_NUMBER ASC ");
	}
	
	public String createBoardNumber(String dt) {
		String sql="SELECT fn_create_board_number('"+dt+"') FROM DUAL"; // 오라클이라서 ' '.. 빼도 오류는 안나는데..
		
		return jdbc.selectValue(sql);
	}
	
	public int insert(List<Object> param) {
		String sql="INSERT INTO BOARD(BOARD_NUMBER, TITLE, CONTENT, MEM_ID, DATETIME) ";
		sql=sql+"  VALUES(?, ?, ?, ?, ?) ";
		
		return jdbc.update(sql, param);
	}
}







