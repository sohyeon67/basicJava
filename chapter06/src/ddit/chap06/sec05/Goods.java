package ddit.chap06.sec05;

public class Goods { //extends Object
	private String itemName;
	int price;
	int bonusPoint;

	Goods() { }

	Goods(String itemName, int price) {
		this.itemName = itemName;
		this.price = price;
		this.bonusPoint = (int) (price * 0.001);
	}
	
	
	 public String toString() { //�� child�� �´� �̸� ���
		 return itemName;
	 }
	 
	
}
