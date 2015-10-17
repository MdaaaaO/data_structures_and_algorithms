package algorithms;

import java.util.ArrayList;

public class MyQuickSort {

	private void swap(ArrayList<Integer> unsortedList, int index_1, int index_2) {

		int tmp_1 = unsortedList.get(index_1);
		int tmp_2 = unsortedList.get(index_2);
		unsortedList.set(index_1, tmp_2);
		unsortedList.set(index_2, tmp_1);

	}

	private int partition(ArrayList<Integer> unsortedList, int low, int high) {
		int pivot = unsortedList.get(high);
//		System.out.println("PIVOT=" + pivot);
		int swap = low;

		for (int j = swap; j < high; j++) {
			if (unsortedList.get(j) <= pivot) {
				swap(unsortedList, j, swap);
				swap++;
			}
		}
//		System.out.println("SWAP Pivot " + high + " and " + swap);
		swap(unsortedList, swap, high);
//		System.out.println(unsortedList.toString());
//		System.out.println("RETURN " + swap);
		return swap;
	}

	public void sort(ArrayList<Integer> unsortedList, int low, int high) {
		if (low < high) {
//			System.out.println("LOW=" + low + " HIGH=" + high);
//			System.out.println("INPUT LIST=" + unsortedList.toString());
			int p = partition(unsortedList, low, high);
			sort(unsortedList, low, p - 1);
			sort(unsortedList, p + 1, high);
//			System.out.println("OUTPUT LIST=" + unsortedList.toString());
		}
	}
}
