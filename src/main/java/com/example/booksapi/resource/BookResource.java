package com.example.booksapi.resource;

import com.example.booksapi.model.Book;
import com.example.booksapi.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookResource {

    public final BookRepository bookRepository;

    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book) {
        bookRepository.save(book);
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PutMapping(value = "/edit", consumes = "application/json")
    public ResponseEntity<List<Book>> editBook(@RequestBody Book book) {
        bookRepository.save(book);
        List<Book> books = bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<Book>> deleteBook (@PathVariable Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            List<Book> books = bookRepository.findAll();
            return new ResponseEntity<>(books, HttpStatus.OK);
        } else {
            List<Book> books = bookRepository.findAll();
            return new ResponseEntity<>(books, HttpStatus.NOT_FOUND);
        }
    }
}