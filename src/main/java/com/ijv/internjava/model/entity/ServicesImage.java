package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
<<<<<<< HEAD
<<<<<<< HEAD
import lombok.*;

import jakarta.persistence.*;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "services_image")
public class ServicesImage extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
=======
=======
<<<<<<< HEAD
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
=======
import lombok.Data;
=======
import lombok.*;
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)

import jakarta.persistence.*;
import java.util.Date;
>>>>>>> 49c445e (spring_app)

<<<<<<< HEAD

@Getter
@Setter
@Entity
=======
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
@Table(name = "services_image")
@Entity
public class ServicesImage extends BaseEntity {
    @Id
<<<<<<< HEAD
    @Column(name = "id", nullable = false)
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
    @Column(name = "ID", nullable = false)
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
<<<<<<< HEAD
<<<<<<< HEAD
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Services service;

    @Column(name = "NAME_FILE", nullable = false)
    private String nameFile;

}
=======
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
=======
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Services service;
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)

    @Column(name = "NAME_FILE", nullable = false)
    private String nameFile;
<<<<<<< HEAD
=======

<<<<<<< HEAD
}
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
>>>>>>> 49c445e (spring_app)
}
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
