package com.ijv.internjava.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEES", indexes = {
        @Index(name = "WORK_SHIFT_ID", columnList = "WORK_SHIFT_ID")
})
@Getter
@Setter
public class Employee {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "GENDER")
    private Boolean gender;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "PHONE", nullable = false, length = 10)
    private String phone;

    @Column(name = "ADDRESS", length = 500)
    private String address;

    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Column(name = "IMAGE", length = 200)
    private String image;

    @Column(name = "USER_NAME", nullable = false, length = 50)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "WORK_SHIFT_ID", nullable = false)
    private WorkShift workShift;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeService> employeeServices = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles = new LinkedHashSet<>();

}