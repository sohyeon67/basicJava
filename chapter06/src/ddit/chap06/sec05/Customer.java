package ddit.chap06.sec05;

public class Customer {
	private int money;
	private int bonusPoint;
	private String cart = "";

	Customer() {

	}
	
	public void buy(Goods goods) { // 부모 클래스 사용
		money = money + goods.price; // private 붙으면 사용 못함
		bonusPoint += goods.bonusPoint;
		cart = cart + "," + goods;
	}

	/*
	 * public void buy(Tv t) { money = money + t.price; // private 붙으면 사용 못함
	 * bonusPoint += t.bonusPoint; cart = cart + "," + t; }
	 * 
	 * public void buy(Computer c) { money = money + c.price; // private 붙으면 사용 못함
	 * bonusPoint += c.bonusPoint; cart = cart + "," + c; }
	 * 
	 * public void buy(Audio a) { money = money + a.price; // private 붙으면 사용 못함
	 * bonusPoint += a.bonusPoint; cart = cart + "," + a; }
	 */

	public void summary() {
		System.out.println("구입품목 : " + cart.substring(1));
		System.out.println("구입금액 합계 : " + money);
		System.out.println("적립포인트 : " + bonusPoint);
	}

	
}
