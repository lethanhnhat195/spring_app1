package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYEE_SERVICE", indexes = {
        @Index(name = "EMPLOYEE_ID", columnList = "EMPLOYEE_ID"),
        @Index(name = "SERVICE_ID", columnList = "SERVICE_ID")
})
@Getter
@Setter
public class EmployeeService extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Service service;

    @Column(name = "NOTE", length = 500)
    private String note;
}