package com.ijv.internjava.model.dto;

<<<<<<< HEAD


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
=======
import jakarta.persistence.*;
import lombok.Data;

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
<<<<<<< HEAD
@Getter
@Setter
public class BaseEntity implements Serializable {

    @Column(name = "CREATED_BY", length = 100)
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "UPDATED_BY", length = 100)
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "IS_DELETED")
=======
@Data
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
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
    private Boolean isDeleted;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }
<<<<<<< HEAD
=======

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
    @PreUpdate
    protected void onUpdate() {
        updatedOn = new Date();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
