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

		MemberRepository memberRepository = applicationContext.getBean(MemberRepository.class);
		ReservationRepository reservationRepository = applicationContext.getBean(ReservationRepository.class);
		ReviewRepository reviewRepository = applicationContext.getBean(ReviewRepository.class);
		Member member = new Member();
		member.setUsername("Genie");
		memberRepository.save(member);

		Reservation reservation = new Reservation();
		reservation.setActivityName("LotteWorld Package");
		reservationRepository.save(reservation);

		Review rv = new Review();
		rv.setMember(member);
		rv.setReservation(reservation);
		rv.setReviewTitle("It was really fun");
		rv.setReviewContent("I didn't notice the passing of time and I had a lot of fun.");
		rv.setReviewType(ReviewType.GOOD);
		rv.setCreatedAt(new Date());

		reviewRepository.save(rv);
		reviewRepository.findById(1L);
		
		System.out.println("==========================");
		System.out.println(rv.getReviewTitle());
		System.out.println(rv.getReviewContent());
		System.out.println(rv.getReviewType());
		System.out.println("==========================");
	}

}
