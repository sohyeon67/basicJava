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
		return "탱크";
	}
}

class DropShip extends GroundUnit implements Repairable {
	DropShip() {
		super(125);
		hitPoint = MAX_HP;
	}
	
	@Override
	public String toString() {
		return "수송선";
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
			System.out.println(u + "의 수리 완료");
		}
	}

	@Override
	public String toString() {
		return "수리공장";
	}
}

class Marine extends GroundUnit {
	Marine() {
		super(30);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "해병";
	}
}
