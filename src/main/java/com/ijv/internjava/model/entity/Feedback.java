package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "feedbacks", indexes = {
        @Index(name = "services_id", columnList = "services_id")
})
@Getter
@Setter
public class Feedback extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "services_id", nullable = false)
    private Service services;

    @Column(name = "title", length = 256)
    private String title;

    @Column(name = "content", length = 256)
    private String content;

    @Column(name = "reply_id")
    private Long replyId;

    @Column(name = "rating")
    private Integer rating;

    @OneToMany(mappedBy = "feedbacks")
    private Set<Reply> replies = new LinkedHashSet<>();

}