package sk.itlearning.java4.c.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Map {

	public static void main(String[] args) {
		
		// stream retazcov
		String[] strings = { "a", "b", "c", "d" };
		
		List<String> lowerA = Arrays.asList(strings);
		
		lowerA.stream().forEach(s -> System.out.println(s));
		
		lowerA.forEach(s -> System.out.println(s));
		
		// stream retazcov inak
		Stream<String> lowerB = Stream.of("a", "b", "c", "d");
		
		lowerB = lowerB.map(s -> s.toUpperCase());
		
		lowerB.forEach(s -> System.out.println(s));
	}

}