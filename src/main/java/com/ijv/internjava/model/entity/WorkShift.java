package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Table(name = "work_shift")
@Getter
@Setter
public class WorkShift extends BaseEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "working_from_time", nullable = false)
    private Date workingFromTime;

    @Column(name = "working_to_time", nullable = false)
    private Date workingToTime;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "description", length = 500)
    private String description;
    @OneToMany(mappedBy = "workShift")
    private Set<Employee> employees = new LinkedHashSet<>();

    public WorkShift(Long id) {
        this.id = id;
    }

    public WorkShift() {
    }
}
