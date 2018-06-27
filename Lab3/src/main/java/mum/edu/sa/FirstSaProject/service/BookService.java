package mum.edu.sa.FirstSaProject.service;

import mum.edu.sa.FirstSaProject.dao.BookRepository;
import mum.edu.sa.FirstSaProject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book){
        bookRepository.insert(book);
    }

    public void deleteBook(String isbn){

    }

    public Book getBook(String isbn){
        return null;
    }

    public List<Book> getAllBooks(){
        return null;
    }
}
