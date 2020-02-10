package yncrea.lab06.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yncrea.lab06.core.dao.BookDAO;
import yncrea.lab06.core.entity.Book;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@Transactional
public class BookService {

    private BookDAO bookDAO;

    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public BookService() {
    }

    public Book getBookById(long id) {
        return bookDAO.getOneWithAuthorsAndTagsAndReviews(id);
    }

    public Map<Long, String> getAllBooks() {
        Map<Long,String> allBooksWithIds = new TreeMap<>();
        final List<Book> books = bookDAO.findAll();
        for(Book book:books){
            allBooksWithIds.put(book.getId(), book.getTitle());
        }
        return allBooksWithIds;
    }

}
