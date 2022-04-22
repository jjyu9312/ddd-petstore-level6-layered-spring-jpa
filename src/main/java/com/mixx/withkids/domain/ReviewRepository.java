package com.mixx.withkids.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findByActivityId(Long id); // select * from review where activity = id;

    List<Review> findByMemberId(Long id);   // select * from review where member = id;
}
