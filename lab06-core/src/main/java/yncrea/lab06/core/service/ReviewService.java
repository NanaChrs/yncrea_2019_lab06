package yncrea.lab06.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yncrea.lab06.core.dao.ReviewDAO;
import yncrea.lab06.core.entity.Review;

@Service
@Transactional
public class ReviewService {
    private ReviewDAO reviewDAO;

    public ReviewService(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    public void save(final Review review) {
        reviewDAO.save(review);
    }

    public void deleteById(long id) {
        reviewDAO.deleteById(id);
    }
}
