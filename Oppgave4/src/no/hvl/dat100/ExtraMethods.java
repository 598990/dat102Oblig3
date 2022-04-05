package no.hvl.dat100;

public class ExtraMethods {

	public static int minimumHeight(int n) {
		return (int) (Math.log(n) / Math.log(2));
	}
	
	public static int maximumHeight(int n) {
		return n-1;
	}
	
}
