package ddit.chap06.sec05;

public class Customer {
	private int money;
	private int bonusPoint;
	private String cart = "";

	Customer() {

	}
	
	public void buy(Goods goods) { // �θ� Ŭ���� ���
		money = money + goods.price; // private ������ ��� ����
		bonusPoint += goods.bonusPoint;
		cart = cart + "," + goods;
	}

	/*
	 * public void buy(Tv t) { money = money + t.price; // private ������ ��� ����
	 * bonusPoint += t.bonusPoint; cart = cart + "," + t; }
	 * 
	 * public void buy(Computer c) { money = money + c.price; // private ������ ��� ����
	 * bonusPoint += c.bonusPoint; cart = cart + "," + c; }
	 * 
	 * public void buy(Audio a) { money = money + a.price; // private ������ ��� ����
	 * bonusPoint += a.bonusPoint; cart = cart + "," + a; }
	 */

	public void summary() {
		System.out.println("����ǰ�� : " + cart.substring(1));
		System.out.println("���Աݾ� �հ� : " + money);
		System.out.println("��������Ʈ : " + bonusPoint);
	}

	
}
