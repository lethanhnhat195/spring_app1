package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "services")
<<<<<<< HEAD

@Entity
public class Services extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SERVICE_TIME", nullable = false)
    private Integer serviceTime;

    @Column(name = "PRICE", nullable = false)
    private Long price;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "service")
    private Set<EmployeeService> employeeServices = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "services")
    private Set<Feedbacks> feedbacks = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "service")
    private Set<ServicesImage> servicesImages = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "service")
    private Set<BookingDetail> bookingDetails = new LinkedHashSet<>();
}
