package ddit.chap06.sec03;

public class CylinderEx {

	public static void main(String[] args) {
		Cylinder cylinder = new Cylinder(new Circle(2.8), 5.6);
		cylinder.getVolume();
	}
}
