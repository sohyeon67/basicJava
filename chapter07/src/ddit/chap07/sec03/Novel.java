package ddit.chap07.sec03;

public class Novel extends Book {
	String genre; // �帣

	Novel() {
	}

	Novel(String isbn, String title, int price, String genre) {
		super(isbn, title, price);
		this.genre = genre;
	}

	@Override
	public void printInfo() {
		System.out.println("�帣 : "+genre);
		System.out.println("���� : "+title);
		System.out.println("���� : "+price);
	}
	
	public void refund() {
		System.out.println("�Ҽ�å�� ��ǰ�ϴ�");
	}
}
