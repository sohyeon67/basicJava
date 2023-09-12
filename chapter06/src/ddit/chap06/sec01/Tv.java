package ddit.chap06.sec01;

//제조사, 생산년도, 크기
public class Tv { // 명시적 초기화
	String company = "SAMSUNG";
	int year = 2022;
	double size = 60.5;
	
	{// 초기화 블록
		company="LG";
		year=2023;
		size=75.5;
	}
	
	Tv(String company, int year, double size) { // 생성자
		this.company=company;
		this.year=year;
		this.size=size;
	}
}
