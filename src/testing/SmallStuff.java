package testing;

import java.util.ArrayList;

import stack.MyListStack;

public class SmallStuff {
	
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

	public static void main(String[] args) {
		MyListStack stack = new MyListStack();
		stack.push(" 2 ");
		stack.push(" 3 ");
		stack.push(" 4 ");
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

	}

}
