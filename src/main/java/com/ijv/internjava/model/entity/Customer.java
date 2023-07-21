package com.ijv.internjava.model.entity;
import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Entity(name = "customer")
@Table
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
    @Column(name = "total_money", precision = 10)
    private BigDecimal totalMoney;
}
