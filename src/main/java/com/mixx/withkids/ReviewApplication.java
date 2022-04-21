package com.mixx.withkids;

import com.mixx.withkids.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

@SpringBootApplication
public class ReviewApplication {
	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(ReviewApplication.class, args);

		ReviewRepository repository = applicationContext.getBean(ReviewRepository.class);
		Member member = new Member();
		member.setId(0L);
		member.setUsername("Genie");
		Reservation reservation = new Reservation();
		reservation.setActivityName("LotteWorld Package");
		Review rv = new Review();
		rv.setMember(member);
		rv.setReservation(reservation);
		rv.setReviewTitle("It was really fun");
		rv.setReviewContent("I didn't notice the passing of time and I had a lot of fun.");
		rv.setReviewType(ReviewType.GOOD);
		rv.setCreatedAt(new Date());
		repository.save(rv);
		System.out.println("==========================");
		repository.findById(0L);
		System.out.println("==========================");
		System.out.println(rv.checkReview());
	}

}
