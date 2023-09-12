package ddit.chap06.sec02;

public class StaticExample {

	public static void main(String[] args) {
		/*
		Product p1 = new Product();
		p1.showProduct();
		
		Product p2 = new Product();
		p2.showProduct();
		
		Product p3 = new Product();
		p3.showProduct();
		*/
		
		Product.showProduct(); //static 메서드는 객체 생성 안해도 된다.
		Product.showProduct();
		Product.showProduct();
	}

}
