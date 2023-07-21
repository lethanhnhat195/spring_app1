package com.ijv.internjava.model.entity;
import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
=======
import java.util.LinkedHashSet;
import java.util.Set;

>>>>>>> ce725da (Fix conflict on branch customer manager)
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
>>>>>>> ce725da (Fix conflict on branch customer manager)
public class Customer extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;
<<<<<<< HEAD
    @Column(name = "total_money", precision = 10)
    private BigDecimal totalMoney;
=======

    @Column(name = "TOTAL_MONEY")
    private Long totalMoney;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Booking> booking = new LinkedHashSet<>();

>>>>>>> ce725da (Fix conflict on branch customer manager)
}
