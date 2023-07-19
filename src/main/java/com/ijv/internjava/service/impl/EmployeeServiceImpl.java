package com.ijv.internjava.service.impl;

import com.ijv.internjava.model.entity.Employee;
import com.ijv.internjava.repository.IEmployeeRepository;
import com.ijv.internjava.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository IEmployeeRepository;

    @Override
    public Optional<Employee> findByUsername(String username) {
        return IEmployeeRepository.findByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return IEmployeeRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return IEmployeeRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return IEmployeeRepository.existsByPhone(phone);
    }

    @Override
    public void save(Employee employee) {
        IEmployeeRepository.save(employee);
    }
}
