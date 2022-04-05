package no.hvl.dat102;

public class MainTestInsertionSortDouble {

	public static void main(String[] args) {
		// Calculates the time 10 times and finds the average time
				double[] times = new double[10];
				for(int i = 0; i < 10; i++) {
					
					// Generating an Integer array
					Integer[] a = new Integer[70000];
					
					for(int j = 0; j < a.length; j++) {
						a[j] = (int) Math.floor(Math.random() * a.length);
					}
					
					// Current time before sorting
					long start = System.nanoTime();
					
					InsertionSort.insertionSortDouble(a, a.length);
					
					// Current time after sorting
					long end = System.nanoTime();
					
					// Time it took to sort in seconds
					double time = (double) (end - start)/1000000000;
					
					times[i] = time;
					
					System.out.println(time);
				}
				System.out.println();
				
				double total = 0;
				
				//Adds together all the times
				for(double d : times) {
					total += d;
				}
				
				// Prints out the average time
				System.out.println(total/10);
	}
	
}
