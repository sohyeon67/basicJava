package ddit.chap07.sec07;

class A {
	public void methodA(B b) {
		b.methodB();
	}
	
	public void methodA(I i) { // C클래스 받을 수 있음. upcast. 다형성
		i.methodB();
	}
}

class B implements I {
	public void methodB() {
		System.out.println("B클래스의 methodB");
	}
}

class C implements I {
	public void methodB() {
		System.out.println("C클래스의 methodB");
	}
}

public interface I {
	void methodB(); // 추상 메서드
}
