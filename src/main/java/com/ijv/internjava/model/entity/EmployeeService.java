package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EMPLOYEE_SERVICE", indexes = {
        @Index(name = "EMPLOYEE_ID", columnList = "EMPLOYEE_ID"),
        @Index(name = "SERVICE_ID", columnList = "SERVICE_ID")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class EmployeeService extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employees employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Services service;

    @Column(name = "NOTE", length = 500)
    private String note;
}
