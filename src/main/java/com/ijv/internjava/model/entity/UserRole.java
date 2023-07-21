package com.ijv.internjava.model.entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USER_ROLE", indexes = {
        @Index(name = "ROLE_ID", columnList = "ROLE_ID"),
        @Index(name = "USER_ID", columnList = "USER_ID")
})
@Getter
@Setter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private Employee user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Role role;
}