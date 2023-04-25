package sk.itlearning.java4.c.stream.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import sk.itlearning.java4.a.xml.CatalogLoader;
import sk.itlearning.java4.book.Book;

public class Reduction {

	public static void main(String[] args) {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File("C:\\Users\\student\\Desktop\\book.xml"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		List<Book> list = CatalogLoader.getFullCatagalog(fis).getBook();

		Optional<Book> ops = list.stream().filter(e -> e.getPrice() < 20f)
				.max((a, b) -> a.getPublishDate().compare(b.getPublishDate()));

		try {
			System.out.println(ops.get().getTitle());
		} catch (NoSuchElementException e) {
			System.out.println("Kniha do 2 dolarov nie je v zozname");
		}

		ops.ifPresent(v -> v.setPrice(100));
		ops.ifPresent(v -> System.out.println(v.getPrice()));
		
		Book b = ops.orElse(new Book());
		
		System.out.println(b);
	}

}
