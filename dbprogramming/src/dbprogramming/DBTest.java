package dbprogramming;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBTest {

	//url, user, password�� �� �־�� �Ѵ�.
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "pc03";
	private String password = "java";

	private Connection conn = null;
	private Statement stmt = null; // ��������, ������ �� �ٲ��� ����
	private PreparedStatement pstmt = null; // ��������
	private ResultSet rs = null;

	public void selectList(String sql) { // db ����
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB���� ����");
			
			stmt = conn.createStatement(); // pstmt�� ��ü ������ �� �Ű������� sql ��
			
			// �����ų ������ select => executeQuery
			// insert, update, delete => executeUpdateQuery
			rs = stmt.executeQuery(sql); // ���� ���(��)�� rs�� ����
			
			// stmt�� ���� �ʰ� pstmt�� �ᵵ��
			// pstmt=conn.preareStatement(sql);
			// rs=pstmt.executeQuery();
			
			while(rs.next()) { // �����Ͱ� ������ �� ��(��)�� �����´�
				// �÷� ������ �߶� ����
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
			
			pstmt = conn.prepareStatement(sql); // pstmt�� ��ü ������ �� �Ű������� sql ��
			pstmt.setString(1, pd);
			rs = pstmt.executeQuery(); // ���� ���(��)�� rs�� ����
						
			// �����ų ������ select => executeQuery
			// insert, update, delete => executeUpdateQuery
			
			while(rs.next()) { // �����Ͱ� ������ �� ��(��)�� �����´�
				// �÷� ������ �߶� ����
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
			
			pstmt = conn.prepareStatement(sql); // pstmt�� ��ü ������ �� �Ű������� sql ��
			for(int i=0; i<param.size(); i++) {
				pstmt.setObject(i+1, param.get(i)); // ù��° ����ǥ��.. �ι�° ����ǥ��.. i+1
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

