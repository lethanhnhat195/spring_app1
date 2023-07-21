package com.ijv.internjava.controller;

import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.model.dto.FeedbackDto;
import com.ijv.internjava.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    /*Get list*/
    @GetMapping
    public ResponseEntity<ApiResponseDto> findAll() {
        return ResponseEntity.ok().body(ApiResponseDto.builder()
                .code("feedbackService.findAll()")
                .message("Get list feedback")
                .data(feedbackService.findAll())
                .status("HttpStatus.CREATED")
                .build());
    }

    /*Add new feedback*/
    @PostMapping("/{id}/add")
    public ResponseEntity<ApiResponseDto> add(@PathVariable(name = "id") long id, @RequestBody FeedbackDto feedbackDto) {
        return ResponseEntity.ok().body(ApiResponseDto.builder()
                .code("feedbackService.add(id,feedbackDto)")
                .message("Add new feedback")
                .data(feedbackService.add(id, feedbackDto))
                .status("HttpStatus.CREATED")
                .build());
    }

    /*Update feedback*/
    @PutMapping("/{id}/update")
    public ResponseEntity<ApiResponseDto> update(@PathVariable(name = "id") long id, @RequestBody FeedbackDto feedbackDto) {
        return ResponseEntity.ok().body(ApiResponseDto.builder()
                .code("Update feedback")
                .message("Update feedback")
                .data(feedbackService.update(id, feedbackDto))
                .status("HttpStatus.CREATED")
                .build());
    }

    /*Delete feedback*/
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        feedbackService.delete(id);
    }
}


