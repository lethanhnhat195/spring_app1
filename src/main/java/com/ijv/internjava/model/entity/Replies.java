package com.ijv.internjava.model.entity;

import com.ijv.internjava.model.dto.BaseEntity;
import lombok.*;

import jakarta.persistence.*;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "replies")
<<<<<<< HEAD
=======
@Entity
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
public class Replies extends BaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @ManyToOne(targetEntity=Feedbacks.class,fetch = FetchType.LAZY, optional = false)
=======
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
    @JoinColumn(name = "FEEDBACKS_ID", nullable = false)
    private Feedbacks feedbacks;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

}
