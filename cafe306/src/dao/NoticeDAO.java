package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class NoticeDAO {
	private static NoticeDAO instance = null;

	private NoticeDAO() {
	}

	public static NoticeDAO getInstance() {
		if (instance == null)
			instance = new NoticeDAO();
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Map<String, Object>> list() {
		String sql = " SELECT NOTICE_NO, NOTICE_SUB, NOTICE_CON, TO_CHAR(NOTICE_DATE, 'YYYY-MM-DD') "
				+ "AS NOTICE_DATE, " + "(SELECT ADMIN_NAME FROM ADMIN WHERE ADMIN_ID = NOTICE.ADMIN_ID) AS ADMIN_NAME "
				+ " FROM NOTICE" + " ORDER BY NOTICE_NO ASC ";
		return jdbc.selectList(sql);
	}

	public int createNoticeNumber() {
		String sql = " select nvl(max(NOTICE_NO),0) + 1 " + " from NOTICE "; // 오라클이라서 ' '.. 빼도 오류는 안나는데..

		return jdbc.selectIntValue(sql);
	}

	// 공지 등록
	public int insert(List<Object> param) {
		String sql = "INSERT INTO NOTICE(NOTICE_NO, NOTICE_SUB, NOTICE_CON, NOTICE_DATE, ADMIN_ID) ";
		sql = sql + "  VALUES(?, ?, ?, ?, ?) ";

		return jdbc.update(sql, param);
	}

	public int delete(int notice_no) {
		String sql = "DELETE FROM NOTICE WHERE NOTICE_NO = " + notice_no;
		return jdbc.delete(sql, notice_no);
	}

	public String detail(int notice_no) {
		String sql = "SELECT  NOTICE_CON FROM NOTICE WHERE NOTICE_NO = " + notice_no;
		return jdbc.selectValue(sql);
	}

	public int update(List<Object> param) {
		String sql = " UPDATE NOTICE SET NOTICE_SUB=?, NOTICE_CON=? WHERE NOTICE_NO=? AND ADMIN_ID=? ";

		return jdbc.update(sql, param);
	}

	// 공지사항 총 개수 조회
	public int getTotalNoticeCount() {
		String sql = "SELECT COUNT(*) FROM NOTICE";
		return jdbc.selectIntValue(sql);
	}

	// 페이징 처리된 공지사항 목록 조회
	public List<Map<String, Object>> listPaging(int startIdx, int itemsPerPage) {
		String sql = "SELECT NOTICE_NO, NOTICE_SUB, ADMIN_NAME, TO_CHAR(NOTICE_DATE, 'YYYY-MM-DD') AS NOTICE_DATE "
				+ "FROM (SELECT ROWNUM AS RNUM, A.* FROM ("
				+ "SELECT N.NOTICE_NO, N.NOTICE_SUB, A.ADMIN_NAME, N.NOTICE_DATE " + "FROM NOTICE N "
				+ "JOIN ADMIN A ON N.ADMIN_ID = A.ADMIN_ID " + "ORDER BY N.NOTICE_NO ASC) A) "
				+ "WHERE RNUM BETWEEN ? AND ?";
		// 행 번호 범위, 시작 번호와 끝 번호

		List<Object> param = new ArrayList<>();
		param.add(startIdx);
		param.add(startIdx + itemsPerPage - 1);

		return jdbc.selectList(sql, param);
	}
}
