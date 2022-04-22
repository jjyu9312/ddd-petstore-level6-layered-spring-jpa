package com.mixx.withkids.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long>{
    Optional<Activity> findByActivityName(String name);
}
