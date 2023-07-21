package com.ijv.internjava.model.dto;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

<<<<<<< HEAD
@Data
=======
@Getter
@Setter
>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Serializable {
    private Long id;
    private String customerName;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private Long totalMoney;
}

