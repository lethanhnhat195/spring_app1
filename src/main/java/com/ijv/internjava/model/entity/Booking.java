package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;

import lombok.Data;


import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
@Data
@Entity
@Table(name = "booking")
public class Booking extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BOOKING_DATE", nullable = false)
    private Date bookingDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FROM_TIME", nullable = false)
    private Date fromTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TO_TIME", nullable = false)
    private Date toTime;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "STATUS")
    private Integer status;

    /*JPA Require Constructor*/
    public Booking() {
    }

    @OneToMany(mappedBy = "booking")
    private Set<BookingDetail> bookingDetails = new LinkedHashSet<>();
}
