package com.ijv.internjava.service.impl;

import com.ijv.internjava.exception.ResourceNotFoundException;
import com.ijv.internjava.model.entity.Employee;
import com.ijv.internjava.model.entity.WorkShift;
import com.ijv.internjava.repository.EmployeeRepository;
import com.ijv.internjava.service.EmployeeService;

import com.ijv.internjava.service.ExcelUploadService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public List<Employee> searchEmployees(String query) {
        List<Employee> employees = employeeRepository.searchEmployees(query);
        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Optional<Employee> employeeByEmail = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetail) {
       Optional<Employee> optionalEmployee = employeeRepository.findById(id);

       if (optionalEmployee.isPresent()){
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
       }else {
           throw new ResourceNotFoundException("Employee not exist with id : " + id);
       }
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee resetPassword(Long id, Employee employeeDetail) {
        final String passwordDefault = "A123456@";
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));

        employee.setPassword("passwordDefault");
        Employee resetEmployee = employeeRepository.save(employee);
        return resetEmployee;
    }

    public void saveEmployeesToDatabase(MultipartFile file) {
        if(ExcelUploadService.isValueExcelFile(file)){
            try {
                List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.employeeRepository.saveAll(employees);
            }catch (IOException e) {
                throw new IllegalStateException("the file is not a valid excel file");
            }
        }
    }
  
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
