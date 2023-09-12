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
		int itemsPerPage = 5; // 한 페이지에 보여줄 게시물 수
		int currentPage = 1; // 현재 페이지
		int startIdx = 0; // 시작 인덱스
		int totalItems = noticeDao.getTotalNoticeCount(); // 전체 공지사항 개수

		if (list == null) {
			System.out.println("공지가 없습니다!!");

			
			if (perm.equals("ADMIN")) {
				System.out.println("---------------------------------------");
				System.out.println("2.등록 0.종료");
				System.out.print("번호 선택 >> ");
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

				System.out.println("-- 공지사항 목록 --");
				System.out.println("번호\t제목\t\t작성자\t작성일");
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
						.println("현재 페이지: " + currentPage + "/" + (int) Math.ceil((double) totalItems / itemsPerPage));
				System.out.println("페이지 이동(이전:b, 다음:n) ");
				if (perm.equals("ADMIN")) {
					System.out.println("1.상세 2.등록 3.수정 4.삭제 0.종료");
				} else {
					System.out.println("1.상세 0.종료");
				}

				System.out.print("번호 선택 >> ");
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
			System.out.println("공지사항은 관리자만 작성할 수 있습니다.");
			return View.ADMIN_LOGIN;
		}

		List<Object> param = new ArrayList<>();
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String dt = format.format(now);

		System.out.println("-- 공지사항 등록 --");
		// 게시글 번호 생성
		int notice_no = noticeDao.createNoticeNumber();
		param.add(notice_no);

		System.out.print("제목 : ");
		String notice_title = ScanUtil.nextLine();
		param.add(notice_title);

		System.out.print("내용 : ");
		String notice_content = ScanUtil.nextLine();
		param.add(notice_content);

		param.add(dt);

		String member_id = Controller.sessionStorage.get("loginInfo").toString();
		param.add(member_id);

		int res = noticeDao.insert(param);
		if (res > 0) {
			System.out.println("공지사항이 등록됐습니다.");
		} else {
			System.out.println("공지사항이 등록되지 않았습니다.");
		}

		return View.ADMIN_MENU;
	}

	public int update() {
		String perm = Controller.sessionStorage.get("role").toString();
		String adminID = Controller.sessionStorage.get("loginInfo").toString();

		if (!perm.equals("ADMIN")) {
			System.out.println("공지사항은 관리자만 수정할 수 있습니다.");
			return View.ADMIN_LOGIN;
		}

		List<Object> param = new ArrayList<>();

		System.out.print("수정할 공지번호 >>> ");
		int noticeNum = ScanUtil.nextInt();

		System.out.print("제목 : ");
		String title = ScanUtil.nextLine();
		param.add(title);

		System.out.print("내용 : ");
		String content = ScanUtil.nextLine();
		param.add(content);

		param.add(noticeNum);
		param.add(adminID);

		int res = noticeDao.update(param);

		if (res > 0) {
			System.out.println("공지가 수정됐습니다.");
		} else {
			System.out.println("공지가 수정되지 않았습니다.");
		}

		return View.ADMIN_MENU;
	}

	public int delete() {
		String perm = Controller.sessionStorage.get("role").toString();

		if (!perm.equals("ADMIN")) {
			System.out.println("공지사항은 관리자만 삭제할 수 있습니다.");
			return View.ADMIN_LOGIN;
		}

		System.out.print("삭제할 공지사항 번호 >>> ");
		String deleted_notice_no = ScanUtil.nextLine();

		int res = noticeDao.delete(Integer.parseInt(deleted_notice_no));
		if (res > 0) {
			System.out.println("공지사항이 삭제됐습니다.");
		} else {
			System.out.println("정상적으로 삭제되지 않았습니다.");
		}

		return View.ADMIN_MENU;
	}

	public int detail() {
		String perm = Controller.sessionStorage.get("role").toString();

		System.out.print("상세히 볼 공지사항 번호 >>> ");
		int notice_no = ScanUtil.nextInt();

		String res = noticeDao.detail(notice_no);

		System.out.println("내용: " + res);

		if (perm.equals("ADMIN")) {
			return View.ADMIN_MENU;
		} else {
			return View.HOME;
		}

	}

}
