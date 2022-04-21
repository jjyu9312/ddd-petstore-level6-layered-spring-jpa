package com.mixx.withkids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Date;

import com.mixx.withkids.domain.Review;
import com.mixx.withkids.domain.ReviewRepository;
import com.mixx.withkids.domain.ReviewType;

@SpringBootApplication
public class ReviewApplication {
	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(ReviewApplication.class, args);

		ReviewRepository repository = applicationContext.getBean(ReviewRepository.class);

		Review rv = new Review(user);
		rv.setUserId("1");
		rv.setUsername("genie");
		rv.setActivityId("1");
		rv.setActivityName("롯데월드 패키지");
		rv.setReviewTitle("정말 재밌었어요");
		rv.setReviewContent("시간가는 줄 모르고 정말 재밌게 놀았습니다.");
		rv.setReviewType(ReviewType.추천);
		rv.setCreatedAt(new Date());
		repository.save(rv);
		System.out.println("==========================");
		repository.findById(0L);
		System.out.println("==========================");
		System.out.println(rv.checkReview());
	}

}
