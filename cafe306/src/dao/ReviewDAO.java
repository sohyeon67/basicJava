package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class ReviewDAO {

	private static ReviewDAO instance = null;

	private ReviewDAO() {
	}

	public static ReviewDAO getInstance() {
		if (instance == null)
			instance = new ReviewDAO();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();

	// Controller > Service > Dao > Database
	// Controller < Service < Dao < Database

	// ���� ��ü �о����
	public List<Map<String, Object>> list() {
		String sql = " SELECT REV_NO, REV_SCORE, REV_CONTENT, TO_CHAR(REV_DATE, 'YYYY-MM-DD') AS REV_DATE, ORDER_NO FROM REVIEW ORDER BY REV_NO ASC ";

		return jdbc.selectList(sql);
	}
	
	// �ڱⲨ�� ���� �߰�
	public int insert(List<Object> param) {
		String sql = "INSERT INTO REVIEW(REV_NO, REV_SCORE, REV_CONTENT, REV_DATE, ORDER_NO) "
				+ "SELECT ?, ?, ?, ?, O.ORDER_NO " + "FROM ORDERS O " + "WHERE O.ORDER_NO = ? AND O.MEM_ID = ?";

		return jdbc.update(sql, param);
	}

	// �ı� ����Ʈ 1�� ����
	public int createReviewNumber() {
		String sql = " select nvl(max(rev_no),0) + 1 " + " from review "; // ����Ŭ�̶� ' '.. ���� �����¾ȳ��µ�..

		return jdbc.selectIntValue(sql);
	}

	// �ڱⲨ�� ����, ������Ʈ
	public int update(List<Object> param) {
		String sql = "UPDATE REVIEW R " +
                " SET R.REV_SCORE = ?, R.REV_CONTENT = ? " +
                " WHERE R.REV_NO = ? AND R.ORDER_NO = ( " +
                " SELECT O.ORDER_NO " +
                " FROM ORDERS O " +
                "  WHERE O.ORDER_NO = ? AND O.MEM_ID = ? " + ")";

		return jdbc.update(sql, param);
	}

	// �ڱⲨ�� ���� ���� 
	public int memDelete(List<Object> param) {
		String sql = " DELETE FROM REVIEW " 
					+ " WHERE REV_NO = ? AND ORDER_NO IN ( " 
					+ " SELECT ORDER_NO "
					+ " FROM ORDERS " 
					+ " WHERE MEM_ID = ?)";

		return jdbc.update(sql, param);
	}

	// �����ڴ� ���� �� ���� ����
	public int adminDelete(List<Object> param) {
		String sql = " DELETE FROM REVIEW WHERE REV_NO = ?";

		return jdbc.update(sql, param);
	}

	public String detail(int review_no) {
		String sql = "SELECT REV_CONTENT FROM REVIEW WHERE REV_NO = " + review_no;
		return jdbc.selectValue(sql);
	}

	public int check(String memID) { // �ֹ��� ���� �ֳ� üũ
		String sql = " SELECT COUNT(*) FROM ORDERS WHERE MEM_ID = '" + memID + "' ";

		return jdbc.selectIntValue(sql);
	}
	
	public int getTotalReviewCount() {
		String sql = "SELECT COUNT(*) FROM REVIEW";
		return jdbc.selectIntValue(sql);
	}
	
	public List<Map<String, Object>> listPaging(int startIdx, int itemsPerPage) {
	    String sql = "SELECT REV_NO, REV_SCORE, REV_CONTENT, TO_CHAR(REV_DATE, 'YYYY-MM-DD') AS REV_DATE, ORDER_NO "
	               + "FROM (SELECT ROWNUM AS RNUM, A.* FROM ("
	               + "SELECT R.REV_NO, R.REV_SCORE, R.REV_CONTENT, R.REV_DATE, O.ORDER_NO "
	               + "FROM REVIEW R "
	               + "JOIN ORDERS O ON R.ORDER_NO = O.ORDER_NO "
	               + "ORDER BY R.REV_NO ASC) A) "
	               + "WHERE RNUM BETWEEN ? AND ?";
	    
	    List<Object> param = new ArrayList<>();
	    param.add(startIdx);
	    param.add(startIdx + itemsPerPage - 1);

	    return jdbc.selectList(sql, param);
	}
	
	

}
