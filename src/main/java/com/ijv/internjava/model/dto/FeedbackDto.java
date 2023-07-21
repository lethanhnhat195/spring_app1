package com.ijv.internjava.model.dto;

import com.ijv.internjava.model.entity.Services;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDto implements Serializable {
    private Long id;
    private String name;
    private String email;
    private Integer serviceId;
    private String title;
    private String content;
    private Integer replyId;
    private Integer rating;
}
