package ddit.chap07.sec03;

public class BookExample {

	public static void main(String[] args) {
		Book b = new Book("4848-71", "�����̰� ��ƿø�", 15000);
		
		/*
		 * Novel n1=new Novel("1111-22", "�Ƴ����� �ִ� ����", 5000, "��ȭ"); n1.printInfo();
		 * n1.setSalePrice(0.2); n1.printInfo();
		 * 
		 * TextBook t1 = new TextBook("3535-55", "Real-World Software", 18000, "SE");
		 * t1.printInfo(); t1.setSalePrice(0.1); t1.printInfo();
		 */
		
		Book b1 = new Novel("1111-22", "�Ƴ����� �ִ� ����", 5000, "��ȭ");
		Book b2 = new TextBook("3535-55", "Real-World Software", 18000, "SE");
		
		b1.printInfo(); //�������̵��� �޼���
		//b1.refund(); �θ� ���� �޼���
		//b2.major="IT Tech";
		//TextBook Ŭ������ supplyBook()ȣ���� �䱸�ɶ� -- down casting
		if(b2 instanceof TextBook) {
			TextBook tb1 = (TextBook)b2;
			tb1.supplyBook("�ѱ�����");
		}
	}

}
