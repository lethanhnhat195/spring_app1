package com.ijv.internjava.service.impl;


<<<<<<< HEAD
=======

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
import com.ijv.internjava.exception.ResourceNotFoundException;
import com.ijv.internjava.model.entity.Employee;
import com.ijv.internjava.model.entity.WorkShift;
import com.ijv.internjava.repository.EmployeeRepository;

import com.ijv.internjava.service.ExcelUploadService;

import com.ijv.internjava.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository EmployeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = EmployeeRepository.findAll();
        return employees;
    }

    @Override
    public List<Employee> searchEmployees(String query) {
        List<Employee> employees = EmployeeRepository.searchEmployees(query);
        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee) {
<<<<<<< HEAD
        Optional<Employee> employeeByEmail = employeeRepository.findEmployeeByEmail(employee.getEmail());
<<<<<<< HEAD
        if (employeeByEmail.isPresent()) {
=======
=======
        Optional<Employee> employeeByEmail = EmployeeRepository.findEmployeeByEmail(employee.getEmail());
>>>>>>> 56d4993 (fix conflict from main branch)
        if(employeeByEmail.isPresent()) {
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
            throw new IllegalStateException("email taken");
        }
        return EmployeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = EmployeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetail) {
<<<<<<< HEAD
<<<<<<< HEAD
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            employee.setName(employeeDetail.getName());
            employee.setGender(employeeDetail.getGender());
            employee.setBirthday(employeeDetail.getBirthday());
            employee.setAddress(employeeDetail.getAddress());
            employee.setPhone(employeeDetail.getPhone());
            employee.setEmail(employeeDetail.getEmail());
            employee.setUserName(employeeDetail.getUserName());
            employee.setPassword(employeeDetail.getPassword());
            employee.setImage(employeeDetail.getImage());
            employee.setWorkShift(new WorkShift(employeeDetail.getId()));

            Employee updateEmployee = employeeRepository.save(employee);
            return updateEmployee;
        } else {
            throw new ResourceNotFoundException("Employee not exist with id : " + id);
        }
=======
       Optional<Employee> optionalEmployee = employeeRepository.findById(id);
=======
       Optional<Employee> optionalEmployee = EmployeeRepository.findById(id);
>>>>>>> 56d4993 (fix conflict from main branch)

       if (optionalEmployee.isPresent()){
           Employee employee = optionalEmployee.get();

           employee.setName(employeeDetail.getName());
           employee.setGender(employeeDetail.getGender());
           employee.setBirthday(employeeDetail.getBirthday());
           employee.setAddress(employeeDetail.getAddress());
           employee.setPhone(employeeDetail.getPhone());
           employee.setEmail(employeeDetail.getEmail());
           employee.setUsername(employeeDetail.getUsername());
           employee.setPassword(employeeDetail.getPassword());
           employee.setImage(employeeDetail.getImage());
           employee.setWorkShift(new WorkShift(employeeDetail.getId()));

           Employee updateEmployee = EmployeeRepository.save(employee);
           return updateEmployee;
       }else {
           throw new ResourceNotFoundException("Employee not exist with id : " + id);
       }
    }
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)

    @Override
    public void deleteEmployee(Long id) {
        EmployeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        EmployeeRepository.deleteById(id);
    }

<<<<<<< HEAD
=======
    @Override
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
    public Employee resetPassword(Long id, Employee employeeDetail) {
        final String passwordDefault = "A123456@";
        Employee employee = EmployeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));

        employee.setPassword("passwordDefault");
        Employee resetEmployee = EmployeeRepository.save(employee);
        return resetEmployee;
    }

    public void saveEmployeesToDatabase(MultipartFile file) {
<<<<<<< HEAD
        if (ExcelUploadService.isValueExcelFile(file)) {
            try {
                List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.employeeRepository.saveAll(employees);
            } catch (IOException e) {
=======
        if(ExcelUploadService.isValueExcelFile(file)){
            try {
                List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.EmployeeRepository.saveAll(employees);
            }catch (IOException e) {
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
                throw new IllegalStateException("the file is not a valid excel file");
            }
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
  
    @Override
    public Optional<Employee> findByUsername(String username) {
        return EmployeeRepository.findByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return EmployeeRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return EmployeeRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return EmployeeRepository.existsByPhone(phone);
    }

    @Override
    public void save(Employee employee) {
        EmployeeRepository.save(employee);
    }
>>>>>>> 56d4993 (fix conflict from main branch)
}
