package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "services")
public class Services extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SERVICE_TIME", nullable = false)
    private Integer serviceTime;

    @Column(name = "PRICE", nullable = false)
    private Long price;

    @Column(name = "DESCRIPTION")
    private String description;

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

    /*JPA Require Constructor*/
    public Services() {
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "service")
    private Set<EmployeeService> employeeServices = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "services")
    private Set<Feedbacks> feedbacks = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "service")
    private Set<ServicesImage> servicesImages = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "service")
    private Set<BookingDetail> bookingDetails = new LinkedHashSet<>();
}
