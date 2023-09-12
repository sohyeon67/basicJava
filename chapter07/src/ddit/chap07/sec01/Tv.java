package ddit.chap07.sec01;

public class Tv extends Product {
	double discountRate;

	Tv(String prodName, int price, double discountRate) {
		super(prodName, (int) (price * (1 - discountRate)));
		this.discountRate = discountRate;
	}

}
