package util;

public interface View {
	int HOME = 1;
	int MAIN = 11;
	int USERHOME = 12;
	
	// 멤버 담당 팀원
	int MEMBER = 2;
	int MEMBER_SIGNUP = 21;
	int MEMBER_LOGIN = 22;
	int MEMBER_RESIGN = 23;
	
	// 관리자 담당
	int ADMIN = 3;
	int ADMIN_LOGIN = 31;
	int ADMIN_MENU = 32;
	int ADMIN_TOTAL = 33;
	
	// 메뉴 담당
	int MENU = 4;
	int MENU_LIST = 41;
	int MENU_INSERT = 42;
	int MENU_UPDATE = 43;
	int MENU_DELETE = 44;
	
	// 공지사항 팀원
	int NOTICE = 5;
	int NOTICE_LIST = 51;
	int NOTICE_DETAIL = 52;
	int NOTICE_INSERT = 53;
	int NOTICE_UPDATE = 54;
	int NOTICE_DELETE = 55;
	
	// 후기
	int REVIEW = 6;
	int REVIEW_LIST = 61;
	int REVIEW_DETAIL = 62;
	int REVIEW_INSERT = 63;
	int REVIEW_UPDATE = 64;
	int REVIEW_DELETE = 65;

	// 주문
	int ORDER = 7;
	int ORDER_LIST = 71;
	int ORDER_DETAIL = 72;
	int ORDER_INSERT = 73; // 고객만 가능
	int ORDER_DELETE = 74;

	
}