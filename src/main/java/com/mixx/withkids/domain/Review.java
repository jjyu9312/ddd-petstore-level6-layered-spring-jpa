package com.mixx.withkids.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "REVIEW_ID")
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "RESERVATION_ID")
    private Reservation reservation;

    private String reviewTitle;

    private String reviewContent;

    private ReviewType reviewType;

    private Date createdAt;

    // method
    public Date checkReview(){

        Date today = new Date();

        if(today.before(new Date(getCreatedAt().getTime()))) {
            return new Date(getCreatedAt().getTime());
        }
        else return today;
    }
}
