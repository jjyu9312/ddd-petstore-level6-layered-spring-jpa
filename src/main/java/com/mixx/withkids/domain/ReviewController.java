package com.mixx.withkids.domain;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    public ReviewRepository reviewRepository;
    public MemberRepository memberRepository;
    public ActivityRepository activityRepository;

    public ReviewController(ReviewRepository reviewRepository, MemberRepository memberRepository, ActivityRepository activityRepository) {
        this.reviewRepository = reviewRepository;
        this.memberRepository = memberRepository;
        this.activityRepository = activityRepository;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/reviews")
    public Review savePet(@RequestBody Review rv) {
        reviewRepository.save(rv);
        return rv;
    }

    // 단순 Review ID로 조회
    @RequestMapping(method = RequestMethod.GET, path = "/reviews/review/{Id}/select")
    public Review selectReview(@PathVariable("Id") Long reviewId) {
        Optional<Review> rv = reviewRepository.findById(reviewId);

        return rv.get();
    }

    // Reservation ID로 조회
    @RequestMapping(method = RequestMethod.GET, path = "/reviews/activity/{name}/select")
    public List<Review> selectActivityId(@PathVariable("name") String name) {
        Optional<Activity> activity = activityRepository.findByActivityName(name);
        List<Review> rv = reviewRepository.findByActivityId(activity.get().getId());

        return rv;
    }
    // Member ID로 조회
    @RequestMapping(method = RequestMethod.GET, path = "/reviews/member/{name}/select")
    public List<Review> selectMemberId(@PathVariable("name") String name) {
        Optional<Member> member = memberRepository.findByMemberName(name);
        List<Review> rv = reviewRepository.findByMemberId(member.get().getId());
        return rv;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/reviews/{id}/delete")
    public void deleteReview(@PathVariable("id") Long reviewId) {
        reviewRepository.findById(reviewId).ifPresent(rv -> {
            reviewRepository.delete(rv);
        });
    }
}
