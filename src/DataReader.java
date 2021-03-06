import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * this class is used to write integer numbers into a .txt file,
 * or to get them out again
 *
 * @author Julian
 */

public class DataReader {
	
	public ArrayList<Integer> readNumbersFromFile () {
		ArrayList<Integer> numbers_list = new ArrayList<Integer>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("test_numbers_list.txt")));
			int number;
			while ((number = reader.read()) > 0) {
				numbers_list.add(number);
				System.out.println("Read " + number + " into the list");
			}
			reader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return numbers_list;
	}
	
	public void writeNumbersIntoFile (ArrayList<Integer> numbers_list) {
		try {
			FileWriter writer = new FileWriter("test_numbers_list.txt");
			for (int number : numbers_list) {
				writer.write(number);
				System.out.println("wrote " + number + " into the .txt file");
			}
			writer.close();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
