package ddit.chap11.string;

// 긴 문자열 결합연산이나 반복되는 문자열 결합 연산에 사용
// StringBuffer - thread safe, StringBuilder - 일반적인 문자열 결합연산에 효율적
// StringBuilder의 주요메서드
// 1. 생성자
// StringBuilder([int capacity]) : capacity-버퍼사이즈
// 2. append(데이터) : 기존의 문자열 끝에 '데이터'를 추가하여 저장
// 3. insert(int offset, String str)
// 4. replace(int index1, int index2, String str) : index1부터 index2-1까지 문자열을 str로 교체
// 5. toString() : String타입으로 변환
public class StringBuilderExample {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(); // 디폴트 버퍼사이즈 16?
		sb.append(" select mem_id, mem_name, mem_hp, mem_mileage \n");
		sb.append("    from member \n");
		sb.append("    where mem_regno1 like '0%' ");
		String sql = sb.toString();
		System.out.println(sql);

		StringBuilder str = new StringBuilder("대한민국대전시");
		str.insert(4, "오룡");
		
		System.out.println(str.toString());
		
		str.replace(4, 9, "계룡");
		System.out.println(str.toString());
	}

}
