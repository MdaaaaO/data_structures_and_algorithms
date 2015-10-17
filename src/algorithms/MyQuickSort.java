package algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class MyQuickSort {

	/**
	 * This method will find the maximum in an array. Complexity: O(n) 1.
	 * Assignment of max counts for 1 EO 2. For Loop counts for N EO 3. IF
	 * condition counts for 1 EO 4. Assignment counts for 1 EO => worst case:
	 * 1+N*2 EO == O(2N) => Complexity: O(n)
	 * 
	 * @param unsortedList
	 */
	public static void findMaximum(ArrayList<Integer> unsortedList) {
		System.out.println("");
		int max = unsortedList.get(0);
		for (int i = 0; i < unsortedList.size() - 1; i++) {
			if (max < unsortedList.get(i + 1)) {
				max = unsortedList.get(i + 1);
			}
		}
		System.out.println("Maximum = " + max);
	}

	public static void swap(ArrayList<Integer> unsortedList, int index_1, int index_2) {

		int tmp_1 = unsortedList.get(index_1);
		int tmp_2 = unsortedList.get(index_2);
		unsortedList.set(index_1, tmp_2);
		unsortedList.set(index_2, tmp_1);

	}

	public static int partition(ArrayList<Integer> unsortedList, int low, int high) {
		int pivot = unsortedList.get(high);
		System.out.println("PIVOT=" + pivot);
		int swap = low;

		for (int j = swap; j < high; j++) {
			if (unsortedList.get(j) <= pivot) {
				swap(unsortedList, j, swap);
				swap++;
			}
		}
		System.out.println("SWAP Pivot " + high + " and " + swap);
		swap(unsortedList, swap, high);
		System.out.println(unsortedList.toString());
		System.out.println("RETURN " + swap);
		return swap;
	}

	public static void quickSort(ArrayList<Integer> unsortedList, int low, int high) {
		if (low < high) {
			System.out.println("LOW=" + low + " HIGH=" + high);
			System.out.println("INPUT LIST=" + unsortedList.toString());
			int p = partition(unsortedList, low, high);
			quickSort(unsortedList, low, p - 1);
			quickSort(unsortedList, p + 1, high);
			System.out.println("OUTPUT LIST=" + unsortedList.toString());
		}
	}

	/**
	 * Example for parsing by "reference" in Java for Arrays
	 */
	public static void demo() {
		int[] array = new int[5];
		System.out.println(Arrays.toString(array)); // 0, 0, 0, 0, 0
		fillArray(array);
		System.out.println(Arrays.toString(array)); // 0, 1, 2, 3, 4

		ArrayList<Integer> unsortedArray = new ArrayList<Integer>();
		System.out.println(unsortedArray.toString());
		fillArrayList(unsortedArray);
		System.out.println(unsortedArray.toString());
	}

	public static void fillArrayList(ArrayList<Integer> arrayList) {
		for (int i = 0; i < 5; i++) {
			arrayList.add(i);
		}
	}

	public static void fillArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}

	/**
	 * MAIN
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] array = { 5, 7, 2, 6, 9, 3 };
		ArrayList<Integer> unsortedArray = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			unsortedArray.add(array[i]);
		}
		// findMaximum(unsortedArray);
		// demo();
		quickSort(unsortedArray, 0, unsortedArray.size() - 1);
		System.out.println("after Quicksort=" + unsortedArray.toString());
	}
}
