package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "services")
@Getter
@Setter
public class Service extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "service_time", nullable = false)
    private Integer serviceTime;

    @Column(name = "price", nullable = false, precision = 10)
    private BigDecimal price;

    @Column(name = "description", length = 500)
    private String description;

    @OneToMany(mappedBy = "service")
    private Set<EmployeeService> employeeServices = new LinkedHashSet<>();

    @OneToMany(mappedBy = "services")
    private Set<Feedback> feedbacks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "service")
    private Set<ServicesImage> servicesImages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "service")
    private Set<BookingDetail> bookingDetails = new LinkedHashSet<>();
}