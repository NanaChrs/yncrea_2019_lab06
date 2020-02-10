package yncrea.lab06.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

// TODO complete this implementation with the correct annotations, fields and methods.
// The @JsonIgnoreProperties annotation is mandatory in our case because it helps the JSON Serialization
// The @ManyToMany annotation is provided because it is not that easy ;)

@JsonIgnoreProperties({ "books" })
@Entity
public class Author implements Comparable<Author> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {
    }

    public Author(final String firstname, final String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }


    @Override public int compareTo(final Author o) {
        if (lastname.equals(o.lastname)) {
            return firstname.compareTo(o.firstname);
        } else {
            return lastname.compareTo(o.lastname);
        }
    }

    @Override
    public String toString() {
        return firstname+ " " + lastname;
    }
}
