package com.example.data.service;




import com.example.data.model.Book;
import com.example.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Créer un nouveau livre
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Trouver tous les livres
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    // Trouver les livres par auteur, avec pagination
    public Page<Book> findBooksByAuthor(String author, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title").ascending());
        return bookRepository.findByAuthor(author, pageable);
    }

    // Trouver les livres avec un nombre de pages minimum et publiés après une certaine date
    public List<Book> findLongBooksPublishedAfterDate(int pageCount, LocalDate date) {
        // Récupérer tous les livres publiés après la date donnée
        List<Book> books = bookRepository.findByPublicationDateAfter(date);

        // Filtrer les livres qui ont un nombre de pages >= à pageCount
        return books.stream()
                .filter(book -> book.getPageCount() >= pageCount)
                .toList();
    }

    // Supprimer un livre par ID
    public void deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            // Il serait bon d'ajouter un mécanisme de gestion des erreurs, par exemple, en lançant une exception
            throw new RuntimeException("Book with ID " + id + " not found");
        }
    }
}
