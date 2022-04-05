package no.hvl.dat102;

public class Main {

	public static void main(String[] args) {
		
		Integer[] a = {5, 2, 7, 1, 7, 9, 2, 10, 0, 28, 1, 7};
		
		Sorting.insertionSort(a, a.length);
		
		for(Integer i : a) {
			System.out.println(i);
		}
		
	}

}
