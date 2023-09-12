package ddit.chap07.sec01;

public class Student extends People {
	int grade;
	String name; // null

	Student(String name, int age, String gender, int grade) {
		super(name, age, gender); // ù���� super()
		this.grade = grade;
	}

	public void printInfo() {
		System.out.println("�г� : " + grade);
		System.out.println("�̸� : " + super.name);
		System.out.println("���� : " + age);
		System.out.println("���� : " + gender);
	}
}
