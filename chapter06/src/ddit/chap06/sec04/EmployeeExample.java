package ddit.chap06.sec04;

import java.util.Scanner;

public class EmployeeExample {
	Scanner sc = new Scanner(System.in);
	Employees[] employee = { new Employees("202310001", "������", "����������"), 
							 new Employees("202111012", "��ο�", "����������"),
							 new Employees("202011031", "�̼���", "����������"), 
							 new Employees("202210001", "���ڹ�", "����������"),
							 new Employees("202011001", "���ڹ�", "����������") }; // ��ü �迭

	public static void main(String[] args) {
		EmployeeExample emp = new EmployeeExample(); //������ �����

		while (true) {
			int choice = emp.view(); // ����â

			switch (choice) {
			case 1:
				emp.selectList();
				break;
			case 2:
				emp.selectOne();
				break;
			case 3:
				emp.changeSalary();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�...");
				System.exit(0);
			default:
				System.out.println("�۾���ȣ�� �߸� �����߽��ϴ�...");
			}
		}
	}

	public int view() {
		System.out.println("[[�����ȸ]]");
		System.out.println(" 1. ��ü ��ȸ");
		System.out.println(" 2. �μ��� ��ȸ");
		System.out.println(" 3. �޿� ����");
		System.out.println(" 9. ����");
		System.out.println("------------------------");
		System.out.print("���� >> ");
		int choice = sc.nextInt();

		return choice;
	}


	public void selectList() {
		System.out.println("�μ���            �����ȣ             �̸�   �޿�");
		System.out.println("---------------------------------");
		for (int i = 0; i < employee.length; i++) {
			System.out.printf("%-11s", employee[i].getDeptName());
			System.out.printf("%-11s", employee[i].getEmpID());
			System.out.printf("%-5s", employee[i].getEmpName());
			System.out.printf("%-20d\n", employee[i].getSalary());
		}
		System.out.println("---------------------------------");
	}

	public void selectOne() {
		System.out.print("��ȸ�� �μ��� : ");
		// String dept = sc.nextLine(); nextInt() ������ nextLine()���� ���๮�ڸ� ���� ��Ȳ
		String dept = sc.next();

		System.out.println("�μ���            �����ȣ             �̸�   �޿�");
		System.out.println("---------------------------------");
		for (int i = 0; i < employee.length; i++) {
			if (dept.equals(employee[i].getDeptName())) {
				System.out.printf("%-11s", employee[i].getDeptName());
				System.out.printf("%-11s", employee[i].getEmpID());
				System.out.printf("%-5s", employee[i].getEmpName());
				System.out.printf("%-20d\n", employee[i].getSalary());
			}
		}
		System.out.println("---------------------------------");
	}

	public void changeSalary() {
		System.out.print("�޿��� �ٲ� ����� ��ȣ : ");
		String empID = sc.next();
		
		for (int i = 0; i < employee.length; i++) {
			if (empID.equals(employee[i].getEmpID())) {
				System.out.print("������ �޿� : ");
				int salary = sc.nextInt();
				employee[i].setSalary(salary);
			}
			
		}
	}

}