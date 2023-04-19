package sk.itlearning.java4.c.stream.map;

import java.util.function.Supplier;

public class DefferedLog {

	static int l = 2;
	
	public static void main(String[] args) {
	
		try {
			throw new Exception();
		} catch (Exception e) {
			info("nastala chyba");
			info(() -> new String("nastala chyba"));
		}
	}
	
	static void info(Supplier<String> s) {
		if (l <= 1) {
			System.out.println(s.get());
		}
	}
	
	static void info(String s) {
		if (l <= 1) {
			System.out.println(s);
		}
	}
	
}
