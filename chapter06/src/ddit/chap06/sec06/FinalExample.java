package ddit.chap06.sec06;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FinalExample {

	public static void main(String[] args) {
		Final f1 = new Final("학교주변");
		System.out.println(f1.loc + "에서 허용된 속도 : " + f1);

		Final f2 = new Final("시외");
		System.out.println(f2.loc + "에서 허용된 속도 : " + f2);

		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String formatNow = now.format(formatter);
		System.out.println(now); //윈도우?
		System.out.println(formatNow);
	}

}

class Final {
	final int SCHOOL_ZONE_SPEED = 30;
	final int DOWN_TOWN_SPEED = 50;
	final int COUNTRY_SIDE_SPEED = 70;
	String loc;

	Final(String loc) { // 생성자
		this.loc = loc;
	}

	@Override
	public String toString() {
		int speed = 0;
		if (loc.equals("학교주변")) {
			speed = SCHOOL_ZONE_SPEED;
		} else if (loc.equals("시내")) {
			speed = DOWN_TOWN_SPEED;
		} else if (loc.equals("시외")) {
			speed = COUNTRY_SIDE_SPEED;
		}
		return speed + "km/h";
	}
}
