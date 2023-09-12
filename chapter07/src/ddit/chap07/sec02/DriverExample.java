package ddit.chap07.sec02;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		Taxi taxi = new Taxi();
		
		driver.drive(new Bus()); //Vehicle vehicle = new Bus();
		driver.drive(taxi);	//Vehicle vehicle = taxi; taxi = new Tax();
	}

}
