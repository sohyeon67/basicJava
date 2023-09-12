package ddit.chap06.sec01;

public class Student {
	private String major;
	private int studID;

	Student() {
	} // 매개변수를 받는 생성자를 만들어주면 컴파일러가 디폴트 생성자를 생성해주지 않음. 습관적으로 적어주기

	Student(String major, int studID) { // 멤버 필드 초기화
		this.major = major;
		this.studID = studID;
	}

	public String getMajor() { // getter
		return major;
	}

	public int getStudID() { // getter
		return studID;
	}

	public void setMajor(String major) { // setter, 값 변경
		this.major = major;
	}

	public void setStudID(int studID) { // setter
		this.studID = studID;
	}
}
