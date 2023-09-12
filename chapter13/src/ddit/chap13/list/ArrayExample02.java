package ddit.chap13.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayExample02 {

	public static void main(String[] args) {
		ArrayList<Employees> list = new ArrayList<Employees>();

		list.add(new Employees("10101", "홍길동", 15000));
		list.add(new Employees("22102", "홍길순", 25000));
		list.add(new Employees("10191", "정몽주", 10500));
		list.add(new Employees("13103", "이순신", 20000));

		// for문
//		for (Employees emp : list) { // selectList? selectAll??
//			System.out.println(emp.eid + " " + emp.name + ", " + emp.salary);
//		}

		// Iterator 객체, 반복자
		Iterator<Employees> iter = list.iterator();
		while (iter.hasNext()) { // 꺼내올 값이 있냐?
			Employees emp = iter.next(); // 꺼내온다
			// 제네릭 없으면 Employees emp = (Employees)iter.next();
			if (emp.eid.equals("10191")) {
				System.out.println(emp.eid + " " + emp.name + ", " + emp.salary); //selectOne?
			}
		}
	}

}
