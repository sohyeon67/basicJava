package ddit.chap13.map;

import java.util.HashMap;
import java.util.Map.Entry;

// 학번(정수), 이름(문자열)자료를 저장하는 map
public class HashMapExample {

	public static void main(String[] args) {
		mapMethod01();
	}

	public static void mapMethod01() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		// put(k,v) : 자료저장
		map.put(1001, "홍길동");
		map.put(1101, "정몽주");
		map.put(2011, "이성계");
		map.put(1903, "임현우");
		
		// map 전체자료 출력
		System.out.println(map);
		
		// get(key) : key값으로 value 추출
		System.out.println(map.get(2011));
		
		// Entry 객체를 이용하여 순차검색
		System.out.println("학번       이름");
		System.out.println("-------------------");
		for(Entry<Integer,String> entrySet : map.entrySet()) {
			if(entrySet.getKey()==1101) {
				System.out.println(entrySet.getKey()+"  "+entrySet.getValue());
			}
		}
		
		// map의 keySet()을 이용한 검색
		for(Integer i:map.keySet()) { // key로만 구성된 Set
			System.out.println(i+" -> "+map.get(i));
		}
	}
}
