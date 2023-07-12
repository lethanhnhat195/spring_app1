package com.ijv.internjava.service;


import com.ijv.internjava.model.entity.Employee;

import java.util.Optional;

public interface IEmployeeService {
    Optional<Employee> findByUsername(String username);
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByPhone(String phone);

    void save(Employee employee);
}
