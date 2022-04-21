package com.mixx.withkids.domain;

import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    public ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reviews/{id}/select")
    public Review selectReview(@PathVariable("id") Long id) {
        Review rv = new Review();
        reviewRepository.findById(rv.getReviewId(id));

        return rv;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/reviews")
    public Review savePet(@RequestBody Review rv) {
        reviewRepository.save(rv);
        return rv;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/reviews/{id}/delete")
    public void deleteReview(@PathVariable("id") Long id) {
        reviewRepository.findById(id).ifPresent(rv -> {
            reviewRepository.delete(rv);
        });
    }
}
