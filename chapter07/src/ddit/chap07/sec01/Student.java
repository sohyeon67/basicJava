package ddit.chap07.sec01;

public class Student extends People {
	int grade;
	String name; // null

	Student(String name, int age, String gender, int grade) {
		super(name, age, gender); // 첫줄은 super()
		this.grade = grade;
	}

	public void printInfo() {
		System.out.println("학년 : " + grade);
		System.out.println("이름 : " + super.name);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
	}
}
