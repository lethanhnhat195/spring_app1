package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "FEEDBACKS", indexes = {
        @Index(name = "SERVICES_ID", columnList = "SERVICES_ID")
})
@Getter
@Setter
public class Feedback extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICES_ID", nullable = false)
    private Service services;

    @Column(name = "TITLE", length = 256)
    private String title;

    @Column(name = "CONTENT", length = 256)
    private String content;

    @Column(name = "REPLY_ID")
    private Long replyId;

    @Column(name = "RATING")
    private Integer rating;

    @OneToMany(mappedBy = "FEEDBACKS")
    private Set<Reply> replies = new LinkedHashSet<>();

}