package com.ijv.internjava.model.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "employees", indexes = {
        @Index(name = "work_shift_id", columnList = "work_shift_id")
})

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone", nullable = false, length = 10)
    private String phone;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "image", length = 200)
    private String image;

    @Column(name = "username", nullable = false, length = 50)

    @Column(name = "user_name", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "work_shift_id", nullable = false)
    private WorkShift workShift;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "updated_on")
    private Date updatedOn;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeService> employeeServices = new LinkedHashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new LinkedHashSet<>();

}