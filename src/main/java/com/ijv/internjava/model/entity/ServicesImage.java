package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;

import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.*;


@Entity
@Table(name = "SERVICES_IMAGE", indexes = {
        @Index(name = "SERVICE_ID", columnList = "SERVICE_ID")
})

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "services_image")
@Entity
public class ServicesImage extends BaseEntity {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_ID", nullable = false)

    private Service service;

    @Column(name = "NAME_FILE", nullable = false, length = 256)

    private String nameFile;

}
