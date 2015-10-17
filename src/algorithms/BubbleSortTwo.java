package algorithms;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Julian
 *
 */
public class BubbleSortTwo {

	// ein gewöhnlicher bubblesort
	public ArrayList<Integer> sort(ArrayList<Integer> integer_list) {

		int size = integer_list.size();
		System.out.print("BubbleSort(J) using ArrayList size " + size);
		long startTime = System.currentTimeMillis();

		if (integer_list.size() == 1) {
			return integer_list;
		}

		for (int i = 0; i < integer_list.size() - 1; i++) {
			boolean switched = false;
			for (int j = 0; j < integer_list.size() - 1 - i; j++) {
				if (integer_list.get(j) > integer_list.get(j + 1)) {
					switched = true;
					int temp = integer_list.get(j);
					int temp_two = integer_list.get(j + 1);
					integer_list.set(j, temp_two);
					integer_list.set(j + 1, temp);
				}
			}
			if (!switched) {
				break;
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.print(" total execution time: " + (endTime - startTime) + "ms");
		System.out.println(" ~" + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime)+ "s");
		return integer_list;
	}
}
