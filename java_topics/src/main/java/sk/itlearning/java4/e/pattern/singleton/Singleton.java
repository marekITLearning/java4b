package sk.itlearning.java4.e.pattern.singleton;

public class Singleton {

	private static Singleton instance = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello, I am the only object of type Singleton that might ever exist!");
	}
}
