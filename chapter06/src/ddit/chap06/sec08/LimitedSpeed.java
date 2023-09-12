package ddit.chap06.sec08;

public enum LimitedSpeed {
	SchoolZone(30), DownTown(50), CountrySide(70);

	private final int values; // �ε��� 30, 50, 70�� �����ϴ� ���

	LimitedSpeed(int values) { // enum Ŭ���� ������ �޼���(�ε����� ������ enum Ŭ����)
		this.values = values;
	}
	
	public int getValues() { // �ش� �ε���(values)�� enum Ŭ������ ȣ���� ��ġ�� ��ȯ
		return values;
	}
	
}
