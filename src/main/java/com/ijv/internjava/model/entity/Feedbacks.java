package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import lombok.Data;

import jakarta.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "feedbacks")
public class Feedbacks extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICES_ID", nullable = false)
    private Services services;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "REPLY_ID")
    private Integer replyId;

    @Column(name = "RATING")
    private Integer rating;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

    /*JPA Required Constructor*/
    public Feedbacks() {
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "feedbacks")
    private Set<Replies> replies = new LinkedHashSet<>();
}
