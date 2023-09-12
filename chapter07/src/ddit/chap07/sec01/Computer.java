package ddit.chap07.sec01;

public class Computer extends Product {
	double discountRate;

	Computer(String prodName, int price, double discountRate) {
		super(prodName, price);
		this.discountRate = discountRate;
	}

	@Override
	public String toString() {
		return "제품명 : " + prodName + ", 가격 : " + price + ", 할인율 : " + discountRate;
	}
}
