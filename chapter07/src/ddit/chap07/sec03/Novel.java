package ddit.chap07.sec03;

public class Novel extends Book {
	String genre; // 장르

	Novel() {
	}

	Novel(String isbn, String title, int price, String genre) {
		super(isbn, title, price);
		this.genre = genre;
	}

	@Override
	public void printInfo() {
		System.out.println("장르 : "+genre);
		System.out.println("제목 : "+title);
		System.out.println("가격 : "+price);
	}
	
	public void refund() {
		System.out.println("소설책을 반품하다");
	}
}
