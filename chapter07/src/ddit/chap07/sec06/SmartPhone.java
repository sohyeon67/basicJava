package ddit.chap07.sec06;

public class SmartPhone extends Computer implements Phone, Repair {
	boolean power;

	@Override
	public void call() {
		String number1 = String.valueOf(PHONE_NUM_1);
		String number2 = String.valueOf(PHONE_NUM_2);

		System.out.println("간첩신고는 " + number1 + number1 + number2 + "입니다");
	}

	@Override
	public void turnOn() {
		if (power != true)
			power = !power;
	}

	@Override
	public void turnOff() {
		if (power)
			power = !power;
	}

}
