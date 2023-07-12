package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "replies")
public class Replies extends BaseEntity {
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity=Feedbacks.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FEEDBACKS_ID", nullable = false)
    private Feedbacks feedbacks;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    /*JPA Required Constructor*/
    public Replies() {
    }
}
