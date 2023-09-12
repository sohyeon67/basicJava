package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MemberDAO {
	private static MemberDAO instance = null;
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if(instance == null) instance = new MemberDAO();
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public Map<String, Object> login(String id, String pass) {
		return jdbc.selectOne("SELECT * FROM MEMBER "
				+ " WHERE MEM_ID='"+id+"' AND MEM_PASS='"+pass+"' ");
	}
	
	public int signUp(List<Object> param) {
		return jdbc.update("INSERT INTO MEMBER (MEM_ID, MEM_PW, MEM_NAME, MEM_TEL, MEM_MILE) VALUES ( ?, ?, ?, ?, ?)", param); // 이름이 not null
	}
	
	 public int checkId(String id) {
	       String sql = "SELECT COUNT(*) FROM MEMBER WHERE MEM_ID = '" + id + "'";
	   
	      return jdbc.selectIntValue(sql);
	         
	   }
	
	
	public List<Map<String, Object>> selectAll() {
		return jdbc.selectList("SELECT * FROM MEMBER");
	}
	
	public Map<String, Object> mileage_list(String id) {
		return jdbc.selectOne(" SELECT MEM_NAME, MEM_MILE FROM MEMBER WHERE MEM_ID='"+id+"' ");
	}
	

	public int getMileage(String memID) {
		String sql = " SELECT MEM_MILE FROM MEMBER WHERE MEM_ID = '"+ memID + "' ";
		return jdbc.selectIntValue(sql);
	}
	
	public int updateMileage(int mileage, String memID) {
		String sql = " UPDATE MEMBER SET MEM_MILE = '" + mileage + "' WHERE MEM_ID = '" + memID + "' "; // memID 작은 따옴표..

		return jdbc.update(sql);
	}
}