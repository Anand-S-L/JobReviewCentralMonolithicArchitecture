package com.anand.MonolithicSpring.controller;

import com.anand.MonolithicSpring.model.Review;
import com.anand.MonolithicSpring.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAll(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        if (
                reviewService.addReview(review, companyId)) {
            return new ResponseEntity<>(String.format("Successfully added Review for company with id %d", companyId), HttpStatus.OK);

        }
        return new ResponseEntity<>(String.format("Company with id %d not found and review not saved", companyId), HttpStatus.NOT_FOUND);

    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReviewById(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        reviewService.updateReview(companyId, reviewId, review);
        return new ResponseEntity<>("Review updated", HttpStatus.OK);
    }
}
