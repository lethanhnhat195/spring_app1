package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;
=======
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
>>>>>>> ce725da (Fix conflict on branch customer manager)


@Entity
@Table(name = "BOOKING_DETAIL", indexes = {
        @Index(name = "BOOKING_ID", columnList = "BOOKING_ID"),
        @Index(name = "SERVICE_ID", columnList = "SERVICE_ID")
})

@Getter
@Setter
@Entity
@Table(name = "booking_detail")
@Entity
public class BookingDetail extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BOOKING_ID", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Service service;

    @Column(name = "NOTE", length = 500)
    private String note;
<<<<<<< HEAD
}
=======


}
>>>>>>> ce725da (Fix conflict on branch customer manager)
