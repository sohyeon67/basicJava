package ddit.chap07.sec03;

import java.util.ArrayList;
import java.util.List;

public class EBtestExample {
	public static void main(String[] args) {
		JDBCUtil jdbc=JDBCUtil.getInstance();
		
		String sql="select mem_id, mem_name, mem_regno1, mem_regno2, mem_hp, ";
		sql=sql+" mem_mileage from member where mem_regno1 like '0%' "; //정적쿼리.
		
		//사용자로부터 입력받는 쿼리는 동적쿼리
		
		//jdbc.selectList(sql); //쿼리 전달
		test();
	}
	
	public static void test() {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(5);
		//list.add("홍길동");
		list.add(100);
		System.out.println(list);
		
		int sum=0;
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
			sum=sum+list.get(i);
		}
		System.out.println(sum);
	}
}
