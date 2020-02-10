package yncrea.lab06.core.service;

import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("ok");

        final List<Book> books = this.bookDAO.findAll();
        System.out.println("books " + books.size());
        for(Book book:books){
            System.out.println("book " + book.getTitle());
            allBooksWithIds.put(book.getId(), book.getTitle());
        }
        return allBooksWithIds;
    }

}
