package JSONparse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class JSONgetAndDecode {

	public static void main(String[] args) {
		/*
		Leggere da una connessione URL (URLConnection) invece di leggere direttamente da un URL è migliore!
		Questo perchè posso usare, allo stesso tempo, l'oggetto URLConnection per altre mansioni (come scrivere sul URL)
		*/

		String url = " https://www.dati.gov.it/api/3/action/package_show?id=a8aa3845-bd09-46ab-b2fa-c76ed745fa10";
		if(args.length == 1)
			url = args[0]; //controlla se l'url viene messo tramite argomento di avvio del programma
		try {
			//apro una connessione 
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0 Chrome/51.0.2704.84");
			InputStream in = openConnection.getInputStream();//restituisce l'inputstream connesso all'output del processo
			//l'inputstream contiene delle API(metodi e campi)	 che permettono di realizzare stream che leggono byte
			 String data = "";
			 String line = "";
			 try {
			   InputStreamReader inR = new InputStreamReader( in ); // accetta un oggetto inputstream e crea unoggetto inputstreamreader (quindi crea uno reader)
			   BufferedReader buf = new BufferedReader( inR ); //il buffering rende più efficiente le operazioni di I/O su stream di caratteri
			  
			   while ( ( line = buf.readLine() ) != null ) {
				   data+= line;
				   System.out.println( line );
			   }
			 } finally {
			   in.close();
			 }
			JSONObject obj = (JSONObject) JSONValue.parseWithException(data); 
			JSONObject objI = (JSONObject) (obj.get("result"));
			JSONArray objA = (JSONArray) (objI.get("resources"));
			
			//for(int i=0; i<arr.length();i++){ arr.getJSONObject(i); } 
			for(Object o: objA){
			    if ( o instanceof JSONObject ) 
			        JSONObject o1 = (JSONObject)o; 
			        String format = (String)o1.get("format");
			        String urlD = (String)o1.get("url");
			        System.out.println(format + " | " + urlD);
			        if(format.equals("csv")) {
			        	download(urlD, "datastructure.csv");
			        }
			    }
			}
			System.out.println( "Your CSV file is downloaded!! " );
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void download(String url, String fileName) throws Exception {
	    try (InputStream in = URI.create(url).toURL().openStream()) {
	        Files.copy(in, Paths.get(fileName));
	    }
	}
}
