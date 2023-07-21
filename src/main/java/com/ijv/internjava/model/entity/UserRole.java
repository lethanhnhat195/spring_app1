package com.ijv.internjava.model.entity;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER_ROLE", indexes = {
        @Index(name = "ROLE_ID", columnList = "ROLE_ID"),
        @Index(name = "USER_ID", columnList = "USER_ID")
})
@Getter
@Setter
<<<<<<< HEAD
public class UserRole {
=======
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "user_role")
@Entity
public class UserRole extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private Employees user;

    @ManyToOne(targetEntity=Roles.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Roles role;
>>>>>>> ce725da (Fix conflict on branch customer manager)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private Employee user;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;

}

