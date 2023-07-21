package com.ijv.internjava.service;

import com.ijv.internjava.model.entity.Employee;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    List<Employee> getAllEmployee();
    List<Employee> searchEmployees(String query);

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employeeDetail);

    void deleteEmployee(Long id);

    Employee resetPassword(Long id, Employee employeeDetail);

    void saveEmployeesToDatabase(MultipartFile file);
<<<<<<< HEAD
=======

>>>>>>> 57ad015e475eb543278e989af430ce5bbbf34333
    Optional<Employee> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByPhone(String phone);

    void save(Employee employee);

}
