package no.hvl.dat102;

public class InsertionSort {

	/**
	 * Insertion sort without specified start location
	 * @param a array of elements
	 * @param n amount of elements to be sorted
	 */
	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int n) {
		insertionSort(a, 0, n);
	}

	/**
	 * Insertion sort with specified start location
	 * @param a array of elements
	 * @param start first index to sort from
	 * @param end last index to sort to
	 */
	public static <T extends Comparable<? super T>> void insertionSort(T[] a, int start, int end) {
		for(int i = start + 1; i < end; i++) {
			T temp = a[i];
			int j = i-1;
			while (j >= start) {
				if(temp.compareTo(a[j]) < 0) {
					a[j + 1] = a[j];
					j--;
				}
				else {
					break;
				}
			}
			a[j+1] = temp;
		}
	}
	
	/**
	 * Insertion sort without specified start location, adds two elements at the same time
	 * @param a array of elements
	 * @param n amount of elements to be sorted
	 */
	public static <T extends Comparable<? super T>> void insertionSortDouble(T[] a, int n) {
		insertionSortDouble(a, 0, n);
	}
	
	/**
	 * Insertion sort with specified start location, adds two elements at the same time
	 * @param a array of elements
	 * @param start first index to sort from
	 * @param end last index to sort to
	 */
	public static <T extends Comparable<? super T>> void insertionSortDouble(T[] a, int start, int end) {
		for(int i = start + 1; i < end; i = i+2) {
			T temp1 = a[i];
			T temp2;
			if(i+1 < end) {
				temp2 = a[i+1];
			}
			else {
				temp2 = a[i-1];
			}
			int j = i-1;
			while (j >= start) {
				if(temp1.compareTo(a[j]) < 0 || temp2.compareTo(a[j]) < 0) {
					if(temp1.compareTo(a[j]) < 0 && temp2.compareTo(a[j]) < 0) {
						a[j+2] = a[j];
						if(temp1.compareTo(temp2) < 0) {
							a[j] = temp1;
							a[j+1] = temp2;
							j--;
						}
						else {
							a[j] = temp2;
							a[j+1] = temp1;
							j--;
						}
					}
					else if(temp1.compareTo(a[j]) < 0) {
						a[j + 1] = a[j];
						a[j] = temp1;
						j--;
						
					}
					else {
						a[j + 1] = a[j];
						a[j] = temp2;
						a[j+2] = temp1;
						j--;
					}
				}
				else {
					break;
				}
			}
		}
	}

	/**
	 * Find the index of the smallest element
	 * @param a array of elements
	 * @param n amount of elements to be sorted
	 * @return index of the smallest element
	 */
	public static <T extends Comparable<? super T>> int findMin(T[] a, int n) {
		int index = 0;
		
		for(int i = 0; i < n; i++) {
			if(a[i].compareTo(a[index]) < 0) {
				index = i;
			}
		}
		
		return index;
	}
	
	
}
