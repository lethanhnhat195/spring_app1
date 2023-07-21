package com.ijv.internjava.service;

import com.ijv.internjava.model.dto.FeedbackDto;

import java.util.List;

public interface FeedbackService {
    List<FeedbackDto> findAll();
    FeedbackDto add(long id,FeedbackDto feedbackDto);
    FeedbackDto update(long id,FeedbackDto feedbackDto);
    void delete(long id);
}
