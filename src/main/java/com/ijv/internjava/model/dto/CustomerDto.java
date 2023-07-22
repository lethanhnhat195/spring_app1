package com.ijv.internjava.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Serializable {
    private Long id;
    private String customerName;
    private String phoneNumber;
    private String address;
    private Date dateOfBirth;
    private BigDecimal totalMoney;
}