package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "REPLIES", indexes = {
        @Index(name = "FEEDBACKS_ID", columnList = "FEEDBACKS_ID")
})
@Getter
@Setter
public class Replies extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FEEDBACKS_ID", nullable = false)
    private Feedbacks feedbacks;

    @Column(name = "TITLE", length = 256)
    private String title;

    @Column(name = "CONTENT", length = 256)
    private String content;
}