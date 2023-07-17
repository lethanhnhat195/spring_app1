package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
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

    @ManyToOne(targetEntity=Roles.class,fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private Roles role;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
}
