package algorithms;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyQuickSort {

	private void swap(ArrayList<Integer> unsortedList, int index_1, int index_2) {

		int tmp_1 = unsortedList.get(index_1);
		int tmp_2 = unsortedList.get(index_2);
		unsortedList.set(index_1, tmp_2);
		unsortedList.set(index_2, tmp_1);

	}

	private int partition(ArrayList<Integer> unsortedList, int low, int high) {
		int pivot = unsortedList.get(high);
		int swap = low;

		for (int j = swap; j < high; j++) {
			if (unsortedList.get(j) <= pivot) {
				swap(unsortedList, j, swap);
				swap++;
			}
		}
		swap(unsortedList, swap, high);
		return swap;
	}

	private void sort(ArrayList<Integer> unsortedList, int low, int high) {
		if (low < high) {
			int p = partition(unsortedList, low, high);
			sort(unsortedList, low, p - 1);
			sort(unsortedList, p + 1, high);
		}
	}
	
	public void sort_benchmark(ArrayList<Integer> unsortedList) {
		System.out.print("QuickSort(G) using ArrayList size " + unsortedList.size());
		long startTime = System.currentTimeMillis();
		sort(unsortedList, 0, unsortedList.size()-1);
		long endTime = System.currentTimeMillis();
		System.out.print(" total execution time: " + (endTime - startTime) + "ms");
		System.out.println(" ~" + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime) + "s");
	}
}
