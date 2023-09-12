package dbprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBTestExample {

	public static void main(String[] args) {
		DBTest dt = new DBTest();
		StringBuilder sb = new StringBuilder(); // 쿼리. 나중에 문자열로 바꿔줌
		Scanner sc = new Scanner(System.in);
		String sql = null;
		List<Object> param = null; // ArrayList 객체

		System.out.println("[[데이터베이스 관리]]");
		System.out.println(" 1. 전체검색");
		System.out.println(" 2. 단일검색");
		System.out.println(" 3. 신규자료입력"); // 신규 자료수...
		System.out.println(" 4. 자료수정"); // 수정된 자료수...
		System.out.println(" 5. 자료삭제"); // 삭제된 자료수...
		System.out.println(" 9. 종료");
		System.out.println("--------------------");
		System.out.println("작업번호 >> ");
		int choice = new Scanner(System.in).nextInt();

		switch (choice) {
		case 1: // 컴파일 시간에 정해져있음. 정적쿼리
			sb.append(" SELECT PROD_ID, PROD_NAME, PROD_PRICE, PROD_PROPERSTOCK");
			sb.append(" FROM TPROD");
			sb.append(" WHERE PROD_PRICE >= 1000000");
			sb.append(" ORDER BY PROD_PRICE DESC");
			sql = sb.toString();
			dt.selectList(sql);
			break;
		case 2: // 동적쿼리
			sb.append(" SELECT PROD_ID, PROD_NAME, PROD_PRICE, PROD_PROPERSTOCK");
			sb.append(" FROM TPROD");
			sb.append(" WHERE PROD_ID = ?"); // 컴파일할 때는 정해있지 않음. 하나의 값.. selectOne
			sb.append(" ORDER BY PROD_PRICE DESC");
			sql = sb.toString(); // 물음표를 가지고 있는 쿼리
			System.out.println("조회할 상품코드 : ");
			String pid = sc.next();
			dt.selectOne(sql, pid); // 조회할 금액 입력 후 ... 동적쿼리. 물음표에 price 매핑
			break;
		case 3: // 입력(insert into~)
			param = new ArrayList<Object>();
			System.out.print("상품코드 : ");
			String p = sc.next();
			param.add(p);

			System.out.print("상품명 : ");
			String pname = sc.next();
			param.add(pname);

			System.out.print("가격 : ");
			int pr = sc.nextInt();
			param.add(pr);

			System.out.print("적정재고 : ");
			int ps = sc.nextInt();
			// int ps=Integer.parseInt(sc.nextLine());
			// String은 nextLine()
			param.add(ps); // int => Integer => Object (auto casting)

			sql = "INSERT INTO TPROD VALUES( ?, ?, ?, ? )";
			int flag = dt.update(sql, param);
			if (flag != 0) {
				System.out.println("자료입력 성공");
			} else {
				System.out.println("자료가 입력되지 않았습니다");
			}
			break;
		case 4: // 갱신 update 테이블명 set ~
			param = new ArrayList<Object>();
			sql = "UPDATE TPROD SET ";
			String yesOrNot = "";

			System.out.print("변경할 상품번호 : ");
			String cpid = sc.nextLine();
			param.add(cpid);

			System.out.print("상품명 변경?(y/n)");
			yesOrNot = sc.nextLine();
			while (yesOrNot.equalsIgnoreCase("y")) {
				System.out.print("상품명 : ");
				String p1 = sc.nextLine();
				sql = sql + "PROD_NAME = '" + p1 + "', "; // 오라클에서 문자열 작은따옴표
				break;
			}

			System.out.print("상품가격 변경?(y/n)");
			yesOrNot = sc.nextLine();
			while (yesOrNot.equalsIgnoreCase("y")) {
				System.out.print("상품가격 : ");
				int p2 = Integer.parseInt(sc.nextLine());
				sql = sql + "PROD_PRICE = " + p2 + ", ";
				break;
			}

			System.out.print("적정재고 변경?(y/n)");
			yesOrNot = sc.nextLine();
			while (yesOrNot.equalsIgnoreCase("y")) {
				System.out.print("적정재고 : ");
				int p3 = Integer.parseInt(sc.nextLine());
				sql = sql + "PROD_PROPERSTOCK = " + p3 + ", ";
				break;
			}

			int len = sql.length();
			sql = sql.substring(0, len - 2);
			sql = sql + "WHERE PROD_ID = ? ";

			flag = dt.update(sql, param);
			if (flag != 0) {
				System.out.println("자료가 정상적으로 갱신됨");
			} else {
				System.out.println("자료갱신 실패");
			}
			break;
		case 5: // 삭제 delete from ~ [where ]
			param = new ArrayList<Object>();
			sql = "DELETE FROM TPROD ";

			System.out.print("삭제할 상품번호 : ");
			pid = sc.nextLine();
			sql = sql + " WHERE PROD_ID = ? ";

			param.add(pid);
			flag = dt.update(sql, param);
			if (flag != 0) {
				System.out.println("자료가 정상적으로 삭제됨");
			} else {
				System.out.println("자료삭제 실패");
			}
			break;
		case 9:
			System.out.println("시스템을 종료 합니다....");
			System.exit(0);
		}
	}
}
