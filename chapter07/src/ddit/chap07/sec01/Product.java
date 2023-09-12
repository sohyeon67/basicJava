package ddit.chap07.sec01;

public class Product {
	String prodName;
	int price;

	Product(String prodName, int price) {
		this.prodName = prodName; // this는 멤버변수 prodName을 참조하기 위함
		this.price = price;
	}

	@Override
	public String toString() {
		// return getClass().getName()+'@'+Integer.toHexString(hashCode());
		return "제품명 : " + prodName + "\n가격 : " + price;
	}
}
