package ddit.chap07.sec03;

public class BookExample {

	public static void main(String[] args) {
		Book b = new Book("4848-71", "난쟁이가 쏘아올린", 15000);
		
		/*
		 * Novel n1=new Novel("1111-22", "아낌없이 주는 나무", 5000, "동화"); n1.printInfo();
		 * n1.setSalePrice(0.2); n1.printInfo();
		 * 
		 * TextBook t1 = new TextBook("3535-55", "Real-World Software", 18000, "SE");
		 * t1.printInfo(); t1.setSalePrice(0.1); t1.printInfo();
		 */
		
		Book b1 = new Novel("1111-22", "아낌없이 주는 나무", 5000, "동화");
		Book b2 = new TextBook("3535-55", "Real-World Software", 18000, "SE");
		
		b1.printInfo(); //오버라이딩된 메서드
		//b1.refund(); 부모에 없는 메서드
		//b2.major="IT Tech";
		//TextBook 클래스의 supplyBook()호출이 요구될때 -- down casting
		if(b2 instanceof TextBook) {
			TextBook tb1 = (TextBook)b2;
			tb1.supplyBook("한국대학");
		}
	}

}
