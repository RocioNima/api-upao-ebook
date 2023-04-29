package com.upao.api_book.controller;

import com.upao.api_book.model.Review;
import com.upao.api_book.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
        public ResponseEntity<Review> addReview(@RequestParam String title,
                                                @RequestParam String comment,
                                                @RequestParam Integer rating,
                                                @RequestParam Long bookId,
                                                @RequestParam Long userId){
        Review review1 = reviewService.createReview(title,comment,rating,bookId,userId);
        return ResponseEntity.ok(review1);
    }

    @GetMapping
        public ResponseEntity<List<Review>> getAllReview(){
            return new ResponseEntity<List<Review>>(reviewService.getAllReviews(), HttpStatus.OK);
    }


    @PostMapping("/update/{id}")
        public ResponseEntity<Review> updateReviewById(@PathVariable Long id,
                                                       @PathVariable String title,
                                                       @PathVariable String comment,
                                                       @PathVariable Integer rating){
        Review review1 = reviewService.updateReview(id,title,comment,rating);
        return ResponseEntity.ok(review1);
    }

    @DeleteMapping("/delete/{id}")
        public void deleteReview(@PathVariable Long id){
            reviewService.deleteReview(id);
    }
}
