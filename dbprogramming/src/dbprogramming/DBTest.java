package dbprogramming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBTest {

	//url, user, password는 꼭 있어야 한다.
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "pc03";
	private String password = "java";

	private Connection conn = null;
	private Statement stmt = null; // 정적쿼리, 실행할 때 바뀌지 않음
	private PreparedStatement pstmt = null; // 동적쿼리
	private ResultSet rs = null;

	public void selectList(String sql) { // db 연결
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연결 성공");
			
			stmt = conn.createStatement(); // pstmt는 객체 생성할 때 매개변수로 sql 들어감
			
			// 실행시킬 쿼리가 select => executeQuery
			// insert, update, delete => executeUpdateQuery
			rs = stmt.executeQuery(sql); // 실행 결과(뷰)를 rs에 보관
			
			// stmt를 쓰지 않고 pstmt를 써도됨
			// pstmt=conn.preareStatement(sql);
			// rs=pstmt.executeQuery();
			
			while(rs.next()) { // 데이터가 있으면 한 줄(행)씩 꺼내온다
				// 컬럼 단위로 잘라서 보관
				String pid=rs.getString("PROD_ID");
				String pname=rs.getString("PROD_NAME");
				StringBuilder ss = new StringBuilder(pname);
				for(int i=pname.length(); i<20; i++) {
					ss.append("\0");
				}
				String name = ss.toString();
				int price=rs.getInt("PROD_PRICE");
				int pstock=rs.getInt("PROD_PROPERSTOCK");
				
				System.out.printf("%-12s %-20s %10d %5d\n", pid, name, price, pstock);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(Exception e) {}
			if(stmt!=null) try { stmt.close(); } catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); } catch(Exception e) {}
			if(conn!=null) try { conn.close(); } catch(Exception e) {}
		}
	}
	
	
	public void selectOne(String sql, String pd) {
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			pstmt = conn.prepareStatement(sql); // pstmt는 객체 생성할 때 매개변수로 sql 들어감
			pstmt.setString(1, pd);
			rs = pstmt.executeQuery(); // 실행 결과(뷰)를 rs에 보관
						
			// 실행시킬 쿼리가 select => executeQuery
			// insert, update, delete => executeUpdateQuery
			
			while(rs.next()) { // 데이터가 있으면 한 줄(행)씩 꺼내온다
				// 컬럼 단위로 잘라서 보관
				String pid=rs.getString("PROD_ID");
				String pname=rs.getString("PROD_NAME");
				StringBuilder ss = new StringBuilder(pname);
				for(int i=pname.length(); i<20; i++) {
					ss.append("\0");
				}
				String name = ss.toString();
				int price=rs.getInt("PROD_PRICE");
				int pstock=rs.getInt("PROD_PROPERSTOCK");
				
				System.out.printf("%-12s %-20s %10d %5d\n", pid, name, price, pstock);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(Exception e) {}
			if(stmt!=null) try { stmt.close(); } catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); } catch(Exception e) {}
			if(conn!=null) try { conn.close(); } catch(Exception e) {}
		}
	}
	
	public int update(String sql, List<Object> param) {
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, user, password);
			
			pstmt = conn.prepareStatement(sql); // pstmt는 객체 생성할 때 매개변수로 sql 들어감
			for(int i=0; i<param.size(); i++) {
				pstmt.setObject(i+1, param.get(i)); // 첫번째 물음표에.. 두번째 물음표에.. i+1
			}
			result = pstmt.executeUpdate();
			conn.commit();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close(); } catch(Exception e) {}
			if(stmt!=null) try { stmt.close(); } catch(Exception e) {}
			if(pstmt!=null) try { pstmt.close(); } catch(Exception e) {}
			if(conn!=null) try { conn.close(); } catch(Exception e) {}
		}
		return result;
	}
}

