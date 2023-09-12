package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.DetailOrderDAO;
import dao.MemberDAO;
import dao.OrderDAO;
import util.ScanUtil;
import util.View;

public class OrderService {
	private static OrderService instance = null;

	private OrderService() {
	}

	public static OrderService getInstance() {
		if (instance == null)
			instance = new OrderService();
		return instance;
	}

	OrderDAO orderDao = OrderDAO.getInstance();
	DetailOrderDAO detailOrderDao = DetailOrderDAO.getInstance();
	MenuService menuService = MenuService.getInstance();
	MemberDAO memberDao = MemberDAO.getInstance();

	public int list() { // 주문 내역 확인
		
		String memID = Controller.sessionStorage.get("loginInfo").toString();

		List<Map<String, Object>> result = null;
		result = orderDao.orderList(memID);

		if(result != null) {
			System.out.println("==============================================================");
			System.out
					.println("주문번호                 날짜                                     총결제금액       수량             메뉴명");
			System.out.println("==============================================================");

			for (int i = 0; i < result.size(); i++) {
				String orderno = String.valueOf(result.get(i).get("ORDER_NO"));
				System.out.printf("%-8d", Integer.parseInt(orderno));
				System.out.printf("%-25s", result.get(i).get("ORDER_DATE"));
				String orderprice = String.valueOf(result.get(i).get("ORDER_PRICE"));
				System.out.printf("%-10d", Integer.parseInt(orderprice));
				String dordercount = String.valueOf(result.get(i).get("DORDER_COUNT"));
				System.out.printf("%-5d", Integer.parseInt(dordercount));
				System.out.printf("%-10s\n", result.get(i).get("MENU_NAME"));
			}
		} else {
			System.out.println("주문 내역이 없습니다!");
		}
		
		return View.USERHOME;
	}

	public int insert() { // 메뉴를 보고 주문 상세에 넣는 곳
		// 주문 : 주문번호, 주문시간(날짜), 총결제금액, 회원ID
		// 주문상세 : 주문번호, 메뉴번호, 개수
		int res = 0;

		List<Object> orderParam = new ArrayList<>();
		List<List<Object>> details = new ArrayList<>();

		if (Controller.sessionStorage.get("loginInfo") == null) {
			System.out.println("로그인하지 않았습니다.");
			System.out.println("주문은 로그인 후 작성할 수 있습니다.");
			return View.MEMBER_LOGIN;
		}

		// 주문번호
		int orderNum = orderDao.createOrderNumber();
		orderParam.add(orderNum); // orderNum

		// 날짜
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
		// String dt = format.format(Calendar.getInstance().getTime());
		String dt = format.format(now);
		orderParam.add(dt);

		// 총 결제액
		int totalOrderPrice = 0;

		// 고객 ID
		String memID = Controller.sessionStorage.get("loginInfo").toString();

		/* -------------------------------- */

		// 메뉴와 수량(상세 데이터) 입력받기
		while (true) {
			List<Object> detailOrderParam = new ArrayList<>(); // 주문 상세 파라미터

			if (menuService.list() == -1) {
				break; // 주문 완료
			}

			System.out.print("메뉴 번호를 입력하세요 (주문 완료: -1): ");
			int menuNum = ScanUtil.nextInt();
			if (menuNum == -1) {
				break; // 주문 완료
			}

			// 상세 테이블에 주문 번호는 고정
			detailOrderParam.add(orderNum);

			// 메뉴 번호
			detailOrderParam.add(menuNum);

			// 수량
			System.out.print("수량 : ");
			int menuQty = ScanUtil.nextInt();
			detailOrderParam.add(menuQty);

			// 총 결제금액은 계산해야 함
			int menuPrice = orderDao.price(menuNum);
			totalOrderPrice += menuQty * menuPrice;
			System.out.println("총 결제금액 : " + totalOrderPrice);

			details.add(detailOrderParam);
		}

		if (details.size() != 0) {
			// 마일리지 적립
			int memMileage = memberDao.getMileage(memID);
			int useMileage = 0;

			System.out.print("마일리지를 사용하시겠습니까? (사용: 1, 미사용: 2) : ");
			if (ScanUtil.nextInt() == 1) {
				while (true) {
					System.out.print("사용할 마일리지 입력 (보유 : " + memMileage + ") : ");
					useMileage = ScanUtil.nextInt();
					if (memMileage < useMileage) {
						System.out.println("마일리지가 부족합니다.");
					} else {
						memMileage -= useMileage;
						System.out.println(useMileage + " 마일리지가 차감되었습니다.");
						totalOrderPrice -= useMileage;
						orderParam.add(totalOrderPrice);
						break;
					}
				}
			} else {
				orderParam.add(totalOrderPrice);
			}

			// 총 결제금액 업데이트
			int mileage = (int) (totalOrderPrice * 0.03);
			memMileage += mileage;
			orderParam.add(memID);

			orderDao.insert(orderParam);
			for (List detailOrder : details) {
				detailOrderDao.insert(detailOrder); // 메뉴이름과 수량을 넘겨줌
			}

			if (memberDao.updateMileage(memMileage, memID) > 0) {
				System.out.println("주문이 완료되었습니다.");
				System.out.println("\n========= 영수증 =========");
				System.out.println("주문번호 : " + orderNum);
				System.out.println("결제일자 : " + dt);
				System.out.print("주문자 : " + memID + "\n");

				List<Map<String, Object>> result = null;
				result = orderDao.receipt(orderNum);
				if (result != null) {
					System.out.println("수량            메뉴명");
					for (int i = 0; i < result.size(); i++) {
						String dodercount = String.valueOf(result.get(i).get("DORDER_COUNT"));
						System.out.printf("%-8d", Integer.parseInt(dodercount));
						System.out.printf("%-20s\n", result.get(i).get("MENU_NAME"));
					}
				}
				System.out.println("------------------------");
				System.out.println("총 결제금액 : " + totalOrderPrice);
				System.out.println(mileage + " 마일리지 적립");
				System.out.println();
				
				
			} else {
				System.out.println("마일리지 차감 오류");
			}
		}

		return View.USERHOME;
	}
}
