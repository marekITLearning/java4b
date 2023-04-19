package sk.itlearning.java4.b.stream.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class F1 {

	public static void main(String[] args) {
		
		System.out.println(getBookLines().size());

	}	

	public static List<String> getBookLines() {
		
		String relPath = "src/main/resources/sk/itlearning/java4/a/xml/book.xml";

		List<String> lines = new ArrayList<>();
		
		File f = new File(relPath);
		
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			String line = null;
			while ( (line = br.readLine()) != null ) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
}