package com.mixx.withkids;

import com.mixx.withkids.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

public class ReviewMain {
    static ApplicationContext applicationContext;
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static void main(String[] args) {

        MemberRepository memberRepository = applicationContext.getBean(MemberRepository.class);
        ActivityRepository reservationRepository = applicationContext.getBean(ActivityRepository.class);
        ReviewRepository reviewRepository = applicationContext.getBean(ReviewRepository.class);
        Member member = new Member();
        member.setMemberName("Genie");
        memberRepository.save(member);
        Member member2 = new Member();
        member2.setMemberName("KKW");
        memberRepository.save(member2);

        Activity activity1 = new Activity();
        activity1.setActivityName("LotteWorldPackage");
        reservationRepository.save(activity1);

        Activity activity2 = new Activity();
        activity2.setActivityName("EverLandPackage");
        reservationRepository.save(activity2);

        Review rv = new Review();
        rv.setMember(member);
        rv.setActivity(activity1);
        rv.setReviewTitle("It was really fun");
        rv.setReviewContent("I didn't notice the passing of time and I had a lot of fun.");
        rv.setReviewType(ReviewType.GOOD);
        rv.setCreatedAt(new Date());
        Review rv2 = new Review();
        rv2.setMember(member);
        rv2.setActivity(activity2);
        rv2.setReviewTitle("very exciting");
        rv2.setReviewContent("very very awesome!!!!");
        rv2.setReviewType(ReviewType.GOOD);
        rv2.setCreatedAt(new Date());

        reviewRepository.save(rv);
        reviewRepository.save(rv2);
        // reviewRepository.findById(1L);
    }
}
