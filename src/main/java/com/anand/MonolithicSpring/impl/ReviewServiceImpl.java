package com.anand.MonolithicSpring.impl;

import com.anand.MonolithicSpring.model.Company;
import com.anand.MonolithicSpring.model.Review;
import com.anand.MonolithicSpring.repository.ReviewRepository;
import com.anand.MonolithicSpring.service.CompanyService;
import com.anand.MonolithicSpring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private CompanyService companyService;
    @Override
    public List<Review> getAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Boolean addReview(Review review,Long companyId) {
        Company company = companyService.getById(companyId);
        if (company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Long companyId,Long reviewId) {
        List<Review> reviews =reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if (companyService.getById(companyId)!=null){
            updatedReview.setCompany(companyService.getById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
        }
    }
}
