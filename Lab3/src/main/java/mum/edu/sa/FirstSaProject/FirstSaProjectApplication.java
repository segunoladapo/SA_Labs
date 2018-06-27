package mum.edu.sa.FirstSaProject;

import mum.edu.sa.FirstSaProject.dao.BookRepository;
import mum.edu.sa.FirstSaProject.model.Book;
import mum.edu.sa.FirstSaProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSaProjectApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(FirstSaProjectApplication.class, args);
	}

	public  void run(String... args) throws Exception{
		Book book = new Book();
		book.setAuthor("Jon Skeet");
		book.setIsbn("111-1111-11111");
		book.setTitle("C# in Depth");
		book.setPrice(56.60);

		Book book2 = new Book();
		book2.setAuthor("Karthy Sierra & Bert Bates");
		book2.setIsbn("222-2222-2222");
		book2.setTitle("Head First Java");
		book2.setPrice(56.60);
		bookService.addBook(book);
		bookService.addBook(book2);
	}
}
