package ddit.chap06.sec07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	private static JDBCUtil instance = null;
	private JDBCUtil() {} //�ܺο��� ��ü ���� ����
	public static JDBCUtil getInstance() { //singleton, �ܺο��� ���� ���
		if (instance == null) instance = new JDBCUtil();
		return instance;
	}

	//thin: ojdbc�� �ִ� ���� ����, ������, ����. 1521(����Ŭ ��Ʈ). xe(��¥��) orcl(������)
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "pc03";
	private String password = "java";

	private Connection conn = null;
	private Statement stmt = null; //��������
	private PreparedStatement pstmt = null; //��������
	private ResultSet rs = null;

	public void selectList(String sql) { //�������� ���޹���
		try {
			// �Ʒ� �� �޼��忡 throws(���� �̷��)�� �ֱ� ������ ����ó��
			conn=DriverManager.getConnection(url, user, password);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql); //select�ؼ� ���� �並 rs�� ����
			
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
		}finally { //�������� ����
			if(rs!=null) try { rs.close();}catch(Exception e) {} // �Ҵ�ż� ���������� �ݾ���. close�� throws����
			if(stmt!=null) try { stmt.close();}catch(Exception e) {}
			if(conn!=null) try { conn.close();}catch(Exception e) {}
		}
	}
}
