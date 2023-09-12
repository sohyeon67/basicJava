package ddit.chap02.sec03;

public class HomeWork01 {

	public static void main(String[] args) {
		//날수
		double year=365.2422;
		int days=(int)year;
		
		//시간
		double hours=(year-days)*24;
		int hour=(int)hours;
		
		//분
		double minutes=(hours-hour)*60;
		int minute=(int)minutes;
		
		//초
		double seconds=(minutes-minute)*60;
		int second=(int)seconds;
		
		System.out.println("1년은 "+days+"일 "+hour+"시간 "+minute+"분 "+second+"초 입니다..");
		System.out.println();
	}

}
