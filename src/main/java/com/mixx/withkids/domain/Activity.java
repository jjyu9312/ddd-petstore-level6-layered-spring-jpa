package com.mixx.withkids.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Activity {

    @Id
    @GeneratedValue
    @Column(name = "ACTIVITY_ID")
    private Long id;

    @Column(name = "ACTIVITY_NAME")
    private String activityName;
}
