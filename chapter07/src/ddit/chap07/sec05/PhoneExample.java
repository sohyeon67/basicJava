package ddit.chap07.sec05;

public class PhoneExample {

	public static void main(String[] args) {
//		SmartPhone smartPhone = new IPhone("010-1234-5678", "iphone-14");
//		smartPhone.call();
//		smartPhone.turnOn();
//		smartPhone.game();
		
		Phone phone = new IPhone("010-9876-2424", "iphone-14");
		phone.call();
		phone.turnOn();
		//phone.game();
	}

}
