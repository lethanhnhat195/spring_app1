package com.ijv.internjava.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
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