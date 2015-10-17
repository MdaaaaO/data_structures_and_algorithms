package algorithms;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * This is the well known bubble sort algorithm, extended with an iterator count
 * to avoid checking the last number in the list after swapping.
 * 
 * @date 10/07/2015
 * @author Georg Kasper
 *
 */
public class BubbleSort {

	/**
	 * BubbleSort with little benchmark output to command line!
	 * 
	 * @param integer_list
	 * @return sorted integer_list
	 */
	public ArrayList<Integer> sort(ArrayList<Integer> integer_list) {

		int size = integer_list.size();
		System.out.print("BubbleSort(G) using ArrayList size " + size);
		long startTime = System.currentTimeMillis();

		int iterator = 0;
		for (int i = 0; i < size - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < size - 1 - iterator; j++) {
				int tmp = integer_list.get(j);
				int tmp_plus = integer_list.get(j + 1);

				if (tmp > tmp_plus) {
					// switch
					integer_list.set(j, tmp_plus);
					integer_list.set(j + 1, tmp);
					swapped = true;
				}
			}
			iterator += 1;
			if (swapped == false) {
				break;
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.print(" total execution time: " + (endTime - startTime) + "ms");
		System.out.println(" ~" + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime)+ "s");
		return integer_list;
	}
}
