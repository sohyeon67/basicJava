package dbprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBTestExample {

	public static void main(String[] args) {
		DBTest dt = new DBTest();
		StringBuilder sb = new StringBuilder(); // ����. ���߿� ���ڿ��� �ٲ���
		Scanner sc = new Scanner(System.in);
		String sql = null;
		List<Object> param = null; // ArrayList ��ü

		System.out.println("[[�����ͺ��̽� ����]]");
		System.out.println(" 1. ��ü�˻�");
		System.out.println(" 2. ���ϰ˻�");
		System.out.println(" 3. �ű��ڷ��Է�"); // �ű� �ڷ��...
		System.out.println(" 4. �ڷ����"); // ������ �ڷ��...
		System.out.println(" 5. �ڷ����"); // ������ �ڷ��...
		System.out.println(" 9. ����");
		System.out.println("--------------------");
		System.out.println("�۾���ȣ >> ");
		int choice = new Scanner(System.in).nextInt();

		switch (choice) {
		case 1: // ������ �ð��� ����������. ��������
			sb.append(" SELECT PROD_ID, PROD_NAME, PROD_PRICE, PROD_PROPERSTOCK");
			sb.append(" FROM TPROD");
			sb.append(" WHERE PROD_PRICE >= 1000000");
			sb.append(" ORDER BY PROD_PRICE DESC");
			sql = sb.toString();
			dt.selectList(sql);
			break;
		case 2: // ��������
			sb.append(" SELECT PROD_ID, PROD_NAME, PROD_PRICE, PROD_PROPERSTOCK");
			sb.append(" FROM TPROD");
			sb.append(" WHERE PROD_ID = ?"); // �������� ���� �������� ����. �ϳ��� ��.. selectOne
			sb.append(" ORDER BY PROD_PRICE DESC");
			sql = sb.toString(); // ����ǥ�� ������ �ִ� ����
			System.out.println("��ȸ�� ��ǰ�ڵ� : ");
			String pid = sc.next();
			dt.selectOne(sql, pid); // ��ȸ�� �ݾ� �Է� �� ... ��������. ����ǥ�� price ����
			break;
		case 3: // �Է�(insert into~)
			param = new ArrayList<Object>();
			System.out.print("��ǰ�ڵ� : ");
			String p = sc.next();
			param.add(p);

			System.out.print("��ǰ�� : ");
			String pname = sc.next();
			param.add(pname);

			System.out.print("���� : ");
			int pr = sc.nextInt();
			param.add(pr);

			System.out.print("������� : ");
			int ps = sc.nextInt();
			// int ps=Integer.parseInt(sc.nextLine());
			// String�� nextLine()
			param.add(ps); // int => Integer => Object (auto casting)

			sql = "INSERT INTO TPROD VALUES( ?, ?, ?, ? )";
			int flag = dt.update(sql, param);
			if (flag != 0) {
				System.out.println("�ڷ��Է� ����");
			} else {
				System.out.println("�ڷᰡ �Էµ��� �ʾҽ��ϴ�");
			}
			break;
		case 4: // ���� update ���̺�� set ~
			param = new ArrayList<Object>();
			sql = "UPDATE TPROD SET ";
			String yesOrNot = "";

			System.out.print("������ ��ǰ��ȣ : ");
			String cpid = sc.nextLine();
			param.add(cpid);

			System.out.print("��ǰ�� ����?(y/n)");
			yesOrNot = sc.nextLine();
			while (yesOrNot.equalsIgnoreCase("y")) {
				System.out.print("��ǰ�� : ");
				String p1 = sc.nextLine();
				sql = sql + "PROD_NAME = '" + p1 + "', "; // ����Ŭ���� ���ڿ� ��������ǥ
				break;
			}

			System.out.print("��ǰ���� ����?(y/n)");
			yesOrNot = sc.nextLine();
			while (yesOrNot.equalsIgnoreCase("y")) {
				System.out.print("��ǰ���� : ");
				int p2 = Integer.parseInt(sc.nextLine());
				sql = sql + "PROD_PRICE = " + p2 + ", ";
				break;
			}

			System.out.print("������� ����?(y/n)");
			yesOrNot = sc.nextLine();
			while (yesOrNot.equalsIgnoreCase("y")) {
				System.out.print("������� : ");
				int p3 = Integer.parseInt(sc.nextLine());
				sql = sql + "PROD_PROPERSTOCK = " + p3 + ", ";
				break;
			}

			int len = sql.length();
			sql = sql.substring(0, len - 2);
			sql = sql + "WHERE PROD_ID = ? ";

			flag = dt.update(sql, param);
			if (flag != 0) {
				System.out.println("�ڷᰡ ���������� ���ŵ�");
			} else {
				System.out.println("�ڷ᰻�� ����");
			}
			break;
		case 5: // ���� delete from ~ [where ]
			param = new ArrayList<Object>();
			sql = "DELETE FROM TPROD ";

			System.out.print("������ ��ǰ��ȣ : ");
			pid = sc.nextLine();
			sql = sql + " WHERE PROD_ID = ? ";

			param.add(pid);
			flag = dt.update(sql, param);
			if (flag != 0) {
				System.out.println("�ڷᰡ ���������� ������");
			} else {
				System.out.println("�ڷ���� ����");
			}
			break;
		case 9:
			System.out.println("�ý����� ���� �մϴ�....");
			System.exit(0);
		}
	}
}
