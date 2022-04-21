package com.mixx.withkids.domain;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ReviewController {

    public ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reviews/{id}/select")
    public Review selectReview(@PathVariable("id") Long reviewId) {
        Optional<Review> rv = reviewRepository.findById(reviewId);

        return rv.get();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/reviews")
    public Review savePet(@RequestBody Review rv) {
        reviewRepository.save(rv);
        return rv;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/reviews/{id}/delete")
    public void deleteReview(@PathVariable("id") Long reviewId) {
        reviewRepository.findById(reviewId).ifPresent(rv -> {
            reviewRepository.delete(rv);
        });
    }
}
