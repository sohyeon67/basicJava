package ddit.chap13.map;

import java.util.HashMap;
import java.util.Map.Entry;

// �й�(����), �̸�(���ڿ�)�ڷḦ �����ϴ� map
public class HashMapExample {

	public static void main(String[] args) {
		mapMethod01();
	}

	public static void mapMethod01() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		// put(k,v) : �ڷ�����
		map.put(1001, "ȫ�浿");
		map.put(1101, "������");
		map.put(2011, "�̼���");
		map.put(1903, "������");
		
		// map ��ü�ڷ� ���
		System.out.println(map);
		
		// get(key) : key������ value ����
		System.out.println(map.get(2011));
		
		// Entry ��ü�� �̿��Ͽ� �����˻�
		System.out.println("�й�       �̸�");
		System.out.println("-------------------");
		for(Entry<Integer,String> entrySet : map.entrySet()) {
			if(entrySet.getKey()==1101) {
				System.out.println(entrySet.getKey()+"  "+entrySet.getValue());
			}
		}
		
		// map�� keySet()�� �̿��� �˻�
		for(Integer i:map.keySet()) { // key�θ� ������ Set
			System.out.println(i+" -> "+map.get(i));
		}
	}
}
