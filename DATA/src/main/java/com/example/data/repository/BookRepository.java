package com.example.data.repository;

import com.example.data.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);
    List<Book> findByAuthorContaining(String authorName);
    List<Book> findByPublicationDateAfter(java.time.LocalDate date);
    List<Book> findByTitleAndAuthor(String title, String author);
    List<Book> findByPageCountBetween(int min, int max);
    long countByAuthor(String author);
    List<Book> findTop3ByOrderByPageCountDesc();

    Page<Book> findByAuthor(String author, Pageable pageable);
}
