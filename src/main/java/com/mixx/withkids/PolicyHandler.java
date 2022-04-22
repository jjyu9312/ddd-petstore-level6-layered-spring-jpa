package com.mixx.withkids;

import com.mixx.withkids.domain.*;
import com.mixx.withkids.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PolicyHandler {
    @Autowired
    ReviewMemberRepository reviewMemberRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverMemberReserved_displayOnTheReview(@Payload MemberReserved memberReserved){ // member 데이터는 받을 때 한번에 받음
        if(!memberReserved.validate())
            return;

        ReviewMember rm = new ReviewMember();
        rm.setId(memberReserved.getId());
        rm.setMemberName(memberReserved.getMemberName());
        reviewMemberRepository.save(rm);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPetUpdate_updateItem(@Payload MemberUpdated memberUpdated){
        if(!memberUpdated.validate())
            return;

        reviewMemberRepository.findById(memberUpdated.getId()).ifPresent(member->{
            member.setId(memberUpdated.getId());
            member.setMemberName(memberUpdated.getMemberName());
            reviewMemberRepository.save(member);
        });
    }
}