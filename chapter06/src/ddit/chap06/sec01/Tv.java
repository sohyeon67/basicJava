package ddit.chap06.sec01;

//������, ����⵵, ũ��
public class Tv { // ����� �ʱ�ȭ
	String company = "SAMSUNG";
	int year = 2022;
	double size = 60.5;
	
	{// �ʱ�ȭ ���
		company="LG";
		year=2023;
		size=75.5;
	}
	
	Tv(String company, int year, double size) { // ������
		this.company=company;
		this.year=year;
		this.size=size;
	}
}
