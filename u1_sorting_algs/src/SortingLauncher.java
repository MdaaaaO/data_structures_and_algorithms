package u1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Data Structures and Algorithms Lecture HFT.
 * 
 * This is the main function, responsible for generation of a random array and
 * calling different sorting algorithms to test the benchmark.
 * 
 * Just for fun! ;-)
 * 
 * @date 10/07/2015
 * @author Georg Kasper
 *
 */
public class SortingLauncher {

	/**
	 * This method will generate a random number within the range. Be careful,
	 * this numbers are not unique!
	 * 
	 * @param Integer
	 *            n (The range for the random number)
	 * @return Integer
	 */
	public static int createRandomNumber(int n) {
		Random randomIntegerGenerator = new Random();
		return randomIntegerGenerator.nextInt(n);
	}

	/**
	 * This method will generate an random Integer ArrayList with the size of n.
	 * Be careful, the ArrayList is not filled with unique numbers!
	 * 
	 * @param n
	 *            (size for the array list)
	 * @return Integer ArrayList
	 */
	public static ArrayList<Integer> geneareRandomIntegerArrayList(int n) {

		ArrayList<Integer> list_1 = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			int test = createRandomNumber(n);
			list_1.add(test);
		}
		return list_1;
	}

	public static void amIsorted(ArrayList<Integer> random_list) {
		boolean sorted = true;
		for (int i = 0; i < random_list.size() - 1; i++) {
			if (random_list.get(i) > random_list.get(i + 1)) {
				sorted = false;
			}
		}
		if (!sorted) {
			System.out.println("You are not sorted! ;-(");
			System.out.println(random_list.toString());
		}
	}

	/**
	 * This Method will start the implemented algorithms and increase the sample
	 * size every iteration, pay attention that we create a new random list for
	 * every new algorithm, to avoid JVM build-in optimizations after reading
	 * one ArrayList.
	 * 
	 * @param iterations
	 */
	public static void benchmark(int iterations) {

		int n = 100000;
		for (int i = 0; i < iterations; i++) {

			// sample size
			System.out.println(">> starting benchmark tests [" + i + "] with " + "n=" + n);

			// Create random ArrayList
//			ArrayList<Integer> random_list_2 = geneareRandomIntegerArrayList(n);
//			ArrayList<Integer> random_list_4 = geneareRandomIntegerArrayList(n);

			// BubbleSort by Georg
//			for (int j = 0; j < 2; j++) {
//				ArrayList<Integer> random_list = geneareRandomIntegerArrayList(n);
//				BubbleSort bub = new BubbleSort();
//				ArrayList<Integer> sorted_list_1 = bub.sort(random_list);
//				amIsorted(sorted_list_1);
//			}
			

			// BubbleSort by Julian
//			BubbleSortTwo bub_two = new BubbleSortTwo();
//			ArrayList<Integer> sorted_list_2 = bub_two.sort(random_list_2);
//			amIsorted(sorted_list_2);

			// SimpleSort by Georg
			for (int j = 0; j < 6; j++) {
				ArrayList<Integer> random_list_3 = geneareRandomIntegerArrayList(n);
				SimpleSort simpleSort = new SimpleSort();
				ArrayList<Integer> sorted_list_3 = simpleSort.sort(random_list_3);
				amIsorted(sorted_list_3);
			}

			// SimpleSortTwo by Julian
//			SimpleSortTwo simpleSortTwo = new SimpleSortTwo();
//			ArrayList<Integer> sorted_list_4 = simpleSortTwo.sort(random_list_4);
//			amIsorted(sorted_list_4);

			System.out.println(">> done!");
			n += 10000;
		}

	}

	public static void main(String[] args) {
		benchmark(1);
	}
}
