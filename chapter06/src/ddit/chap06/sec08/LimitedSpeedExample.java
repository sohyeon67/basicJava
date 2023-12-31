package ddit.chap06.sec08;

import java.util.Scanner;

public class LimitedSpeedExample {

	public static void main(String[] args) {
		String str = ""; //valueOf()의 매개변수
		Scanner sc = new Scanner(System.in);

		System.out.println("1. 스쿨존");
		System.out.println("2. 시내주행");
		System.out.println("3. 시외주행");
		System.out.println("------------------");

		System.out.print("번호 >> ");
		int num = sc.nextInt();

		switch (num) {
		case 1:
			str = "SchoolZone";
			break;
		case 2:
			str = "DownTown";
			break;
		case 3:
			str = "CountrySide";
			break;
		default:
			System.out.println("작업번호 오류");
			System.exit(0);
		}

		// 열거형에서 사용되는 메서드 : valueOf(), oridinal(), values() 메서드가 가장 많이 사용
		// valueOf(String arg) : arg를 enum객체에서 가져옴. 없으면 오류 발생
		// values() : enum 요소들을 순서대로 enum 타입의 배열로 반환
		// 열거타입변수명.oridinal() : 해당 변수의 값이 enum에 저장된 순번(배열index) 반환 => 0,1,2...
		LimitedSpeed lSpeed = LimitedSpeed.valueOf(str);
		switch (lSpeed) {
		case SchoolZone:
			System.out.println(lSpeed.SchoolZone + "에서는 " + lSpeed.getValues() + "km/h 미만의 속도를 유지해야합니다.");
			break;
		case DownTown:
			System.out.println(lSpeed.DownTown + "에서는 " + lSpeed.getValues() + "km/h 미만의 속도를 유지해야합니다.");
			break;
		case CountrySide:
			System.out.println(lSpeed.CountrySide + "에서는 " + lSpeed.getValues() + "km/h 미만의 속도를 유지해야합니다.");
			break;
		}
		
		for(LimitedSpeed var:lSpeed.values()) {
			System.out.println(var+"->"+var.ordinal());
		}
	}
}
