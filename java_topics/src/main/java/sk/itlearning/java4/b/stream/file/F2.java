package sk.itlearning.java4.b.stream.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class F2 {

	public static void main(String[] args) {

		System.out.println(getBookLines().size());

	}

	public static List<String> getBookLines() {
		
		String relPath = "src/main/resources/sk/itlearning/java4/a/xml/book.xml";

		List<String> lines = new ArrayList<>();
		
		try {
			lines = Files.readAllLines(Paths.get(relPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}
	
}