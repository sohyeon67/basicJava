package ddit.chap07.sec03;

public class TextBook extends Book {
	String major; // ����

	TextBook() {
	}

	TextBook(String isbn, String title, int price, String major) {
		super(isbn, title, price);
		this.major = major;
	}

	@Override
	public void printInfo() {
		System.out.println("�����о� : " + major);
		System.out.println("���� : " + title);
		System.out.println("���� : " + price);
	}
	
	public void supplyBook(String buyer) {
		System.out.println(buyer+"���� "+title+"å�� ��ǰ�ϴ�");
	}
}