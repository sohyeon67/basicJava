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

	public int list() { // �ֹ� ���� Ȯ��
		
		String memID = Controller.sessionStorage.get("loginInfo").toString();

		List<Map<String, Object>> result = null;
		result = orderDao.orderList(memID);

		if(result != null) {
			System.out.println("==============================================================");
			System.out
					.println("�ֹ���ȣ                 ��¥                                     �Ѱ����ݾ�       ����             �޴���");
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
			System.out.println("�ֹ� ������ �����ϴ�!");
		}
		
		return View.USERHOME;
	}

	public int insert() { // �޴��� ���� �ֹ� �󼼿� �ִ� ��
		// �ֹ� : �ֹ���ȣ, �ֹ��ð�(��¥), �Ѱ����ݾ�, ȸ��ID
		// �ֹ��� : �ֹ���ȣ, �޴���ȣ, ����
		int res = 0;

		List<Object> orderParam = new ArrayList<>();
		List<List<Object>> details = new ArrayList<>();

		if (Controller.sessionStorage.get("loginInfo") == null) {
			System.out.println("�α������� �ʾҽ��ϴ�.");
			System.out.println("�ֹ��� �α��� �� �ۼ��� �� �ֽ��ϴ�.");
			return View.MEMBER_LOGIN;
		}

		// �ֹ���ȣ
		int orderNum = orderDao.createOrderNumber();
		orderParam.add(orderNum); // orderNum

		// ��¥
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:SS");
		// String dt = format.format(Calendar.getInstance().getTime());
		String dt = format.format(now);
		orderParam.add(dt);

		// �� ������
		int totalOrderPrice = 0;

		// �� ID
		String memID = Controller.sessionStorage.get("loginInfo").toString();

		/* -------------------------------- */

		// �޴��� ����(�� ������) �Է¹ޱ�
		while (true) {
			List<Object> detailOrderParam = new ArrayList<>(); // �ֹ� �� �Ķ����

			if (menuService.list() == -1) {
				break; // �ֹ� �Ϸ�
			}

			System.out.print("�޴� ��ȣ�� �Է��ϼ��� (�ֹ� �Ϸ�: -1): ");
			int menuNum = ScanUtil.nextInt();
			if (menuNum == -1) {
				break; // �ֹ� �Ϸ�
			}

			// �� ���̺� �ֹ� ��ȣ�� ����
			detailOrderParam.add(orderNum);

			// �޴� ��ȣ
			detailOrderParam.add(menuNum);

			// ����
			System.out.print("���� : ");
			int menuQty = ScanUtil.nextInt();
			detailOrderParam.add(menuQty);

			// �� �����ݾ��� ����ؾ� ��
			int menuPrice = orderDao.price(menuNum);
			totalOrderPrice += menuQty * menuPrice;
			System.out.println("�� �����ݾ� : " + totalOrderPrice);

			details.add(detailOrderParam);
		}

		if (details.size() != 0) {
			// ���ϸ��� ����
			int memMileage = memberDao.getMileage(memID);
			int useMileage = 0;

			System.out.print("���ϸ����� ����Ͻðڽ��ϱ�? (���: 1, �̻��: 2) : ");
			if (ScanUtil.nextInt() == 1) {
				while (true) {
					System.out.print("����� ���ϸ��� �Է� (���� : " + memMileage + ") : ");
					useMileage = ScanUtil.nextInt();
					if (memMileage < useMileage) {
						System.out.println("���ϸ����� �����մϴ�.");
					} else {
						memMileage -= useMileage;
						System.out.println(useMileage + " ���ϸ����� �����Ǿ����ϴ�.");
						totalOrderPrice -= useMileage;
						orderParam.add(totalOrderPrice);
						break;
					}
				}
			} else {
				orderParam.add(totalOrderPrice);
			}

			// �� �����ݾ� ������Ʈ
			int mileage = (int) (totalOrderPrice * 0.03);
			memMileage += mileage;
			orderParam.add(memID);

			orderDao.insert(orderParam);
			for (List detailOrder : details) {
				detailOrderDao.insert(detailOrder); // �޴��̸��� ������ �Ѱ���
			}

			if (memberDao.updateMileage(memMileage, memID) > 0) {
				System.out.println("�ֹ��� �Ϸ�Ǿ����ϴ�.");
				System.out.println("\n========= ������ =========");
				System.out.println("�ֹ���ȣ : " + orderNum);
				System.out.println("�������� : " + dt);
				System.out.print("�ֹ��� : " + memID + "\n");

				List<Map<String, Object>> result = null;
				result = orderDao.receipt(orderNum);
				if (result != null) {
					System.out.println("����            �޴���");
					for (int i = 0; i < result.size(); i++) {
						String dodercount = String.valueOf(result.get(i).get("DORDER_COUNT"));
						System.out.printf("%-8d", Integer.parseInt(dodercount));
						System.out.printf("%-20s\n", result.get(i).get("MENU_NAME"));
					}
				}
				System.out.println("------------------------");
				System.out.println("�� �����ݾ� : " + totalOrderPrice);
				System.out.println(mileage + " ���ϸ��� ����");
				System.out.println();
				
				
			} else {
				System.out.println("���ϸ��� ���� ����");
			}
		}

		return View.USERHOME;
	}
}
