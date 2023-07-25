package com.ijv.internjava.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto implements Serializable {
    private Long id;
    private String name;
    private int serviceTime;
    private BigDecimal price;
    private String description;
    private Set<ServiceImageDto> serviceImageDtos;
}
