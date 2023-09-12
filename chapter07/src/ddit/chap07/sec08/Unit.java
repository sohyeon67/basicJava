package ddit.chap07.sec08;

interface Repairable {
}

public class Unit {
	int hitPoint;
	final int MAX_HP;

	Unit(int hp) {
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit {
	GroundUnit(int hp) {
		super(hp);
	}
}

class AirUnit extends Unit {
	AirUnit(int hp) {
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "��ũ";
	}
}

class DropShip extends GroundUnit implements Repairable {
	DropShip() {
		super(125);
		hitPoint = MAX_HP;
	}
	
	@Override
	public String toString() {
		return "���ۼ�";
	}
}

class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(50);
		hitPoint = MAX_HP;
	}

	public void repair(Repairable r) {
		if (r instanceof Unit) {
			Unit u = (Unit) r;
			while (u.hitPoint != u.MAX_HP) {
				u.hitPoint++;
			}
			System.out.println(u + "�� ���� �Ϸ�");
		}
	}

	@Override
	public String toString() {
		return "��������";
	}
}

class Marine extends GroundUnit {
	Marine() {
		super(30);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "�غ�";
	}
}