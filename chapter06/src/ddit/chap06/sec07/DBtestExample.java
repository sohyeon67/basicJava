package ddit.chap06.sec07;

public class DBtestExample {

	public static void main(String[] args) {
		JDBCUtil jdbc=JDBCUtil.getInstance();
		
		String sql="select mem_id, mem_name, mem_regno1, mem_regno2, mem_hp, ";
		sql=sql+" mem_mileage from member where mem_regno1 like '0%' "; //정적쿼리.
		
		//사용자로부터 입력받는 쿼리는 동적쿼리
		
		jdbc.selectList(sql); //쿼리 전달
	}

}
