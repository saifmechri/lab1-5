package com.example.data.controller;










import java.time.LocalDate;
import java.util.List;

import com.example.data.model.Book;
import com.example.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    // Créer un livre
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        log.info("Creating a new book: {}", book);
        Book createdBook = bookService.createBook(book);
        log.info("Created book: {}", createdBook);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    // Obtenir tous les livres
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("Fetching all books...");
        List<Book> books = bookService.findAllBooks();
        log.info("Found {} books.", books.size());
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Obtenir les livres d'un auteur avec pagination
    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getBooksByAuthor(
            @PathVariable String author,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        log.info("Fetching books by author: {} with page {} and size {}", author, page, size);
        List<Book> books = bookService.findBooksByAuthor(author, page, size).getContent();
        log.info("Found {} books by author {}", books.size(), author);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Trouver les livres longs publiés après une certaine date
    @GetMapping("/long-books")
    public ResponseEntity<List<Book>> getLongBooksPublishedAfterDate(
            @RequestParam int pageCount,
            @RequestParam String date) {
        log.info("Fetching books longer than {} pages and published after {}", pageCount, date);
        LocalDate parsedDate = LocalDate.parse(date);
        List<Book> books = bookService.findLongBooksPublishedAfterDate(pageCount, parsedDate);
        log.info("Found {} books longer than {} pages published after {}", books.size(), pageCount, date);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // Supprimer un livre
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        try {
            log.info("Deleting book with ID: {}", id);
            bookService.deleteBook(id);
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            log.error("Error deleting book with ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }
}
