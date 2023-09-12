package ddit.chap11.math;

import java.util.Arrays;

public class MathExample {

	public static void main(String[] args) {
		// 수학적 기능을 수행하는 메서드 제공 - random()
		// max(val1, val2) : 두 매개변수(val1, val2) 중 큰값을 반환
		// 10명의 마일리지를 배열에 저장한 후 그 값이 1000미만이면 1000을 부여하시오
		// 오라클에서 SELECT MEM_NAME 회원명, GREATEST(1000,MEM_MILEAGE) 변경마일리지, MEM_MILEAGE 원본마일리지 FROM MEMBER;

		int[] mileage = { 1000, 2300, 3500, 1700, 6500, 2700, 800, 1500, 900, 1100 };
		System.out.println("원본 : " + Arrays.toString(mileage));
		for(int i=0; i<mileage.length; i++) {
			mileage[i]=Math.max(1000, mileage[i]);
		}
		System.out.println("변경 : " + Arrays.toString(mileage));

	}

}
