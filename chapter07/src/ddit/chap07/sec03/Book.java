package ddit.chap07.sec03;

public class Book {
	String isbn; // 도서번호
	String title; // 제목
	int price; // 가격

	Book() {
	} // 기본 생성자

	Book(String isbn, String title, int price) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}

	public void setSalePrice(double discountRate) { // 할인가격 설정
		price = price - (int) (price * discountRate);
	}
	
	public void printInfo() {
		System.out.println("제목 : "+title);
		System.out.println("가격 : "+price);
	}
}
