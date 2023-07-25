package com.ijv.internjava.service;

import com.ijv.internjava.model.dto.ServiceDto;

import java.util.List;

public interface ServiceService {
    List<ServiceDto> findAll();
    ServiceDto detail(Long id);
    ServiceDto create(ServiceDto serviceDto);
    ServiceDto edit(ServiceDto serviceDto, Long id);
    void delete(long id);
}
