package ddit.chap06.sec07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private static JDBCUtil instance = null;
	private JDBCUtil() {} //외부에서 객체 생성 못함
	public static JDBCUtil getInstance() { //singleton, 외부와의 연결 통로
		if (instance == null) instance = new JDBCUtil();
		return instance;
	}

	//thin: ojdbc에 있는 파일 연동, 범용적, 느림. 1521(오라클 포트). xe(공짜판) orcl(정식판)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "pc03";
	private String password = "java";

	private Connection conn = null;
	private Statement stmt = null; //정적쿼리
	private PreparedStatement pstmt = null; //동적쿼리
	private ResultSet rs = null;

	public void selectList(String sql) { //정적쿼리 전달받음
		try {
			// 아래 세 메서드에 throws(예외 미루기)가 있기 때문에 예외처리
			conn=DriverManager.getConnection(url, user, password);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql); //select해서 나온 뷰를 rs에 저장
			
			while(rs.next()) {
				String mid=rs.getString("MEM_ID");
				String mname=rs.getString("MEM_NAME");
				String jumin=rs.getString("MEM_REGNO1")+"-"+rs.getNString("MEM_REGNO2");
				String hp=rs.getString("MEM_HP");
				int mileage=rs.getInt("MEM_MILEAGE");
				
				System.out.printf("%6s %5s  %14s   %15s  %6d\n", mid, mname, jumin, hp, mileage);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally { //역순으로 닫음
			if(rs!=null) try { rs.close();}catch(Exception e) {} // 할당돼서 쓰고있으면 닫아줌. close에 throws있음
			if(stmt!=null) try { stmt.close();}catch(Exception e) {}
			if(conn!=null) try { conn.close();}catch(Exception e) {}
		}
	}
}
