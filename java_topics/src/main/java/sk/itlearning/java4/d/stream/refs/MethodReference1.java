package sk.itlearning.java4.d.stream.refs;

import java.util.Arrays;
import java.util.stream.Stream;

public class MethodReference1 {

	Integer x = 5;
	
	public static void main(String[] args) {

		/*
		 * The :: operator separates the method name from the name of an object or class. 
		 * 
		 * object::instanceMethod
		 * 
		 * Class::staticMethod
		 * 
		 * Class::instanceMethod
		 */
		
		String[] strings = { "B", "c", "d", "a" };
		
		
		Arrays.asList(strings).forEach(p -> System.out.println(p));
		
		Arrays.asList(strings).forEach(System.out::println);
		
		
		Arrays.sort(strings, (a, b) -> a.compareToIgnoreCase(b));
		
		Arrays.sort(strings, String::compareToIgnoreCase);
		
		
		Arrays.asList(strings).stream().map(s -> s.toUpperCase()).forEach(System.out::println);
		
		Arrays.asList(strings).stream().map(String::toUpperCase).forEach(System.out::println);
		
		
		MethodReference1 mr1 = new MethodReference1();
		
		mr1.testEquals(Stream.of(3, 4, 5, 6));
	}
	
	void testEquals(Stream<Integer> s) {
		s.filter(i -> this.x.equals(i)).forEach(System.out::println); // convert to method reference
		s.filter(this.x::equals).forEach(System.out::println);
	}
	
}
