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

		int itemsPerPage = 5; // 한 페이지에 보여줄 게시물 수
		int currentPage = 1; // 현재 페이지
		int startIdx = 0; // 시작 인덱스
		int totalItems = reviewDao.getTotalReviewCount(); // 전체 공지사항 개수

		if (result == null) {
			System.out.println("리뷰가 없습니다!!");

			if (Controller.sessionStorage.get("loginInfo") == null) { // 로그인이 안되어 있음
				return View.HOME;
			} else {
				if (perm.equals("MEM")) { // 로그인 되어있고, 고객이면
					System.out.println("---------------------------------------");
					System.out.println("2.등록 0.종료");
					System.out.print("번호 선택 >> ");
					switch (ScanUtil.nextInt()) {
					case 2:
						return View.REVIEW_INSERT;
					default:
						return View.USERHOME;
					}
				} else { // 관리자면
					return View.ADMIN_MENU;
				}
			}

		} else {
			while (true) {
				startIdx = (currentPage - 1) * itemsPerPage + 1;

				List<Map<String, Object>> pagedReviews = reviewDao.listPaging(startIdx, itemsPerPage);

				System.out.println("-- 리뷰 목록 --");
				System.out.println("리뷰번호     별점      작성일자                    주문번호");
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
						.println("현재 페이지: " + currentPage + "/" + (int) Math.ceil((double) totalItems / itemsPerPage));
				System.out.println("페이지 이동(이전:b, 다음:n) ");
				if (perm.equals("ADMIN")) {
					System.out.println("1.상세 4.삭제 0.종료");
				} else {
					if (Controller.sessionStorage.get("loginInfo") == null) { // 로그인 안되어 있음
						System.out.println("1.상세 0.종료");
					} else { // 멤버 로그인 됨
						System.out.println("1.상세 2.작성 3.수정 4.삭제 0.종료");
					}
				}

				System.out.print("번호 선택 >> ");
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
						if (Controller.sessionStorage.get("loginInfo") == null) { // 로그인 안되어 있음
							return View.HOME;
						} else { // 멤버 로그인 됨
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
			System.out.println("로그인하지 않았습니다.");
			System.out.println("후기글은 로그인 후 작성할 수 있습니다.");
			return View.MEMBER_LOGIN;
		}

		if (reviewDao.check(memID) > 0) { // 주문을 한 적이 있는지 체크
			System.out.println("-- 리뷰 등록 --");
			// 리뷰번호 생성

			int reviewNum = reviewDao.createReviewNumber();
			System.out.println("리뷰번호 : " + reviewNum);
			param.add(reviewNum);

			System.out.print("별점 : ");
			int score = Integer.parseInt(ScanUtil.nextLine());
			param.add(score);

			System.out.print("내용 : ");
			String content = ScanUtil.nextLine();
			param.add(content);

			System.out.println("작성일자 : " + dt);
			param.add(dt);

			System.out.print("주문번호 : ");
			int orderNum = Integer.parseInt(ScanUtil.nextLine());
			param.add(orderNum);

			param.add(memID);

			int res = reviewDao.insert(param); // 주문을 한 사람만 리뷰 작성 가능
			if (res > 0) {
				System.out.println("리뷰가 등록됐습니다.");
			} else {
				System.out.println("리뷰가 등록되지 않았습니다.");
			}
		} else {
			System.out.println("주문을 한 사람만 리뷰를 작성할 수 있습니다.");
		}
		return View.USERHOME;

	}

	public int update() { // 자기거만 수정
		List<Object> param = new ArrayList<>();
		System.out.println("-- 리뷰 수정 --");
		String memID = (String) Controller.sessionStorage.get("loginInfo");

		// 1. 별점 입력 처리
		System.out.print("별점: ");
		int rev_score = ScanUtil.nextInt();
		param.add(rev_score);

		// 2. 내용 입력 처리
		System.out.print("내용: ");
		String REV_content = ScanUtil.nextLine();
		param.add(REV_content);

		// 3. 리뷰번호 입력 처리
		System.out.print("리뷰번호: ");
		int REV_NO = ScanUtil.nextInt();
		param.add(REV_NO);

		// 4. 주문번호 입력 처리
		System.out.print("주문번호: ");
		int ORDER_NO = ScanUtil.nextInt();
		param.add(ORDER_NO);

		param.add(memID);

		int res = reviewDao.update(param);

		if (res > 0) {
			System.out.println("리뷰가 수정됐습니다.");
		} else {
			System.out.println("리뷰가 수정되지 않았습니다.");
		}

		return View.USERHOME;

	}

	public int delete() { // 관리자는 다 삭제 가능, 멤버는 자기꺼만 삭제
		List<Object> param = new ArrayList<>();
		int res = 0;
		String memID = Controller.sessionStorage.get("loginInfo").toString();
		String perm = Controller.sessionStorage.get("role").toString();

		System.out.print("삭제할 리뷰번호 >>> ");
		int reviewNo = ScanUtil.nextInt();
		param.add(reviewNo);

		if (memID == null) {
			System.out.println("로그인 후 삭제 가능합니다.");
			return View.MEMBER_LOGIN; // 로그인 화면으로 이동

		}

		if (perm.equals("ADMIN")) { // 관리자는 다 삭제 가능
			res = reviewDao.adminDelete(param);
		} else { // 유저는 자기꺼만 삭제 가능
			param.add(memID);
			res = reviewDao.memDelete(param);
		}

		if (res > 0) {
			System.out.println("리뷰가 삭제되었습니다");
		} else {
			System.out.println("리뷰가 삭제되지 않았습니다.");
		}

		if (perm.equals("ADMIN")) {
			return View.ADMIN_MENU;
		} else {
			if (Controller.sessionStorage.get("loginInfo") == null) { // 로그인 안되어 있음
				return View.HOME;
			} else { // 멤버 로그인 됨
				return View.USERHOME;
			}
		}
	}

	public int detail() {
		String perm = Controller.sessionStorage.get("role").toString();

		System.out.print("상세히 볼 리뷰번호 >>> ");
		int review_no = ScanUtil.nextInt();

		String res = reviewDao.detail(review_no);

		System.out.println("내용: " + res);

		if (perm.equals("ADMIN")) {
			return View.ADMIN_MENU;
		} else {
			if (Controller.sessionStorage.get("loginInfo") == null) { // 로그인 안되어 있음
				return View.HOME;
			} else { // 멤버 로그인 됨
				return View.USERHOME;
			}
		}

	}

}