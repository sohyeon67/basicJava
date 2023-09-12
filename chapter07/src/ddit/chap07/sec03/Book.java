package ddit.chap07.sec03;

public class Book {
	String isbn; // ������ȣ
	String title; // ����
	int price; // ����

	Book() {
	} // �⺻ ������

	Book(String isbn, String title, int price) {
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}

	public void setSalePrice(double discountRate) { // ���ΰ��� ����
		price = price - (int) (price * discountRate);
	}
	
	public void printInfo() {
		System.out.println("���� : "+title);
		System.out.println("���� : "+price);
	}
}
