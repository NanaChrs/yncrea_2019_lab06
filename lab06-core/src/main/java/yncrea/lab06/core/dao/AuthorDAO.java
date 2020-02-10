package yncrea.lab06.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yncrea.lab06.core.entity.Author;
import yncrea.lab06.core.entity.Book;

public interface AuthorDAO extends JpaRepository<Author, Long> {

}
