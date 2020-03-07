package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.awt.print.Book;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {
    private final EntityManager entityManager;

    @Transactional
    public BookEntity createBook(String isbn, String title, String author) {
        BookEntity book = new BookEntity();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);

        return entityManager.merge(book);
    }

    @Transactional
    public BookEntity getBookById(int id) {
        return entityManager.find(BookEntity.class, id);
    }

    @Transactional
    public BookEntity createBook(BookEntity book) {

        return entityManager.merge(book);
    }

    @Transactional
    public List<BookEntity> findAllBooks() {
        return entityManager.createQuery("SELECT b FROM BookEntity b", BookEntity.class)
                .getResultList();
    }
}

