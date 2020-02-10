package yncrea.lab06.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

// TODO complete this implementation with the correct annotations, fields and methods.
@Entity
public class Review implements Comparable<Review> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private int score;

    private Date dateOfReview;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //We need this annotation for the deserialization only
    private Book book;


    @Override
    public int compareTo(final Review o) {
        return dateOfReview.compareTo(o.dateOfReview);
    }
}
