package ddit.chap07.sec07;

class A {
	public void methodA(B b) {
		b.methodB();
	}
	
	public void methodA(I i) { // CŬ���� ���� �� ����. upcast. ������
		i.methodB();
	}
}

class B implements I {
	public void methodB() {
		System.out.println("BŬ������ methodB");
	}
}

class C implements I {
	public void methodB() {
		System.out.println("CŬ������ methodB");
	}
}

public interface I {
	void methodB(); // �߻� �޼���
}
