package com.ijv.internjava.model.entity;
import com.ijv.internjava.model.dto.BaseEntity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.*;
import java.util.Date;

=======
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import lombok.*;
import java.util.LinkedHashSet;
import java.util.Set;

>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
<<<<<<< HEAD
@Entity(name = "customer")
@Table
=======
@Entity
@Table(name = "customer")
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
public class Customer extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "ADDRESS")
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_OF_BIRTH", columnDefinition = "date")
    private Date dateOfBirth;

    @Column(name = "TOTAL_MONEY")
    private Long totalMoney;
<<<<<<< HEAD
}

=======

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Booking> booking = new LinkedHashSet<>();
}
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
