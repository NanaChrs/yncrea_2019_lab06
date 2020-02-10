package yncrea.lab06.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import yncrea.lab06.core.entity.Book;
import yncrea.lab06.core.entity.Review;

public interface ReviewDAO extends JpaRepository<Review, Long> {
}
