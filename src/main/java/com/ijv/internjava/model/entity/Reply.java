package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "replies", indexes = {
        @Index(name = "feedbacks_id", columnList = "feedbacks_id")
})
@Getter
@Setter
public class Reply extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "feedbacks_id", nullable = false)
    private Feedback feedbacks;

    @Column(name = "title", length = 256)
    private String title;

    @Column(name = "content", length = 256)
    private String content;
}