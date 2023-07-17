package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "booking_detail")
public class BookingDetail extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
=======
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "booking_detail", indexes = {
        @Index(name = "booking_id", columnList = "booking_id"),
        @Index(name = "service_id", columnList = "service_id")
})
@Getter
@Setter
public class BookingDetail extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
<<<<<<< HEAD
    @JoinColumn(name = "BOOKING_ID", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Services service;

    @Column(name = "NOTE")
    private String note;

}
=======
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "note", length = 500)
    private String note;

}
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
