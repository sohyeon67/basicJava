package ddit.chap07.sec03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	//singleton
	private static JDBCUtil instance = null;
	private JDBCUtil() {} //외부에서 객체 생성 못함
	public static JDBCUtil getInstance() { //singleton, 외부와의 연결 통로
		if (instance == null) instance = new JDBCUtil();
		return instance;
	}

	//thin: ojdbc에 있는 파일 연동, 범용적, 느림. 서버 주소 localhost, 1521(오라클 포트). xe(공짜판) orcl(정식판)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; //드라이버파일 위치
	private String user = "pc03";
	private String password = "java";

	private Connection conn = null;
	private Statement stmt = null; //정적쿼리
	private PreparedStatement pstmt = null; //동적쿼리
	private ResultSet rs = null;

	public List<Map<String, Object>> selectList(String sql, List<Object>param) { //쿼리를 문자열로 받음. 
		List<Map<String,Object>> list = null;
		try {
			conn=DriverManager.getConnection(url, user, password);
			pstmt=conn.prepareStatement(sql);
			for(int i=0; i<param.size(); i++) {
				pstmt.setObject(i+1, param.get(i));
			}
			rs=pstmt.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int columnCount=rsmd.getColumnCount();
						
			while(rs.next()) {
				Map<String,Object>row=new HashMap<>(); // 부모(Map) 인터페이스.. 
				
				for(int i=0; i<columnCount; i++) {
					String key=rsmd.getColumnLabel(i+1);
					Object value=rs.getObject(i);
					row.put(key, value);
				}
				list.add(row);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally { //역순으로 닫음
			if(rs!=null) try { rs.close();}catch(Exception e) {}
			if(stmt!=null) try { stmt.close();}catch(Exception e) {}
			if(conn!=null) try { conn.close();}catch(Exception e) {}
		}
		return list;
	}
}
