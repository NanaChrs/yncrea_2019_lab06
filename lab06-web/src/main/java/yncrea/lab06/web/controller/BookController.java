package yncrea.lab06.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import yncrea.lab06.core.entity.Author;
import yncrea.lab06.core.entity.Book;
import yncrea.lab06.core.entity.Tag;
import yncrea.lab06.core.service.BookService;
import yncrea.lab06.web.dto.BookDTO;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController implements RestController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private BookService bookService;

    @GET
    public Map<Long, String> getAllBooks(){
        logger.info("get all Books");
        return bookService.getAllBooks();
    }

    @GET
    @Path("/{id}")
    public BookDTO getBookById(@PathParam("id") long id){
        Book book = bookService.getBookById(id);
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthors(book.getAuthors().stream().map(a -> a.toString()).collect(Collectors.toList()));
        bookDTO.setId(book.getId());
        bookDTO.setImage(book.getImage());
        bookDTO.setLanguage(book.getLanguage().toString());
        bookDTO.setTags(book.getTags().stream().map((Tag::getName)).collect(Collectors.toList()));
        bookDTO.setTitle(book.getTitle());
        return bookDTO;
    }
}
