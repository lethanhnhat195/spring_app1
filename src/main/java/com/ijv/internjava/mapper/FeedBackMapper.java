package com.ijv.internjava.mapper;

import com.ijv.internjava.model.dto.FeedbackDto;
import com.ijv.internjava.model.entity.Feedbacks;
import com.ijv.internjava.model.entity.Services;

public class FeedBackMapper {
    private static FeedBackMapper INSTANCE;

    public static FeedBackMapper getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new FeedBackMapper ();
        }
        return INSTANCE;
    }
    public Feedbacks toEntity(FeedbackDto feedbackDto) {
        Feedbacks feedback = new Feedbacks();
        feedback.setId(feedbackDto.getId());
        feedback.setName(feedbackDto.getName());
        feedback.setEmail(feedbackDto.getEmail());
        feedback.setTitle(feedbackDto.getTitle());
        feedback.setServices(new Services(feedbackDto.getServiceId()));
        feedback.setContent(feedbackDto.getContent());
        feedback.setReplyId(feedbackDto.getReplyId());
        feedback.setRating(feedbackDto.getRating());
        return feedback;
    }

    public FeedbackDto toDto(Feedbacks feedback) {
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setId(feedback.getId());
        feedbackDto.setName(feedback.getName());
        feedbackDto.setEmail(feedback.getEmail());
        feedbackDto.setServiceId(feedback.getServices().getId());
        feedbackDto.setTitle(feedback.getTitle());
        feedbackDto.setContent(feedback.getContent());
        feedbackDto.setReplyId(feedback.getReplyId());
        feedbackDto.setRating(feedback.getRating());
        return feedbackDto;
    }
}