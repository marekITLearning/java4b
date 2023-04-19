package sk.itlearning.java4.c.stream.filter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilterPredicateLazy {

	public static void main(String[] args) {

		String relPath = "src/main/resources/sk/itlearning/java4/a/xml/book.xml";
		
		try {		
			List<String> lines = Files.lines(Paths.get(relPath)).filter(l -> l.contains("</book>")).collect(Collectors.toList());
			
			System.out.println(lines.size());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}