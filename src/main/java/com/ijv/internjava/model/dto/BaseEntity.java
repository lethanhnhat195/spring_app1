package com.ijv.internjava.model.dto;

<<<<<<< HEAD
<<<<<<< HEAD


import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
=======
=======
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

<<<<<<< HEAD
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
=======


<<<<<<< HEAD
import lombok.Data;
>>>>>>> 49c445e (spring_app)
=======
import lombok.Getter;
import lombok.Setter;
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)

import jakarta.persistence.*;
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
<<<<<<< HEAD
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
=======
@Getter
@Setter
public class BaseEntity implements Serializable {
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)

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

<<<<<<< HEAD
    @Column(name = "is_deleted")
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
    @Column(name = "IS_DELETED")
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
}
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
