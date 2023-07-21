package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
<<<<<<< HEAD

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;

=======
import javax.persistence.*;
>>>>>>> 49c445e (spring_app)
=======
import lombok.*;

import jakarta.persistence.*;
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

<<<<<<< HEAD

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "work_shift")
=======
<<<<<<< HEAD
@Getter
@Setter
@Entity
=======
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
@Table(name = "work_shift")
@Entity
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
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

<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
    /*JPA Require Constructor*/
    public WorkShift() {
    }

>>>>>>> 49c445e (spring_app)
=======
>>>>>>> ac64e9d (First 5 Feature of Customer Manager)
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "workShiftId")
    private Set<Employees> employees = new LinkedHashSet<>();
}
