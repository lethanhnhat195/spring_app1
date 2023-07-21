package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.persistence.*;
<<<<<<< HEAD
<<<<<<< HEAD
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "employee_service")
=======
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
=======
import javax.persistence.*;
import lombok.Data;
=======
import jakarta.persistence.*;
import lombok.*;
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)


import java.util.Date;

<<<<<<< HEAD
@Data
>>>>>>> 49c445e (spring_app)
@Entity
=======
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
@Table(name = "employee_service")
@Entity
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
public class EmployeeService extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity=Employees.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID", nullable = false)
    private Employees employee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_ID", nullable = false)
    private Services service;

    @Column(name = "NOTE")
    private String note;
<<<<<<< HEAD
}

=======

<<<<<<< HEAD
<<<<<<< HEAD
=======
    /*JPA Required Constructor*/
    public EmployeeService() {
    }
=======
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
}
>>>>>>> 49c445e (spring_app)
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
