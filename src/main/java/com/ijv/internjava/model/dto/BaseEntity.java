package com.ijv.internjava.model.dto;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
=======

import jakarta.persistence.*;
import lombok.Data;

>>>>>>> 470e9af (create database with jpa)
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
<<<<<<< HEAD
@Getter
@Setter
=======
@Data
>>>>>>> 470e9af (create database with jpa)
public abstract class BaseEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "is_deleted")

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedOn = new Date();
    }
}