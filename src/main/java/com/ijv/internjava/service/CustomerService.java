package com.ijv.internjava.service;

import com.ijv.internjava.model.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> findAll();
    CustomerDto detail(long id);
    CustomerDto add(CustomerDto customerDto);
    CustomerDto update(long id, CustomerDto customerDto);
     void delete(long id);

<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 0ed19f4 (Fix conflict Customer Manager)
=======

>>>>>>> ce725da (Fix conflict on branch customer manager)
}
