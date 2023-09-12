package ddit.chap04.sec03;
/* 1)      2)        3)         4)        5)               6)
 *  *           *      *****      *****           *          *********
 *  **         **      ****        ****          ***          *******
 *  ***       ***      ***          ***         *****          *****
 *  ****     ****      **            **        *******          ***
 *  *****   *****      *              *       *********          *
 */
public class NestedForExample02 {

	public static void main(String[] args) {
		nestedForMethod05();
		System.out.println();
		nestedForMethod06();
	}
	
	public static void nestedForMethod01() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void nestedForMethod02() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<4-i; j++) {	//공백 출력
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) {	//"*" 출력
				System.out.print("*");
			}
			System.out.println();	//줄바꿈
		}
	}
	
	public static void nestedForMethod03() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void nestedForMethod04() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<5-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	//과제 5, 6
	public static void nestedForMethod05() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<4-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<=i; j++) {
				System.out.print("*");
			}
			/*
			for(int j=0; j<=i; j++) {
				if(j==0) {
					continue;
				}
				System.out.print("*");
			}*/
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void nestedForMethod06() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<5-i; j++) {
				System.out.print("*");
			}
			for(int j=0; j<4-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	


}
