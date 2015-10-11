import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Julian
 *
 */
public class SimpleSortTwo {
	
	/**
	 * mein eigener Sortieralgorithmus der algorithmus vergleicht die erste zahl
	 * in der liste mit den nachfolgenden, solange bis er eine kleinere zahl
	 * findet anschließend vergleicht er die kleinere zahl mit allen zahlen die
	 * bisher an den anfang gestellt worden sind. ist die gefundene zahl kleiner
	 * als eine der bisher gefundenen, tauschen sie ihre plätze, ansonsten wird
	 * sie an das ende der bisher getauschten zahlen gesetzt
	 */
	
	public ArrayList<Integer> sort(ArrayList<Integer> integer_list) {

		int size = integer_list.size();
		System.out.print("SimpleSort(J) using ArrayList size " + size );
		long startTime = System.currentTimeMillis();
		
		if (integer_list.size() == 1) {
			return integer_list;
		}

		int startNumber;
		int switchCount = 0;
		for (int i = 0; i < integer_list.size() - 1; i++) {
			startNumber = integer_list.get(i);
			for (int j = 0; j < integer_list.size() - 1; j++) {
				if (startNumber > integer_list.get(j)) {
					startNumber = integer_list.get(j);
					switchCount++;
					for (int k = 0; k < switchCount; k++) {
						if (startNumber < integer_list.get(k)) {
							int temp = integer_list.get(k);
							integer_list.set(k, startNumber);
							integer_list.set(j, temp);
						} else {
							int temp = integer_list.get(switchCount);
							integer_list.set(switchCount, startNumber);
							integer_list.set(j, temp);
						}
					}
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.print(" total execution time: " + (endTime - startTime) + "ms");
		System.out.println(" ~" + TimeUnit.MILLISECONDS.toSeconds(endTime - startTime)+ "s");
		return integer_list;
	}

}
