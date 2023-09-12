package ddit.chap02.sec02;

//실수자료형 : float, double
public class FloatExample {

	public static void main(String[] args) {
		// 1)float : 4byte(1bit(부호), 8bit(지수), 23bit(가수:소수점 이하의 수)
		// 1.4e-45 ~ 3.4e+38(long보다 큰 범위)
		// 리터럴 끝에 F(f) 추가해야 함. ex)3.1415926f
		// 2)double : 8byte(1bit(부호), 11bit(지수), 52bit(가수:소수점 이하의 수)
		// 4.9e-324 ~ 1.8e+308
		// 기본실수 타입
		// 리터럴 끝에 D(d) 추가하거나 생략할 수 있음

		float f1 = 3.14f;
		float f2 = 0.1f;

		double d1 = 3.14;
		double d = 3.14d;
		double d2 = 0.1;
		double d3 = f2;
		
		if(f2==d2) {
			System.out.println("같은 크기의 수");
		}
		else {
			System.out.println("다른 크기의 수");
			System.out.println("d3 : "+d3);
		}
		
	}

}
