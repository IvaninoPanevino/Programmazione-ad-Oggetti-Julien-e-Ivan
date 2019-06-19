package JSONparse;

import java.io.*;
import java.util.*;

public class Serializzazione {
	static String delimiter = ";";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel var = null;
		try {//l'inputstream è una classe astratta che descrive uno stream in input
			FileInputStream fileIn = new FileInputStream("hotel.ser");//legge da un file
			ObjectInputStream in = new ObjectInputStream(fileIn);// inputstream per oggetti
			var = (Hotel) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Hotel class not found");
			c.printStackTrace();
			return;
		}

		List<List<String>> records = new ArrayList<>();
		Vector<Hotel> v = new Vector<Hotel>();
		try (BufferedReader br = new BufferedReader(new FileReader("datastructure.csv"))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(delimiter);
				System.out.println(values.length);
				records.add(Arrays.asList(values));
				v.add(new Hotel(values[0], values[1], values[2], values[3], Integer.parseInt(values[4]), values[5], values[6], Integer.parseInt(values[7]), Integer.parseInt(values[8]), Integer.parseInt(values[9]), values[10], values[11], values[12], values[13]));
			}
			br.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		}
		for(Hotel item: v) {		
			System.out.println(v.toString());
		}

		List<List<String>> records2 = new ArrayList<>();
		try (Scanner s = new Scanner(new File("datastructure.csv"));) {
			while (s.hasNextLine()) {
				records2.add(getRecordFromLine(s.nextLine()));
			}
			s.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		}
	}

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(delimiter);
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}


	}

}
