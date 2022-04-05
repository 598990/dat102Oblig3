package no.hvl.dat102;

public class MainWithSimplification {

	public static void main(String[] args) {

		// Calculates the time 10 times and finds the average time
		double[] times = new double[10];
		for (int i = 0; i < 10; i++) {

			// Generating an Integer array
			Integer[] a = new Integer[70000];

			for (int j = 0; j < a.length; j++) {
				a[j] = (int) Math.floor(Math.random() * a.length);
			}

			// Current time before sorting
			long start = System.nanoTime();

			// Index of the smallest number
			Integer index = InsertionSort.findMin(a, a.length);

			//swaps the smallest number to index 0
			Integer temp = a[index];
			a[index] = a[0];
			a[0] = temp;

			// Method with specified start location
			InsertionSort.insertionSort(a, 1, a.length);

			// Current time after sorting
			long end = System.nanoTime();

			// Time it took to sort in seconds
			double time = (double) (end - start) / 1000000000;

			times[i] = time;

			System.out.println(time);
		}
		System.out.println();

		double total = 0;

		// Adds together all the times
		for (double d : times) {
			total += d;
		}

		// Prints out the average time
		System.out.println(total / 10);

	}

}
