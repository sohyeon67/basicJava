package ddit.chap07.sec05;

public abstract class SmartPhone extends Phone {
	String model;

	SmartPhone(String phoneNumber, String model) {
		super(phoneNumber);
		this.model = model;
	}

	public void game() {
		System.out.println("���ӱ���� ������");
	}
}

class IPhone extends SmartPhone {
	IPhone(String phoneNumber, String model) {
		super(phoneNumber, model);
	}

	@Override
	public void turnOn() {
		System.out.println("������ư ���");
	}

}
