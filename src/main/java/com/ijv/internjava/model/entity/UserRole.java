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
