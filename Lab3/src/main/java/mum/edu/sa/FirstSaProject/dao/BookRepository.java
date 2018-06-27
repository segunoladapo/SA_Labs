package mum.edu.sa.FirstSaProject.dao;

import mum.edu.sa.FirstSaProject.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
    void deleteByIsbn(String isbn);
    Book findByIsbn(String isbn);
}
