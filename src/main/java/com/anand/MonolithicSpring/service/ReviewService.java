package com.anand.MonolithicSpring.service;

import com.anand.MonolithicSpring.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    Boolean addReview(Review review,Long companyId);

    Review getReviewById(Long companyId, Long reviewId);

    void updateReview(Long companyId, Long reviewId, Review review);
}
