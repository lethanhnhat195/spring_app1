package com.ijv.internjava.service;

import com.ijv.internjava.model.entity.Employees;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    List<Employees> getAllEmployee();
    List<Employees> searchEmployees(String query);

    Employees createEmployee(Employees employee);

    Employees getEmployeeById(Long id);

    Employees updateEmployee(Long id, Employees employeeDetail);

    void deleteEmployee(Long id);

    Employees resetPassword(Long id, Employees employeeDetail);

    void saveEmployeesToDatabase(MultipartFile file);
    Optional<Employees> findByUsername(String username);

    boolean existsByEmail(String email);

    Optional<Employees> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByPhone(String phone);

    void save(Employees employee);

}
