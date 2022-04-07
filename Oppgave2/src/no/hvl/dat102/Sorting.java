package no.hvl.dat102;

import java.lang.reflect.Array;

public class Sorting {
	
	/**
	 * Private method to swap two elements in an array
	 * Assumes that all parameters are legal
	 * @param a Array of Objects 
	 * @param i Index of 1st element
	 * @param j Index of 2nd element
	 */
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

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
	 * Find the index of the smallest element
	 * @param a Array of elements
	 * @param from First element to Check
	 * @param to Last element to check
	 * @return Index of the smallest element
	 */
	public static <T extends Comparable<? super T>> int findMin(T[] a, int from, int to) {
		int index = from;
		
		for(int i = from+1; i < to; i++) {
			if(a[i].compareTo(a[index]) < 0) {
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * Selection sort method
	 * @param a Array of elements
	 * @param n Amounts of elements to be sorted
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
		for(int i = 0; i < n; i++) {
			int smallestIndex = findMin(a, i, n);
			swap(a, i, smallestIndex);
		}
	}
	
	
	private final static int MIN_SIZE = 3;
	/**
	 * Quick sort method
	 * @param a Array of elements
	 * @param n Amount of elements
	 */
	public static <T extends Comparable<? super T>> void quickSort(T[]a, int n) {
		quickSort(a, 0, n-1);
	}
	
	/**
	 * Quick sort method
	 * @param a Array of elements
	 * @param min First index
	 * @param max Max index
	 */
	public static <T extends Comparable<? super T>> void quickSort(T[]a, int min, int max) {
		
		//comments explain when all elements are equal
		if(max - min + 1 >= MIN_SIZE) {
			int p = partition(a, min, max); //0 n-1, returns 0
			quickSort(a, min, p-1); //0 -1, fails methods if statement
			quickSort(a, p+1, max);// 1 n-1, one method fails, one will increase by 1 until fails if statement
		} // for less elements, 
		// else do nothing
	}
	
	/**
	 * Finds a value to use as the split in the array
	 * @param a Array of elements
	 * @param first index of 1st element
	 * @param last index of Last element
	 * @return index of split value
	 */
	private static <T extends Comparable<? super T>> int partition(T[] a, int first, int last) {
		
		// Comments explain the method when all elements are equal
		T pivot = a[last]; // 5
		
		int i = first; // 0
		
		for(int j = first; j < last; j++) { // j = 0 j < n-1
			if(a[j].compareTo(pivot) < 0) { // a[j] < 5, never true
				swap(a, i, j); 
				i++;
			}
		}
		swap(a, i, last); // swaps 0 with n-1
		
		return i; // return 0
	}
	
	/**
	 * Merge sort method
	 * @param a Array with elements
	 */
	public static Integer[] mergeSort(Integer[] a) {
		
		if(a.length <= 1) {
			return a;
		}
		
		int midpoint = a.length / 2;
		
		Integer[] left = new Integer[midpoint];
		Integer[] right;
		
		if(a.length % 2 == 0) {
			right = new Integer[midpoint];;
		}
		else {
			right = new Integer[midpoint+1];
		}
		
		for(int i = 0; i < midpoint; i++) {
			left[i] = a[i];
		}
		
		for(int i = 0; i < right.length; i++) {
			right[i] = a[midpoint + i];
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	/**
	 * Merges two arrays together
	 * @param left Array of elements
	 * @param right Array of elements
	 * @return Sorted merged array
	 */
	private static Integer[] merge(Integer[] left, Integer[] right) {
		Integer[] result = new Integer[left.length + right.length];;
		
		int indexL, indexR, index;
		indexL = indexR = index = 0;
		
		while(indexL < left.length || indexR < right.length) {
			
			if(indexL < left.length && indexR < right.length) {
				if(left[indexL].compareTo(right[indexR]) < 0) {
					result[index++] = left[indexL++];
				}
				else {
					result[index++] = right[indexR++];
				}
			}
			else if(indexL < left.length) {
				result[index++] = left[indexL++];
			}
			else {
				result[index++] = right[indexR++];
			}
			
		}
		
		return result;
	}
}
