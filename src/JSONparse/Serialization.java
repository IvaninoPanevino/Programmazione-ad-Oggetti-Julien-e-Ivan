package JSONparse;

import java.io.*;
import java.util.*;

public class Serialization {

	public Serialization() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		int i = 0;
		List<List<String>> records = new ArrayList<>();		
		String fileName = "datastructure.csv";
		JSONgetAndDecode.getJSONAndDownloadCSV(fileName);
		ArrayList<Hotel> v = new ArrayList<Hotel>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) 
		{
			String line = br.readLine();
			while ((line = br.readLine()) != null) 
			{
				System.out.println(line);
				String[] values = line.split("\",\"");
				
				for(String item: values) 
				{
					item = item.replaceAll("\"", "");                      
				}
				try 
				{
					if(i==0) 
					{
						i++;
						continue;
					}
					else i++;
					// trasformo le variabili di tipo String ed Integer nell'oggetto Hotel e li metto in un vettore
					v.add(new Hotel(values[0],values[1],values[2],values[3],values[4],values[5],values[6],Integer.parseInt(values[7].replaceAll("\"", "")),Integer.parseInt(values[8].replaceAll("\"", "")),Integer.parseInt(values[9].replaceAll("\"", "")),values[10],values[11],values[12],values[13]));

                }
				catch (Exception e) 
				{
					System.out.println(e);
				}
				//System.out.println(values.length);
            }
			br.close();
		}
		catch (IOException c) {
			c.printStackTrace();
			return;
		}
		for(Hotel item: v) {		
			System.out.println(item.toString()); //devo usare item e non v per vedere
		}
		
		Statistics stats = new Statistics();
		stats.setSize(v.size());
		stats.Statistics(v);
		
		Filters filters = new Filters();
		filters.setSize(v.size());
		filters.Filters(v);
	}

	private static List<String> getRecordFromLine(String nextLine) {
		// TODO Auto-generated method stub
		return null;
	}
}
