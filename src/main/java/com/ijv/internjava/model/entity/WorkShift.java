package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import lombok.Data;

import jakarta.persistence.*;
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

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

    /*JPA Require Constructor*/
    public WorkShift() {
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "workShiftId")
    private Set<Employees> employees = new LinkedHashSet<>();
}
