package com.ijv.internjava.model.entity;
import com.ijv.internjava.model.dto.BaseEntity;

import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;


@Entity
@Table(name = "BOOKING")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "booking")
public class Booking extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @Column(name = "PHONE_NUMBER", nullable = false, length = 10)

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


    @Column(name = "NOTE", length = 500)

    private String note;

    @Column(name = "STATUS")
    private Integer status;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "booking")
    private Set<BookingDetail> bookingDetail = new LinkedHashSet<>();
}