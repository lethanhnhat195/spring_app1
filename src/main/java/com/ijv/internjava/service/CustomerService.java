package com.ijv.internjava.service;

import com.ijv.internjava.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAll();
    CustomerDto detail(long id);
    CustomerDto add(CustomerDto customerDto);
    CustomerDto update(long id, CustomerDto customerDto);
    void delete(long id);
}