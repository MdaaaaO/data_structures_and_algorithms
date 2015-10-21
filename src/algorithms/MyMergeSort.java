package algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * This is a Top-down implementation of the MergeSort algorithm using LISTS in 
 * Java.
 * 
 * https://en.wikipedia.org/wiki/Merge_sort#Top-down_implementation_using_lists
 *  
 * worst case complexity: O(n log n)  
 * 
 * @author 	Kasper
 * @date	10/21/2015	 	
 */
public class MyMergeSort {
	
	public ArrayList<Integer> sort_benchmark(ArrayList<Integer> unsortedList){
		
		ArrayList<Integer> sortedList = new ArrayList<>();
		System.out.print("MergeSort(G) using ArrayList size " + unsortedList.size());
		long startTime = System.currentTimeMillis();
		
		sortedList = sort(unsortedList);
		
		long endTime = System.currentTimeMillis();
		System.out.print(" total execution time: " + (endTime - startTime) + "ms");
		System.out.println(" ~" + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime) + "s");
		
		return sortedList;
		
	}
	
	
	/**
	 * This method is initializing the MergeSort algorithms.
	 * @param ArrayList<Integer> unsortedList
	 * @return ArrayList<Integer> sortedList
	 */
	private ArrayList<Integer> sort(ArrayList<Integer> unsortedList){
		
		if (unsortedList.size() <= 1) {
			return unsortedList;
		}
		
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();

		int middle = unsortedList.size() / 2;
		
		for (int i = 0; i < middle; i++) {
			left.add(unsortedList.get(i));
		}
		
		for (int j = middle; j < unsortedList.size(); j++) {
			right.add(unsortedList.get(j));
		}
		
		left = sort(left);
		right = sort(right);
		return merge(left, right);
	}
	
	/**
	 * This method is merging two lists into a new _mergedList_ using iterators. 
	 * Merging is done by comparing the two first elements of _list_one_ and 
	 * _list_two_ the smaller element will be added to the merged list and will 
	 * be removed from the original list.
	 * 
	 * @param ArrayList<Integer> list_one
	 * @param ArrayList<Integer> list_two
	 * @return ArrayList<Integer> mergedList 
	 */
	private ArrayList<Integer> merge(ArrayList<Integer> list_one, 
			ArrayList<Integer> list_two) {
		
		Iterator<Integer> list_one_it = list_one.iterator();
		Iterator<Integer> list_two_it = list_two.iterator();

		ArrayList<Integer> mergedList = new ArrayList<Integer>();
		
		while (list_one_it.hasNext() && list_two_it.hasNext()) {
			
			if (list_one.get(0) < list_two.get(0)) {
				mergedList.add(list_one.get(0));
				list_one.remove(0);
			} else {
				mergedList.add(list_two.get(0));
				list_two.remove(0);
			}
		}
		
		while (list_one_it.hasNext()) {
			mergedList.add(list_one.get(0));
			list_one.remove(0);
		}
		
		while (list_two_it.hasNext()) {
			mergedList.add(list_two.get(0));
			list_two.remove(0);
		}
		return mergedList;
	}
}
