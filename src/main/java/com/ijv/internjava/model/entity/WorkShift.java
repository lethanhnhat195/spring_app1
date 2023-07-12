package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "work_shift")
public class WorkShift extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WORKING_FROM_TIME", nullable = false)
    private Date workingFromTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WORKING_TO_TIME", nullable = false)
    private Date workingToTime;

    @Column(name = "IS_DEFAULT")
    private Boolean isDefault;

    @Column(name = "DESCRIPTION")
    private String description;

    /*JPA Require Constructor*/
    public WorkShift() {
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "workShiftId")
    private Set<Employees> employees = new LinkedHashSet<>();
}
