package ddit.chap02.sec03;

public class HomeWork01 {

	public static void main(String[] args) {
		//����
		double year=365.2422;
		int days=(int)year;
		
		//�ð�
		double hours=(year-days)*24;
		int hour=(int)hours;
		
		//��
		double minutes=(hours-hour)*60;
		int minute=(int)minutes;
		
		//��
		double seconds=(minutes-minute)*60;
		int second=(int)seconds;
		
		System.out.println("1���� "+days+"�� "+hour+"�ð� "+minute+"�� "+second+"�� �Դϴ�..");
		System.out.println();
	}

}
