package ddit.chap07.sec01;

public class InheritanceExample02 {

	public static void main(String[] args) {
		Tv t = new Tv("LG Caption 70", 1500000, 0.25);
		System.out.println(t);
		System.out.println("«“¿Œ¿≤ : " + t.discountRate * 100 + "%");
	}

}
