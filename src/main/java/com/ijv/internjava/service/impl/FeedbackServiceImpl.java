package com.ijv.internjava.service.impl;

import com.ijv.internjava.mapper.FeedBackMapper;
import com.ijv.internjava.model.dto.FeedbackDto;
import com.ijv.internjava.model.entity.Feedbacks;
import com.ijv.internjava.model.entity.Services;
import com.ijv.internjava.repository.FeedbackRepository;
import com.ijv.internjava.service.FeedbackService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FeedbackServiceImpl implements FeedbackService {
    private FeedbackRepository feedbackRepository;
    @Override
    public List<FeedbackDto> findAll() {
        return feedbackRepository.findAll().stream()
                .map(feedbacks -> FeedBackMapper.getInstance().toDto(feedbacks))
                .collect(Collectors.toList());
    }

    @Override
    public FeedbackDto add(long id,FeedbackDto feedbackDto) {
        Feedbacks feedback = new Feedbacks();
        feedback.setId(feedbackDto.getId());
        feedback.setName(feedbackDto.getName());
        feedback.setEmail(feedbackDto.getEmail());
        feedback.setServices(new Services(feedbackDto.getServiceId()));
        feedback.setTitle(feedbackDto.getTitle());
        feedback.setContent(feedbackDto.getContent());
        feedback.setReplyId(feedbackDto.getReplyId());
        feedback.setRating(feedbackDto.getRating());
        Feedbacks feedbackAdded = feedbackRepository.save(feedback);
        return FeedBackMapper.getInstance().toDto(feedbackAdded);
    }

    @Override
    public FeedbackDto update(long id, FeedbackDto feedbackDto) {
        Feedbacks feedback = feedbackRepository.findById(id).get();
        feedback.setId(feedbackDto.getId());
        feedback.setName(feedbackDto.getName());
        feedback.setEmail(feedbackDto.getEmail());
        feedback.setServices(new Services(feedbackDto.getServiceId()));
        feedback.setTitle(feedbackDto.getTitle());
        feedback.setContent(feedbackDto.getContent());
        feedback.setReplyId(feedbackDto.getReplyId());
        feedback.setRating(feedbackDto.getRating());

        Feedbacks feedbackUpdated = feedbackRepository.save(feedback);
        return FeedBackMapper.getInstance().toDto(feedbackUpdated);
    }

    @Override
    public void delete(long id) {
        if (id>0) {
            Feedbacks feedbacks = feedbackRepository.getById(id);
            if (feedbacks != null) {
                feedbackRepository.delete(feedbacks);
            }
        }
    }
}
