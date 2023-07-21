package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;

<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;
=======
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
>>>>>>> ce725da (Fix conflict on branch customer manager)

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
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(name = "note", length = 500)
    private String note;
<<<<<<< HEAD
}
=======


}
>>>>>>> ce725da (Fix conflict on branch customer manager)
