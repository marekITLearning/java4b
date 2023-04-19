package sk.itlearning.java4.a.abc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordering {

	public static void main(String[] args) {
		
		Obcan o1 = new Obcan("44", "Jano");
		Obcan o2 = new Obcan("22", "Miso");
		Obcan o3 = new Obcan("33", "Adam");
		
		List<Obcan> lo = new ArrayList<>();
		lo.add(o1);
		lo.add(o2);
		lo.add(o3);
		
		lo.forEach(System.out::println);
		
		String[] strings = { "b", "d", "a", "c" };
		
		List<String> lowerA = Arrays.asList(strings);
		
		Collections.sort(lowerA);
		
		lowerA.forEach(System.out::println);
		
		Comparator<Obcan> co =  (a, b) -> a.getRodneCislo().compareTo(b.getRodneCislo());
		
		Collections.sort(lo, co);
		
		lo.forEach(System.out::println);
		
		
	}
	
}
