package ddit.chap05.sec01;

public class ArrayExample02 {

	public static void main(String[] args) {
		//5���� ģ���̸��� �迭�� ����(name)�ϰ� 3��° ����� ģ���̸��� ���
		String[] name = new String[5];	//�������� �ʱ�ȭ �ʿ�. �����ָ� ����. �迭�� ����
		name[0]="ȫ�浿";
		name[1]="�̼���";
		name[2]="������";
		name[3]="ȫ���";
		name[4]="������";
		
		String[] name1 = new String[] {"ȫ�浿", "�̼���", "������", "ȫ���", "������"};
		
		String[] name2 = {"ȫ�浿", "�̼���", "������", "ȫ���", "������"};
		
		System.out.println(name[2]);
	}
}
