package ddit.chap07.sec01;

public class Product {
	String prodName;
	int price;

	Product(String prodName, int price) {
		this.prodName = prodName; // this�� ������� prodName�� �����ϱ� ����
		this.price = price;
	}

	@Override
	public String toString() {
		// return getClass().getName()+'@'+Integer.toHexString(hashCode());
		return "��ǰ�� : " + prodName + "\n���� : " + price;
	}
}
