package com.ijv.internjava.model.entity;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_role", indexes = {
        @Index(name = "role_id", columnList = "role_id"),
        @Index(name = "user_id", columnList = "user_id")
})
@Getter
@Setter
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Employee user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
    public UserRole(Employee user, Role role) {
        this.user = user;
        this.role = role;
    }

    public UserRole() {
    }

}