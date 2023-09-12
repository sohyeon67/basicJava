package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controller.Controller;
import dao.ReviewDAO;
import util.ScanUtil;
import util.View;

public class ReviewService {
	private static ReviewService instance = null;

	private ReviewService() {
	}

	public static ReviewService getInstance() {
		if (instance == null)
			instance = new ReviewService();
		return instance;
	}

	ReviewDAO reviewDao = ReviewDAO.getInstance();

	public int list() {
		List<Map<String, Object>> result = null;
		result = reviewDao.list();
		String perm = Controller.sessionStorage.get("role").toString();

		// List
		// 0 Map
		// 1 Map
		// 2 Map
		// ...

		int itemsPerPage = 5; // �� �������� ������ �Խù� ��
		int currentPage = 1; // ���� ������
		int startIdx = 0; // ���� �ε���
		int totalItems = reviewDao.getTotalReviewCount(); // ��ü �������� ����

		if (result == null) {
			System.out.println("���䰡 �����ϴ�!!");

			if (Controller.sessionStorage.get("loginInfo") == null) { // �α����� �ȵǾ� ����
				return View.HOME;
			} else {
				if (perm.equals("MEM")) { // �α��� �Ǿ��ְ�, ���̸�
					System.out.println("---------------------------------------");
					System.out.println("2.��� 0.����");
					System.out.print("��ȣ ���� >> ");
					switch (ScanUtil.nextInt()) {
					case 2:
						return View.REVIEW_INSERT;
					default:
						return View.USERHOME;
					}
				} else { // �����ڸ�
					return View.ADMIN_MENU;
				}
			}

		} else {
			while (true) {
				startIdx = (currentPage - 1) * itemsPerPage + 1;

				List<Map<String, Object>> pagedReviews = reviewDao.listPaging(startIdx, itemsPerPage);

				System.out.println("-- ���� ��� --");
				System.out.println("�����ȣ     ����      �ۼ�����                    �ֹ���ȣ");
				System.out.println("---------------------------------------");

				for (Map<String, Object> item : pagedReviews) {
					System.out.printf("%-8s", item.get("REV_NO"));
					System.out.printf("%-5s", item.get("REV_SCORE"));
					System.out.printf("%-15s", item.get("REV_DATE"));
					System.out.printf("%-10s", item.get("ORDER_NO"));
					System.out.println();
				}

				System.out.println("---------------------------------------");
				System.out
						.println("���� ������: " + currentPage + "/" + (int) Math.ceil((double) totalItems / itemsPerPage));
				System.out.println("������ �̵�(����:b, ����:n) ");
				if (perm.equals("ADMIN")) {
					System.out.println("1.�� 4.���� 0.����");
				} else {
					if (Controller.sessionStorage.get("loginInfo") == null) { // �α��� �ȵǾ� ����
						System.out.println("1.�� 0.����");
					} else { // ��� �α��� ��
						System.out.println("1.�� 2.�ۼ� 3.���� 4.���� 0.����");
					}
				}

				System.out.print("��ȣ ���� >> ");
				switch (ScanUtil.nextLine().toLowerCase()) {
				case "1":
					return View.REVIEW_DETAIL;
				case "2":
					return View.REVIEW_INSERT;
				case "3":
					return View.REVIEW_UPDATE;
				case "4":
					return View.REVIEW_DELETE;
				case "b":
					currentPage = Math.max(currentPage - 1, 1);
					break;
				case "n":
					currentPage = Math.min(currentPage + 1, (int) Math.ceil((double) totalItems / itemsPerPage));
					break;
				default:
					if (perm.equals("ADMIN")) {
						return View.ADMIN_MENU;
					} else {
						if (Controller.sessionStorage.get("loginInfo") == null) { // �α��� �ȵǾ� ����
							return View.HOME;
						} else { // ��� �α��� ��
							return View.USERHOME;
						}
					}
				}
			}
		}

	}

	public int insert() {
		List<Object> param = new ArrayList<>();
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String dt = format.format(now);
		String memID = Controller.sessionStorage.get("loginInfo").toString();

		if (memID == null) {
			System.out.println("�α������� �ʾҽ��ϴ�.");
			System.out.println("�ı���� �α��� �� �ۼ��� �� �ֽ��ϴ�.");
			return View.MEMBER_LOGIN;
		}

		if (reviewDao.check(memID) > 0) { // �ֹ��� �� ���� �ִ��� üũ
			System.out.println("-- ���� ��� --");
			// �����ȣ ����

			int reviewNum = reviewDao.createReviewNumber();
			System.out.println("�����ȣ : " + reviewNum);
			param.add(reviewNum);

			System.out.print("���� : ");
			int score = Integer.parseInt(ScanUtil.nextLine());
			param.add(score);

			System.out.print("���� : ");
			String content = ScanUtil.nextLine();
			param.add(content);

			System.out.println("�ۼ����� : " + dt);
			param.add(dt);

			System.out.print("�ֹ���ȣ : ");
			int orderNum = Integer.parseInt(ScanUtil.nextLine());
			param.add(orderNum);

			param.add(memID);

			int res = reviewDao.insert(param); // �ֹ��� �� ����� ���� �ۼ� ����
			if (res > 0) {
				System.out.println("���䰡 ��ϵƽ��ϴ�.");
			} else {
				System.out.println("���䰡 ��ϵ��� �ʾҽ��ϴ�.");
			}
		} else {
			System.out.println("�ֹ��� �� ����� ���並 �ۼ��� �� �ֽ��ϴ�.");
		}
		return View.USERHOME;

	}

	public int update() { // �ڱ�Ÿ� ����
		List<Object> param = new ArrayList<>();
		System.out.println("-- ���� ���� --");
		String memID = (String) Controller.sessionStorage.get("loginInfo");

		// 1. ���� �Է� ó��
		System.out.print("����: ");
		int rev_score = ScanUtil.nextInt();
		param.add(rev_score);

		// 2. ���� �Է� ó��
		System.out.print("����: ");
		String REV_content = ScanUtil.nextLine();
		param.add(REV_content);

		// 3. �����ȣ �Է� ó��
		System.out.print("�����ȣ: ");
		int REV_NO = ScanUtil.nextInt();
		param.add(REV_NO);

		// 4. �ֹ���ȣ �Է� ó��
		System.out.print("�ֹ���ȣ: ");
		int ORDER_NO = ScanUtil.nextInt();
		param.add(ORDER_NO);

		param.add(memID);

		int res = reviewDao.update(param);

		if (res > 0) {
			System.out.println("���䰡 �����ƽ��ϴ�.");
		} else {
			System.out.println("���䰡 �������� �ʾҽ��ϴ�.");
		}

		return View.USERHOME;

	}

	public int delete() { // �����ڴ� �� ���� ����, ����� �ڱⲨ�� ����
		List<Object> param = new ArrayList<>();
		int res = 0;
		String memID = Controller.sessionStorage.get("loginInfo").toString();
		String perm = Controller.sessionStorage.get("role").toString();

		System.out.print("������ �����ȣ >>> ");
		int reviewNo = ScanUtil.nextInt();
		param.add(reviewNo);

		if (memID == null) {
			System.out.println("�α��� �� ���� �����մϴ�.");
			return View.MEMBER_LOGIN; // �α��� ȭ������ �̵�

		}

		if (perm.equals("ADMIN")) { // �����ڴ� �� ���� ����
			res = reviewDao.adminDelete(param);
		} else { // ������ �ڱⲨ�� ���� ����
			param.add(memID);
			res = reviewDao.memDelete(param);
		}

		if (res > 0) {
			System.out.println("���䰡 �����Ǿ����ϴ�");
		} else {
			System.out.println("���䰡 �������� �ʾҽ��ϴ�.");
		}

		if (perm.equals("ADMIN")) {
			return View.ADMIN_MENU;
		} else {
			if (Controller.sessionStorage.get("loginInfo") == null) { // �α��� �ȵǾ� ����
				return View.HOME;
			} else { // ��� �α��� ��
				return View.USERHOME;
			}
		}
	}

	public int detail() {
		String perm = Controller.sessionStorage.get("role").toString();

		System.out.print("���� �� �����ȣ >>> ");
		int review_no = ScanUtil.nextInt();

		String res = reviewDao.detail(review_no);

		System.out.println("����: " + res);

		if (perm.equals("ADMIN")) {
			return View.ADMIN_MENU;
		} else {
			if (Controller.sessionStorage.get("loginInfo") == null) { // �α��� �ȵǾ� ����
				return View.HOME;
			} else { // ��� �α��� ��
				return View.USERHOME;
			}
		}

	}

}