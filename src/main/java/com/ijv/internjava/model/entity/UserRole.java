package com.ijv.internjava.model.entity;


import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "USER_ROLE", indexes = {
        @Index(name = "ROLE_ID", columnList = "ROLE_ID"),
        @Index(name = "USER_ID", columnList = "USER_ID")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class UserRole {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private Employees user;

    @ManyToOne(targetEntity=Roles.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Roles role;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}

