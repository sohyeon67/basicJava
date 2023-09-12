package ddit.chap02.task;

public class Task2 {

	public static void main(String[] args) {
		double y = 365.2422;
		
		double days = (int)y;	//365
		
		double hours = (y-days)*24;	//(365.2422-365)*24
		
		double minutes = hours*60-(int)hours*60;
		
		double seconds = minutes*60-(int)minutes*60;
		
		System.out.println((int)days+"일 "+(int)hours+"시간 "+(int)minutes+"분 "+(int)seconds+"초 입니다.");
	}

}
