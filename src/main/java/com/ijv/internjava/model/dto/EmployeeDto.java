package com.ijv.internjava.model.dto;

import com.ijv.internjava.model.entity.WorkShift;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;
    private String name;
    private Boolean gender;
    private Date birthday;
    private String phone;
    private String address;
    private String email;
    private String image;
    private String userName;
    private String password;
    private WorkShift workShift;
    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;
    private Boolean isDeleted;
}
