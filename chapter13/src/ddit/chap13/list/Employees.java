package ddit.chap13.list;

public class Employees {
	String eid;
	String name;
	int salary;

	Employees(String eid, String name, int salary) {
		this.eid = eid;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
