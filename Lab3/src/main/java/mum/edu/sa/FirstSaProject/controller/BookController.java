package mum.edu.sa.FirstSaProject.controller;

import mum.edu.sa.FirstSaProject.model.Book;
import mum.edu.sa.FirstSaProject.model.Greeting;
import mum.edu.sa.FirstSaProject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("book/{isbn}")
    public ResponseEntity<?> findBookByIsbn(@PathVariable("isbn") String isbn){
        Book book = bookService.getBook(isbn);
        if(book == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("book")
    public ResponseEntity saveBook(@RequestBody Book book){
        bookService.addBook(book);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("book/{isbn}")
    public ResponseEntity deleteBook(@PathVariable("isbn") String isbn){
        bookService.deleteBook(isbn);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("book")
    public ResponseEntity<?> getAllBooks(){
        return new ResponseEntity(bookService.getAllBooks(), HttpStatus.OK);
    }
}
