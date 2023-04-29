package com.upao.api_book.service;

import com.upao.api_book.model.Review;

import java.util.List;

public interface ReviewService{
    Review createReview(String title, String comment, Integer rating, Long bookId, Long userId);
    Review updateReview(Long id, String title, String comment, Integer rating);
    void deleteReview(Long id);
    List<Review> getAllReviews();
    Review getReviewById(Long id);
}
