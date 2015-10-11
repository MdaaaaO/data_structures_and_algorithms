import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * This is the method which a human would use to sort numbers. We will start
 * with looking for the smallest number and then switching it to the front of
 * our ArrayList!
 * 
 * UPDATE: Now we are also looking for the biggest number and swap it to the
 * 		   end of our ArrayList, _IF ALLOWED_ ;-0 
 * 		   Note: Refactoring needed!
 * 
 * 
 * @date 10/07/2015
 * @author Georg Kasper
 *
 */
public class SimpleSort {

	public ArrayList<Integer> sort(ArrayList<Integer> integer_list) {

		int minNumber;
		int indexMinNumber = 0;

		int maxNumber;
		int indexMaxNumber = 0;

		int switchedMaxIt = 0;

		int size = integer_list.size();

		System.out.print("SimpleSort(G) using ArrayList size " + size);
		long startTime = System.currentTimeMillis();

		for (int n = 0; n < size - switchedMaxIt; n++) {
			// System.out.println("\nn=" + n);
			minNumber = integer_list.get(n);
			maxNumber = integer_list.get(n);
			for (int i = n; i < size - switchedMaxIt; i++) {
				// you need >= otherwise you will mess up if you have two same
				// numbers in a row
				if (minNumber >= integer_list.get(i)) {
					minNumber = integer_list.get(i);
					indexMinNumber = i;
					// System.out.println("min=" + minNumber + "@i=" + i);
				}

				if (maxNumber <= integer_list.get(i)) {
					maxNumber = integer_list.get(i);
					indexMaxNumber = i;
					// System.out.println("max=" + maxNumber + "@i=" + i);
				}
			}
			// System.out.println("\nn=" + n);
			// System.out.println("min=" + minNumber + "indx=" + indexMinNumber
			// );
			// System.out.println("max=" + maxNumber + "indx=" + indexMaxNumber
			// );

			int oldMinNumber = integer_list.get(n);
			int oldMaxNumber = integer_list.get(size - switchedMaxIt - 1);
			// switch minNumber
			integer_list.set(n, minNumber);
			integer_list.set(indexMinNumber, oldMinNumber);

			// switch maxNumber, this are conditions where we are not allowed
			// to switch the number because we are touching the indx already
			// with our minNumber switch...
			//TODO: refactor the if conditions to improve calculation time 
			if ((indexMaxNumber == n) || (indexMinNumber == size - switchedMaxIt)
					|| (indexMaxNumber == size - switchedMaxIt)) {
				// System.out.println("not allowed to switch max");
			} else {
				integer_list.set(size - switchedMaxIt - 1, maxNumber);
				integer_list.set(indexMaxNumber, oldMaxNumber);
				switchedMaxIt += 1;
			}
			// System.out.println(integer_list.toString());
		}

		long endTime = System.currentTimeMillis();
		System.out.print(" total execution time: " + (endTime - startTime) + "ms");
		System.out.println(" ~" + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime) + "s");
		return integer_list;
	}
}
