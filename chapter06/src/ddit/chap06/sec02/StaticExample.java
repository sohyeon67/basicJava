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
		
		Product.showProduct(); //static �޼���� ��ü ���� ���ص� �ȴ�.
		Product.showProduct();
		Product.showProduct();
	}

}
