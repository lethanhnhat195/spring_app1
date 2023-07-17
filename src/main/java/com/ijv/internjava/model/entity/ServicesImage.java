package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
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
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "services_image", indexes = {
        @Index(name = "service_id", columnList = "service_id")
})
@Getter
@Setter
public class ServicesImage extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
<<<<<<< HEAD
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Services service;

    @Column(name = "NAME_FILE", nullable = false)
    private String nameFile;

}
=======
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "name_file", nullable = false, length = 256)
    private String nameFile;

}
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
