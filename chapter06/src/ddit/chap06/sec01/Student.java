package ddit.chap06.sec01;

public class Student {
	private String major;
	private int studID;

	Student() {
	} // �Ű������� �޴� �����ڸ� ������ָ� �����Ϸ��� ����Ʈ �����ڸ� ���������� ����. ���������� �����ֱ�

	Student(String major, int studID) { // ��� �ʵ� �ʱ�ȭ
		this.major = major;
		this.studID = studID;
	}

	public String getMajor() { // getter
		return major;
	}

	public int getStudID() { // getter
		return studID;
	}

	public void setMajor(String major) { // setter, �� ����
		this.major = major;
	}

	public void setStudID(int studID) { // setter
		this.studID = studID;
	}
}
