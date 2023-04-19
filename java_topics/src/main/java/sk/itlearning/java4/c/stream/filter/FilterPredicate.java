package sk.itlearning.java4.c.stream.filter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilterPredicate {

	public static void main(String[] args) {

		String relPath = "src/main/resources/sk/itlearning/java4/a/xml/book.xml";

		List<String> lines = new ArrayList<>();
		
		try {
			lines = Files.readAllLines(Paths.get(relPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		long count = lines.stream().filter(p -> p.contains("</book>")).count();
		
		System.out.println(count);
	}

}