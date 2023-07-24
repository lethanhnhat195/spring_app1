package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "work_shift")
@Entity
public class WorkShift extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

    @Column(name = "WORKING_FROM_TIME", nullable = false)
    private Date workingFromTime;

    @Column(name = "WORKING_TO_TIME", nullable = false)
    private Date workingToTime;

    @Column(name = "IS_DEFAULT")
    private Boolean isDefault;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @OneToMany(mappedBy = "workshift")
    private Set<Employee> employees = new LinkedHashSet<>();
}

