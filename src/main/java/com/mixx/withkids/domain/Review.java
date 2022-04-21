package com.mixx.withkids.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Review {

    @Id
    @GeneratedValue
    private Long reviewId;

    private User user;

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
