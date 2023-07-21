package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
<<<<<<< HEAD
<<<<<<< HEAD

import lombok.*;

=======
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
=======

import lombok.*;

>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.persistence.*;

@Builder
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


    @OneToMany(mappedBy = "booking")
    private Set<BookingDetail> bookingDetails = new LinkedHashSet<>();
}
=======
=======
<<<<<<< HEAD
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)

@Getter
@Setter
=======
import javax.persistence.*;
@Data
>>>>>>> 49c445e (spring_app)
@Entity
=======
import jakarta.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
@Table(name = "booking")
@Entity
public class Booking extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false)
    private Customer customer;

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

<<<<<<< Updated upstream
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
    /*JPA Require Constructor*/
    public Booking() {
    }
>>>>>>> 49c445e (spring_app)
=======
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)

    @OneToMany(mappedBy = "booking")
    private Set<BookingDetail> bookingDetails = new LinkedHashSet<>();
}
=======
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "booking")
    private Set<BookingDetail> bookingDetail = new LinkedHashSet<>();

}
<<<<<<< HEAD
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
>>>>>>> Stashed changes
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
