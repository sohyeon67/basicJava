package ddit.chap13.list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayExample02 {

	public static void main(String[] args) {
		ArrayList<Employees> list = new ArrayList<Employees>();

		list.add(new Employees("10101", "ȫ�浿", 15000));
		list.add(new Employees("22102", "ȫ���", 25000));
		list.add(new Employees("10191", "������", 10500));
		list.add(new Employees("13103", "�̼���", 20000));

		// for��
//		for (Employees emp : list) { // selectList? selectAll??
//			System.out.println(emp.eid + " " + emp.name + ", " + emp.salary);
//		}

		// Iterator ��ü, �ݺ���
		Iterator<Employees> iter = list.iterator();
		while (iter.hasNext()) { // ������ ���� �ֳ�?
			Employees emp = iter.next(); // �����´�
			// ���׸� ������ Employees emp = (Employees)iter.next();
			if (emp.eid.equals("10191")) {
				System.out.println(emp.eid + " " + emp.name + ", " + emp.salary); //selectOne?
			}
		}
	}

}
