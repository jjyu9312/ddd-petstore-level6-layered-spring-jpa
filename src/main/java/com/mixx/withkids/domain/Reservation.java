package com.mixx.withkids.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue
    @Column(name = "RESERVATION_ID")
    private Long id;

    private String activityName;
}
