package ddit.chap11.string;

public class StringExample {

	public static void main(String[] args) {
		// String class : 불변(immutable)의 문자열 자료 취급
		// 1. 부분문자열 추출 : substring(int startindex, int endindex) endindex-1 까지
		String str = "무궁화 꽃이 피었습니다.";
		System.out.println(str.substring(0, str.length() - 1));
		System.out.println(str.substring(0, 6));
		// 기본타입 => 문자열
		// String.valueOf(기본 타입 데이터);
		// 기본 타입 데이터 + ""
		int num = 1001;
		String numStr = String.valueOf(num);
		System.out.println(numStr + 99);
		System.out.println(num + "" + 99);
		// 문자열 => 기본
		// Wrapper.parse기본타입 (문자열)
		String flag1 = "true";
		boolean flag = Boolean.parseBoolean(flag1);
		System.out.println(!flag);
	}

}
