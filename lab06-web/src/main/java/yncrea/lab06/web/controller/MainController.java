package yncrea.lab06.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yncrea.lab06.core.entity.Book;
import yncrea.lab06.core.service.BookService;
import yncrea.lab06.web.dto.BookDTO;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Named
@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Inject
    private BookService bookService;


    @GET
    @Path("/books")
    public Map<Long, String> getAllBooks(){
        logger.info("get all Books");
        return bookService.getAllBooks();
    }

    @GET
    @Path("/books/{id}")
    public BookDTO getBookById(@PathParam("id") long id){
        Book book = bookService.getBookById(id);
        BookDTO bookDTO = new BookDTO();
        bookDTO.setAuthors((List)book.getAuthors());
        bookDTO.setId(book.getId());
        bookDTO.setImage(book.getImage());
        bookDTO.setLanguage(String.valueOf(book.getLanguage()));
        bookDTO.setTags((List)book.getTags());
        bookDTO.setTitle(book.getTitle());
        return bookDTO;
    }

/*    @POST
    @Path("/reviews")
    public void addNewReview(Review)*/

}
