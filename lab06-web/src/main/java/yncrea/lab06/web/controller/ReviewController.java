package yncrea.lab06.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import yncrea.lab06.core.entity.Review;
import yncrea.lab06.core.service.ReviewService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Named
@Path("/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewController implements RestController{

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private ReviewService reviewService;

    @POST
    public void saveReview(Review review){
        reviewService.save(review);
    }

    @DELETE
    @Path("/{id}")
    public void deleteReview(@PathParam("id") long id){
        reviewService.deleteById(id);
    }
}
