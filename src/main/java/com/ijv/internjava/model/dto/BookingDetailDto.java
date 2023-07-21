package com.ijv.internjava.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetailDto implements Serializable {
    private Long id;
    private Long serviceId;
    private String note;
}
