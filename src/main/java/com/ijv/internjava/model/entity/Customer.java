package com.ijv.internjava.model.entity;
import com.ijv.internjava.model.dto.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CUSTOMER")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "customer")
@Table
public class Customer extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUSTOMER_NAME", nullable = false, length = 100)
    private String customerName;

    @Column(name = "PHONE_NUMBER", nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "ADDRESS", length = 500)
    private String address;

    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;


    @Column(name = "TOTAL_MONEY", precision = 10)
    private BigDecimal totalMoney;

    @OneToMany(mappedBy = "customer")
    private Set<Booking> bookings = new LinkedHashSet<>();
}
