package com.ijv.internjava.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto implements Serializable {
    private Long id;
    private Long customerId;
    private String phoneNumber;
    private Date bookingDate;
    private Date fromTime;
    private Date toTime;
    private String note;
    private Integer status;
    private Set<BookingDetailDto> bookingDetailDtos;
}
