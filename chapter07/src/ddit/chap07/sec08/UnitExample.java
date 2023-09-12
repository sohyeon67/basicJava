package ddit.chap07.sec08;

public class UnitExample {

	public static void main(String[] args) {
		Tank tank = new Tank();

		Unit u = new Tank();
		SCV scv = new SCV();
		
		scv.repair(new Tank());
		scv.repair(tank);
		//scv.repair(u);
		
	}

}
