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

	public static void testingDataReader() {
		ArrayList<Integer> test_list = geneareRandomIntegerArrayList(10);

		// Write the lists into a .txt file, or get them out of it
		DataReader dataReader = new DataReader();
		dataReader.writeNumbersIntoFile(test_list);
		ArrayList<Integer> empty_list = new ArrayList<Integer>(dataReader.readNumbersFromFile());

		System.out.println("the list that was written: ");
		for (int number : test_list) {
			System.out.println(number);
		}

		System.out.println("the list that was read: ");
		for (int number : empty_list) {
			System.out.println(number);
		}
	}

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

		int n = 10000;

		for (int i = 0; i < iterations; i++) {
		
			System.out.println(">> starting benchmark tests [" + i + "] with " + "n=" + n);
			for (int j = 0; j < 6; j++) {
				ArrayList<Integer> random_list_3 = geneareRandomIntegerArrayList(n);
				SimpleSort simpleSort = new SimpleSort();
				ArrayList<Integer> sorted_list_3 = simpleSort.sort(random_list_3);
				amIsorted(sorted_list_3);
			}
			System.out.println(">> done!");
			n += 10000;
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Uncomment the method you would like to launch!");
		benchmark(1);

	}
}
