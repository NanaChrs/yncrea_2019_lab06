package yncrea.lab06.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import yncrea.lab06.core.entity.Book;

import java.util.Map;

public interface BookDAO extends JpaRepository<Book, Long> {

    @Query("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.authors LEFT JOIN FETCH b.tags LEFT JOIN FETCH b.reviews WHERE b.id=:id")
    Book getOneWithAuthorsAndTagsAndReviews(@Param("id") long bookId);

    @Query("SELECT DISTINCT b.id, b.title FROM Book b")
    Map<Long, String> getAllBooksWithIds();
}
