package sk.itlearning.java4.a.abc;

public class Cloning {

	
	public static void main(String[] args) {
	
		Obcan o1 = new Obcan("11", "Peter");
		Obcan o2 = new Obcan("11", "Peter");
				
		System.out.println(o1.equals(o2));
		
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		
		Obcan o3 = o2.clone();
		
		System.out.println(o3);
		
		o3.setMeno("Jano");
		
		System.out.println(o3);
		
		System.out.println(o2);
		
		
		
		
	}
	
}
