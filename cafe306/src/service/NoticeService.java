package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import controller.Controller;
import dao.NoticeDAO;
import util.ScanUtil;
import util.View;

public class NoticeService {
	private static NoticeService instance = null;

	private NoticeService() {
	}

	public static NoticeService getInstance() {
		if (instance == null)
			instance = new NoticeService();
		return instance;
	}

	NoticeDAO noticeDao = NoticeDAO.getInstance();

	public int list() {
		String perm = Controller.sessionStorage.get("role").toString();
		List<Map<String, Object>> list = noticeDao.list();
		// List
		// 0 Map
		// 1 Map
		// 2 Map
		// ...
		int itemsPerPage = 5; // �� �������� ������ �Խù� ��
		int currentPage = 1; // ���� ������
		int startIdx = 0; // ���� �ε���
		int totalItems = noticeDao.getTotalNoticeCount(); // ��ü �������� ����

		if (list == null) {
			System.out.println("������ �����ϴ�!!");

			
			if (perm.equals("ADMIN")) {
				System.out.println("---------------------------------------");
				System.out.println("2.��� 0.����");
				System.out.print("��ȣ ���� >> ");
				switch (ScanUtil.nextInt()) {
				case 2:
					return View.NOTICE_INSERT;
				default:
					return View.ADMIN_MENU;
				}
			} else {
				return View.HOME;
			}
		} else {
			while (true) {
				startIdx = (currentPage - 1) * itemsPerPage + 1;

				List<Map<String, Object>> pagedNotices = noticeDao.listPaging(startIdx, itemsPerPage);

				System.out.println("-- �������� ��� --");
				System.out.println("��ȣ\t����\t\t�ۼ���\t�ۼ���");
				System.out.println("--------------------------------------------");

				for (Map<String, Object> item : pagedNotices) {
					System.out.print(item.get("NOTICE_NO"));
					System.out.print("\t" + item.get("NOTICE_SUB"));
					System.out.print("\t\t" + item.get("ADMIN_NAME"));
					System.out.print("\t" + item.get("NOTICE_DATE"));
					System.out.println();
				}

				System.out.println("--------------------------------------------");
				System.out
						.println("���� ������: " + currentPage + "/" + (int) Math.ceil((double) totalItems / itemsPerPage));
				System.out.println("������ �̵�(����:b, ����:n) ");
				if (perm.equals("ADMIN")) {
					System.out.println("1.�� 2.��� 3.���� 4.���� 0.����");
				} else {
					System.out.println("1.�� 0.����");
				}

				System.out.print("��ȣ ���� >> ");
				switch (ScanUtil.nextLine().toLowerCase()) {
				case "1":
					return View.NOTICE_DETAIL;
				case "2":
					return View.NOTICE_INSERT;
				case "3":
					return View.NOTICE_UPDATE;
				case "4":
					return View.NOTICE_DELETE;
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
						return View.HOME;
					}
				}
			}
		}

	}

	public int insert() {
		String perm = Controller.sessionStorage.get("role").toString();

		if (!perm.equals("ADMIN")) {
			System.out.println("���������� �����ڸ� �ۼ��� �� �ֽ��ϴ�.");
			return View.ADMIN_LOGIN;
		}

		List<Object> param = new ArrayList<>();
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String dt = format.format(now);

		System.out.println("-- �������� ��� --");
		// �Խñ� ��ȣ ����
		int notice_no = noticeDao.createNoticeNumber();
		param.add(notice_no);

		System.out.print("���� : ");
		String notice_title = ScanUtil.nextLine();
		param.add(notice_title);

		System.out.print("���� : ");
		String notice_content = ScanUtil.nextLine();
		param.add(notice_content);

		param.add(dt);

		String member_id = Controller.sessionStorage.get("loginInfo").toString();
		param.add(member_id);

		int res = noticeDao.insert(param);
		if (res > 0) {
			System.out.println("���������� ��ϵƽ��ϴ�.");
		} else {
			System.out.println("���������� ��ϵ��� �ʾҽ��ϴ�.");
		}

		return View.ADMIN_MENU;
	}

	public int update() {
		String perm = Controller.sessionStorage.get("role").toString();
		String adminID = Controller.sessionStorage.get("loginInfo").toString();

		if (!perm.equals("ADMIN")) {
			System.out.println("���������� �����ڸ� ������ �� �ֽ��ϴ�.");
			return View.ADMIN_LOGIN;
		}

		List<Object> param = new ArrayList<>();

		System.out.print("������ ������ȣ >>> ");
		int noticeNum = ScanUtil.nextInt();

		System.out.print("���� : ");
		String title = ScanUtil.nextLine();
		param.add(title);

		System.out.print("���� : ");
		String content = ScanUtil.nextLine();
		param.add(content);

		param.add(noticeNum);
		param.add(adminID);

		int res = noticeDao.update(param);

		if (res > 0) {
			System.out.println("������ �����ƽ��ϴ�.");
		} else {
			System.out.println("������ �������� �ʾҽ��ϴ�.");
		}

		return View.ADMIN_MENU;
	}

	public int delete() {
		String perm = Controller.sessionStorage.get("role").toString();

		if (!perm.equals("ADMIN")) {
			System.out.println("���������� �����ڸ� ������ �� �ֽ��ϴ�.");
			return View.ADMIN_LOGIN;
		}

		System.out.print("������ �������� ��ȣ >>> ");
		String deleted_notice_no = ScanUtil.nextLine();

		int res = noticeDao.delete(Integer.parseInt(deleted_notice_no));
		if (res > 0) {
			System.out.println("���������� �����ƽ��ϴ�.");
		} else {
			System.out.println("���������� �������� �ʾҽ��ϴ�.");
		}

		return View.ADMIN_MENU;
	}

	public int detail() {
		String perm = Controller.sessionStorage.get("role").toString();

		System.out.print("���� �� �������� ��ȣ >>> ");
		int notice_no = ScanUtil.nextInt();

		String res = noticeDao.detail(notice_no);

		System.out.println("����: " + res);

		if (perm.equals("ADMIN")) {
			return View.ADMIN_MENU;
		} else {
			return View.HOME;
		}

	}

}
