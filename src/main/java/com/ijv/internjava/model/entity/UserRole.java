package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
<<<<<<< HEAD
import lombok.*;

import jakarta.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "user_role")
public class UserRole extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private Employees user;

=======
<<<<<<< HEAD
<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
=======
import lombok.Data;
=======
import lombok.*;
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)

import jakarta.persistence.*;

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
@Table(name = "user_role")
@Entity
public class UserRole extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private Employees user;

>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
    @ManyToOne(targetEntity=Roles.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Roles role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
<<<<<<< HEAD
}
=======

<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
=======
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
}

>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
