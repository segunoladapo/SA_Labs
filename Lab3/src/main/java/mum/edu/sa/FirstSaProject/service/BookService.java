package mum.edu.sa.FirstSaProject.service;

import mum.edu.sa.FirstSaProject.dao.BookRepository;
import mum.edu.sa.FirstSaProject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(String isbn){
        bookRepository.deleteByIsbn(isbn);
    }

    public Book getBook(String isbn){
        return bookRepository.findByIsbn(isbn);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
