package ddit.chap06.sec01;
/*
 * ���� 1 -������ �����ϴ� Student Ŭ������ �ۼ��Ͻÿ�.
�� String���� �а��� �������� �й��� �ʵ�� ����
�� StudentExample Ŭ������ main() �޼ҵ忡�� Student ��ü�� �����Ͽ� �а��� �й� �ʵ忡 ������ ���� �Է� �� ���
 */
public class StudentExample {

	public static void main(String[] args) {
		Student std = new Student();
		Student std1 = new Student("�濵�а�", 202322222);
		
		std.setMajor("�濵�а�");
		std.setStudID(202301015);
		
		System.out.println("�а� : "+std.getMajor());
		System.out.println("�й� : "+std.getStudID());
	}
}
