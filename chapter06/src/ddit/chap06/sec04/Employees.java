package ddit.chap06.sec04;

// ���Ŭ����
// �����ȣ(empID), �����(empName), �μ���(deptName), �޿�(salary)
// 5���� ��������� �����Ͽ� �����ϰ�
// ��ü��ȸ, ������ȸ�� �����ϴ� �޼��� ����
public class Employees {
	private String empID;

	private String empName;
	private String deptName;
	private int salary;

	// �⺻������
	public Employees() {

	}

	// �����ȣ, �����, �μ��� �Է¹޴� ������(salary�� 0���� ����)
	public Employees(String empID, String empName, String deptName) {
		this.empID = empID;
		this.empName = empName;
		this.deptName = deptName;
		this.salary = 0;
	}

	// �޿��� �����ϴ� �޼���
	// setter(�����ϴ� �޼���) this����ϱ�
	public void setSalary(int salary) {
		this.salary=salary;
	}


	public String getEmpID() {
		return empID;
	}

	public String getEmpName() {
		return empName;
	}

	public String getDeptName() {
		return deptName;
	}        

	public int getSalary() {
		return salary;
	}

}