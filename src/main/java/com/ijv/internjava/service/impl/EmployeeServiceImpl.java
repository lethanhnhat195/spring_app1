package com.ijv.internjava.service.impl;

<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD

<<<<<<< HEAD
=======

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======


>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
>>>>>>> fe4beda (Fix conflict in branch customer manager)
import com.ijv.internjava.exception.ResourceNotFoundException;
import com.ijv.internjava.model.entity.Employee;
import com.ijv.internjava.model.entity.WorkShift;
import com.ijv.internjava.repository.EmployeeRepository;
<<<<<<< HEAD

import com.ijv.internjava.service.ExcelUploadService;

import com.ijv.internjava.service.EmployeeService;
=======
import com.ijv.internjava.service.EmployeeService;

import com.ijv.internjava.service.ExcelUploadService;

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

<<<<<<< HEAD
    private EmployeeRepository EmployeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = EmployeeRepository.findAll();
=======
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
        return employees;
    }

    @Override
    public List<Employee> searchEmployees(String query) {
<<<<<<< HEAD
        List<Employee> employees = EmployeeRepository.searchEmployees(query);
=======
        List<Employee> employees = employeeRepository.searchEmployees(query);
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
        return employees;
    }

    @Override
    public Employee createEmployee(Employee employee) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> fe4beda (Fix conflict in branch customer manager)
        Optional<Employee> employeeByEmail = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if (employeeByEmail.isPresent()) {
        Optional<Employee> employeeByEmail = EmployeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeByEmail.isPresent()) {
        Optional<Employee> employeeByEmail = EmployeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeByEmail.isPresent()) {
        if(employeeByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        return EmployeeRepository.save(employee);
=======
        Optional<Employee> employeeByEmail = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeByEmail.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        return employeeRepository.save(employee);
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
    }

    @Override
    public Employee getEmployeeById(Long id) {
<<<<<<< HEAD
        Employee employee = EmployeeRepository.findById(id).orElseThrow(() ->
=======
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
                new ResourceNotFoundException("Employee not exist with id : " + id));
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeDetail) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> fe4beda (Fix conflict in branch customer manager)
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
       Optional<Employee> optionalEmployee = employeeRepository.findById(id);
       Optional<Employee> optionalEmployee = EmployeeRepository.findById(id);

        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
       Optional<Employee> optionalEmployee = EmployeeRepository.findById(id);

       if (optionalEmployee.isPresent()){
           Employee employee = optionalEmployee.get();

       if (optionalEmployee.isPresent()){
           Employee employee = optionalEmployee.get();
       Optional<Employee> optionalEmployee = EmployeeRepository.findById(id);

        if (optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
=======
       Optional<Employee> optionalEmployee = employeeRepository.findById(id);

       if (optionalEmployee.isPresent()){
           Employee employee = optionalEmployee.get();
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)

           employee.setName(employeeDetail.getName());
           employee.setGender(employeeDetail.getGender());
           employee.setBirthday(employeeDetail.getBirthday());
           employee.setAddress(employeeDetail.getAddress());
           employee.setPhone(employeeDetail.getPhone());
           employee.setEmail(employeeDetail.getEmail());
<<<<<<< HEAD
           employee.setUserName(employeeDetail.getUserName());
=======
<<<<<<< HEAD
>>>>>>> fe4beda (Fix conflict in branch customer manager)
           employee.setUsername(employeeDetail.getUsername());
=======
           employee.setUserName(employeeDetail.getUserName());
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
           employee.setPassword(employeeDetail.getPassword());
           employee.setImage(employeeDetail.getImage());
           employee.setWorkShift(new WorkShift(employeeDetail.getId()));

<<<<<<< HEAD
           Employee updateEmployee = employeeRepository.save(employee);
=======
<<<<<<< HEAD
           Employee updateEmployee = EmployeeRepository.save(employee);
=======
           Employee updateEmployee = employeeRepository.save(employee);
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
>>>>>>> fe4beda (Fix conflict in branch customer manager)
           return updateEmployee;
       }else {
           throw new ResourceNotFoundException("Employee not exist with id : " + id);
       }
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
>>>>>>> fe4beda (Fix conflict in branch customer manager)

    @Override
    public void deleteEmployee(Long id) {
        EmployeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));
        EmployeeRepository.deleteById(id);
    }

    @Override
    public Employee resetPassword(Long id, Employee employeeDetail) {
        final String passwordDefault = "A123456@";
        Employee employee = EmployeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id : " + id));

        employee.setPassword("passwordDefault");
        Employee resetEmployee = EmployeeRepository.save(employee);
=======

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
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
        return resetEmployee;
    }

    public void saveEmployeesToDatabase(MultipartFile file) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> fe4beda (Fix conflict in branch customer manager)
        if (ExcelUploadService.isValueExcelFile(file)) {
            try {
                List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.employeeRepository.saveAll(employees);
            } catch (IOException e) {
        if(ExcelUploadService.isValueExcelFile(file)){
            try {
                List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.EmployeeRepository.saveAll(employees);
            }catch (IOException e) {
<<<<<<< HEAD
        if(ExcelUploadService.isValueExcelFile(file)){
            try {
                List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.EmployeeRepository.saveAll(employees);
            }catch (IOException e) {
=======
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
        if(ExcelUploadService.isValueExcelFile(file)){
            try {
                List<Employee> employees = ExcelUploadService.getEmployeeDataFromExcel(file.getInputStream());
                this.employeeRepository.saveAll(employees);
            }catch (IOException e) {
>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
>>>>>>> fe4beda (Fix conflict in branch customer manager)
                throw new IllegalStateException("the file is not a valid excel file");
            }
        }
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
=======
>>>>>>> fe4beda (Fix conflict in branch customer manager)
  
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
<<<<<<< HEAD
}
=======
>>>>>>> 56d4993 (fix conflict from main branch)
=======
        IEmployeeRepository.save(employee);
    }
>>>>>>> 81396b0 (create repository, service and controller for login and sign-up)
=======

>>>>>>> 2fb74d8 (create repository, service and controller for employee management)
}
>>>>>>> fe4beda (Fix conflict in branch customer manager)
