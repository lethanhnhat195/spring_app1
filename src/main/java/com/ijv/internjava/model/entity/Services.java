package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "SERVICES")
@Getter
@Setter
public class Services extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "SERVICE_TIME", nullable = false)
    private Integer serviceTime;

    @Column(name = "PRICE", nullable = false, precision = 10)
    private BigDecimal price;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @OneToMany(mappedBy = "service")
    private Set<EmployeeService> employeeServices = new LinkedHashSet<>();

    @OneToMany(mappedBy = "services")
    private Set<Feedbacks> feedbacks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "service")
    private Set<ServicesImage> servicesImages = new LinkedHashSet<>();

    @OneToMany(mappedBy = "service")
    private Set<BookingDetail> bookingDetails = new LinkedHashSet<>();

    public Services(Long serviceId) {
        this.id = serviceId;
    }
}