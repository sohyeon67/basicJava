package ddit.chap07.sec05;

public abstract class Phone {
	String phoneNumber;
	
	Phone(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	
	public void call() {
		System.out.println("��ȭ�ϴ�");
	}
	
	public abstract void turnOn();
}
